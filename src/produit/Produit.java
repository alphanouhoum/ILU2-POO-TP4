package produit;

import personnages.Gaulois;

public abstract class Produit {
	private String nom;
	private Unite unite;
	
	public Produit (String nom, Unite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	public String getNom() {
		return nom;
	}
	
	public abstract void decrireProduit();
	
	
	public static void main(String[] args) {
		Produit angille = new Poisson("Angille", "jeudi");
		angille.decrireProduit();
		Gaulois obelix = new Gaulois("Obélix", 10);
		Produit sanglier = new Sanglier(15, obelix, "Sam");
		sanglier.decrireProduit();
	}

}
