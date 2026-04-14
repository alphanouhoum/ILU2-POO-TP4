package produit;


public class Poisson extends Produit {
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.PIECE);
		this.date = date;
	}
	
	@Override
	public String decrireProduit() {
		StringBuilder string = new StringBuilder();
		string.append("poisson pêchés "+this.date + ".");
		return string.toString();
	}

	@Override
	public int calculerPrix(int prix) {
		return prix;
	}

}
