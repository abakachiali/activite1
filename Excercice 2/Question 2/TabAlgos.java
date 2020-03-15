package fr.u_picardie.active.c306;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public final class TabAlgos {

	/**                                                                           
	 * @return valeur la plus grande d'un tableau.                                
	 */
	public static int plusGrand(final int[] tab) {
		int result = 0;
		if(tab.length == 1) {
			return tab[0];             
		} else {
			for(int i = 0; i < tab.length; i++) {
				if(tab[i] <= 0 ) {
					result = tab[i];
				} else {
					if(tab[i] > result ) {
						result = tab[i];
					}
				}
			}
		}
		return result;                 
	}

	/**                                                                           
	 * @return moyenne des valeurs du tableau.                                    
	 * @throw IllegalArgumentException si tab et null ou vide.                    
	 **/
	public static double moyenne(final int[] tab) {
		double moyenne = 0;
		if(tab != null) {
			if( (tab.length > 0) ) {
				int somme = 0;
				for(int i = 0; i < tab.length; i++) {
					somme += tab[i];
				}
				moyenne = (somme/tab.length);
				return moyenne;
			}
		}
		throw new IllegalArgumentException("tab null ou vide");
	}

	/**                                                                           
	 * Compare le contenu de 2 tableaux en tenant compte de l'ordre.              
	 * @return true si les 2 tableaux contiennent les mêmes éléments              
	 *         avec les mêmes nombres d'occurences                                
	 *         (avec les elements dans le meme ordre).                            
	 **/
	public static boolean egaux(final int[] tab1,final int[] tab2) {
		boolean result = false;
		if( (tab1 != null) && (tab1 != null) ) {
			if( tab1.length == tab2.length) {
				for(int i = 0; i < tab1.length; i++) {
					if( tab1[i] ==  tab2[i] ) {
						result = true;
					} else {
						return false;
					}
				}
			}
		}
		return result;
	}

	/**                                                                           
	 * Compare le contenu de 2 tableaux sans tenir compte de l'ordre.             
	 * @return true si les 2 tableaux contiennent les mêmes éléments              
	 *         avec les mêmes nombres d'occurrence                                
	 *         (pas forcément dans le meme ordre).                                
	 **/
	public static boolean similaires(final int[] tab1,final int[] tab2) {
		boolean result = false;
		Map<Integer, Integer> mapOccurenceTab1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapOccurenceTab2 = new HashMap<Integer, Integer>();
		if( (tab1 != null) && (tab1 != null) ) {
			if( tab1.length == tab2.length) {
				for(int i = 0; i < tab1.length; i++) {
					if(!mapOccurenceTab1.containsKey(tab1[i])) { 
						int occurence = 1;
						mapOccurenceTab1.put(tab1[i], occurence);
					} else {
						int  occurence = mapOccurenceTab1.get(tab1[i]);
						mapOccurenceTab1.replace(tab1[i], occurence++);
					}
				}

				for(int j = 0; j < tab2.length; j++) {
					if(!mapOccurenceTab2.containsKey(tab2[j])) { 
						int occurence = 1;
						mapOccurenceTab2.put(tab2[j], occurence);
					} else {
						int  occurence = mapOccurenceTab2.get(tab2[j]);
						mapOccurenceTab2.replace(tab2[j], occurence++);
					}
				}
			}

			for (Map.Entry entry : mapOccurenceTab1.entrySet()) {
				Integer nombre = (Integer) entry.getKey();
				Integer occurence = (Integer) entry.getValue();

				if(mapOccurenceTab2.containsKey(nombre)) {
					int  nombreMap2 = mapOccurenceTab2.get(nombre);

					if(occurence == nombreMap2) {
						result = true;
					} else {
						return false;
					}
				}
			}
		}
		return result;
	}

	@Test
	public void testPlusGrand() {
		assertEquals(5, TabAlgos.plusGrand(new int[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testMoyenne() {
		try {
			TabAlgos.moyenne(null);
			fail("tab est null");
		} catch(IllegalArgumentException e) {

		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMoyenneGood() {
		assertEquals(2, TabAlgos.moyenne(new int[] {2, 2, 2, 2}));
	}

	@Test
	public void testEgaux() {
		assertEquals(true, TabAlgos.egaux(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testSimilaires() {
		assertEquals(true, TabAlgos.similaires(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1}));
	}
}