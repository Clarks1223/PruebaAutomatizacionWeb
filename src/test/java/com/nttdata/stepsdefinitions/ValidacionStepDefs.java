package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginStep;
import com.nttdata.steps.PopupStep;
import com.nttdata.steps.ProductosStep;
import com.nttdata.steps.ShoppingCartStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidacionStepDefs {
    private LoginStep login;
    private ProductosStep productos;
    private PopupStep popup;
    private ShoppingCartStep cart;
    private WebDriver driver;
    private Scenario scenario;

    @Before(order = 0)
    public void setUp() {
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    //Inicia el codigo de la automatizacion
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() throws InterruptedException {
        login = new LoginStep(driver);
        login.navegarHacia("https://qalab.bensg.com/store/en/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) {
        login = new LoginStep(driver);
        login.opcionIniciarSesion();
        login.escriboUsuario(arg0);
        login.escriboContrasena(arg1);
        login.inicioSesion();
        screenShot();
    }

    @When("navego a la categoría {string} y subcategoría {string}")
    public void navegoALaCategoríaYSubcategoría(String arg0, String arg1) {
        productos = new ProductosStep(driver);
        productos.encontrarCategoria();
        productos.encontrarSubCategoria();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        productos = new ProductosStep(driver);
        productos.encuentroProducto();
        productos.seleccionCantidad(arg0);
        productos.AgregarItems();
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado tenga el mensaje {string}")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregadoTengaElMensaje(String arg0) {
        popup = new PopupStep(driver);
        popup.validarTitulo(arg0);
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente total {string}")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamenteTotal(String arg0) {
        popup = new PopupStep(driver);
        popup.validaPrecio(arg0);
        screenShot();

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        popup = new PopupStep(driver);
        popup.continuarAlCarrito();
        screenShot();

    }

    @Then("valido el título de la página del carrito {string}")
    public void validoElTítuloDeLaPáginaDelCarrito(String arg0) {
        cart = new ShoppingCartStep(driver);
        cart.validarTitulo(arg0);
        screenShot();
    }

    @And("vuelvo a validar el cálculo de precios en el carrito {string}")
    public void vuelvoAValidarElCálculoDePreciosEnElCarrito(String arg0) {
        cart = new ShoppingCartStep(driver);
        cart.validaPrecio(arg0);
        screenShot();
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
