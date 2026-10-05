package dao;

import util.ConexionBD;
import model.Pedido;
import model.EstadoPedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public boolean create(Pedido pedido){
        String sql = "INSERT INTO pedidos (direccion, tipo, estado) VALUES (?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, pedido.getDireccion());
            preparedStatement.setString(2, pedido.getTipo());
            preparedStatement.setString(3, pedido.getEstado());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al insertar el pedido: " + e.getMessage());
            return false;
        }
    }

    public List<Pedido> readAll(){
       List<Pedido> lista = new ArrayList<>();
       String sql = "SELECT * FROM pedidos";
       try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    lista.add(new Pedido(
                            resultSet.getInt("id"),
                            resultSet.getString("direccion"),
                            resultSet.getString("tipo"),
                            resultSet.getString("estado")
                    ));
                }
       }catch (SQLException e){
                System.err.println("Error al leer el pedido: " + e.getMessage());
       }
       return lista;
    }

    public boolean update(Pedido pedido){
        String sql = "UPDATE pedidos SET direccion = ?, tipo = ?, estado = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, pedido.getDireccion());
            preparedStatement.setString(2, pedido.getTipo());
            preparedStatement.setString(3, pedido.getEstado());
            preparedStatement.setInt(4, pedido.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id){
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al eliminar el pedido: " + e.getMessage());
            return false;
        }
    }
}
