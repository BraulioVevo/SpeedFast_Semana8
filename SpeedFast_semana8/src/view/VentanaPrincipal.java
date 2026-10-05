package view;

import controller.PedidoController;
import dao.PedidoDAO;
import model.Pedido;

import javax.swing.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private JPanel mainPanel;
    private JButton btnRegistrarPedido;
    private JButton btnListarPedido;
    private JButton btnIniciarEntrega;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JButton btnActualizar;
    private JTextArea jtextArea;
    private JLabel JLabel;

    private PedidoController pedidoController;

    public VentanaPrincipal(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
        setContentPane(mainPanel);
        setTitle("Sistema SpeedFast");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnRegistrarPedido.addActionListener(e -> {
            VentanaRegistroPedido ventanaRegistro = new VentanaRegistroPedido(this.pedidoController);
            ventanaRegistro.setVisible(true);
        });

        btnListarPedido.addActionListener(e -> {
            VentanaListaPedidos ventanaListaPedidos = new VentanaListaPedidos(this.pedidoController);
            ventanaListaPedidos.setVisible(true);
        });

        btnIniciarEntrega.addActionListener(e -> {
            List<Pedido> pedidos = this.pedidoController.listar();
            if (pedidos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ninguna hay pedidos pendientes.", " Atención", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Simulación de entrega iniciada con " + pedidos.size() + " pedido.");
            }
        });

        btnActualizar.addActionListener(e -> actualizarTextArea());

        btnGuardar.addActionListener(e -> {
            actualizarTextArea();
            JOptionPane.showMessageDialog(this, "Datos actualizados.");
        });

        btnLimpiar.addActionListener(e -> jtextArea.setText(""));

        //Cerrar aplicación
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
    }
        private void actualizarTextArea(){
        List<Pedido> pedidos = pedidoController.listar();
            if (pedidos == null || pedidos.isEmpty()){
                jtextArea.setText("No hay pedidos.");
            } else {
                StringBuilder sBuilder = new StringBuilder("~~~ Lista de pedidos ~~~\n");
                for (Pedido pedido : pedidos){
                    sBuilder.append("ID: ").append(pedido.getId())
                            .append("| Dirección: ").append(pedido.getDireccion())
                            .append("| Tipo: " ).append(pedido.getTipo())
                            .append("\n");
                }
            jtextArea.setText(sBuilder.toString());
        }
    }
}

