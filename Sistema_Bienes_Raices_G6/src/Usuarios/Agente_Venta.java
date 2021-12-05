package Usuarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import sistema_bienes_raices_g6.UIUsuarios;
import sistema_bienes_raices_g6.Venta;

/**
 *Sub-clase de Usuario, que actua como vendedor del sistema, el cual tiene definidos sus metodos
 * getters, setter y menus propios.
 * @author andya
 */
public class Agente_Venta extends Usuario {
    //private ArrayList<Propiedad> ListaPropiedades;
    private static ArrayList<Venta> VentasRealizadas;
    //private ArrayList<Consultas> ListaConsultas;
    private static int contador;
    private int id;
    
     public Agente_Venta(String user, String password, String nombre, int cedula, String correo, int id) {
        super(user, password, nombre, cedula, correo/*, TipoUsuario.Agente_Venta*/);
        VentasRealizadas = new ArrayList<Venta>();
        contador= 0;
        this.id = id;
    }
    
    
    public static void MostrarMenuAgente(){
        Scanner  sc = new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\t\tBienvenido :)");
            System.out.println("\nOPCIONES DE AGENTE DE VENTAS\n");
            System.out.println("1. Revisar Buzon");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    opcion1AV();
                    break;
                case "2":
                    opcion2AV();
                    break;
                case "3":
                    System.out.println("Sesion cerrada");
                    break;  
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!opcion.equals("3"));
        }
    
    private static void opcion1AV(){
        Scanner sc = new Scanner(System.in);
        Scanner scRespuesta = new Scanner(System.in);
        System.out.println("Opcion Buzon de Consultas");
        int consul = 0;

        if(UIUsuarios.getListaConsultas().isEmpty()){
            System.out.println("NO HAY CONSULTAS PARA MOSTRAR... VACIO");
        }else{consul=1;}
        
        for (Consulta c: UIUsuarios.getListaConsultas()){
                System.out.println("Fecha_Inicio\tCodigoPro\tNombre_Agente\tEstado\tPregunta" + "\n" +
                                c.getFechaconsulta() + "\t" + c.getCodigo()+ "\t\t" + c.getAgente().getNombre() + "\t" + c.isIsRespondida()+ "\t" + c.getPregunta());
                               
        }
        
        
        if(consul==1){
            System.out.print("\nIngrese el id de la propiedad para responder la consulta: ");
            while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Id incorrecta");
                System.out.print("\nIngrese el id de la propiedad para seguir la consulta: ");
            }
            
                    int codigo = sc.nextInt();
            for (Consulta c: UIUsuarios.getListaConsultas()){
                if(c.getCodigo()== codigo){
                    for(Conversacion con:c.getConversaciones()){
                        System.out.println(con);
                    }
                    System.out.print("Desea agregar una respuesta o regresar (si/no): ");
                    String respuesta = scRespuesta.nextLine();
                    if(respuesta.toLowerCase().equals("si")){
                        System.out.print("\nIngrese la respuesta: ");
                        String pregunta = scRespuesta.nextLine();
                        LocalDate fechapreg = LocalDate.now();
                        Conversacion nuevo_mss  = new Conversacion(fechapreg, pregunta);
                        c.getConversaciones().add(nuevo_mss);
                        contador+=1;
                    }
                }
            }//-->FOR QUE RECORRE LA LISTA DE CONSULTAS
        
        }//--> IF QUE ACTUA CUNADO ExISTE AL MENOS 1 CONSULTA QUE MOSTRAR, SI NO MUESTRA QUE ESTA VACIO
    }
    
    
    private static void opcion2AV(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opcion Resgistrar Venta");
        System.out.println("Ingrese los datos del cliente al que se realizo la venta");
        System.out.print("Ingrese el nombre del cliente:");
        String nombrec = sc.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String correoc= sc.nextLine();
        System.out.print("Ingrese los datos la cedula del cliente: ");
        while(!sc.hasNextInt()){
                sc.nextLine();
                System.out.println("Cedula Identidad Incorrecta");
                System.out.print("Ingrese su identificacion correctamente:");
            }

        int cedulac= sc.nextInt();
        sc.nextLine();
        
        //Pido los datos de la venta que realizo, creo una venta con esos datos y lo añado a la lista de ventas realizadas
        Cliente cv = new Cliente(nombrec, correoc, cedulac);
        LocalDate fechav = LocalDate.now();
        Venta v = new Venta(fechav, cv);
   
        VentasRealizadas.add(v);
        
    
    }

    public int getId() {
        return id;
    }

    public static void setVentasRealizadas(ArrayList<Venta> VentasRealizadas) {
        Agente_Venta.VentasRealizadas = VentasRealizadas;
    }

    public ArrayList<Venta> getVentasRealizadas() {
        return VentasRealizadas;
    }
    
    public int getContador(){
        return contador;
    }
    
    public void mostrarInformacion(){
        System.out.print("\nVentas:"+ VentasRealizadas.size()+"\nConsultas:"+calcularNumeroConsultas()+
                "\nNombre: "+super.getNombre()+"\nUsuario: "+super.getUser());
    }
    
    public int calcularNumeroConsultas(){
       
        for(Consulta c: UIUsuarios.getListaConsultas()){
            if(c!=null){
                if(c.getAgente().getId()==id){
                contador +=1;
                return contador;
                }
            }
        }
        return contador;
    }
    
    
    public int calcularVentasRealizadas(){
        return VentasRealizadas.size();
    }
}

