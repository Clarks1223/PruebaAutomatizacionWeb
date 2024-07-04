package com.nttdata.steps;

import com.nttdata.page.PopupPage;
import com.nttdata.page.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ShoppingCartStep {
    WebDriver driver;
    ShoppingCartPage cart;

    public ShoppingCartStep(WebDriver driver) {
        this.driver = driver;
        cart = new ShoppingCartPage(driver);
    }

    public void validarTitulo(String titulo) {
        Assertions.assertEquals(titulo, cart.tituloCorrecto());
    }

    public void validaPrecio(String numero) {
        Assertions.assertEquals(numero, cart.precioTotal());
    }
}
