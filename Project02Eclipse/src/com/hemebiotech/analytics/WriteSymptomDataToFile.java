package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de ISymptomWriter pour écrire les données des symptômes dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * Constructeur avec le chemin du fichier où écrire les données.
     * 
     * @param filepath Chemin vers le fichier de sortie.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
