# Proyecto: Gestión de Pedidos y Facturación

Este proyecto aborda la construcción de una aplicación de gestión de pedidos, que permite a los usuarios realizar compras, gestionar carritos y procesar pagos, utilizando un enfoque de persistencia poliglota. Los objetivos principales incluyen el registro de usuarios, carritos de compra, conversiones de pedidos a facturas y la gestión de pagos.

## Funcionalidades clave:

1. **Gestión de Usuarios**: Almacena datos de los usuarios, que incluyen su nombre, dirección y documento de identidad, y rastrea su actividad de conexión para clasificarlos como usuarios TOP, MEDIUM o LOW.

2. **Carrito de Compras**: Permite a los usuarios gestionar productos en su carrito; pueden agregar, eliminar o modificar la cantidad de productos. También incluye funcionalidades para retroceder a estados anteriores del carrito.

3. **Conversión de Pedidos**: Facilita la conversión del carrito en un pedido, capturando información relevante, como los datos del cliente, importes, descuentos y condiciones fiscales.

4. **Facturación y Pagos**: Genera facturas a partir de los pedidos y registra los pagos, detallando el medio de pago utilizado y otros datos relevantes, asegurando el control exhaustivo de las operaciones.

5. **Catálogo de Productos**: Incluye una base de datos de productos con descripciones, imágenes, comentarios y otros elementos que enriquecen la experiencia del usuario, además de mantener actualizada la lista de precios.

## Modelos de Base de Datos:

La aplicación incluye definiciones de modelos de base de datos adecuadas, garantizando una estructura que soporte la escalabilidad y eficiencia en la recuperación de datos. Se proporcionan modelos físicos de cada base de datos utilizada, apoyando el desarrollo efectivo y justificado de la solución.

## Herramientas y Tecnologías:
-Java
-Spring Boot
-MongoDB
-Maven
-Postman

