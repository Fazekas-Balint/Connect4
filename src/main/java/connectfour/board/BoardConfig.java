package connectfour.board;

public enum BoardConfig  {
    /**
     * A sorok száma a táblán.
     */
    ROWS(6),
    /**
     * Az oszlopok száma a táblán.
     */
    COLUMNS(7),
    /**
     * Az üres mezők jelölése a táblán.
     */
    EMPTY_SLOT('.');

    /**
     * Int érték.
     */
    private final int intValue;
    /**
     * Karakterérték.
     */
    private final char charValue;

    // Konstruktor az egész szám típusú értékekhez (ROWS és COLUMNS)
    BoardConfig(final int value) {
        this.intValue = value;
        this.charValue = '\0'; // Alapértelmezett érték, ha nem karakter
    }

    // Konstruktor a karakter típusú értékhez (EMPTY_SLOT)
    BoardConfig(final char value) {
        this.intValue = -1; // Alapértelmezett érték, ha nem egész szám
        this.charValue = value;
    }
    /**
     * Metódus az egész szám típusú értékek lekéréséhez.
     * @return .
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Metódus a karakter típusú érték lekéréséhez.
     * @return .
     */
    public char getCharValue() {
        return charValue;
    }


}
