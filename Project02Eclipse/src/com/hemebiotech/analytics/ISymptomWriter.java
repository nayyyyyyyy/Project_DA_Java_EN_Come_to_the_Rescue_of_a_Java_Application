package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface pour écrire les données de symptômes.
 * Permet de spécifier une méthode pour enregistrer les symptômes et leurs occurrences dans un fichier.
 */
public interface ISymptomWriter {
    /**
     * Écrit les données des symptômes dans un fichier.
     * 
     * @param symptoms Une Map contenant les symptômes comme clés et leurs occurrences comme valeurs.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}

