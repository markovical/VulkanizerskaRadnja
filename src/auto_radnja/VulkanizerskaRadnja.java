package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;
/**
 * Klasa koja implementira interfejs Radnja i njene metode
 * Sadrzi privatni atribut gume koji je tipa LinkedList<>
 * 
 * @author Aleksandar Markovic
 *
 */
public class VulkanizerskaRadnja implements Radnja {
	/**
	 * lista guma kao LinkedList<>
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	@Override
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		/**
		 * nova lista guma kao LinkedList<>
		 */
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).getMarkaModel().equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}
}