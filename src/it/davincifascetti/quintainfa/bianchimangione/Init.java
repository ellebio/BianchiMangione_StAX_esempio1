/* Authors: Leonardo Bianchi and Carlo Mangione */
/* Version: 1.0, last modified on 21-11-21 */

package it.davincifascetti.quintainfa.bianchimangione;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class Init {

	public static void main(String[] args) {

		List<Studente> studenti = new ArrayList<Studente>();
		Studente studenteAttuale = null;

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {

			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("files/studente.xml"));
			while (reader.hasNext()) {

				XMLEvent nextEvent = reader.nextEvent();
				if (nextEvent.isStartElement()) {
					StartElement element = nextEvent.asStartElement();
					switch (element.getName().getLocalPart()) {

					case "studenti":
						break;

					case "studente":
						studenteAttuale = new Studente();
						break;

					case "nome":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setNome(nextEvent.toString());
						break;

					case "cognome":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setCognome(nextEvent.toString());
						break;

					case "dataNascita":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setDataNascita(nextEvent.toString());
						break;

					case "luogoNascita":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setLuogoNascita(nextEvent.toString());
						break;

					case "sesso":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setSesso(nextEvent.toString());
						break;

					case "classe":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setClasse(nextEvent.toString());
						break;

					case "indirizzo":
						nextEvent = reader.nextEvent();
						if (studenteAttuale.initialized)
							studenteAttuale.setIndirizzo(nextEvent.toString());
						break;

					}

				}

				if (nextEvent.isEndElement()) {

					EndElement element = nextEvent.asEndElement();
					switch (element.getName().getLocalPart()) {

					case "studenti":
						reader.close();
						break;

					case "studente":
						if (studenteAttuale.isComplete()) {

							studenti.add(studenteAttuale);

						} else {

							System.out.println("Studente is not complete, ignoring.");
							studenteAttuale = null;

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

				}

			}

			System.out.print("FINISHED READING!\n\n");

			for (int i = 0; i < studenti.size(); i++) {

				System.out.print(studenti.get(i).getDetails());

			}

		} catch (FileNotFoundException e) {

			System.out.print("File not found! " + e + ".\n");

		} catch (XMLStreamException e) {

			System.out.print("Stream exception! " + e + ".\n");

		} catch (Exception e) {

			System.out.print("Exception! " + e + ".\n");

		}

	}

}
