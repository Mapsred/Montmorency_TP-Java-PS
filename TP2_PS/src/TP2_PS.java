import java.util.Scanner;
import java.io.*;

public class TP2_PS {
	static Scanner Lire = new Scanner(System.in);

	public static void main(String[] args) {
		// François Mathieu Groupe 60 TP2 Programmation Structurée
		// Encryptage de fichier texte avec deux methodes différentes
		// desencryptage de fichier texte pour les deux methodes utilisées
		// à partir d'un fichier texte
		// le message est récupéré depuis le fichier texte et est remplacé
		// par le message encrypté
		// menu 1: on affiche le contenu du fichier
		// menu 2: on encrypte avec la méthode Rotation 13
		// menu 3: on encrypte avec la méthode table
		// menu 4: on desencrypte avec la methode Rotation 13
		// menu 5: on desencrypte avec la methode table
		// menu 6: on quitte le programme
		int choix = 0;
		String nomFichier = "", resultat = ""; // nomFichier : original.txt
		char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		do {
			do {
				System.out.println("\t\tMenu Principal");
				// Choix 1 Afficher le fichier
				System.out.println("\n1- Afficher le contenu du fichier");
				// Choix 2 Cryptage Rotation 13
				System.out
						.println("\n2- Crypter le fichier texte avec l’option"
								+ " Rotation 13, afficher le résultat à l’écran"
								+ " et remplacer le contenu du fichier"
								+ " par le texte crypté.");
				// Choix 3 Cryptage Table
				System.out
						.println("\n3- Crypter le fichier texte avec l’option "
								+ "Table, afficher le résultat à l’écran et "
								+ "remplacer le contenu du fichier par "
								+ "le texte crypté.");
				// Choix 4 Déryptage Rotation 13
				System.out.println("\n4- Décrypter et afficher à l’écran "
						+ "le fichier crypté précédemment avec "
						+ "l’option Rotation 13 et remplacer le "
						+ "contenu du fichier par le texte décrypté.");
				// Choix 5 Décryptage Table
				System.out.println("\n5- Décrypter et afficher à l’écran le "
						+ "fichier crypté précédemment avec l’option "
						+ "Table et remplacer le contenu du fichier"
						+ " par le texte décrypté.");
				// Choix 6 Stop
				System.out.println("\n6- Arrêt du programme.");

				System.out.print("\n\nVotre Choix : ");

				choix = Lire.nextInt();

			} while (choix < 1 && choix > 6);

			if (choix >= 1 && choix <= 5) {
				System.out.println("Entrez le nom du fichier");
				nomFichier = Lire.next();
			}

			if (choix == 1) {
				// Choix 1 Afficher le fichier
				AfficherContenuFichier(nomFichier, resultat);
			} else if (choix == 2) {
				// Choix 2 Cryptage Rotation 13
				EncryptageOptionRotation(nomFichier, alpha, resultat);
			} else if (choix == 3) {
				// Choix 3 Cryptage Table
				EncryptageOptionTable(nomFichier, resultat);
			} else if (choix == 4) {
				// Choix 4 Déryptage Rotation 13
				DecryptageOptionRotation(nomFichier, alpha, resultat);
			} else if (choix == 5) {
				// Choix 5 Décryptage Table
				DecryptageOptionTable(nomFichier, resultat);
			} else if (choix == 6) {
				// Choix 6 Stop
			}
		} while (choix != 6);

	}

	public static void EncryptageOptionRotation(String nomFichier,
			char alpha[], String resultat) {
		String ligneLue = "";
		char[] tabMots = new char[200];
		char position;

		try {
			BufferedReader ficEntree = new BufferedReader(new FileReader(
					nomFichier));
			while ((ligneLue = ficEntree.readLine()) != null) {
				System.out.println("Contenu du fichier non encrypté : "
						+ ligneLue);
				for (int i = 0; i < ligneLue.length(); i++) {
					position = ligneLue.charAt(i);
					for (int k = 0; k < alpha.length; k++) {
						if (position == alpha[k]) {
							int j = k + 13;
							if (j > 25) {
								j = k - 13;

							}
							tabMots[i] = alpha[j];
							resultat += tabMots[i];
						}

					}
				}
				ficEntree.close();
				PrintWriter ficSortie = new PrintWriter(new File(nomFichier));
				ficSortie.print(resultat);
				ficSortie.close();
			}

		} catch (IOException e) {
			// System.out.println("\nProblème : " + e.getMessage());
		}
		System.out.println("Contenu du fichier encrypté : " + resultat);

	}

	public static void DecryptageOptionRotation(String nomFichier,
			char alpha[], String resultat) {
		String ligneLue = "";
		char[] tabMots = new char[200];
		char position;

		try {
			BufferedReader ficEntree = new BufferedReader(new FileReader(
					nomFichier));
			while ((ligneLue = ficEntree.readLine()) != null) {
				System.out.println("Contenu du fichier encrypté : " + ligneLue);
				for (int i = 0; i < ligneLue.length(); i++) {
					position = ligneLue.charAt(i);
					for (int k = 0; k < alpha.length; k++) {
						if (position == alpha[k]) {
							int j = k + 13;
							if (j > 25) {
								j = k - 13;
							}
							tabMots[i] = alpha[j];
							resultat += tabMots[i];
						}
					}
				}
				ficEntree.close();
				PrintWriter ficSortie = new PrintWriter(new File(nomFichier));
				ficSortie.print(resultat);
				ficSortie.close();
			}
		} catch (IOException e) {
			// System.out.println("\nProblème : " + e.getMessage());
		}
		System.out.println("Contenu du fichier non encrypté : " + resultat);
	}

	public static void EncryptageOptionTable(String nomFichier, String resultat) {

		String ligneLue = "";
		char[] tabMots = new char[200];
		char position, position2, position3;
		String table = "table.txt";
		String ligneLue2 = "";
		String ligneLue3 = "";

		try {
			BufferedReader ficEntree = new BufferedReader(new FileReader(
					nomFichier));
			BufferedReader Table = new BufferedReader(new FileReader(table));
			while ((ligneLue = ficEntree.readLine()) != null) {
				ligneLue2 = Table.readLine();
				ligneLue3 = Table.readLine();
				System.out.println("ligneLue2 : " + ligneLue2);
				System.out.println("ligneLue3 : " + ligneLue3);

				System.out.println("Contenu du fichier encrypté : " + ligneLue);

				for (int i = 0; i < ligneLue.length(); i++) {
					position = ligneLue.charAt(i);

					for (int k = 0; k < ligneLue2.length(); k++) {
						position2 = ligneLue2.charAt(k);
						position3 = ligneLue3.charAt(k);

						if (position == position2) {

							tabMots[i] = position3;
							resultat += tabMots[i];
						}
					}
				}
				ficEntree.close();
				Table.close();
				PrintWriter ficSortie = new PrintWriter(new File(nomFichier));
				ficSortie.print(resultat);
				ficSortie.close();
			}
		} catch (IOException e) {
			// System.out.println("\nProblème : " + e.getMessage());
		}
		System.out.println("Contenu du fichier non encrypté : " + resultat);
	}

	public static void DecryptageOptionTable(String nomFichier, String resultat) {
		String ligneLue = "";
		char[] tabMots = new char[200];
		char position, position2, position3;
		String table = "table.txt";
		String ligneLue2 = "";
		String ligneLue3 = "";

		try {
			BufferedReader ficEntree = new BufferedReader(new FileReader(
					nomFichier));
			BufferedReader Table = new BufferedReader(new FileReader(table));
			while ((ligneLue = ficEntree.readLine()) != null) {
				ligneLue2 = Table.readLine();
				ligneLue3 = Table.readLine();
				System.out.println("ligneLue2 : " + ligneLue2);
				System.out.println("ligneLue3 : " + ligneLue3);

				System.out.println("Contenu du fichier encrypté : " + ligneLue);

				for (int i = 0; i < ligneLue.length(); i++) {
					position = ligneLue.charAt(i);

					for (int k = 0; k < ligneLue2.length(); k++) {
						position2 = ligneLue2.charAt(k);
						position3 = ligneLue3.charAt(k);

						if (position == position3) {

							tabMots[i] = position2;
							resultat += tabMots[i];
						}
					}
				}
				ficEntree.close();
				Table.close();
				PrintWriter ficSortie = new PrintWriter(new File(nomFichier));
				ficSortie.print(resultat);
				ficSortie.close();
			}
		} catch (IOException e) {
			// System.out.println("\nProblème : " + e.getMessage());
		}
		System.out.println("Contenu du fichier non encrypté : " + resultat);
	}

	public static void AfficherContenuFichier(String nomFichier, String resultat) {

		try {
			BufferedReader ficEntree = new BufferedReader(new FileReader(
					nomFichier));
			resultat = ficEntree.readLine();
			ficEntree.close();
		} catch (IOException e) {
			// System.out.println("Problème : " + e.getMessage());
		}
		System.out.println("Contenu du fichier : \n" + resultat);
	}

}
