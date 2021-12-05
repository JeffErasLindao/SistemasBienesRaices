/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.time.LocalDate;


/**
 * Clase la cual guarda las fechas y el mensaje la cual puede ser una pregunta o una respuesta dependiendo
 * de que usuario la este utilizando
 * @author jeras
 */
public class Conversacion {
    private LocalDate fechaMss;
    private String mss;
    
    public Conversacion (LocalDate fechaMss, String mss){
        this.fechaMss=fechaMss;
        this.mss=mss;
    }
    
    @Override
    public String toString(){
     return fechaMss + ":" + mss ;   
    }
    
    public void mostrarConversacion(){
        System.out.println("Fecha:"+fechaMss+" - Pregunta: "+mss);
    }
}
