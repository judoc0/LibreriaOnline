import java.util.ArrayList;
import java.util.List;

public class Test {

	final static int nLibri = 10;
	final static int nRecensioni = 15;

	public static void main(String[] args) {

		List<Libro> libri = new ArrayList<>();
		
		for (int i = 1; i < nLibri; i++) {
			String nome = "Libro" + i;
			String autore;
			String genere;
			if(i <= 3) {
				autore = "Autore" + 1;
				genere = "Genere" + 1;
			}
			else if (i <= 6) {
				autore = "Autore" + 2;
				genere = "Genere" + 2;
			}
			else {
				autore = "Autore" + 3;
				genere = "Genere" + 3;
			}
			
			
			libri.add(new Libro(i, nome, autore, genere));			
		}
		
		for (Libro libro : libri) {
			libro.mostraDettagli();
		}
		
		Utente utente = new Utente(1, "Utente1");
				
		List<Recensione> recensioni = new ArrayList<>();
		
		for (int i = 1; i < nRecensioni; i++) {
			recensioni.add(new Recensione(utente, libri.get(((int)(Math.random()*(nLibri-2))+1)), ((int)(Math.random()*5)+1), "Recensione"+i));
		}
		
		for (Recensione recensione : recensioni) {
			System.out.println(recensione);
		}
		
		LibreriaOnline libreriaOnline = new LibreriaOnline();
		
		libreriaOnline.setListaLibri(libri);

		List<Libro> libriPopolari = libreriaOnline.libriPopolari(recensioni, libreriaOnline);
		
		System.out.println("LIBRI DISPONIBILI");
		for (Libro libro : libri) {
			System.out.println(libro + " Valutazione media: " + libreriaOnline.valutazioneMedia(recensioni, libro));
		}
		System.out.println("LIBRI POPOLARI");
		for (Libro libro : libriPopolari) {
			System.out.println(libro + " Valutazione media: " + libreriaOnline.valutazioneMedia(recensioni, libro));
			
		}
		
	}

}
