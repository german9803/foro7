import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/kd_electronics";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "##########";
        

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static void insertarProducto(Producto producto) {
        String query = "INSERT INTO productos (nombre, descripcion, precio_base, precio_venta, categoria, cantidad_disponible) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conectar();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecioBase());
            pstmt.setDouble(4, producto.getPrecioVenta());
            pstmt.setString(5, producto.getCategoria());
            pstmt.setInt(6, producto.getCantidadDisponible());
            pstmt.executeUpdate();
            System.out.println("Producto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }
}