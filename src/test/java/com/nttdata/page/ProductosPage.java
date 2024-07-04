package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductosPage {
    //atributos de la clase
    private WebDriver driver;
    private WebDriverWait wait;
    //identificadores para elementos web
    private By buttonClothes = By.xpath("//a[@class=\"dropdown-item\" and @data-depth=\"0\"]");
    private By buttonMen = By.xpath("//ul[@class=\"category-sub-menu\"]/li[1]/a");
    //Otras alternativas al boton men
    //private By buttonMen = By.xpath("//a[@title=\"Men\"]");
    //private By buttonMen = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[1]/div[1]/a[1]");
    private By primerElementoCategoria = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
    private By inputCantidad = By.xpath("//i[@class=\"material-icons touchspin-up\"]");
    private By buttonAgregarAlCarrito = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]");

    //constructor
    public ProductosPage(WebDriver driver) {
        this.driver = driver;
        //defino el tiempo que esperara que la pagina web se cargue
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //metodos
    public void clicBottonClothes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonClothes));
        WebElement botonCategoria = driver.findElement(buttonClothes);
        botonCategoria.click();

    }

    public void clicBottonMen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMen));
        WebElement botonSubCategoria = driver.findElement(buttonMen);
        botonSubCategoria.click();
    }

    public void seleccionarProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(primerElementoCategoria));
        WebElement primerElemento = driver.findElement(primerElementoCategoria);
        primerElemento.click();
    }

    public void seleccionarUnidades(int cantidad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCantidad));
        WebElement elementoCantidad = driver.findElement(inputCantidad);
        int i = 1;
        if (cantidad <= 0) {
            System.out.println("Valor no valido");
        }
        while (i < cantidad) {
            elementoCantidad.click();
            i++;
        }
    }

    public void clicBottonAgregarAlCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAgregarAlCarrito));
        WebElement primerElemento = driver.findElement(buttonAgregarAlCarrito);
        primerElemento.click();
    }
}
