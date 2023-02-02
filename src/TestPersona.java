public class TestPersona {
    public static void main(String[] args) {
        Fecha fechaNacimiento = new Fecha("29/1/1970");
        Fecha otraFecha = new Fecha("1/2/2023");
        Nif nif = new Nif( 21691308 );
        Address address = new Address( "España","Córdoba",
                "Córdoba","C\\ Doctor Gregorio Marañon 3, Piso 3, Puerta 3" );

        Persona dadASY = new Persona( nif,"Fran", "Gregori", "Tandazo","642603912",fechaNacimiento, address );

        System.out.println(dadASY.esMayorEdad());
    }
}
