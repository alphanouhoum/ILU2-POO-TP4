package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	private String nom;
	
	public Sanglier(int poids, Gaulois chasseur, String nom) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.nom = nom;
		this.chasseur = chasseur;
	}
	
	public void decrireProduit() {
		System.out.println("sanglier de "+ this.poids +" "+Unite.KILOGRAMME + " chassé par "+ this.chasseur.getNom());
	}
}
