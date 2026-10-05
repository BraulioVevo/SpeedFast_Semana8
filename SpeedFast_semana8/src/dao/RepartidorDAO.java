package dao;

import util.ConexionBD;
import model.Repartidor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public boolean create(Repartidor repartidor){
        String sql = "INSERT INTO repartidores (nombre) VALUES (?)";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, repartidor.getNombre());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al insertar el repartidor: " + e.getMessage());
            return false;
        }
    }
    public List<Repartidor> readAll(){
        List<Repartidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM repartidores";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                lista.add(new Repartidor(resultSet.getInt("id"), resultSet.getString("nombre")));
            }
        }catch (SQLException e){
            System.err.println("Error al ingresar el repartidor: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Repartidor repartidor){
        String sql = "UPDATE repartidores SET nombre = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, repartidor.getNombre());
            preparedStatement.setInt(2,repartidor.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al actualizar el repartidor: " + e.getMessage());
            return false;
        }
    }

    public boolean delete (int id){
        String sql = "DELETE FROM repartidores WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
                    return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            System.err.println("Error al eliminar el repartidor: " + e.getMessage());
            return false;
        }
    }
}
