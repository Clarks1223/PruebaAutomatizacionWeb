Feature: Validación del Precio de un Producto en Carrito de Compras

  @BusquedaProducto
  Scenario: Agregar producto al carrito y validar precios

    Given estoy en la página de la tienda
    And me logueo con mi usuario "gustavouchuarii@gmail.com" y clave "$dWk86fEmS"
    When navego a la categoría "Clothes" y subcategoría "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado tenga el mensaje "Product successfully added to your shopping cart"
    And valido en el popup que el monto total sea calculado correctamente total "PEN38.24"

    When finalizo la compra
    Then valido el título de la página del carrito "SHOPPING CART"
    And vuelvo a validar el cálculo de precios en el carrito "PEN38.24"
