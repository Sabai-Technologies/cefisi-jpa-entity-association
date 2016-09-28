package fr.sabai.cefisi.onlinebids.domain.bidrectionnal;


import java.util.HashSet;
import java.util.Set;


public class Item3 {

    /*
     * Maintenant l'association entre ITEM et BID est bidirectionnelle
     *
     * Même questions qu'avec BID2 et ITEM2
     *
     * Pour aller plus loin:
     *      - ajouter une association entre USER(owner) et ITEM
     *
     */
    private Set<Image3> images = new HashSet<Image3>();
}
