package com.example.Examen.service;
import com.example.Examen.entity.producto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class producto_service {


    public List<producto> productos = new ArrayList<>();


    public producto_service() {

        productos.add(new producto(1, "papa", "verdura", 1500f, 20));
        productos.add(new producto(2, "frijol verde", "verdura", 1100f, 40));
        productos.add(new producto(3, "banano", "fruta", 900f, 10));
        productos.add(new producto(4, "papaya", "fruta", 2100f, 2));
        productos.add(new producto(5, "Arroz doria Por 500gr", "grano", 1500f, 20));
        productos.add(new producto(6, "pasta doria 250gr ", "grano", 1500f, 40));
        productos.add(new producto(7, "durazno", "fruta", 1500f, 5));
        productos.add(new producto(8, "pitaya", "fruta", 3000f, 20));
        productos.get(0).aplicarDescuento();
    }

    public List<producto> listarProducto() {
        return productos;
    }

    public producto buscarProducto(int referencia) {
        for (producto producto : productos) {
            if (producto.getReferencia() == referencia) {
                return producto;
            }
        }
        return null;
    }

    public ResponseEntity<String> agregarProducto(producto productoagregado) {
        if (buscarProducto(productoagregado.getReferencia()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(  "{\"error\": \"El producto ya está en la lista.\"}");
        }
        if (productoagregado.getCantidad() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"La cantidad del producto debe ser mayor a 0.\"}");
        }
        if (productoagregado.getPrecio_unitario() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"El precio unitario debe ser mayor a 0.\"}");
        }
        productos.add(productoagregado);
        productoagregado.aplicarDescuento();

        ObjectMapper mapper = new ObjectMapper();
        String mensaje;
        try {
            mensaje = mapper.writeValueAsString("el producto ah sido agregado exitosamente");
        }catch (JsonProcessingException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error al ingresar los datos");
        }
        return ResponseEntity.ok(mensaje);
    }









}
