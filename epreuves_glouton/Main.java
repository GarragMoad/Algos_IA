package tp1_vEtudiants.exercice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tp1_vEtudiants.exercice1.Epreuve;
import tp1_vEtudiants.exercice1.ListeEpreuves;

public class Main {

	public static void main(String[] args) {
		
		String fichierEpreuves = "C:\\Users\\garra\\Documents\\ESIREM\\4A\\IA\\TP_algos\\epreuves_glouton\\out\\production\\exercice1\\tp1_vEtudiants\\exercice1\\Epreuves.txt";
		
		ListeEpreuves listeEpreuves = new ListeEpreuves(fichierEpreuves);



		/*System.out.println("#################################################");
		System.out.println("# Toutes les epreuves inscrites dans le fichier #");
		System.out.println("#################################################");
		
		System.out.println(listeEpreuves);
		System.out.println();*/
		
		listeEpreuves.triParHeureFin();
		
		System.out.println("#################################################");
		System.out.println("# Epreuves triees par horaires de fin croissant #");
		System.out.println("#################################################");
		
		System.out.println(listeEpreuves);
		System.out.println();
		
		
		/*Epreuve e = listeEpreuves.get(3);
		listeEpreuves.eliminerConflits(e);
		
		System.out.println("#################################################");
		System.out.println("#  Epreuves apres suppression des conflits de   #");
		System.out.println("#              l'epreuve de " +  e.getIntitule() + "             #");
		System.out.println("#################################################");
		
		
		System.out.println(listeEpreuves);
		System.out.println();*/
		
				
		ArrayList<Epreuve> planning = new ArrayList<Epreuve>();
		// Implementez votre algorithme de planification efficace des epreuves.
		// Les epreuves retenues seront ajoutees, au fur et a mesure dans "planning"
			while(listeEpreuves.getListe().size()>0){
			planning.add(listeEpreuves.get(0));
			listeEpreuves.eliminerConflits(listeEpreuves.get(0));
		}


		
		//Collections.sort((List<Epreuve>) planning);
		
		System.out.println("#################################################");
		System.out.println("#             Planning des epreuves             #");
		System.out.println("#################################################");
		
		for (int i = 0; i < planning.size(); i++) {
			System.out.println(planning.get(i));
		}
	}


}
