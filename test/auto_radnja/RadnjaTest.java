package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja radnja;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Miselin");
		a.setPrecnik(14);
		a.setSirina(136);
		a.setVisina(30);
		
		radnja.dodajGumu(a);
		
		assertTrue(radnja.pronadjiGumu("Miselin").contains(a));;
		
	
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Miselin");
		a1.setPrecnik(18);
		a1.setSirina(300);
		a1.setVisina(70);
		
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Miselin");
		a2.setPrecnik(18);
		a2.setSirina(300);
		a2.setVisina(70);
		
		radnja.dodajGumu(a1);
		
		assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(a2));
	
	}

	@Test
	void testPronadjiGumuVise() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Miselin");
		a1.setPrecnik(14);
		a1.setSirina(136);
		a1.setVisina(30);
		
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Miselin");
		a2.setPrecnik(15);
		a2.setSirina(137);
		a2.setVisina(31);
		
		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("Miselin");
		a3.setPrecnik(16);
		a3.setSirina(138);
		a3.setVisina(32);
		
		radnja.dodajGumu(a1);
		radnja.dodajGumu(a2);
		radnja.dodajGumu(a3);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Miselin");
		
		assertEquals(3,rezultat.size());
		assertTrue(rezultat.contains(a1));
		assertTrue(rezultat.contains(a2));
		assertTrue(rezultat.contains(a3));
	}
	
	@Test
	void testPronadjiGumu() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Miselin");
		a1.setPrecnik(14);
		a1.setSirina(136);
		a1.setVisina(30);
		
		radnja.dodajGumu(a1);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Miselin");
		
		assertEquals(1,rezultat.size());
		assertEquals(a1, rezultat.get(0));
		
	}
	@Test
	void testPronadjiGumuNull() {
		assertNull(radnja.pronadjiGumu(null));

	}
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("Miselin");
		a1.setPrecnik(14);
		a1.setSirina(136);
		a1.setVisina(30);
		
		radnja.dodajGumu(a1);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Tojo");
		
		assertTrue(rezultat.isEmpty());
		

	}
}
