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

    public boolean esMayorEdad(){
        Fecha fecha = new Fecha("1/2/2023");
        return fechaNacimiento.getAnyosTranscurridos( fecha  ) >= 18;
    }

    public boolean estaJubilado(){
        Fecha fecha = new Fecha("1/2/2023");
        return fecha.getAnyosTranscurridos( fechaNacimiento  ) >= 65;
    }
}
