/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clasela cual contiene informacion de las consulta creada por un cliente, el cual el agente de venta,
 * tendra interaccion, dentro de esta clase habran conversaciones las cuales serán preguntas y respuestas
 * correspondientes a los clientes y agentes respectivamente
 * @author ALICE
 */
public class Consulta {
    private LocalDate fechaconsulta;
    private int codigo;
    private Agente_Venta agente;
    private boolean isRespondida;
    private String pregunta;
    private ArrayList<Conversacion> conversaciones;
    
    public Consulta(LocalDate fechaconsulta, int codigo,Agente_Venta agente, String pregunta, boolean isRespondido) {
        this.pregunta=pregunta;
        this.fechaconsulta=fechaconsulta;
        this.agente=agente;
        this.isRespondida=isRespondida;
        this.codigo=codigo;
        this.conversaciones = new ArrayList<Conversacion>();
//To change body of generated methods, choose Tools | Templates.
    }

    public LocalDate getFechaconsulta() {
        return fechaconsulta;
    }

    public int getCodigo() {
        return codigo;
    }

    public Agente_Venta getAgente() {
        return agente;
    }

    public ArrayList<Conversacion> getConversaciones() {
        return conversaciones;
    }

    public boolean isIsRespondida() {
        return isRespondida;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setFechaconsulta(LocalDate fechaconsulta) {
        this.fechaconsulta = fechaconsulta;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAgente(Agente_Venta agente) {
        this.agente = agente;
    }

    public void setIsRespondida(boolean isRespondida) {
        this.isRespondida = isRespondida;
    }
    
    public void anadirConversacion(Conversacion con){
        conversaciones.add(con);
    }
}