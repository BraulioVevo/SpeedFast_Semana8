package view;

import dao.PedidoDAO;
import model.Pedido;
import controller.PedidoController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private JTable table1;
    private JLabel JlblLista;
    private JPanel JpanelMain;
    private JPanel mainPanel;

    private PedidoController pedidoController;

    public VentanaListaPedidos(PedidoController pedidoController) {
        this.pedidoController = pedidoController;

        setContentPane(JpanelMain != null ? JpanelMain : table1);
        setTitle("Lista de Pedidos");
        setSize(500, 350);
        setLocationRelativeTo(null);

        cargarDatosTabla();
    }

    public void cargarDatosTabla() {
        String[] columnas = {"ID", "Direccion", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (pedidoController != null && pedidoController.listar() != null) {
            for (Pedido pedido : pedidoController.listar()) {
                Object[] fila = {
                        pedido.getId(),
                        pedido.getDireccion(),
                        pedido.getTipo(),
                        pedido.getEstado()
                };
                model.addRow(fila);
            }
            table1.setModel(model);
        }
    }
}