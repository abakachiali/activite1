package fr.u_picardie.active.c306;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

public final class TabAlgos {

	/**                                                                           
	 * @return valeur la plus grande d'un tableau.                                
	 */
	public static int plusGrand(final int[] tab) {
		// TODO                                                                     
	}

	/**                                                                           
	 * @return moyenne des valeurs du tableau.                                    
	 * @throw IllegalArgumentException si tab et null ou vide.                    
	 **/
	public static double moyenne(final int[] tab) {
		// TODO                                                                     
	}

	/**                                                                           
	 * Compare le contenu de 2 tableaux en tenant compte de l'ordre.              
	 * @return true si les 2 tableaux contiennent les mêmes éléments              
	 *         avec les mêmes nombres d'occurences                                
	 *         (avec les elements dans le meme ordre).                            
	 **/
	public static boolean egaux(final int[] tab1,final int[] tab2) {
		// TODO                                                                     
	}

	/**                                                                           
	 * Compare le contenu de 2 tableaux sans tenir compte de l'ordre.             
	 * @return true si les 2 tableaux contiennent les mêmes éléments              
	 *         avec les mêmes nombres d'occurrence                                
	 *         (pas forcément dans le meme ordre).                                
	 **/
	public static boolean similaires(final int[] tab1,final int[] tab2) {
		// TODO                                                                     
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