package model;

/**
 * Clase base abstracta que representa un pedido generico dentro del sistema
 * SpeedFast.
 */

public class Pedido {

    protected int id;
    protected String direccion;
    protected String tipo;
    protected String estado;

    public Pedido(int id, String direccion, String tipo, String estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Pedido(String direccion, String tipo, String estado) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int idPedido) {
        this.id = idPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccionEntrega) {
        this.direccion = direccionEntrega;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id + " - " + direccion + " - " + tipo;
    }

}