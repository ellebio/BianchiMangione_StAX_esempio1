package it.davincifascetti.quintainfa.bianchimangione;

import java.text.*;
import java.util.Date;

public class Studente {

	private String nome, cognome, luogoNascita, classe, indirizzo;
	private char sesso;
	private Date dataNascita;
	private boolean compiled = false;
	
	public Studente() {

	}

	public void setNome(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il nome non può essere vuoto");
		} else {
			this.nome = toSet;
		}

	}

	public void setCognome(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il cognome non può essere vuoto");
		} else {
			this.cognome = toSet;
		}

	}

	public void setDataNascita(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, la data di nascita non può essere vuota");
		} else {
			SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = Format.parse(toSet);
				this.dataNascita = date;
			} catch (ParseException e) {
				throw new Exception("Errore nel parsing: " + e);
			}
		}

	}

	public void setLuogoNascita(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il luogo di nascita non può essere vuoto");
		} else {
			this.luogoNascita = toSet;
		}

	}

	public void setSesso(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il sesso non può essere vuoto");
		} else if (toSet.length() > 1) {
			throw new Exception("Errore, il sesso deve essere un unico carattere");
		} else {
			this.sesso = toSet.charAt(0);
		}

	}
	
	public void setClasse(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, la classe non può essere vuota");
		} else {
			this.classe = toSet;
		}

	}

	public void setIndirizzo(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, l'indirizzo non può essere vuoto");
		} else {
			this.indirizzo = toSet;
		}

	}
	
}
