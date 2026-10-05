package controller;

import dao.PedidoDAO;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private final PedidoDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAO();
    }

    public boolean agregarPedido(Pedido pedido) {
        if (pedido != null){
            return pedidoDAO.create(pedido);
        }
        return false;
    }

    public List<Pedido> listar(){
        return pedidoDAO.readAll();
    }

}
