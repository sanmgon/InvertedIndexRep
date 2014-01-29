package com.sanmgon;

import java.util.ArrayList;
import java.util.Hashtable;

public class InvIndex {

	// Estructura del indice
	private Hashtable<String, ArrayList<String>> index = new Hashtable<String, ArrayList<String>>();

	public InvIndex(String[] data) {
		index = getIndex(data);
	}

	private String getValidWord(String word) {
		//Elimina caracteres en los extremos como ',',';','.','?','!',..
		if (!Character.isLetterOrDigit(word.charAt(0)))
			word = word.substring(1);
		if (!Character.isLetterOrDigit(word.charAt(word.length() - 1)))
			word = word.substring(0, word.length() - 1);
		return word.toLowerCase();
	}

	//Dado un conjunto de documentos, retorna la estructura de Indice generada.
	private Hashtable<String, ArrayList<String>> getIndex(String[] data) {
		Hashtable<String, ArrayList<String>> hAux = new Hashtable<String, ArrayList<String>>();

		for (String file : data) {
			String[] words = file.split(" "); // Divido el documento en una lista de palabras
			for (String word : words) {
				String validWord = getValidWord(word);
				if (!hAux.containsKey(validWord)) {
					ArrayList<String> arrStr = new ArrayList<String>();
					arrStr.add(file);
					hAux.put(validWord, arrStr);
				} else {
					if (!hAux.get(validWord).contains(file)) {

						ArrayList<String> arrStr = hAux.get(validWord);
						arrStr.add(file);
						hAux.put(validWord, arrStr);
					}
				}

			}
		}

		return hAux;
	}

	//Metodo para realizar consultas
	public ArrayList<String> get(String word) {
		ArrayList<String> arrStr = new ArrayList<String>();
		String validWord = word.toLowerCase();
		if (index.containsKey(validWord))
			arrStr = index.get(validWord);
		return arrStr;
	}

}