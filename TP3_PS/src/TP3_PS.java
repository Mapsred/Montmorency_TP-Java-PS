import javax.swing.JOptionPane;

public class TP3_PS {

	public static void main(String[] args) {
		// François Mathieu Groupe 60 TP2 Programmation Structurée
		// On crée nos tableaux de départ
		String[][] micro = new String[3][5];
		String[][] PointVente = new String[3][5];

		micro[0][0] = "1";
		micro[0][1] = "2";
		micro[0][2] = "3";
		micro[0][3] = "4";
		micro[0][4] = "5";
		micro[1][0] = "Imprimantes";
		micro[1][1] = "Écrans";
		micro[1][2] = "Ordinateurs";
		micro[1][3] = "Claviers";
		micro[1][4] = "Souris";
		micro[2][0] = "250";
		micro[2][1] = "150";
		micro[2][2] = "600";
		micro[2][3] = "50";
		micro[2][4] = "15";

		PointVente[0][0] = "PV01";
		PointVente[0][1] = "PV02";
		PointVente[0][2] = "PV03";
		PointVente[0][3] = "PV04";
		PointVente[0][4] = "PV05";
		PointVente[1][0] = "Laval Des Rapides";
		PointVente[1][1] = "Duvernay";
		PointVente[1][2] = "St François";
		PointVente[1][3] = "Auteuil";
		PointVente[1][4] = "Vimont";

		// On appelle la méthode Lire_Quantite
		Lire_Quantite(micro, PointVente);
	}

	public static String Lire_Code(String[][] micro, String[][] pointVente) {
		// Cette méthode demande et récupère le Code de Point de Vente utilisé
		// Dans la méthode Lire_Quantite
		String code = "";
		do {
			String affichage = "\nChoix d'un Point de vente de la "
					+ "Compagnie Micro " + "Système Inc.\n\n";
			int valid = 0;

			Separer(affichage);

			affichage += "\nPoint de vente                                   "
					+ "Succursales\n";// 36 espaces

			affichage = Separer(affichage);
			affichage += "\n";

			affichage = Tableau(affichage, pointVente);

			affichage += "\nEXIT                                          "
					+ "         "
					+ " Afficher Rapport de vente\n\n\nEntrez votre code PV:";

			do {
				code = JOptionPane.showInputDialog(null, affichage,
						"Micro Système Inc.", JOptionPane.PLAIN_MESSAGE);
				code = code.toUpperCase();

				if (code.equals(pointVente[0][0])
						|| code.equals(pointVente[0][1])
						|| code.equals(pointVente[0][2])
						|| code.equals(pointVente[0][3])
						|| code.equals(pointVente[0][4])) {
					valid = 1;
				} else if (code.equals("EXIT")) {
					valid = 2;
				}
			} while (valid != 1 && valid != 2);

			if (valid == 2) {
				JOptionPane.showMessageDialog(null,
						"Fin de la saisie.Cliques sur [OK] "
								+ "pour afficher le rapport de vente",
						"Entete Écran de sortie", JOptionPane.QUESTION_MESSAGE);
			}
			// On retourne le code qui sera récupéré sous NumPointVente
			return code;
		} while (!code.equals("EXIT"));
	}

	public static void Lire_Quantite(String[][] micro, String[][] pointVente) {
		// Cette méthode sert à lire le numéro de l'objet et la quantité
		// Que l'on veut, on appelle aussi la méthode Lire_Code pour
		// Obtenir le code de Point de Vente
		// La méthode boucle tant que l'utilisateur n'a pas entré
		// Q sur le code produit et EXIT sur le code de point de vente
		// On définit un tableau de String par Point de Vente
		String Rapport[][] = new String[4][6];
		String[][] Rapport2 = new String[4][6];
		String[][] Rapport3 = new String[4][6];
		String[][] Rapport4 = new String[4][6];
		String[][] Rapport5 = new String[4][6];
		String NumPointVente = "";
		String code = "Q";
		String quantite;
		double[] MoyPV = new double[6];
		int valid = 0;

		// On initialise les tableaux avec une valeur 0 pour éviter les
		// problèmes "null" plus tard dans le programme
		for (int j = 0; j <= 5; j++) {
			for (int i = 0; i < 3; i++) {
				Rapport[i][j] = "0";
				Rapport2[i][j] = "0";
				Rapport3[i][j] = "0";
				Rapport4[i][j] = "0";
				Rapport5[i][j] = "0";
			}
		}
		// On boucle tant que l'utilisateur n'a pas entré EXIT en point de vente
		do {
			// On va chercher le point de vente
			NumPointVente = Lire_Code(micro, pointVente);
			// On boucle tant que l'utilisateur n'a pas entré Q en Code Produit
			do {
				String affichage = "\nLa Compagnie Micro Système Inc.  Code et"
						+ " nom des articles\n\n";
				if (!NumPointVente.equals("EXIT")) {
					affichage = Separer(affichage);
					affichage += "\nCodes                                      "
							+ "    " + "Articles\n";

					affichage = Separer(affichage);
					affichage += "\n";

					affichage = Tableau(affichage, micro);

					affichage += "\nQ                                "
							+ "                 " + "  "
							+ " Fin saisie \n\n\nEntrez le code de l'article"
							+ " (1 - 2 - 3 - 4 - 5 - Q)";
					do {
						// On affiche le panneau pour obtenir le code
						// de l'article
						code = JOptionPane
								.showInputDialog(null, affichage,
										"Micro Système Inc.",
										JOptionPane.PLAIN_MESSAGE);
						code = code.toUpperCase();

						if (code.equals(micro[0][0])
								|| code.equals(micro[0][1])
								|| code.equals(micro[0][2])
								|| code.equals(micro[0][3])
								|| code.equals(micro[0][4])) {
							valid = 1;
						} else if (code.equals("Q")) {
							valid = 2;
						}
					} while (valid != 1 && valid != 2);

					if (valid == 2) {
						// On affiche le panneau pour signaler la fin de
						// l'entrée du code produit
						JOptionPane.showMessageDialog(null,
								"Fin de la saisie.Cliques sur [OK] pour "
										+ "retourner "
										+ "à la fenêtre principale",
								"Entete Écran de sortie",
								JOptionPane.QUESTION_MESSAGE);
					} else {
						quantite = JOptionPane.showInputDialog(null,
								"Entrez la quantité :", "Micro Système Inc.",
								JOptionPane.PLAIN_MESSAGE);
						int pos = Character.getNumericValue(NumPointVente
								.charAt(3));
						int posProd = Character.getNumericValue(code.charAt(0));
						pos--;
						posProd -= 1;
						int pos1 = pos++;
						int quantité = Integer.parseInt(quantite);

						int prix = Integer.parseInt(micro[2][posProd]);
						int Ventes = quantité * prix;

						// On met les noms de produits dans les rapports
						for (int i = 0; i <= 4; i++) {
							Rapport[0][i] = micro[1][i];
							Rapport2[0][i] = micro[1][i];
							Rapport3[0][i] = micro[1][i];
							Rapport4[0][i] = micro[1][i];
							Rapport5[0][i] = micro[1][i];
						}
						// Calcul du montant total à payer
						// On récupère la moyenne de vente d'un type d'article
						// et on l'ajoute au Rapport
						if (pos == 1) {
							int rap = Integer.parseInt(Rapport[1][posProd])
									+ Ventes;
							for (int i = 0; i <= 4; i++) {
								String vente = Integer.toString(rap);
								Rapport[1][posProd] = vente;
							}
							Rapport[2][posProd] = Moyenne_vente_article(Ventes);
						} else if (pos == 2) {
							int rap = Integer.parseInt(Rapport2[1][posProd])
									+ Ventes;
							for (int i = 0; i <= 4; i++) {
								String vente = Integer.toString(rap);
								Rapport2[1][posProd] = vente;
							}
							Rapport2[2][posProd] = Moyenne_vente_article(Ventes);
						} else if (pos == 3) {
							int rap = Integer.parseInt(Rapport3[1][posProd])
									+ Ventes;
							for (int i = 0; i <= 4; i++) {
								String vente = Integer.toString(rap);
								Rapport3[1][posProd] = vente;
							}
							Rapport3[2][posProd] = Moyenne_vente_article(Ventes);
						} else if (pos == 4) {
							int rap = Integer.parseInt(Rapport4[1][posProd])
									+ Ventes;
							for (int i = 0; i <= 4; i++) {
								String vente = Integer.toString(rap);
								Rapport4[1][posProd] = vente;
							}
							Rapport4[2][posProd] = Moyenne_vente_article(Ventes);
						} else if (pos == 5) {
							int rap = Integer.parseInt(Rapport5[1][posProd])
									+ Ventes;
							for (int i = 0; i <= 4; i++) {
								String vente = Integer.toString(rap);
								Rapport5[1][posProd] = vente;
							}
							Rapport5[2][posProd] = Moyenne_vente_article(Ventes);
						}
						// On fait la moyenne totale
						MoyPV[pos1] = Moyenne_point_de_vente(Rapport);
					}
				}
			} while (!code.equals("Q"));
		} while (!NumPointVente.equals("EXIT"));
		// On construit le rapport Final
		if (NumPointVente.equals("EXIT")) {
			String RapportFinal[][] = new String[4][6];
			for (int i = 0; i <= 4; i++) {
				double d1 = Double.parseDouble(Rapport[1][i])
						+ Double.parseDouble(Rapport2[1][i])
						+ Double.parseDouble(Rapport3[1][i])
						+ Double.parseDouble(Rapport4[1][i])
						+ Double.parseDouble(Rapport5[1][i]);
				double d2 = Double.parseDouble(Rapport[2][i])
						+ Double.parseDouble(Rapport2[2][i])
						+ Double.parseDouble(Rapport3[2][i])
						+ Double.parseDouble(Rapport4[2][i])
						+ Double.parseDouble(Rapport5[2][i]);
				RapportFinal[0][i] = Rapport[0][i];
				RapportFinal[1][i] = String.valueOf(d1);
				RapportFinal[2][i] = String.valueOf(d2);
				MoyPV[5] += MoyPV[i];
			}
			// boucle pour l'appel du rapport, 1-4 = Rapport PV 1-4,
			// 5 = Rapport Final
			for (int no = 0; no <= 5; no++) {
				if (no == 0) {
					Afficher_Rapport(NumPointVente, pointVente, Rapport, MoyPV,
							no);
				} else if (no == 1) {
					Afficher_Rapport(NumPointVente, pointVente, Rapport2,
							MoyPV, no);
				} else if (no == 2) {
					Afficher_Rapport(NumPointVente, pointVente, Rapport3,
							MoyPV, no);
				} else if (no == 3) {
					Afficher_Rapport(NumPointVente, pointVente, Rapport4,
							MoyPV, no);
				} else if (no == 4) {
					Afficher_Rapport(NumPointVente, pointVente, Rapport5,
							MoyPV, no);
				} else if (no == 5) {
					Afficher_Rapport(NumPointVente, pointVente, RapportFinal,
							MoyPV, no);
				}
			}
		}
	}

	public static String Moyenne_vente_article(int PrixTotal) {
		// On calcule ici la moyenne pour chaque article avec la valeur
		// reçue en paramètre
		int nbPointVente = 5;
		double total = PrixTotal / nbPointVente;
		String Total = String.valueOf(total);

		return Total;
	}

	public static double Moyenne_point_de_vente(String[][] Rapport) {
		// On calcule ici la moyenne de chaque point de vente
		double total = 0;

		for (int i = 0; i < 3; i++) {
			double rapport = Double.parseDouble(Rapport[2][i]);
			total += rapport;
		}
		return total;

	}

	public static void Afficher_Rapport(String NumPointVente,
			String[][] pointVente, String[][] RapportF, double MoyPV[], int no) {
		// On affiche ici les 5 Rapports et la rapport final
		if (no != 5) {
			String affichage = "\nLa Compagnie Micro Système Inc.\n\n"
					+ "Code de point de Vente : " + pointVente[0][no] + " - "
					+ pointVente[1][no] + "\n";
			affichage = Separer(affichage) + "\n";
			affichage += "Articles                    Ventes               "
					+ "   Moyenne/ventes(PDV)\n";
			affichage = Separer(affichage) + "\n";
			for (int j = 0; j <= 4; j++) {
				for (int i = 0; i < 3; i++) {
					if (i != 0) {
						double rapport = Double.parseDouble(RapportF[i][j]);
						affichage += rapport + "                      ";
					} else {
						// on gère le nombre d'espaces en fonction
						// de la longueur du nom de produit
						if (j == 0 || j == 2) {
							affichage += RapportF[i][j] + "              ";
						} else if (j == 1 || j == 4) {
							affichage += RapportF[i][j] + "                 ";
						} else if (j == 3) {
							affichage += RapportF[i][j] + "                ";
						}
					}
				}
				affichage += "\n";
			}
			affichage += "\nMoyenne du point de vente (" + pointVente[0][no]
					+ " " + pointVente[1][no] + "): " + MoyPV[no];
			JOptionPane.showMessageDialog(null, affichage,
					"Compagnie Micro Système Inc.",
					JOptionPane.QUESTION_MESSAGE);
			// À décommenter pour afficher dans la console
			// System.out.println(affichage);

		} else if (no == 5) {
			// On affiche le rapport final si no = 5
			String affichage = "\nLa Compagnie Micro Système Inc.\n\n"
					+ "Code de point de Vente : Total " + "\n";
			affichage = Separer(affichage) + "\n";
			affichage += "Articles                    Ventes               "
					+ "   Moyenne/ventes(PDV)\n";
			affichage = Separer(affichage) + "\n";
			for (int j = 0; j <= 4; j++) {
				for (int i = 0; i < 3; i++) {
					if (i != 0) {
						double rapport = Double.parseDouble(RapportF[i][j]);
						affichage += rapport + "          ";
					} else {
						if (j == 0 || j == 2) {
							affichage += RapportF[i][j] + "              ";
						} else if (j == 1 || j == 4) {
							affichage += RapportF[i][j] + "                 ";
						} else if (j == 3) {
							affichage += RapportF[i][j] + "                ";
						}
					}

				}
				affichage += "\n";
			}
			affichage += "\nMoyenne du point de vente : " + MoyPV[no];
			JOptionPane.showMessageDialog(null, affichage,
					"Compagnie Micro Système Inc.",
					JOptionPane.QUESTION_MESSAGE);
			// À décommenter pour afficher dans la console
			// System.out.println(affichage);
		}

	}

	public static String Tableau(String affichage, String[][] tab) {
		// Cette méthode sert à créer le tableau utilisé dans les panneaux
		// avec les valeurs reçues en paramètre
		for (int j = 0; j <= 4; j++) {
			for (int i = 0; i < 2; i++) {
				affichage += tab[i][j]
						+ "                                                    ";
			}
			affichage += "\n";
		}
		return affichage;
	}

	public static String Separer(String affichage) {
		// Cette méthode sert à tirer les séparations dans les panneaux
		for (int j = 0; j < 90; j++) {
			affichage += "-";
		}
		return affichage;
	}

}
