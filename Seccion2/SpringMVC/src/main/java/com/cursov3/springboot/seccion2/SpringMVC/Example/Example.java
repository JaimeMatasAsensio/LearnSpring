package com.cursov3.springboot.seccion2.SpringMVC.Example;

import java.time.LocalDate;


public class Example {

    private String mensaje;

    private String fecha;

    public Example(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Example() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
