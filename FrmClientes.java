//MATERIA: PROGRAMACIÓN ORIENTADA A OBJETOS
//DOCENTE: GABRIEL MAGAÑA GARCIA
//INTEGRACION DE APLICACIONES A BASES DE DATOS
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmClientes extends JFrame {

    //==========================================================
    // ETIQUETAS
    //==========================================================
    JLabel lblTitulo;
    JLabel lblId;
    JLabel lblNombre;
    JLabel lblApellidos;
    JLabel lblTelefono;
    JLabel lblCorreo;
    JLabel lblServicio;
    JLabel lblFecha;
    JLabel lblHora;
    JLabel lblEstilista;
    JLabel lblCosto;
    JLabel lblObservaciones;

    //==========================================================
    // CAJAS DE TEXTO
    // Permiten capturar información del cliente
    //==========================================================
    public JTextField txtId;
    public JTextField txtNombre;
    public JTextField txtApellidos;
    public JTextField txtTelefono;
    public JTextField txtCorreo;
    public JTextField txtFecha;
    public JTextField txtHora;
    public JTextField txtCosto;

    //==========================================================
    // COMBOBOX
    // Permiten seleccionar un servicio y un estilista
    //==========================================================
    public JComboBox<String> cmbServicio;
    public JComboBox<String> cmbEstilista;

    //==========================================================
    // ÁREA DE TEXTO
    // Observaciones del cliente
    //==========================================================
    public JTextArea txtObservaciones;

    //==========================================================
    // BOTONES CRUD
    // Más adelante realizarán las operaciones con la BD
    //==========================================================
    public JButton btnNuevo;
    public JButton btnGuardar;
    public JButton btnBuscar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;

    //==========================================================
    // TABLA
    // Mostrará la información de los clientes
    //==========================================================
    public JTable tablaClientes;
    public DefaultTableModel modeloTabla;

    public FrmClientes() {

        //------------------------------------------------------
        // CONFIGURACIÓN DE LA VENTANA
        //------------------------------------------------------

        setTitle("Sistema de Administración - Salón de Belleza");
        setSize(980, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        //Conexion 
        Conexion.crearTabla();

        //------------------------------------------------------
        // TÍTULO
        //------------------------------------------------------

        lblTitulo = new JLabel("SALÓN DE BELLEZA ELEGANCE");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(270, 20, 450, 30);
        add(lblTitulo);

        //------------------------------------------------------
        // ETIQUETAS
        //------------------------------------------------------

        lblId = new JLabel("ID Cliente:");
        lblId.setBounds(30, 80, 100, 25);
        add(lblId);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 120, 100, 25);
        add(lblNombre);

        lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(30, 160, 100, 25);
        add(lblApellidos);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(500, 80, 100, 25);
        add(lblTelefono);

        lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(500, 120, 100, 25);
        add(lblCorreo);

        lblServicio = new JLabel("Servicio:");
        lblServicio.setBounds(500, 160, 100, 25);
        add(lblServicio);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(30, 200, 100, 25);
        add(lblFecha);

        lblHora = new JLabel("Hora:");
        lblHora.setBounds(250, 200, 100, 25);
        add(lblHora);

        lblEstilista = new JLabel("Estilista:");
        lblEstilista.setBounds(450, 200, 100, 25);
        add(lblEstilista);

        lblCosto = new JLabel("Costo:");
        lblCosto.setBounds(730, 200, 80, 25);
        add(lblCosto);

        lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(30, 240, 150, 25);
        add(lblObservaciones);

        //------------------------------------------------------
        // CAJAS DE TEXTO
        //------------------------------------------------------

        txtId = new JTextField();
        txtId.setBounds(130, 80, 120, 25);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 120, 300, 25);
        add(txtNombre);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(130, 160, 300, 25);
        add(txtApellidos);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(600, 80, 200, 25);
        add(txtTelefono);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(600, 120, 250, 25);
        add(txtCorreo);

        txtFecha = new JTextField();
        txtFecha.setBounds(130, 200, 90, 25);
        add(txtFecha);

        txtHora = new JTextField();
        txtHora.setBounds(300, 200, 90, 25);
        add(txtHora);

        txtCosto = new JTextField();
        txtCosto.setBounds(790, 200, 100, 25);
        add(txtCosto);

        //------------------------------------------------------
        // COMBOBOX
        //------------------------------------------------------

        cmbServicio = new JComboBox<>();

        cmbServicio.addItem("Corte de Cabello");
        cmbServicio.addItem("Peinado");
        cmbServicio.addItem("Tinte");
        cmbServicio.addItem("Rayitos");
        cmbServicio.addItem("Balayage");
        cmbServicio.addItem("Manicure");
        cmbServicio.addItem("Pedicure");
        cmbServicio.addItem("Maquillaje");
        cmbServicio.addItem("Tratamiento Capilar");
        cmbServicio.addItem("Depilación");

        cmbServicio.setBounds(600, 160, 250, 25);

        add(cmbServicio);

        cmbEstilista = new JComboBox<>();

        cmbEstilista.addItem("María");
        cmbEstilista.addItem("Fernanda");
        cmbEstilista.addItem("Daniel");
        cmbEstilista.addItem("Alejandra");
        cmbEstilista.addItem("Patricia");

        cmbEstilista.setBounds(520, 200, 170, 25);

        add(cmbEstilista);

        //------------------------------------------------------
        // ÁREA DE OBSERVACIONES
        //------------------------------------------------------

        txtObservaciones = new JTextArea();

        JScrollPane panelObservaciones = new JScrollPane(txtObservaciones);

        panelObservaciones.setBounds(30, 270, 860, 90);

        add(panelObservaciones);

        //------------------------------------------------------
        // BOTONES CRUD
        //------------------------------------------------------

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(30, 390, 110, 40);
        add(btnNuevo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 390, 110, 40);
        add(btnGuardar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(270, 390, 110, 40);
        add(btnBuscar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(390, 390, 120, 40);
        add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(520, 390, 110, 40);
        add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(640, 390, 110, 40);
        add(btnLimpiar);

        //------------------------------------------------------
        // TABLA
        //------------------------------------------------------

        modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Servicio");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Hora");
        modeloTabla.addColumn("Costo");

        tablaClientes = new JTable(modeloTabla);

        JScrollPane panelTabla = new JScrollPane(tablaClientes);

        panelTabla.setBounds(30, 460, 900, 160);

        add(panelTabla);

        //botones fun
        btnGuardar.addActionListener(e -> guardarCliente());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnBuscar.addActionListener(e -> buscarCliente());
        btnModificar.addActionListener(e -> modificarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());


        //mostrar clientes al iniciar la aplicación
        cargarClientes();
}//fin de constructor

    
    //METODO PARA GUARDAR CLIENTE EN LA BASE DE DATOS
    private void guardarCliente() {

    if (txtNombre.getText().trim().isEmpty()
            || txtApellidos.getText().trim().isEmpty()
            || txtFecha.getText().trim().isEmpty()
            || txtHora.getText().trim().isEmpty()
            || txtCosto.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Completa los campos obligatorios.",
                "Campos incompletos",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    String sql = """
            INSERT INTO clientes (
                nombre,
                apellidos,
                telefono,
                correo,
                servicio,
                fecha,
                hora,
                estilista,
                costo,
                observaciones
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    try (
        Connection conexion = Conexion.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        double costo = Double.parseDouble(txtCosto.getText().trim());

        sentencia.setString(1, txtNombre.getText().trim());
        sentencia.setString(2, txtApellidos.getText().trim());
        sentencia.setString(3, txtTelefono.getText().trim());
        sentencia.setString(4, txtCorreo.getText().trim());
        sentencia.setString(5, cmbServicio.getSelectedItem().toString());
        sentencia.setString(6, txtFecha.getText().trim());
        sentencia.setString(7, txtHora.getText().trim());
        sentencia.setString(8, cmbEstilista.getSelectedItem().toString());
        sentencia.setDouble(9, costo);
        sentencia.setString(10, txtObservaciones.getText().trim());

        sentencia.executeUpdate();

        JOptionPane.showMessageDialog(
                this,
                "Cliente guardado correctamente."
        );

        cargarClientes();
        limpiarCampos();

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El costo debe ser un número válido.",
                "Costo incorrecto",
                JOptionPane.ERROR_MESSAGE
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "No se pudo guardar el cliente:\n" + e.getMessage(),
                "Error de base de datos",
                JOptionPane.ERROR_MESSAGE
        );
    }
    

}
//metodo para buscar cliente por id
private void buscarCliente() {
    if (txtId.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Escribe el ID del cliente que deseas buscar.",
                    "ID vacío",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String sql = """
                SELECT *
                FROM clientes
                WHERE id = ?
                """;

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            int id = Integer.parseInt(txtId.getText().trim());

            sentencia.setInt(1, id);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {

                txtNombre.setText(resultado.getString("nombre"));
                txtApellidos.setText(resultado.getString("apellidos"));
                txtTelefono.setText(resultado.getString("telefono"));
                txtCorreo.setText(resultado.getString("correo"));
                cmbServicio.setSelectedItem(resultado.getString("servicio"));
                txtFecha.setText(resultado.getString("fecha"));
                txtHora.setText(resultado.getString("hora"));
                cmbEstilista.setSelectedItem(resultado.getString("estilista"));
                txtCosto.setText(String.valueOf(resultado.getDouble("costo")));
                txtObservaciones.setText(
                        resultado.getString("observaciones")
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Cliente encontrado correctamente."
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró ningún cliente con ese ID.",
                        "Cliente no encontrado",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número válido.",
                    "ID incorrecto",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo buscar el cliente:\n"
                            + e.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    

}
// MÉTODO PARA MODIFICAR CLIENTEs
    private void modificarCliente() {

        if (txtId.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Escribe o busca el ID del cliente que deseas modificar.",
                    "ID vacío",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (txtNombre.getText().trim().isEmpty()
                || txtApellidos.getText().trim().isEmpty()
                || txtFecha.getText().trim().isEmpty()
                || txtHora.getText().trim().isEmpty()
                || txtCosto.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Completa los campos obligatorios.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String sql = """
                UPDATE clientes
                SET nombre = ?,
                    apellidos = ?,
                    telefono = ?,
                    correo = ?,
                    servicio = ?,
                    fecha = ?,
                    hora = ?,
                    estilista = ?,
                    costo = ?,
                    observaciones = ?
                WHERE id = ?
                """;

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            int id = Integer.parseInt(txtId.getText().trim());
            double costo = Double.parseDouble(txtCosto.getText().trim());

            sentencia.setString(1, txtNombre.getText().trim());
            sentencia.setString(2, txtApellidos.getText().trim());
            sentencia.setString(3, txtTelefono.getText().trim());
            sentencia.setString(4, txtCorreo.getText().trim());
            sentencia.setString(5, cmbServicio.getSelectedItem().toString());
            sentencia.setString(6, txtFecha.getText().trim());
            sentencia.setString(7, txtHora.getText().trim());
            sentencia.setString(8, cmbEstilista.getSelectedItem().toString());
            sentencia.setDouble(9, costo);
            sentencia.setString(10, txtObservaciones.getText().trim());
            sentencia.setInt(11, id);

            int filasModificadas = sentencia.executeUpdate();

            if (filasModificadas > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Cliente modificado correctamente."
                );

                cargarClientes();
                limpiarCampos();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró ningún cliente con ese ID.",
                        "Cliente no encontrado",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID y el costo deben ser números válidos.",
                    "Datos incorrectos",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo modificar el cliente:\n"
                            + e.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    // MÉTODO PARA ELIMINAR CLIENTE
    //==========================================================
    private void eliminarCliente() {

        if (txtId.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Escribe o busca el ID del cliente que deseas eliminar.",
                    "ID vacío",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar este cliente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = """
                DELETE FROM clientes
                WHERE id = ?
                """;

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            int id = Integer.parseInt(txtId.getText().trim());

            sentencia.setInt(1, id);

            int filasEliminadas = sentencia.executeUpdate();

            if (filasEliminadas > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Cliente eliminado correctamente."
                );

                cargarClientes();
                limpiarCampos();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró ningún cliente con ese ID.",
                        "Cliente no encontrado",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número válido.",
                    "ID incorrecto",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo eliminar el cliente:\n"
                            + e.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

// MÉTODO PARA MOSTRAR LOS CLIENTES EN EL JTABLE
private void cargarClientes() {

    // Limpia las filas para que no se repitan
    modeloTabla.setRowCount(0);

    String sql = """
            SELECT id, nombre, apellidos, telefono,
                   servicio, fecha, hora, costo
            FROM clientes
            ORDER BY id
            """;

    try (
        Connection conexion = Conexion.conectar();
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery()
    ) {

        while (resultado.next()) {

            Object[] fila = {
                resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getString("apellidos"),
                resultado.getString("telefono"),
                resultado.getString("servicio"),
                resultado.getString("fecha"),
                resultado.getString("hora"),
                resultado.getDouble("costo")
            };

            modeloTabla.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "No se pudieron mostrar los clientes:\n"
                        + e.getMessage(),
                "Error de base de datos",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

    // MÉTODO PARA LIMPIAR CAMPOS
private void limpiarCampos() {

    txtId.setText("");
    txtNombre.setText("");
    txtApellidos.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("");
    txtFecha.setText("");
    txtHora.setText("");
    txtCosto.setText("");
    txtObservaciones.setText("");

    cmbServicio.setSelectedIndex(0);
    cmbEstilista.setSelectedIndex(0);

    txtNombre.requestFocus();
}

    

    //----------------------------------------------------------
    // MÉTODO PRINCIPAL
    // Permite ejecutar únicamente este formulario para pruebas
    //----------------------------------------------------------

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new FrmClientes().setVisible(true);

        });

    }

}
