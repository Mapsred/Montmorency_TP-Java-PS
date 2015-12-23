import java.text.DecimalFormat;
import java.util.Scanner;

public class TP1 {

	public static void main(String[] args) {
		// François Mathieu Groupe 60
		// TP1 pour le 10 Février 2015

		// tableau des élèves
		String[] noms = { "Alain    ", "Pierre    ", "Claude   ", "Danielle ",
				"Dominique" };
		// tableau des matières
		String[] matieres = { "Maths   ", "Français", "Info    ", "Anglais ",
				"Biologie", "Ecolo.  ", "Chimie  ", "Phys    " };

		double[][] notes = new double[5][9];
		Scanner Lire = new Scanner(System.in);

		// déclaration des valeurs du tableau 'notes'
		notes[0][0] = 80;
		notes[0][1] = 85;
		notes[0][2] = 70;
		notes[0][3] = 65;
		notes[0][4] = 72;
		notes[0][5] = 65;
		notes[0][6] = 65;
		notes[0][7] = 78;

		notes[1][0] = 60;
		notes[1][1] = 70;
		notes[1][2] = 65;
		notes[1][3] = 70;
		notes[1][4] = 84;
		notes[1][5] = 55;
		notes[1][6] = 63;
		notes[1][7] = 76;

		notes[2][0] = 65;
		notes[2][1] = 75;
		notes[2][2] = 80;
		notes[2][3] = 60;
		notes[2][4] = 70;
		notes[2][5] = 65;
		notes[2][6] = 65;
		notes[2][7] = 70;

		notes[3][0] = 58;
		notes[3][1] = 90;
		notes[3][2] = 69;
		notes[3][3] = 80;
		notes[3][4] = 65;
		notes[3][5] = 65;
		notes[3][6] = 67;
		notes[3][7] = 80;

		notes[4][0] = 70;
		notes[4][1] = 80;
		notes[4][2] = 70;
		notes[4][3] = 60;
		notes[4][4] = 70;
		notes[4][5] = 65;
		notes[4][6] = 60;
		notes[4][7] = 80;

		calculerMoyenneMat(matieres, noms, notes);
		// Calculer la moyenne de chaque élève
		// calculerMoyenneEleve(matieres, noms, notes);

		// afficherBulletin(matieres, noms, notes);

	}

	public static void trait(char caractere, int nbDeFois) {
		for (int i = 0; i < nbDeFois; i++) {
			System.out.print(caractere);
		}
	}

	public static void calculerMoyenneMat(String[] matieres, String[] noms,
			double[][] notes) {

		double[] moyenneMat = new double[9];
		double[] somme = new double[8];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				somme[j] += notes[i][j];
			}
		}

		for (int i = 0; i < 8; i++) {
			moyenneMat[i] = somme[i] / 5;
		}
		calculerMoyenneEleve(matieres, noms, notes, moyenneMat);
	}

	public static void calculerMoyenneEleve(String[] matieres, String[] noms,
			double[][] notes, double[] moyenneMat) {

		double[] moyenne = new double[5];
		double[] somme = new double[5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				somme[i] += notes[i][j];
			}
		}

		// Moyenne par élèves
		for (int i = 0; i < 5; i++) {
			moyenne[i] = somme[i] / 8;
			// System.out.print(moyenne[i] + " ");
			// System.out.println(" ");
		}

		for (int i = 0; i < 5; i++) {
			notes[i][8] = moyenne[i];
		}
		// Présentation des résultats de l'ensemble des élèves
		afficherNomNoteMoyenne(matieres, noms, notes, moyenneMat);
	}

	public static void afficherNomNoteMoyenne(String[] matieres, String[] noms,
			double[][] notes, double[] moyenneMat) {
		char caractere = '-';
		int nbDeFois = 50;
		double somme = 0;
		DecimalFormat df = new DecimalFormat(",##0.00;(,##0.00)");

		System.out.println("Présentation des résultats "
				+ "de l'ensemble des élèves");

		// Tracer une ligne
		trait(caractere, nbDeFois);
		System.out.println("\n");

		// affiche les matières
		System.out.print("\t\t ");
		for (int i = 0; i < matieres.length; i++) {
			System.out.print(matieres[i] + " ");
		}
		System.out.println("Moy.élèves ");
		// Trace une ligne
		trait(caractere, nbDeFois);
		System.out.println(" ");

		// affiche les noms et les notes
		for (int i = 0; i < 5; i++) {
			System.out.print(noms[i] + "\t");
			for (int j = 0; j < 9; j++) {
				System.out.print(df.format(notes[i][j]) + "    ");
			}
			System.out.println(" ");
		}

		for (int i = 0; i < 5; i++) {
			somme += notes[i][8];
		}
		moyenneMat[8] = somme / 5;
		// Trace une ligne
		trait(caractere, nbDeFois);
		System.out.println(" ");
		System.out.print("MOYENNE mat\t");
		for (int i = 0; i < moyenneMat.length; i++) {
			System.out.print(moyenneMat[i] + "     ");
		}
		System.out.println("\n\n");
		afficherBulletin(matieres, noms, notes, moyenneMat);
	}

	public static void afficherBulletin(String[] matieres, String[] noms,
			double[][] notes, double[] moyenneMat) {
		char caractere = '-';
		int nbDeFois = 60;

		for (int i = 0; i < noms.length; i++) {
			System.out.println("\t\tÉcole secondaire Duvernay\n");
			System.out.println("Nom de l'élève : " + noms[i]);
			trait(caractere, nbDeFois);
			System.out.println("\nMatières \t\tNotes \t\tMoyennes groupe");
			trait(caractere, nbDeFois);
			System.out.println(" ");
			for (int j = 0; j < matieres.length; j++) {
				System.out.println(matieres[j] + "\t\t\t" + notes[i][j]
						+ "\t\t" + moyenneMat[j]);
			}
			System.out.println("\n\tMoyenne de l'élève : " + notes[i][8]);

			System.out.println("\n\tMoyenne de la classe : " + moyenneMat[8]);

			System.out.println("\n\n");
		}
	}

}
