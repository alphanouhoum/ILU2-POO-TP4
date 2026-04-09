package produit;

public class Poisson extends Produit {
	private String date;
	private String nom;
	
	public Poisson(String nom, String date) {
		super("sanglier", Unite.PIECE);
		this.date = date;
		this.nom = nom;
	}
	
	public void decrireProduit() {
		System.out.println("poisson pêchés "+this.date);
	}

}
