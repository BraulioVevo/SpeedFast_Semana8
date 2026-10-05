package dao;

import util.ConexionBD;
import model.Entrega;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public boolean create(Entrega entrega){
        String sql = "INSERT INTO entregas (id_pedido, id_repartidor, fecha, hora) VALUES (?,?,?,?)";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, entrega.getIdPedido());
            preparedStatement.setInt(2, entrega.getIdRepartidor());
            preparedStatement.setDate(3, entrega.getFecha());
            preparedStatement.setTime(4, entrega.getHora());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al crear el pedido: " + e.getMessage());
            return false;
        }
    }

    public List<Entrega> readAll(){
        List <Entrega> lista  = new ArrayList<>();
        String sql = "SELECT * FROM entregas";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                lista.add(new Entrega(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_pedido"),
                        resultSet.getInt("id_repartidor"),
                        resultSet.getDate("fecha"),
                        resultSet.getTime("hora")
                ));
            }
        }catch (SQLException e){
            System.err.println("Error al listar el pedido: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Entrega entrega){
        String sql = "UPDATE entregas SET id_pedido = ?, id_repartidor = ?, fecha = ?, hora = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, entrega.getIdPedido());
            preparedStatement.setInt(2, entrega.getIdRepartidor());
            preparedStatement.setDate(3, entrega.getFecha());
            preparedStatement.setTime(4, entrega.getHora());
            preparedStatement.setInt(5, entrega.getId());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e){
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id){
        String sql = "DELETE FROM entregas WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            System.err.println("Error al eliminar el pedido: " + e.getMessage());
        return false;
        }
    }
}
