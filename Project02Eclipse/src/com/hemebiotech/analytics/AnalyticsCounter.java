package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();  // Utilise le lecteur pour obtenir les symptômes
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();

        for (String symptom : symptoms) {
            // symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        	if (symptomCount.containsKey(symptom)) {
        		symptomCount.put(symptom,symptomCount.get(symptom)+1);
        	}
        	else {
        		symptomCount.put(symptom,1);
        	}
        }

        return symptomCount;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
  
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);  // Utilise writer pour écrire les résultats
    }

    public static void main(String[] args) throws Exception {
        // Créez des instances des classes de lecture et d'écriture
    	ISymptomReader reader = new ReadSymptomDataFromFile(".\\Project02Eclipse\\symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Créez une instance de AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Étapes du processus
        List<String> symptoms = counter.getSymptoms();  // Récupérer les symptômes
        Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);  // Compter les symptômes
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);  // Trier les symptômes
        counter.writeSymptoms(sortedSymptoms);  // Écrire les résultats dans un fichier
    }
}