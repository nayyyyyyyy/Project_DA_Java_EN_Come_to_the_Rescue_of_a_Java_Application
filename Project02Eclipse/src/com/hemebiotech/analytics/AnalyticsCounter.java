package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) {
        // Lecture des symptômes
    	ISymptomReader reader = new ReadSymptomDataFromFile("C:\\Users\\Alexis\\loire-alexis-debug-Java\\Project02Eclipse\\symptoms.txt");
    	List<String> symptoms = reader.GetSymptoms();

        // Comptage des occurrences
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }

        // Écriture des résultats dans un fichier
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        writer.writeSymptoms(symptomCounts);

        System.out.println("Traitement terminé. Résultats enregistrés dans result.out.");
    }
}
