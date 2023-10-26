package com.bigotes.app.e2e;

import java.time.Duration;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        // Llega un usuario nuevo a la veterinaria con su mascota.

        // El veterinario que está disponible en ese momento intenta ingresar con su usuario
        // y contraseña al sistema.

        // Este se equivoca la primera vez,

        // sin embargo, al segundo intento logra ingresar sin ningún problema.

    }
}
