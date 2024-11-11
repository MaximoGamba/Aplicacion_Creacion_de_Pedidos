package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.pedidomanagement.model.Usuario;
import com.example.pedidomanagement.model.ItemCarrito;
import com.example.pedidomanagement.model.Pago;
import com.example.pedidomanagement.model.Carrito;
import com.example.pedidomanagement.model.Factura;
import com.example.pedidomanagement.model.Pedido;
import com.example.pedidomanagement.model.Producto;
import com.example.pedidomanagment.service.UsuarioService;
import com.example.pedidomanagment.service.CarritoService;
import com.example.pedidomanagment.service.FacturaService;
import com.example.pedidomanagment.service.PagoService;
import com.example.pedidomanagment.service.PedidoService;
import com.example.pedidomanagment.service.ProductoService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableWebSecurity
@ComponentScan(basePackages = {
		"com.example.demo" ,"com.example.pedidomanagement.model", "com.example.pedidomanagment.config", "com.example.pedidomanagment.controller",
		"com.example.pedidomanagment.repository", "com.example.pedidomanagment.security", "com.example.pedidomanagment.service", })



public class GestionPedidos1Application implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private PagoService pagoService; 
    @Autowired
    private FacturaService facturaService; 
    

    public static void main(String[] args) {
        SpringApplication.run(GestionPedidos1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {    	
        Scanner scanner = new Scanner(System.in);
        while (true) {
        	System.out.println("---------------------------------------------");
            System.out.println("1. Crear usuario");
            System.out.println("2. Ver usuario");
            System.out.println("3. Registrar actividad de usuario");
            System.out.println("4. Agregar producto al carrito");
            System.out.println("5. Eliminar producto del carrito");
            System.out.println("6. Actualizar cantidad de producto en el carrito");
            System.out.println("7. Ver carrito");
            System.out.println("8. Crear pedido desde el carrito");
            System.out.println("9. Ver productos");
            System.out.println("10. Realizar Pago");
            System.out.println("11. Generar factura");
            System.out.println("12. Ver Pagos");
            System.out.println("13. Ver Facturas");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la dirección del usuario: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese el documento de identidad del usuario: ");
                    String documentoIdentidad = scanner.nextLine();
                    System.out.print("Ingrese la contraseña del usuario: ");
                    String password = scanner.nextLine();
                    Usuario usuario = new Usuario(nombre, direccion, documentoIdentidad);
                    usuario.setPassword(password);
                    usuarioService.guardarUsuario(usuario);
                    System.out.println("Usuario creado con ID:." + usuario.getId());
                    Carrito carrito = new Carrito();
                    carrito.setUsuarioId(usuario.getId());
                    carrito.setEstado("activo");
                    carritoService.guardarCarrito(carrito);
                    System.out.println("Carrito creado para el usuario con ID: " + carrito.getId());
                    
                    break;
                case 2:
                    System.out.print("Ingrese el ID del usuario: ");
                    String usuarioId = scanner.nextLine();
                    Usuario usuarioObtenido = usuarioService.obtenerUsuarioPorId(usuarioId);
                    if (usuarioObtenido != null) {
                        System.out.println("Nombre: " + usuarioObtenido.getNombre());
                        System.out.println("Dirección: " + usuarioObtenido.getDireccion());
                        System.out.println("Documento de Identidad: " + usuarioObtenido.getDocumentoIdentidad());
                        System.out.println("Categoría: " + usuarioObtenido.getCategoriaUsuario());
                        System.out.println("Tiempo de Conexión Diario: " + usuarioObtenido.getTiempoConexionDiario());
                        System.out.println("Fecha de Última Conexión: " + usuarioObtenido.getFechaUltimaConexion());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    System.out.print("Ingrese el tiempo de conexión en minutos: ");
                    int minutosConectados = scanner.nextInt();
                    usuarioService.actualizarTiempoConexion(usuarioId, minutosConectados);
                    System.out.println("Actividad registrada.");
                    break;
                case 4:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    System.out.print("Ingrese el ID del producto: ");
                    String productoId = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    ItemCarrito item = new ItemCarrito();
                    item.setProductoId(productoId);
                    item.setCantidad(cantidad);
                    carritoService.agregarProducto(usuarioId, item);
                    System.out.println("Producto agregado al carrito.");
                    break;
                case 5:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    System.out.print("Ingrese el ID del producto: ");
                    productoId = scanner.nextLine();
                    carritoService.eliminarProducto(usuarioId, productoId);
                    System.out.println("Producto eliminado del carrito.");
                    break;
                case 6:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    System.out.print("Ingrese el ID del producto: ");
                    productoId = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad del producto: ");
                    cantidad = scanner.nextInt();
                    carritoService.actualizarCantidadProducto(usuarioId, productoId, cantidad);
                    System.out.println("Cantidad de producto actualizada en el carrito.");
                    break;
                case 7:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    Carrito carritos = carritoService.obtenerCarritoPorUsuarioId(usuarioId).orElse(null);
                    if (carritos != null) {
                        System.out.println("Estado del carrito: " + carritos.getEstado());
                        System.out.println("Productos en el carrito:");
                        if (carritos.getProductos() == null) {
                        	System.out.println("Carrito vacio.");
                        	break;
                        }
                        for (Producto producto: carritos.getProductos()) {
                            System.out.println("Producto ID: " + producto.getId() + ",Nombre: " + producto.getNombre() +  ",Cantidad: " + producto.getCantidad());
                        }
                    } else {
                        System.out.println("Carrito no encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el ID del usuario: ");
                    usuarioId = scanner.nextLine();
                    carrito = carritoService.obtenerCarritoPorUsuarioId(usuarioId).orElse(null);
                    if (carrito != null) {
                        Pedido pedido = new Pedido();
                        pedido.setUsuarioId(usuarioId);
                        pedido.setProductos(carrito.getProductos());
                        System.out.print("Ingrese el nombre del cliente: ");
                        String clienteNombre = scanner.nextLine();
                        System.out.print("Ingrese la dirección del cliente: ");
                        String clienteDireccion = scanner.nextLine();
                        System.out.print("Ingrese la condición ante el IVA del cliente: ");
                        String clienteCondicionIva = scanner.nextLine();
                        pedido.setClienteNombre(clienteNombre);
                        pedido.setClienteDireccion(clienteDireccion);
                        pedido.setClienteCondicionIva(clienteCondicionIva);
                        pedido.setEstado("pendiente");

                        // Calcular el total, descuentos e impuestos según sea necesario
                        double total = 0;
                        for (Producto producto : carrito.getProductos()) {
                            total += producto.getCantidad() * productoService.obtenerPrecioProducto(producto.getId());
                        }
                        pedido.setTotal(total);
                        pedidoService.createOrder(pedido);
                        System.out.println("Pedido creado desde el carrito con ID " + pedido.getId());
                    } else {
                        System.out.println("Carrito no encontrado.");
                    }
                    break;
                case 9:
                	for (Producto producto: productoService.obtenerTodosLosProductos()) {
                        System.out.println("Producto ID: " + producto.getId() + ",Nombre:" + producto.getNombre() +  "Cantidad: " + producto.getCantidad());
                    }
                	break;
                case 10:
                	 System.out.print("Ingrese el ID de la factura a pagar: ");
                     String facturaId = scanner.nextLine();
                     System.out.print("Ingrese el método de pago: ");
                     String metodoPago = scanner.nextLine();
                     Pago pago = new Pago();
                     pago.setFacturaId(facturaId);
                     pago.setFormaPago(metodoPago);
                     pago.setMonto(facturaService.obtenerFacturaPorId(facturaId).getMonto());
                     pago.setFecha(new Date());
                     pago = pagoService.guardarPago(pago);
                     System.out.println("Pago realizado con ID: " + pago.getId());
                     break;           
                
                case 11:
                	System.out.print("Ingrese el ID del pedido: ");
                    String pedidoId = scanner.nextLine();
                    Factura factura = new Factura();
                    factura.setPedidoId(pedidoId);
                    factura.setFecha(new Date());
                    System.out.print("Ingrese los detalles de la factura (separados por comas): ");
                    String detallesFactura = scanner.nextLine();
                    factura.setDetalle(detallesFactura);
                    System.out.print("Ingrese el monto total de la factura: ");
                    double montoTotal = scanner.nextDouble();
                    scanner.nextLine(); // consumir la nueva línea
                    factura.setMonto(montoTotal);
                    factura = facturaService.guardarFactura(factura);
                    System.out.println("Factura creada con ID: " + factura.getId());
                    break;
       	
                
                case 12: 
                	 List<Pago> pagos = pagoService.obtenerTodosLosPagos();
                     for (Pago p : pagos) {
                         System.out.println("Pago ID: " + p.getId() + ", Pedido ID: " + p.getFacturaId() + ", Monto: " + p.getMonto() + ", Método de Pago: " + p.getFormaPago() + ", Fecha de Pago: " + p.getFecha());
                     }
                     break;

                	
                case 13:
                	List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
                    for (Factura f : facturas) {
                        System.out.println("Factura ID: " + f.getId() + ", Pedido ID: " + f.getPedidoId() + ", Monto Total: " + f.getMonto() + ", Fecha de Emisión: " + f.getFecha() + ", Detalles: " + String.join(", ", f.getDetalle()));
                    }
                    break;
          	
                	
                case 14:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
