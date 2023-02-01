public class Nif {
    //Atributos
    private int  dni;
    private char letraDni;

    public Nif(int dni) {
        this.dni      = dni;
        this.letraDni = obtenerLetraDni();
    }

    //Getters / Consultores
    public String getNif() {
        return String.valueOf( this.dni + this.letraDni );
    }

    public int getDni() {
        return this.dni;
    }

    public char getLetraDni() {
        return this.letraDni;
    }

    //Métodos
    private int obtenerPosiccionLetra() {
        return this.dni % 23;
    }

    private char obtenerLetraDni() {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[obtenerPosiccionLetra()];
    }

    public void mostraInfo() {
        System.out.println( "----- TEST Clase NIF -----" );
        System.out.printf( "El NIF del DNI %d es %s\n", this.dni, this.letraDni );
    }
}