package scenarioTest;

import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ItalicAction;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;


public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			private int nbEtals = 3;
			private IEtal[] marche = new IEtal[nbEtals];
			private int nbEtalAttribuer = 0;

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nbEtalAttribuer >= nbEtals) return false;

				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtalAttribuer++] = etal;
				return true;
			}

			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {

				int reste = quantiteSouhaitee;

				for (int i = 0; i < nbEtalAttribuer && reste > 0; i++) {
					int dispo = marche[i].contientProduit(produit, reste);

					if (dispo > 0) {
						int prix = marche[i].acheterProduit(dispo);
						System.out.println("Etal " + (i + 1) + " : " + dispo + " achetés pour " + prix);
						reste -= dispo;
					}
				}

				System.out.println("Demandé : " + quantiteSouhaitee + ", acheté : " + (quantiteSouhaitee - reste));
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder("=== Marché ===\n");
				for (int i = 0; i < nbEtalAttribuer; i++) {
					sb.append("Etal ").append(i + 1).append("\n");
					sb.append(marche[i].etalEtal());
				}
				return sb.toString();
			}
		};

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		// ✅ IMPORTANT : typage générique
		Etal<Sanglier> e1 = new Etal<>();
		Etal<Sanglier> e2 = new Etal<>();
		Etal<Poisson> e3 = new Etal<>();

		Sanglier[] s1 = { new Sanglier(200, obelix), new Sanglier(150, obelix) };
		Sanglier[] s2 = { new Sanglier(100, asterix), new Sanglier(150, asterix) };
		Poisson[] p = { new Poisson("lundi") };

		village.installerVendeur(e1, obelix, s1, 8);
		village.installerVendeur(e2, asterix, s2, 10);
		village.installerVendeur(e3, ordralfabetix, p, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}
}