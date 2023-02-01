import java.time.LocalDate;
import java.time.Period;

public class Persona {
    //Agregación == No Dependencia

    //Atributos
    private Nif     nif;
    private String  nombre;
    private String  primerApellido;
    private String  segundoApellido;
    private String  numeroTlf;
    private Fecha   fechaNacimiento;
    private Address address;

    //Constructor
    public Persona(Nif nif, String nombre, String primerApellido, String segundoApellido, String numeroTlf, Fecha fechaNacimiento, Address address) {
        this.nif             = nif;
        this.nombre          = nombre;
        this.primerApellido  = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroTlf       = numeroTlf;
        this.fechaNacimiento = fechaNacimiento;
        this.address         = address;
    }

    //Métodos
    public int calculateAge(Fecha fechaNacimiento, Fecha fechaDiaHoy) {
        if ( fechaDiaHoy.getAnyo() > fechaNacimiento.getAnyo() ) {
            if ( fechaNacimiento.getMes() <= fechaDiaHoy.getMes()
                    && fechaNacimiento.getDia() < fechaDiaHoy.getDia() ) {
                return fechaDiaHoy.getAnyo() - fechaNacimiento.getAnyo() - 1;
            }

            if ( fechaNacimiento.getMes() >= fechaDiaHoy.getMes()
                    && fechaNacimiento.getDia() >= fechaDiaHoy.getDia() ) {
                return fechaDiaHoy.getAnyo() - fechaNacimiento.getAnyo();
            }
        }
        return 0;
    }

    public boolean esMayorEdad(int edadPersona){
        return edadPersona >= 18;
    }

    public boolean estaJubilado(int edadPersona){
        return edadPersona >= 65;
    }
}
