package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    WebDriver driver;
    LoginPage login;

    //Declaro el constructor
    public LoginStep(WebDriver driver) {
        this.driver = driver;
        login = new LoginPage(driver);
    }

    public void navegarHacia(String url) {
        driver.get(url);
    }

    //Click en el boton iniciar sesion
    public void opcionIniciarSesion() {
        login.clickEnIniciarSesion();
    }

    //Escribo el usuario
    public void escriboUsuario(String usuario) {
        login.typeUser(usuario);
    }

    //Escribo la contraseña
    public void escriboContrasena(String contrasena) {
        login.typeContrasena(contrasena);
    }

    //Click en el boton login
    public void inicioSesion() {
        login.singIn();
    }

}
