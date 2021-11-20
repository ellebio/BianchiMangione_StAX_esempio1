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
			this.isComplete();
		}

	}

	public void setCognome(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il cognome non può essere vuoto");
		} else {
			this.cognome = toSet;
			this.isComplete();
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
				this.isComplete();
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
			this.isComplete();
		}

	}

	public void setSesso(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, il sesso non può essere vuoto");
		} else if (toSet.length() > 1) {
			throw new Exception("Errore, il sesso deve essere un unico carattere");
		} else {
			this.sesso = toSet.charAt(0);
			this.isComplete();
		}

	}

	public void setClasse(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, la classe non può essere vuota");
		} else {
			this.classe = toSet;
			this.isComplete();
		}

	}

	public void setIndirizzo(String toSet) throws Exception {

		if (toSet.isBlank() || toSet.isEmpty()) {
			throw new Exception("Errore, l'indirizzo non può essere vuoto");
		} else {
			this.indirizzo = toSet;
			this.isComplete();
		}

	}

	private void isComplete() {

		if (this.nome.isBlank() || this.nome.isEmpty() || this.cognome.isBlank() || this.cognome.isEmpty()
				|| this.luogoNascita.isBlank() || this.luogoNascita.isEmpty() || this.indirizzo.isBlank()
				|| this.indirizzo.isEmpty() || this.dataNascita.toString().isBlank()
				|| this.dataNascita.toString().isEmpty() || this.sesso == Character.MIN_VALUE) {
			this.compiled = false;
		} else {
			this.compiled = true;
		}

	}

	public String getDetails() throws Exception {

		if (this.compiled) {
			String toReturn = "Informazioni studente\n";
			toReturn += "Nome: " + this.nome + ", cognome: " + this.cognome + ", sesso: " + this.sesso + "\n";
			toReturn += "Data e luogo di nascita: " + this.luogoNascita + ", " + this.dataNascita + "\n";
			toReturn += "Classe: " + this.classe + " " + this.indirizzo + "\n";
			return toReturn;
		} else {
			throw new Exception("Errore, le informazioni dello studente non sono complete");
		}

	}

}
