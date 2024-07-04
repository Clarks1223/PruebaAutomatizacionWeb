package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupPage {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;
    //identificadores

    private By paragraphPrecioTotal = By.xpath("//p[@class=\"product-total\"]/span[@class=\"value\"]");

    private By h4TituloAgregado = By.id("myModalLabel");

    private By ButtonProcederCheckout = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");


    //Constructor
    public PopupPage(WebDriver driver) {
        this.driver = driver;
        //defino el tiempo que esperara que la pagina web se cargue
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Metodos

    public String precioTotal() {
        WebElement precio;
        wait.until(ExpectedConditions.visibilityOfElementLocated(paragraphPrecioTotal));
        precio = driver.findElement(paragraphPrecioTotal);
        return precio.getText();
    }


    public String tituloCorrecto() {
        WebElement titulo;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(h4TituloAgregado));
            titulo = driver.findElement(h4TituloAgregado);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(h4TituloAgregado));
            titulo = driver.findElement(h4TituloAgregado);
        }
        return titulo.getText();
    }

    public void clicCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonProcederCheckout));
        WebElement carrito = driver.findElement(ButtonProcederCheckout);
        carrito.click();
    }
}
