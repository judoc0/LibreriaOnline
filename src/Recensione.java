

public class Recensione {
	Utente utente;
	Libro libro;
	Integer valutazione;
	String commento;
	
	public Recensione(Utente utente, Libro libro, Integer valutazione, String commento) {
		this.utente = utente;
		this.libro = libro;
		this.valutazione = valutazione;
		this.commento = commento;
	}
	
	public Libro getLibro() {
		return libro;
	}

	
	public void getUtente(Utente utente) {
		this.utente = utente;
	}
	
	public Integer getValutazione() {
		return valutazione;
	}
	
	public String commento() {
		return commento;
	}

	@Override
	public String toString() {
		return "Recensione [utente=" + utente.getNome() + ", libro=" + libro + ", valutazione=" + valutazione + ", commento="
				+ commento + "]";
	}
	
	
}
