package com.tickets.tickets_backend.records;

public class Ticket{

    private Integer codigo;
    private String usuario;
    private String descripcion;

    //Pendiente, En Proceso, Resuelto
    private String estado;

    public Ticket(Integer codigo, String usuario, String descripcion, String estado) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }

    public Integer getCodigo(){
        return codigo;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return estado;
    }

    @Override
    public String toString() {
        return "Ticket [codigo = " + codigo + ", usuario = " + usuario + ", descripcion = " + descripcion + ", estado = " + estado + "]";
    }
}
