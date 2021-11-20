package it.davincifascetti.quintainfa.bianchimangione;

import java.io.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class Init {

	public static void main(String[] args) {

		Studente studenti[] = {}, studenteAttuale = null;
		int i = 0;

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(".\files\studente.xml"));
			while (reader.hasNext()) {
				XMLEvent nextEvent = reader.nextEvent();
				if (nextEvent.isStartElement()) {
					StartElement element = nextEvent.asStartElement();
					switch (element.getName().getLocalPart()) {
					case "studente":
						studenteAttuale = new Studente();
						break;
					case "nome":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setNome(nextEvent.toString());
						break;
					case "cognome":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setCognome(nextEvent.toString());
						break;
					case "dataNascita":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setDataNascita(nextEvent.toString());
						break;
					case "luogoNascita":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setLuogoNascita(nextEvent.toString());
						break;
					case "sesso":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setSesso(nextEvent.toString());
						break;
					case "classe":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setClasse(nextEvent.toString());
						break;
					case "indirizzo":
						nextEvent = reader.nextEvent();
						if(studenteAttuale != null)
							studenteAttuale.setIndirizzo(nextEvent.toString());
						break;
					}
				}
				if (nextEvent.isEndElement()) {
					EndElement element = nextEvent.asEndElement();
					switch (element.getName().getLocalPart()) {
					case "studente":
						if(studenteAttuale.isComplete()) {
							studenti[i] = studenteAttuale;
							i++;
						}else {
							reader.close();
							throw new Exception("Errore, lo studente attuale non è completo");
						}
						break;
					case "nome":
						break;
					case "cognome":
						break;
					case "dataNascita":
						break;
					case "luogoNascita":
						break;
					case "sesso":
						break;
					case "classe":
						break;
					case "indirizzo":
						break;
					}
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.print("File not found! " + e + ".\n");
		} catch (XMLStreamException e) {
			System.out.print("Stream exception! " + e + ".\n");
		} catch (Exception e ) {
			System.out.print("Exception! " + e + ".\n");
		}

	}

}
