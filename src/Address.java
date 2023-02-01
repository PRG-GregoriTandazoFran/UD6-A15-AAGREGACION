public class Address {
    //Atributos
    private String pais;
    private String provincia;
    private String ciudad;
    private String direccionPostal;

    //Constructor
    public Address(String pais, String provincia, String ciudad, String direccionPostal) {
        this.pais            = pais;
        this.provincia       = provincia;
        this.ciudad          = ciudad;
        this.direccionPostal = direccionPostal;
    }
}
