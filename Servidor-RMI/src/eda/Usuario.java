/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author daniel
 */
public final class Usuario implements java.io.Serializable {
    private int idUsuario;
    private String clave ;
    private String nombre ;
    private String departamento ;
    private String documentoIdentificacion ;

    public Usuario(int idUsuario, String clave, String nombre, String departamento, String documentoIdentificacion) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.departamento = departamento;
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getClave() {
        return clave;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the documentoIdentificacion
     */
    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    /**
     * @param documentoIdentificacion the documentoIdentificacion to set
     */
    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }
    

    
}
