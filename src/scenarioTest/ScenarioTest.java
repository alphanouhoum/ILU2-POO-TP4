package scenarioTest;

import java.util.Iterator;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void acheterProduit(IEtal[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
			IEtal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible != 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".");
	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		/* Gaulois  */
		Gaulois ordralfabetix = new Gaulois("Ordrealfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);
		
		/* Tableau de produits */
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sanglierObelix = {sanglier1, sanglier2};
		Sanglier[] sanglierAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		IEtal[] marche = new IEtal[3];
		
		/* Creation du marcher */
		Etal etalSanglier1 = new Etal<Sanglier>();
		Etal etalSanglier2 = new Etal<Sanglier>();
		Etal etalPoisson1 = new Etal<Poisson>();
		
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson1;
		/* Instalation des vendeur dans leur etals */
		etalSanglier1.installerVendeur(asterix, sanglierAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sanglierObelix, 8);
		etalPoisson1.installerVendeur(ordralfabetix, poissons, 7);

		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etalEtal());
		}
		
		acheterProduit(marche, "sanglier",3);
		
		
		for (int i = 0; i < marche.length; i++) {
			System.out.println(marche[i].etalEtal());
		}
		
		
	}
}

