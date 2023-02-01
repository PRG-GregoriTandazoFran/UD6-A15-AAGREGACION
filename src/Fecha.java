class Fecha {
    // Atributos
    private int dia;
    private int mes;
    private int anyo;

    private static final String[] DIAS_TEXTO = new String[]{"domingo", "lunes", "martes", "miercoles", "jueves", "viernes",
            "sábado"};

    private static final String[] MESES_TEXTO = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio",
            "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    private static final int[] MESES_ANYO = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    private static final int[] DIAS_MESES = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructores

    /**
     * Constructor por defecto
     * Inicializa una fecha a dia 1-1-1970
     */
    public Fecha() {
        // tu codigo aqui
        this.dia  = 1;
        this.mes  = 1;
        this.anyo = 1970;
    }

    /**
     * Inicializa la fecha
     *
     * @param dia  de la semana
     * @param mes  del año
     * @param anyo
     */
    public Fecha(int dia, int mes, int anyo) {
        // Tu código aquí
        this.dia  = dia;
        this.mes  = mes;
        this.anyo = anyo;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     * <p>
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
     *
     * @param fecha
     */
    public Fecha(String fecha) {
        // Tu código aquí
        String[] fechaArray = fecha.split( "/" );
        this.dia  = Integer.parseInt( fechaArray[0] );
        this.mes  = Integer.parseInt( fechaArray[1] );
        this.anyo = Integer.parseInt( fechaArray[2] );
    }

    // Getters / Consultores

    /**
     * Devuelve el día de la semana que representa por la Fecha actual
     *
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Devuelve el mes que representa la Fecha actual
     *
     * @return @mes
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devuelve el año que representa la Fecha actual
     *
     * @return @mes
     */
    public int getAnyo() {
        return this.anyo;
    }

    // Setters / Modificadores

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     */
    public void set(int dia, int mes, int anyo) {
        // Tu código aquí
        this.dia  = dia;
        this.mes  = mes;
        this.anyo = anyo;
    }

    /**
     * Obtiene una fecha con los mismos atributos que la fecha actual
     *
     * @return
     */
    public Fecha clone() {
        return new Fecha( this.dia, this.mes, this.anyo );
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarFormatoES() {
        // Tu código aquí
        System.out.printf( "%02d-%02d-%04d\n", getDia(), getMes(), getAnyo() );
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarFormatoGB() {
        // Tu código aquí
        System.out.printf( "%04d-%02d-%02d\n", getAnyo(), getMes(), getDia() );
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy
     * Ej. 1 enero de 1970
     */
    public void mostrarFormatoTexto() {
        // Tu código aquí
        System.out.printf( "%02d-%s-%d", getDia(), getMesTexto(), getAnyo() );
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
     * argumento
     *
     * @return boolean
     */
    public boolean isEqual(Fecha otraFecha) {
        return otraFecha.dia == this.dia &&
                otraFecha.mes == this.mes &&
                otraFecha.anyo == this.anyo;
    }

    /**
     * Retorna el dia correspondiente de la semana en formato String
     *
     * @return String
     */
    public String getDiaSemana() {
        return DIAS_TEXTO[getDiasTranscurridosOrigen() % 7];
    }

    /**
     * Solo Festivo sábado o domingo
     *
     * @return boolean
     */
    public boolean isFestivo() {
        return getDiaSemana().equalsIgnoreCase( "sábado" ) || getDiaSemana().equalsIgnoreCase( "domingo" );
    }

    /**
     * Devuelve el número de la semana dentro del año actual.
     *
     * @return int dia semana
     */
    public int getNumeroSemana() {
        return (getDiasTranscurridosAnyo() / 7) + 1;
    }

    /**
     * Devuelve un objeto de tipo fecha que representa una fecha añadiendo @numDias
     * A la fecha Actual. El número máximo de dias a restar es 30
     *
     * @return Fecha
     */
    public Fecha anyadir(int numDias) {
        if ( numDias <= 30 && numDias >= 0 ) {
            int ultimoDiaFebrero = 28;
            if ( isBisiesto( this.anyo ) ) {
                MESES_ANYO[1]++;
                ultimoDiaFebrero = 29;
            }

            int diaActual  = this.dia + numDias;
            int mesActual  = MESES_ANYO[mes - 1];
            int anyoActual = this.anyo;


            if ( diaActual > DIAS_MESES[this.mes - 1] ) {
                diaActual -= DIAS_MESES[this.mes - 1];
                if ( this.mes == 12 ) {
                    mesActual = 1;
                    anyoActual++;
                } else {
                    mesActual = MESES_ANYO[this.mes];
                }
                if ( mesActual == 2 && diaActual > ultimoDiaFebrero ) {
                    diaActual -= ultimoDiaFebrero;
                    mesActual++;
                }
            }

            if ( isBisiesto( this.anyo ) ) {
                MESES_ANYO[1]--;
            }
            return new Fecha( diaActual, mesActual, anyoActual );
        }
        return null;
    }

    /**
     * Devuelve un objeto de tipo fecha que representa una fecha restando @numDias
     * A la fecha Actual. El número máximo de dias a restar es 30
     *
     * @return Fecha
     */
    public Fecha restar(int numDias) {
        if ( numDias <= 30 && numDias >= 0 ) {
            int ultimoDiaFebrero = 28;
            if ( isBisiesto( this.anyo ) ) {
                MESES_ANYO[1]++;
                ultimoDiaFebrero = 29;
            }

            int diaActual  = this.dia - numDias;
            int mesActual  = this.mes;
            int anyoActual = this.anyo;

            if ( diaActual < 1 ) {
                diaActual *= -1;

                if ( this.mes == 3 && diaActual >= ultimoDiaFebrero ) {
                    diaActual = DIAS_MESES[0] - (DIAS_MESES[1] - diaActual);
                    mesActual = 1;
                } else if ( this.mes == 1 ) {
                    mesActual = 12;
                    anyoActual--;
                    diaActual = DIAS_MESES[11] - diaActual;
                } else {
                    mesActual = MESES_ANYO[this.mes - 1];
                    diaActual = DIAS_MESES[this.mes - 1] - diaActual;
                }
            }

            if ( isBisiesto( this.anyo ) ) {
                MESES_ANYO[1]--;

            }
            return new Fecha( diaActual, mesActual, anyoActual );
        }
        return null;
    }

    public boolean isCorrecta() {
        if ( this.dia < 1 || this.mes < 1 || this.anyo < 1 ) {
            return false;
        } else return isBisiesto( this.anyo ) || this.dia < 29;
    }

    // Métodos Privados

    /**
     * Retorna el mes del año en formato text (enero, febrero, marzo,...)
     *
     * @return char
     */
    private String getMesTexto() {
        return MESES_TEXTO[getMes() - 1];
    }

    /**
     * Devuelve el número de dias transcurridos desde el 1-1-1
     *
     * @return int
     */
    private int getDiasTranscurridosOrigen() {
        int diasTotalesHastaLaFecha = 0;
        for ( int anyosTranscurridos = 1 ; anyosTranscurridos <= this.anyo ; anyosTranscurridos++ ) {
            diasTotalesHastaLaFecha += getDiasAnyo( anyosTranscurridos );
        }
        int diasSobrantes = getDiasAnyo( this.anyo ) - getDiasTranscurridosAnyo();
        return diasTotalesHastaLaFecha - diasSobrantes;
    }

    /**
     * Devuelve el número de dias transcurridos en el anyo que representa el objeto
     *
     * @return int
     */
    private int getDiasTranscurridosAnyo() {
        int diasTranscurridos = 0;
        for ( int contadorMes = 1 ; contadorMes < this.mes ; contadorMes++ ) {
            diasTranscurridos += getDiasMes( contadorMes, this.anyo );
        }
        return diasTranscurridos + this.dia;
    }

    /**
     * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si es divisible por 4
     * pero no es divisible entre 100 o es divisible entre 4 entre 100 y entre 400
     *
     * @return boolean
     */

    // Método Estáticos
    public static boolean isBisiesto(int anyo) {
        return anyo % 4 == 0 && anyo % 100 != 0 || anyo % 4 == 0 && anyo % 100 == 0 && anyo % 400 == 0;
    }

    /**
     * Calcula el número de días que tiene el @mes en el @año pasado como argumento
     * Deberás hacer uso del métodos isBisiesto
     *
     * @return int total dias mes en curso
     */
    public static int getDiasMes(int mes, int anyo) {
        if ( isBisiesto( anyo ) && mes == 2 ) {
            return 29;
        }

        return switch ( mes ) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            default -> 30;
        };
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @return int total dias anyo en curso
     */
    public static int getDiasAnyo(int anyo) {
        if ( isBisiesto( anyo ) ) {
            return 366;
        }
        return 365;
    }
}