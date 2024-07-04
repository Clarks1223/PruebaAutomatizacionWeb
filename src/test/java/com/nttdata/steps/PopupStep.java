package com.nttdata.steps;

import com.nttdata.page.PopupPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class PopupStep {
    WebDriver driver;
    PopupPage popup;

    public PopupStep(WebDriver driver) {
        this.driver = driver;
        popup = new PopupPage(driver);
    }

    public void continuarAlCarrito() {
        popup.clicCarrito();
    }

    public void validarTitulo(String titulo) {
        Assertions.assertEquals(titulo, popup.tituloCorrecto());
    }

    public void validaPrecio(String numero) {
        Assertions.assertEquals(numero, popup.precioTotal());
    }

}
