package it.davincifascetti.quintainfa.bianchimangione;

import java.io.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class Init {

	public static void main(String[] args) {

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(".\files\studente.xml"));
			while (reader.hasNext()) {
				XMLEvent nextEvent = reader.nextEvent();
				if (nextEvent.isStartElement()) {
					StartElement element = nextEvent.asStartElement();
					switch(element.getName().getLocalPart()) {
					case "studente":
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
				if (nextEvent.isEndElement()) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.print("File not found! " + e + ".\n");
		} catch (XMLStreamException e) {
			System.out.print("Stream exception! " + e + ".\n");
		}

	}

}
