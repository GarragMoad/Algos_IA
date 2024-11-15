package tp1_vEtudiants.exercice1.out.production.exercice1.tp1_vEtudiants.exercice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bipartition {
    // Vous pouvez utiliser d'autres structures de donnees, notamment les List
    static ArrayList<Integer> E = new ArrayList<Integer>( Arrays.asList(2, 10, 3, 8, 5, 7, 9, 5, 3,2) );

    static ArrayList<Integer> F = new ArrayList<Integer>(
            Arrays.asList(771, 121, 281, 854, 885, 734, 486, 1003, 83, 62)
    );
    static ArrayList<Integer> sListe1 = new ArrayList<Integer>();
    static ArrayList<Integer> sListe2 = new ArrayList<Integer>();


    public static void main(String[] args) {

        ArrayList<Integer> liste = F;

        System.out.print("Liste initiale : ");
        Collections.sort((List<Integer>) liste);
        afficher(liste);

        //methode1(liste);
        utiliserMotieSommeCommeRepere(liste);

        System.out.print("Sous-liste 1 : ");
        afficher(sListe1);

        System.out.print("Sous-liste 2 : ");
        afficher(sListe2);
    }

    // Methode 1 :
    //			Trier l'ensemble par ordre décroissant
    //			Parcourir l'ensemble trié et ajouter chaque élément au sous-ensemble dont le somme est la plus petite.
    public static void completerSousEnsembleLePulsPetit(ArrayList<Integer> liste) {

        // Sort the list in descending order
        Collections.sort(liste, Collections.reverseOrder());

        // Iterate through the sorted list
        for (int i : liste) {
            // Add the element to the sublist with the smaller sum
            if (sListe1.stream().mapToInt(Integer::intValue).sum() <= sListe2.stream().mapToInt(Integer::intValue).sum()) {
                sListe1.add(i);
            } else {
                sListe2.add(i);
            }
        }
    }


    // Methode 2 :
    //			Calculer la somme des elements de la liste initiale
    //			Diviser cette somme par 2 pour avoir un reprere
    //			Trier ma liste initiale par ordre decroissant
    //			Remplir la premiere sous-liste avec des elements de la liste principale, en veillant a ne pas depasser somme/2
    public static void utiliserMotieSommeCommeRepere(ArrayList<Integer> liste) {

            int somme = somme(liste);
            int repere = somme / 2;

            Collections.sort(liste, Collections.reverseOrder());

            for (int i : liste) {
                if (somme(sListe1) + i <= repere) {
                    sListe1.add(i);
                }
            }

            for (int i : liste) {
                if (!sListe1.contains(i)) {
                    sListe2.add(i);
                }
            }
    }

    public static int somme(ArrayList<Integer> liste) {

        int n = 0 ;

        if (!liste.isEmpty()) {
            for (int i : liste) {
                n += i;
            }
        }

        return n;

    }

    public static void afficher(ArrayList<Integer> liste) {

        for (int i = 0; i < liste.size(); i++) {
            System.out.print(liste.get(i));
            if (i != liste.size()-1)
                System.out.print(", ");
        }
        System.out.println(" (" + somme(liste) + ")");

    }

}
