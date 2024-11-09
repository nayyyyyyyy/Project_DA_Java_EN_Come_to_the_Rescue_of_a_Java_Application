package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
    private static int headacheCount = 0;    // Je l'ai initialisé à 0
    private static int rashCount = 0;        // Je l'ai initialisé à 0
    private static int pupilCount = 0;       // Je l'ai initialisé à 0 
    
    public static void main(String args[]) throws Exception {
        try (// D'abord, je lis l'entrée depuis le fichier
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
			    System.out.println("symptôme du fichier : " + line);
			    
			    if (line.equals("headache")) { // J'ai corrigé pour utiliser la variable statique 'headacheCount'
			        headacheCount++; // J'ai utilisé 'headacheCount' au lieu de 'headCount'
			        System.out.println("nombre de maux de tête : " + headacheCount); // J'ai mis à jour pour utiliser 'headacheCount'
			    }
			    else if (line.equals("rash")) { // J'ai corrigé la faute de frappe 'rush' en 'rash'
			        rashCount++; // J'ai utilisé la variable 'rashCount' correctement ici
			    }
			    else if (line.contains("pupils")) { // J'ai vérifié la logique pour 'pupils', elle est correcte
			        pupilCount++; // J'ai utilisé correctement la variable 'pupilCount'
			    }

			    line = reader.readLine();    // Je récupère un autre symptôme
			}
		}
        // Ensuite, je génère le fichier de sortie
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n"); // J'ai corrigé pour utiliser 'headacheCount' et écrire la bonne valeur
        writer.write("rash: " + rashCount + "\n");         // J'ai ajouté la sortie pour 'rashCount'
        writer.write("dilated pupils: " + pupilCount + "\n"); // J'ai corrigé la faute de frappe 'dialated' en 'dilated'
        writer.close(); // Je ferme le fichier
    }
}


/*package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
    private static int headacheCount = 0;    // initialize to 0
    private static int rashCount = 0;        // initialize to 0
    private static int pupilCount = 0;       // initialize to 0

    public static void main(String args[]) throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();
        
        /----------------------------------------------------------------------------------
 
        int i = 0;    // set i to 0 (note: 'i' n'est pas utilisé dans le code donc peut être supprimé)
        int headCount = 0;    // counts headaches (cette variable 'headCount' est inutilisée et peut causer confusion)

        while (line != null) {
            i++;    // increment i (toujours incrémenté mais inutilisé, peut être supprimé)
            System.out.println("symptom from file: " + line);
            
            if (line.equals("headache")) { // **ERREUR 1**: Utilisation de 'headCount' qui est une variable locale, mais il faut utiliser 'headacheCount' qui est la variable statique
                headCount++; // **CORRECTION 1**: Utiliser la variable statique 'headacheCount' au lieu de la variable locale 'headCount'
                System.out.println("number of headaches: " + headCount);
            }
            else if (line.equals("rush")) { // **ERREUR 2**: 'rush' est probablement une faute de frappe, le symptôme doit être 'rash'.
                rashCount++; // **CORRECTION 2**: Remplacer 'rush' par 'rash' pour correspondre au symptôme attendu
            }
            else if (line.contains("pupils")) { // **AUCUNE ERREUR**, si l'intention est d'identifier le symptôme exact
                pupilCount++; // **AUCUNE ERREUR**, la variable 'pupilCount' est utilisée correctement
            }

            line = reader.readLine();    // get another symptom
        }

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n"); // **ERREUR 3**: Le fichier va imprimer 0 pour les comptages, car 'headacheCount' n'est pas utilisé correctement dans la boucle
        writer.write("rash: " + rashCount + "\n");         // Les autres comptages peuvent également être à 0
        writer.write("dialated pupils: " + pupilCount + "\n"); // Le nom du symptôme est "dilated pupils" et non "dialated pupils"
        writer.close();
    }
}*/

/* Ce programme compte trois symptômes (maux de tête, éruption cutanée, et pupilles dilatées) à partir d'un fichier texte (symptoms.txt) et écrit les résultats dans un fichier de sortie (result.out).*/
