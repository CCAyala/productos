package com.example.Examen.controler;
import com.example.Examen.entity.producto;
import com.example.Examen.service.producto_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class controlador_producto {

    private producto_service service;


    public controlador_producto(producto_service service){
        this.service=service;
    }
    @GetMapping("/listarProductos")
      public List<producto> listarProducto(){
        return  service.listarProducto();
    }

    @PostMapping("/agregarProducto")
    public ResponseEntity<String> agregarProducto(@RequestBody producto producto){


            return   service.agregarProducto(producto);
        }

    }





