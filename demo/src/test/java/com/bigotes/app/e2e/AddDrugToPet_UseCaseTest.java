package com.bigotes.app.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AddDrugToPet_UseCaseTest {

    private final String BASE_URL = "http://localhost:4200";

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
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-login")));
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();

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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchPet")));
        WebElement inputSearchPet = driver.findElement(By.id("searchPet"));
        inputSearchPet.sendKeys("Pompita");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        WebElement btnFilterNamePet = driver.findElement(By.id("checkbox"));
        btnFilterNamePet.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pet-detail")));
        ArrayList<WebElement> btnPetDetail = (ArrayList<WebElement>) driver.findElements(By.className("pet-detail"));
        btnPetDetail.get(0).click();

        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("selected-drug")));
        Select dropdown = new Select(selectElement);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("field-description")));
        WebElement fieldDescription = driver.findElement(By.id("field-description"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-add-treatment")));
        WebElement btnAddTreatment = driver.findElement(By.id("btn-add-treatment"));
        dropdown.selectByVisibleText("BOFLOX");
        fieldDescription.sendKeys("Se suministró BOFLOX al gato para tratar la rinotraqueítis felina. Se realizará un seguimiento en 24 horas.");
        btnAddTreatment.click();


    }

}
