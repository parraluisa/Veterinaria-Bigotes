package com.bigotes.app.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AddDrugToPet_UseCaseTest {

    private final String BASE_URL = "http://localhost:4200/home";
    private final String ADMIN_URL = "http://localhost:4200/admin/login";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        //chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown(){
        //driver.quit();
    }

    /*
        Descripción: El veterinario va a suministrar un nuevo medicamento a una
        mascota. Busca la mascota en la barra de búsqueda, la selecciona para darle un
        nuevo tratamiento. selecciona tratamiento y da en guardar. Para verificar que
        todo salió bien, busca la mascota, ve sus detalles y se da cuenta que el nuevo
        tratamiento quedó guardado de manera correcta.
        Después se ingresa con el perfil de administrador y que la cantidad de
        medicamentos suministrados y las ganancias sean correctas.
     */

    @Test
    public void drugUseCase() {

        //Arrange
        adminNavigation();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-sales")));
        WebElement totalSales = driver.findElement(By.id("total-sales"));
        int initialTotalSales = Integer.parseInt(totalSales.getText().replaceAll("\\$|,|\\.", ""));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-profit")));
        WebElement totalProfit = driver.findElement(By.id("total-profit"));
        int initialTotalProfit = Integer.parseInt(totalProfit.getText().replaceAll("\\$|,|\\.", ""));

        vetNavigation();
        searchPet();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("td-treatment-disease")));
        List<WebElement> initialTreatmentList = driver.findElements(By.className("td-treatment-disease"));
        int initialTreatmentListSize = initialTreatmentList.size();


        //Act
        addTreatment();
        wait.until(lambda -> driver.findElements(By.className("td-treatment-disease")).size() == initialTreatmentListSize + 1);
        driver.navigate().back();
        searchPet();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("td-treatment-disease")));
        List<WebElement> finalTreatmentList = driver.findElements(By.className("td-treatment-disease"));

        adminNavigation();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-sales")));
        WebElement totalSales2 = driver.findElement(By.id("total-sales"));
        int finalTotalSales = Integer.parseInt(totalSales2.getText().replaceAll("\\$|,|\\.", ""));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total-profit")));
        WebElement totalProfit2 = driver.findElement(By.id("total-profit"));
        int finalTotalProfit = Integer.parseInt(totalProfit2.getText().replaceAll("\\$|,|\\.", ""));

        //Assert
        Assertions.assertEquals(initialTreatmentListSize + 1, finalTreatmentList.size());
        Assertions.assertTrue(finalTotalSales > initialTotalSales);
        Assertions.assertTrue(finalTotalProfit > initialTotalProfit);
        



    }

    private void adminNavigation(){
        driver.get(ADMIN_URL);

        // Se ingresa al login de administrador
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardAdmin")));
        WebElement inputIDCardAdmin = driver.findElement(By.id("idCardAdmin"));
        inputIDCardAdmin.sendKeys("1000612796");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwordAdmin")));
        WebElement inputPasswordAdmin = driver.findElement(By.id("passwordAdmin"));
        inputPasswordAdmin.sendKeys("1234");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-admin-submit")));
        WebElement btnAdminLogin = driver.findElement(By.id("btn-admin-submit"));
        btnAdminLogin.click();
    }

    private void vetNavigation(){
        // Se ingresa al landing page
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-login")));
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();

        // Se ingresa al login de veterinario
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("loginVet")));
        WebElement btnVet = driver.findElement(By.className("loginVet"));
        btnVet.click();

        WebElement inputIDCardVet = driver.findElement(By.id("idCardVet"));
        WebElement inputPasswordVet = driver.findElement(By.id("passwordVet"));
        // -> Se coloca un usuario correcto con contraseña correcta
        inputIDCardVet.sendKeys("1000612796");
        inputPasswordVet.sendKeys("1234");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVetSubmit")));
        WebElement btnSubmit = driver.findElement(By.id("btnVetSubmit"));
        btnSubmit.click();
    }

    private void searchPet(){
        // Se ingresa a la sección de mascotas
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchPet")));
        WebElement inputSearchPet = driver.findElement(By.id("searchPet"));
        inputSearchPet.sendKeys("Pompita");

        // Se selecciona la mascota
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        WebElement btnFilterNamePet = driver.findElement(By.id("checkbox"));
        btnFilterNamePet.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pet-detail")));
        ArrayList<WebElement> btnPetDetail = (ArrayList<WebElement>) driver.findElements(By.className("pet-detail"));
        btnPetDetail.get(0).click();
    }

    private void addTreatment(){
        // Se ingresa a la sección de tratamientos
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("selected-drug")));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText("BOFLOX");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("field-description")));
        WebElement fieldDescription = driver.findElement(By.id("field-description"));
        fieldDescription.sendKeys("Se suministró BOFLOX al gato para tratar la rinotraqueítis felina. Se realizará un seguimiento en 24 horas.");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-add-treatment")));
        WebElement btnAddTreatment = driver.findElement(By.id("btn-add-treatment"));
        btnAddTreatment.click();
    }

}
