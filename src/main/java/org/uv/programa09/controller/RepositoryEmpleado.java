/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.programa09.controller;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wbpat
 */
public interface RepositoryEmpleado extends JpaRepository<Empleado, Long> {
    
}
