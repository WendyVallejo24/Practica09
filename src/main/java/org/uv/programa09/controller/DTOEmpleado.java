/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa09.controller;

/**
 *
 * @author wbpat
 */
public class DTOEmpleado {
    private long idDTO;
    private String nombreDTO;
    private String direccionDTO;
    private String telefonoDTO;

    public long getClaveDTO() {
        return idDTO;
    }

    public void setClaveDTO(long idDTO) {
        this.idDTO = idDTO;
    }

    public String getNombre() {
        return nombreDTO;
    }

    public void setNombre(String nombreDTO) {
        this.nombreDTO = nombreDTO;
    }

    public String getDireccion() {
        return direccionDTO;
    }

    public void setDireccion(String direccionDTO) {
        this.direccionDTO = direccionDTO;
    }

    public String getTelefono() {
        return telefonoDTO;
    }

    public void setTelefono(String telefonoDTO) {
        this.telefonoDTO = telefonoDTO;
    }

    
}
