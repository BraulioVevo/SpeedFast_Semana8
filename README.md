## Sistema SpeedFast - Gestión de Pedidos

Aplicación de escritorio desarrollada en Java Swing con arquitectura MVC y patrón DAO para la gestión de pedidos, repartidores y entregas con persistencia en base de datos MySQL.

---
📁 Estructura del Proyecto
src/
├── app/
│   └── Main.java                   # Punto de entrada de la aplicación
├── controller/
│   └── PedidoController.java       # Gestión de la lógica entre vistas y DAO
├── dao/
│   ├── EntregaDAO.java             # Persistencia de la entidad Entrega
│   ├── PedidoDAO.java              # Persistencia de la entidad Pedido
│   └── RepartidorDAO.java          # Persistencia de la entidad Repartidor
├── model/
│   ├── Entrega.java                # Modelo de datos de Entregas
│   ├── EstadoPedido.java           # Enumerador de estados de pedido
│   ├── Pedido.java                 # Modelo de datos de Pedidos
│   └── Repartidor.java             # Modelo de datos de Repartidores
├── util/
│   └── ConexionBD.java             # Conexión JDBC a MySQL
└── view/
    ├── VentanaListaPedidos.java    # Interfaz para consultar tabla de pedidos
    ├── VentanaPrincipal.java       # Menú principal del sistema
    └── VentanaRegistroPedido.java  # Formulario de registro con ID autogenerado
---

##🗄️ Configuración de la Base de Datos (speedfast_db)

Ejecuta el siguiente script en tu cliente MySQL (Workbench, phpMyAdmin, DBeaver) antes de iniciar el programa:

⚙️ Instalación y Ejecución
Clonar o abrir el proyecto en IntelliJ IDEA o tu IDE preferido.

Agregar el conector JDBC:

Descarga mysql-connector-j-8.3.0.jar.

En IntelliJ IDEA: Ve a File > Project Structure > Libraries > + (Java) y selecciona el archivo .jar.

Verificar credenciales:

Ajusta las variables USUARIO y PASSWORD en util.ConexionBD.java según tu configuración local[cite: 35].

Ejecutar:

Ejecuta el método main ubicado en app.Main.java
