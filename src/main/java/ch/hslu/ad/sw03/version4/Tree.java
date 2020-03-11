package ch.hslu.ad.sw03.version4;


/**
 * Interface zur Definition der wichtigsten Methoden zur Implementation einer Tree-Datenstruktur.
 */
public interface Tree<T> {

    /**
     * Methode um ein Datenelement einer Tree-Datenstruktur hinzuzufügen.
     * @param element Generischer Datentyp
     * @return {@code true} oder {@code false} zur Aussage, ob das Objekt hinzugefügt wurde oder nicht.
     */
    boolean add(T element);

    /**
     * Methode um die komplette Datenstruktur zu löschen.
     */
    void clear();

    /**
     * Methode zur Abfrage ob ein Objekt in der Datenstruktur vorhanden ist.
     * @param element Generischer Datentyp
     * @return {@code true} oder {@code false} zur Aussage, ob das Objekt enthalten ist.
     */
    boolean contains(T element);

}
