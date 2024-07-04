package com.nttdata.steps;

import com.nttdata.page.ProductosPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductosStep {
    WebDriver driver;
    ProductosPage productosPage;

    //Constructor
    public ProductosStep(WebDriver driver) {
        this.driver = driver;
        productosPage = new ProductosPage(driver);
    }

    public void encontrarCategoria() {
        productosPage.clicBottonClothes();
    }

    public void encontrarSubCategoria() {
        productosPage.clicBottonMen();
    }

    public void encuentroProducto() {
        productosPage.seleccionarProducto();
    }

    public void seleccionCantidad(int numero) {
        //String nuevoNumero = String.valueOf(numero);
        productosPage.seleccionarUnidades(numero);
    }

    public void AgregarItems() {
        productosPage.clicBottonAgregarAlCarrito();
    }
}
