import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String URL = "jdbc:sqlite:salon_belleza.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS clientes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                apellidos TEXT NOT NULL,
                telefono TEXT,
                correo TEXT,
                servicio TEXT NOT NULL,
                fecha TEXT NOT NULL,
                hora TEXT NOT NULL,
                estilista TEXT NOT NULL,
                costo REAL NOT NULL,
                observaciones TEXT
            );
            """;

        try (
            Connection conexion = conectar();
            Statement sentencia = conexion.createStatement()
        ) {
            sentencia.execute(sql);
            System.out.println("Base de datos y tabla listas.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}