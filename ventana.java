import javax.swing.*;
import java.util.List;

public class ventana {
    // Panel raíz (el que has marcado como "bind to class")
    private JPanel Principal;
    // El panel interior que contiene todos los controles
    private JPanel panel1;

    // --- Campos de "Ingreso" ---
    private JTextField txtPlacaIn;
    private JTextField txtMarcaIn;
    private JTextField txtModeloIn;
    private JTextField txtAñoIn;
    private JButton    btnAgregar;

    // --- Campos de "Actualizar" ---
    private JTextField txtPlacaUpd;
    private JTextField txtMarcaUpd;
    private JTextField txtModeloUpd;
    private JTextField txtAñoUpd;
    private JButton    btnActualizar;

    // --- Campos de "Buscar / Ordenar" ---
    private JTextField txtPlacaBus;
    private JButton    btnBuscar;
    private JButton    btnOrdenar;
    private JTextArea  textArea1;    // tu JTextArea con nombre "textArea1"

    // Lógica de negocio
    private RegistroMotocicletas registro = new RegistroMotocicletas();

    public ventana() {
        // 1) Al arrancar, muestro las 5 motos predefinidas
        mostrarEnArea(registro.getAll());

        // 2) Botón "Agregar"
        btnAgregar.addActionListener(e -> {
            try {
                Motocicleta m = new Motocicleta(
                        txtPlacaIn.getText().trim(),
                        txtMarcaIn.getText().trim(),
                        txtModeloIn.getText().trim(),
                        Integer.parseInt(txtAñoIn.getText().trim())
                );
                registro.agregar(m);
                JOptionPane.showMessageDialog(Principal, "Motocicleta agregada correctamente");
                limpiarCamposIngreso();
                mostrarEnArea(registro.getAll());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Principal, "Error: verifica los datos de ingreso");
            }
        });

        // 3) Botón "Actualizar"
        btnActualizar.addActionListener(e -> {
            String placa = txtPlacaUpd.getText().trim();
            try {
                Motocicleta m2 = new Motocicleta(
                        placa,
                        txtMarcaUpd.getText().trim(),
                        txtModeloUpd.getText().trim(),
                        Integer.parseInt(txtAñoUpd.getText().trim())
                );
                boolean ok = registro.actualizar(placa, m2);
                JOptionPane.showMessageDialog(Principal,
                        ok ? "Actualización exitosa" : "No existe placa: " + placa);
                mostrarEnArea(registro.getAll());
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(Principal, "Error: año inválido");
            }
        });

        // 4) Botón "Buscar"
        btnBuscar.addActionListener(e -> {
            String placa = txtPlacaBus.getText().trim();
            Motocicleta m3 = registro.buscar(placa);
            textArea1.setText(
                    m3 != null
                            ? m3.toString()
                            : "No se encontró matrícula: " + placa
            );
        });

        // 5) Botón "Ordenar"
        btnOrdenar.addActionListener(e -> {
            List<Motocicleta> listaOrdenada = registro.ordenarPorMarcaModelo();
            mostrarEnArea(listaOrdenada);
        });
    }

    private void limpiarCamposIngreso() {
        txtPlacaIn.setText("");
        txtMarcaIn.setText("");
        txtModeloIn.setText("");
        txtAñoIn.setText("");
    }

    private void mostrarEnArea(List<Motocicleta> list) {
        StringBuilder sb = new StringBuilder();
        for (Motocicleta m : list) {
            sb.append(m).append("\n");
        }
        textArea1.setText(sb.toString());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Programa Apellidos1_Apellido2");
        frame.setContentPane(new ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
