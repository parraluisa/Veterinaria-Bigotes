package com.bigotes.app.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RegisterVet_UseCaseTest {

    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init(){
        
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
        driver.quit();
    }


    // Descripción: Llega un usuario nuevo a la veterinaria con su mascota. El
    // veterinario que está disponible en ese momento intenta ingresar con su usuario
    // y contraseña al sistema. Este se equivoca la primera vez, sin embargo, al segundo
    // intento logra ingresar sin ningún problema. Va a la sección de registro de
    // clientes, pide los datos y da en el botón de “registrar”. Nuevamente el
    // veterinario se equivoca en uno de los campos, corrige e intenta nuevamente. El
    // cliente queda registrado. Posteriormente va a la sección de mascotas y registra la
    // mascota asociándola al dueño. Esta vez todo sale bien a la primera.
    // El veterinario pide al dueño que ingrese con su cedula a través del portal de
    // clientes. Este ingresa y ve que los datos de la mascota son correctos. Se acaba la
    // prueba.

    @Test
    public void vet_Use_Case(){

        // Arrange
        // Ingreso de Veterinario
        vetLogin();

        // Va a la sección de registro de clientes
        // Ir a dashboard clientes
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("petImage")));

        // -> LISTA INICIAL: Pet
        List<WebElement> listaInicialPet = driver.findElements(By.className("petImage"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAllOwner")));
        WebElement btnAllOwner = driver.findElement(By.id("btnAllOwner"));
        btnAllOwner.click();
        
        // Oprimir en botón: agregar cliente
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ownerId")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnsaveOwner")));

        // -> LISTA INICIAL: Owner
        List<WebElement> listaIncialOwner = driver.findElements(By.className("ownerId"));

        WebElement btnSaveOwner = driver.findElement(By.id("btnsaveOwner"));
        btnSaveOwner.click();

        // Act
        // pide los datos y da en el botón de “registrar”
        WebElement inputIDCardOwner = driver.findElement(By.id("idCard"));
        WebElement inputNameOwner = driver.findElement(By.id("firstName"));
        WebElement inputFLNOwner = driver.findElement(By.id("firstLastName"));
        WebElement inputSLNOwner = driver.findElement(By.id("secondLastName"));
        WebElement inputPhoneOwner = driver.findElement(By.id("phone"));
        WebElement inputEmailOwner = driver.findElement(By.id("email"));

        inputIDCardOwner.sendKeys("1001298924");
        inputNameOwner.sendKeys("Fabio");
        inputFLNOwner.sendKeys("Luis");
        inputSLNOwner.sendKeys("Buitrago");

        // -> Teléfono incorrecto
        inputPhoneOwner.sendKeys("TeléfonoIncorrecto");
        inputEmailOwner.sendKeys("fabiobuitra@gmail.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveOwnerForm")));
        WebElement btnSaveOwnerForm = driver.findElement(By.id("btnSaveOwnerForm"));
        btnSaveOwnerForm.click();

        // Nuevamente el veterinario se equivoca en uno de los campos, corrige e intenta nuevamente.

        // -> Control de alerta
        // Espera a que aparezca la alerta.
        wait.until(ExpectedConditions.alertIsPresent());

        // Cambia el control al objeto Alert.
        Alert alert = driver.switchTo().alert();

        // Acepta la alerta haciendo clic en el botón "Aceptar".
        alert.accept();

        inputPhoneOwner.clear();
        inputPhoneOwner.sendKeys("3124606315");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSaveOwnerForm")));
        btnSaveOwnerForm.click();

        // Posteriormente va a la sección de mascotas

        // -> Ir a DashBoard de mascotas
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ownerId")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAllPets")));

        // -> LISTA FINAL: Owner
        List<WebElement> listaFinalOwner = driver.findElements(By.className("ownerId"));

        WebElement btnAllPets = driver.findElement(By.id("btnAllPets"));
        btnAllPets.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("petImage")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAddPet")));

        WebElement btnAddPet = driver.findElement(By.id("btnAddPet"));
        btnAddPet.click();

        // y registra la mascota asociándola al dueño. Esta vez todo sale bien a la primera.
        WebElement inputIDCardOwnerPet = driver.findElement(By.id("ownerId"));
        WebElement inputNamePet= driver.findElement(By.id("name"));
        WebElement inputBreedPet = driver.findElement(By.id("breed"));
        WebElement inputBirthdayPet = driver.findElement(By.id("birthday"));
        WebElement inputWeightPet = driver.findElement(By.id("weight"));
        WebElement inputDiseasePet = driver.findElement(By.id("disease"));
        WebElement inputImgUrlPet = driver.findElement(By.id("imgUrl"));

        String expectedNamePet = "Maw";
        String expectedBreedPet = "Gato naranja";
        String expectedAgePet = "3";
        String expectedOwnerName = "Fabio Luis";
        String expectedWeightPet = "500";
        String expectedDiseasePet = "Tos leve";
        String expectedImgUrlPet = "https://catvills.com/wp-content/uploads/2020/07/orange-and-white-cat-names-a.jpg";

        inputIDCardOwnerPet.sendKeys("1001298924");
        inputBirthdayPet.sendKeys("23/07/2020");
        inputNamePet.sendKeys(expectedNamePet);
        inputBreedPet.sendKeys(expectedBreedPet);
        inputWeightPet.sendKeys(expectedWeightPet);
        inputDiseasePet.sendKeys(expectedDiseasePet);
        inputImgUrlPet.sendKeys(expectedImgUrlPet);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAddPetForm")));
        WebElement btnAddPetForm = driver.findElement(By.id("btnAddPetForm"));
        btnAddPetForm.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("petImage")));

        // -> LISTA FINAL: Pet
        List<WebElement> listaFinalPet = driver.findElements(By.className("petImage"));

        // El veterinario pide al dueño que ingrese con su cedula a través del portal de clientes
        userLogin();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("petImage")));

        List<WebElement> listaFinalPetOwner = driver.findElements(By.className("pet-detail"));
        
        // Obtener el primer elemento de la lista
        WebElement primeraMascota = listaFinalPetOwner.get(0);
        primeraMascota.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pet")));

        // Assert

        // VERIFICACIÓN: Agregado correcto de Owner
        Assertions.assertThat(listaFinalOwner.size()).isEqualTo(listaIncialOwner.size() + 1);

        // VERIFICACIÓN: Agregado correcto de Pet
        Assertions.assertThat(listaFinalPet.size()).isEqualTo(listaInicialPet.size() + 1);

        // VERIFICACIÓN: Agregado correcto de Pet en la vista de Owner
        Assertions.assertThat(listaFinalPetOwner.size()).isEqualTo(1);

        // VERIFICACIÓN: Datos correctos de la mascota
        WebElement lblOwnerName = driver.findElement(By.id("pet-owner-str"));
        Assertions.assertThat(lblOwnerName.getText()).isEqualTo(expectedOwnerName);

        WebElement lblPetName = driver.findElement(By.id("pet-name-str"));
        Assertions.assertThat(lblPetName.getText()).isEqualTo(expectedNamePet);

        WebElement lblWeightName = driver.findElement(By.id("pet-weight-str"));
        Assertions.assertThat(lblWeightName.getText()).isEqualTo(expectedWeightPet + " gr");

        WebElement lblPetBreed = driver.findElement(By.id("pet-breed-str"));
        Assertions.assertThat(lblPetBreed.getText()).isEqualTo(expectedBreedPet);

        WebElement lblPetAge = driver.findElement(By.id("pet-age-str"));
        Assertions.assertThat(lblPetAge.getText()).isEqualTo(expectedAgePet + " años");

        WebElement lblURLImagetAge = driver.findElement(By.id("pet-img"));
        Assertions.assertThat(lblURLImagetAge.getAttribute("src")).isEqualTo(expectedImgUrlPet);

    }

    // Login Veterinario
    private void vetLogin() {
        // Llega un usuario nuevo a la veterinaria con su mascota.
        driver.get(BASE_URL + "/home");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-login")));
        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();

        // El veterinario que está disponible en ese momento intenta ingresar con su usuario
        // y contraseña al sistema.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("loginVet")));
        WebElement btnVet = driver.findElement(By.className("loginVet"));
        btnVet.click();

        // Este se equivoca la primera vez,
        WebElement inputIDCardVet = driver.findElement(By.id("idCardVet"));
        WebElement inputPasswordVet = driver.findElement(By.id("passwordVet"));

        // -> Se coloca un usuario correcto con contraseña incorrecta
        inputIDCardVet.sendKeys("1000612796");
        inputPasswordVet.sendKeys("Incorrecto");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVetSubmit")));
        WebElement btnSubmit = driver.findElement(By.id("btnVetSubmit"));
        btnSubmit.click();

        // -> Control de alerta
        // Espera a que aparezca la alerta.
        wait.until(ExpectedConditions.alertIsPresent());

        // Cambia el control al objeto Alert.
        Alert alert = driver.switchTo().alert();

        // Acepta la alerta haciendo clic en el botón "Aceptar".
        alert.accept();

        // sin embargo, al segundo intento logra ingresar sin ningún problema.
        inputIDCardVet.clear();
        inputPasswordVet.clear();
        inputIDCardVet.sendKeys("1000612796");
        inputPasswordVet.sendKeys("1234");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnVetSubmit")));
        btnSubmit.click();
    }

    // Login User
    private void userLogin(){

        driver.get(BASE_URL + "/login/show");

        WebElement inputIDCardOwnerLogin = driver.findElement(By.id("idCardOwner"));
        inputIDCardOwnerLogin.sendKeys("1001298924");

        // Este ingresa y ve que los datos de la mascota son correctos. Se acaba la prueba.

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnOwnerSubmit")));
        WebElement btnSubmitOwner = driver.findElement(By.id("btnOwnerSubmit"));
        btnSubmitOwner.click();
    }
}
