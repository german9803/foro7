public class Main {
    public static void main(String[] args) {
        Producto nuevoProducto = new Producto("Cámara DSLR", "Cámara profesional de alta resolución", 1200.00, 1500.00, "Fotografía", 10);
        ConexionBD.insertarProducto(nuevoProducto);
    }
}
