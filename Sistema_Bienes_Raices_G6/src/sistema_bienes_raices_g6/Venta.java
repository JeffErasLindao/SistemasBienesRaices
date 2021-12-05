
package sistema_bienes_raices_g6;

import Usuarios.Agente_Venta;
import Usuarios.Cliente;
import java.time.LocalDate;

/**
 * Contiene la fecha de venta y datos del comprador.  
 * @author andya
 */
public class Venta {
    /**
     * @param fechaVenta contiene la fecha en la que se realizo la venta
     * @param comprador contiene el nombre de su cliente
     */
    private LocalDate fechaVenta;
    private Cliente Comprador;
    
    /**
     * Constructor de 2 parametros
     * @param fechaVenta
     * @param Comprador 
     */
    public Venta(LocalDate fechaVenta, Cliente Comprador){
        this.fechaVenta = fechaVenta;
        this.Comprador= Comprador;
    }
    
    /**
     * Getter Devuelve-fechaVenta
     * @return fechaVenta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    
    /**
     * Getter Devuelve-Comprador
     * @return Comprador
     */
    public Cliente getComprador() {
        return Comprador;
    }
    
    
}
