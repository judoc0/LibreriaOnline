

public class Libro {
	Integer id;
	String titolo;
	String autore;
	String genere;
	float prezzo;
	
	public Libro(Integer id, String titolo, String autore, String genere) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		prezzo = ((int)(Math.random()*50)); //Prezzo casuale
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String getGenere() {
		return genere;
	}
	
	public void mostraDettagli() {
		System.out.println(id + " - " + titolo + " -" + autore + " - " + genere);
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", genere=" + genere + ", prezzo=" + prezzo + "]";
	}

	
	
	
	
	
}
