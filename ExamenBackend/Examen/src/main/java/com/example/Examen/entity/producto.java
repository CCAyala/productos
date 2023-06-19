package com.example.Examen.entity;
import java.util.Arrays;
import java.util.List;

public class producto {

    private int referencia;
    private String nombre;
    private String categoria;
    private float precio_unitario;
    private int cantidad;
    private float descuento;
    private float total;

   private static final List<String> categoriacondescuento= Arrays.asList("fruta");


    public producto(int referencia, String nombre, String categoria, float precio_unitario, int cantidad) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        calcularTotal();
        aplicarDescuento();
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {


        return categoria;
    }

    public void setCategoria(String categoria) {

            this.categoria = categoria;
            aplicarDescuento();
            calcularTotal();
        }


    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
        calcularTotal();
        aplicarDescuento();
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
        calcularTotal();
        aplicarDescuento();
    }

    public float getDescuento() {
        return descuento;
    }

    public void aplicarDescuento() {
        if (categoriacondescuento.contains(categoria.toLowerCase())) {
            calcularTotal();
            descuento = total * 0.1f;
            total -= descuento;
        }else {
            descuento = 0.0f;
        }

    }

    public float getTotal() {
        return total;
    }

    public float calcularTotal() {

        total = cantidad * precio_unitario;

        return total;
    }

}
