package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju
 * 
 * @author Aleksandar Markovic
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u Radnju
	 * 
	 * @param a Auto guma koja se dodaje
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pronalazi gumu na osnovu parametra markaModel i vraca u novu listu
	 * 
	 * @param markaModel Marka i model kao String
	 * @return null ako je markaModel null
	 * 
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}