
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utente {
	Integer id;
	String nome;
	String email;
	List<Libro> libriAcquistati;
	
	public Utente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
		email = nome + id + "@gmail.com";
	}
	
	public void acquistaLibro(List<Libro> listaLibri, String libroScelto) {
		for(Libro libro : listaLibri) {
			if(libro.getTitolo().equalsIgnoreCase(libroScelto)) {
				System.out.println("Libro presente nel catalogo");
				Libro copiaLibro = libro;
				libriAcquistati.add(copiaLibro);
				System.out.println("copia aggiunta alla libreria dell'utente");
			}
			else {
				System.out.println("Libro non presente nel catalogo.");
			}
		}
	}
	
	public void mostraDettagli() {
		System.out.println(id + " - " + nome + " - ");
	}
	
	public Recensione lasciaRecensione(Scanner scanner) {
		System.out.println("Digitare il nome del libro tra quelli che hai acquistato:");
		mostraLibreria();
		String titolo = scanner.nextLine();
		Libro libroDaRecensire = null;
		for(Libro libro : libriAcquistati) {
			if(libro.getTitolo().equalsIgnoreCase(titolo)) {
				 libroDaRecensire = libro;
			}
			else {
				System.out.println("Titolo non presente nella tua libreria");
				lasciaRecensione(scanner);
			}
		}
		System.out.println("Digitare valutazione da 0 a 5");
		Integer valutazione;
		while (!scanner.hasNextInt()) {
            System.out.println("Devi inserire un numero intero.");
            System.out.print("Inserisci un numero da 0 a 5: ");
            scanner.next(); // pulisco buffer
        }
        valutazione = scanner.nextInt();
        System.out.println("Lascia un commento!");
        String commento = scanner.nextLine();
        System.out.println("Ecco i dettagli della tua recensione:");
        System.out.println(titolo + "- Valutazione: " + valutazione + " - " + commento);
        Recensione recensione = new Recensione(this, libroDaRecensire, valutazione, commento);
        return recensione;
    }
	
	public List<Libro> raccomandaLibri(List<Recensione> recensioni, LibreriaOnline libreria) {

		List<Libro> libriRaccomandati = new ArrayList<>();
		List<String> genereLibri = new ArrayList<>();

		if (!libriAcquistati.isEmpty()) {

			for (Libro libro : libriAcquistati) {
				if (!genereLibri.contains(libro.getGenere())) {
					genereLibri.add(libro.getGenere());
				}
			}

			if (!genereLibri.isEmpty()) {
				for (String genere : genereLibri) {
					for (Recensione recensione : recensioni) {
						if (genere.equals(recensione.getLibro().getGenere()) && recensione.getValutazione() >= 4 && !libriRaccomandati.contains(recensione.getLibro())) {
							libriRaccomandati.add(recensione.getLibro());
						}
					}
				}
			}

			for (Libro libroUtente : libriAcquistati) {
				for (Libro libroLibreria : libreria.mostraLibri()) {
					if (libroUtente.getAutore().equals(libroLibreria.getAutore()) && !libriRaccomandati.contains(libroLibreria)) {
						libriRaccomandati.add(libroLibreria);
					}
				}
			}

		}
		else {
			libriRaccomandati = libriPopolari(recensioni, libreria);		
		}

		return libriRaccomandati;

	}
	
	public Integer valutazioneMedia(List<Recensione> recensioni, Libro libro) {
		
		Integer valutazione = 0;
		Integer nLibri = 0;
		
		for (Recensione recensione : recensioni) {
			if(recensione.getLibro().equals(libro)) {
				valutazione += recensione.getValutazione();
				nLibri++;
			}
				
		}	
		
		Integer media = 0;
		if(nLibri > 0) {
			media = Math.round(valutazione/nLibri);
		}
		
		return media;
	}
	
	public List<Libro> libriPopolari(List<Recensione> recensioni, LibreriaOnline libreria) {
		
		List<Libro> libriPopolari = new ArrayList<>();
		
		for (Recensione recensione : recensioni) {
			if (recensione.getValutazione() >= 4 && !libriPopolari.contains(recensione.getLibro())) {
				libriPopolari.add(recensione.getLibro());
			}
		}
		
		return libriPopolari;
	}


	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	public void mostraLibreria() {
		for(Libro libro : libriAcquistati) {
			System.out.println("-------------");
			libro.mostraDettagli();
		}
	}
}
