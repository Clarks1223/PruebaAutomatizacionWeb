package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Identificadores de los elementos
    private By buttonIniciarSesion = By.xpath("//div[@id='_desktop_user_info']");
    private By inputUsuario = By.xpath("//input[@id='field-email']");
    private By inputContrasena = By.xpath("//input[@id='field-password']");
    private By buttonSingIn = By.xpath("//button[@id='submit-login']");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //defino el tiempo que esperara la pagina
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //metodos
    public void clickEnIniciarSesion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonIniciarSesion));
        WebElement botonIniciarSesion = driver.findElement(buttonIniciarSesion);
        botonIniciarSesion.click();
    }

    public void typeUser(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsuario));
        WebElement userInput = driver.findElement(inputUsuario);
        userInput.sendKeys(user);
    }

    public void typeContrasena(String contrasena) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsuario));
        WebElement userInput = driver.findElement(inputContrasena);
        userInput.sendKeys(contrasena);
    }

    public void singIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSingIn));
        WebElement botonIniciarSesion = driver.findElement(buttonSingIn);
        botonIniciarSesion.click();
    }

}
