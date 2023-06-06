/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa09.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.programa09.controller.Empleado;

/**
 *
 * @author wbpat
 */
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping("/msg")
    public String holamundo() {
        return "Hola mundo";
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> opt = repositoryEmpleado.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/empleado")
    public List<Empleado> obtenerTodosLosEmpleado() {
        return repositoryEmpleado.findAll();
    }

    //guardarregistro
    @PostMapping("/empleado")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody DTOEmpleado empleadoDTO) {
        Empleado empleado = new Empleado(empleadoDTO);
        try {
            Empleado emp = repositoryEmpleado.save(empleado);
            return new ResponseEntity<>(emp, HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update
    @PutMapping("/empleado/{id}")
    public Empleado modificarEmpleado(@PathVariable("id") long id,
            @RequestBody DTOEmpleado empleadoDTO) {
        
        Empleado empleado = new Empleado(empleadoDTO);
        return repositoryEmpleado.saveAndFlush(empleado);
    }

    //delete
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<HttpStatus> borrarEmpleado(@PathVariable Long id) {
        try {
            repositoryEmpleado.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
