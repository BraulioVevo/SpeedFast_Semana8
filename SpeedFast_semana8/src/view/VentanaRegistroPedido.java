package view;

import controller.PedidoController;
import dao.PedidoDAO;
import model.Pedido;
import javax.swing.*;

public class VentanaRegistroPedido extends JFrame {
    private JPanel panel1;
    private JTextField txtFieldID;
    private JTextField txtFieldDireccion;
    private JComboBox <String> cbxTipo;
    private JLabel jLabelDireccion;
    private JLabel jLabelId;
    private JButton btnGuardarRegistro;

    private PedidoController controller;

    public VentanaRegistroPedido(PedidoController controller) {
        this.controller = controller;

        setContentPane(panel1);
        setTitle("Registro de pedido");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //debido a que el ID en MySql es un AUTO_INCREMENT, se deshabilita de forma manual.
        txtFieldID.setEditable(false);
        txtFieldID.setText("Autogenerado");

        btnGuardarRegistro.addActionListener(e -> {

               String direccion = txtFieldDireccion.getText().trim();
               String tipo = (String) cbxTipo.getSelectedItem();

               if (direccion.isEmpty()) {
                   JOptionPane.showMessageDialog(this, "Debe ingresar una dirección.");
                   return;
               }

               Pedido pedido = new Pedido(direccion, tipo,"Pendiente");
               this.controller.agregarPedido(pedido);

               if (this.controller != null) {
                   this.controller.agregarPedido(pedido);
                   JOptionPane.showMessageDialog(this, "Pedido agregado correctamente.");
                   dispose();
               }
        });
    }
}

