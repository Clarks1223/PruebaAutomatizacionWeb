package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Atributos
    private By cartTitulo = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    private By cartPrecio = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        //defino el tiempo que esperara que la pagina web se cargue
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String precioTotal() {
        WebElement precio;
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPrecio));
        precio = driver.findElement(cartPrecio);
        return precio.getText();
    }


    public String tituloCorrecto() {
        WebElement titulo;
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitulo));
        titulo = driver.findElement(cartTitulo);
        return titulo.getText();
    }
}
