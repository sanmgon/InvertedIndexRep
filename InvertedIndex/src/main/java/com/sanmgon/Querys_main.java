package com.sanmgon;

import java.util.ArrayList;


public class Querys_main {

	public static void main(String[] args) {
		String[] data = new String[]{
				 "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
				 "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
				 "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
				 "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
				 "Another book with music related content"
				    };
		
		InvIndex invInd = new InvIndex(data);
		
		ArrayList<String> resultQuery;
		
		System.out.println ("Consulta sobre la palabra 'music' :" );
		resultQuery = invInd.get("music");
		System.out.println ("	Tamaño resultado:" + resultQuery.size() );
		System.out.println ("	Ocurrencias :" + resultQuery.toString() );
		System.out.println ("--------------------------------------------------------" );
		
		System.out.println ("Consulta sobre la palabra 'and' :" );
		resultQuery = invInd.get("and");
		System.out.println ("	Tamaño resultado:" + resultQuery.size() );
		System.out.println ("	Ocurrencias :" + resultQuery.toString() );
		System.out.println ("--------------------------------------------------------" );
	}

}
