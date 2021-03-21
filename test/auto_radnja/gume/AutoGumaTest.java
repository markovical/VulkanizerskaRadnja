package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	AutoGuma a;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testAutoGuma() {
		a = new AutoGuma();
		
		assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("Miselin", 14, 136, 26);
		assertNotNull(a);
		assertEquals("Miselin", a.getMarkaModel());
		assertEquals(14, a.getPrecnik());
		assertEquals(136, a.getSirina());
		assertEquals(26, a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Tojo");
		
		assertEquals("Tojo", a.getMarkaModel());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto MarkaModel")
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}
	@Test
	void testSetMarkaModelKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setMarkaModel("T"));
	}
	
	@Test
	void testSetPrecnik() {
		a.setPrecnik(14);
		assertEquals(14, a.getPrecnik());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setPrecnik(23));  //promenjena klasa AutoGuma logicki operator && u ||
	}
	
	@ParameterizedTest
	@CsvSource({
		"14",
		"15",
		"16"
	})
	void testSetPrecnik(int precnik) {
		a.setPrecnik(precnik);
		assertEquals(a.getPrecnik(), precnik);
	}
	
	@Test
	void testSetSirina() {
		a.setSirina(136);
		assertEquals(136, a.getSirina());
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setSirina(401)); //promenjena klasa AutoGuma logicki operator && u ||
	}
	
	@ParameterizedTest
	@CsvSource({
		"353",
		"301",
		"300"
	})
	void testSetSirina(int sirina) {
		a.setSirina(sirina);
		assertEquals(a.getSirina(), sirina);
	}
	
	@Test
	void testSetVisina() {
		a.setVisina(26);
		assertEquals(26, a.getVisina());
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setVisina(120));
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"27",
		"30",
		"35",
	})
	void testSetVisina(int visina) {
		a.setVisina(visina);
		assertEquals(a.getVisina(), visina);
		
	}
	

	@Test
	void testToString() {
		a.setMarkaModel("Miselin");
		a.setPrecnik(14);
		a.setSirina(140);
		a.setVisina(26);
		
		String s = a.toString();
		
		assertTrue(s.contains("Miselin"));
		assertEquals(a.getPrecnik(), 14);
		assertEquals(a.getSirina(),140);
		assertEquals(a.getVisina(), 26);
	}

	@Test
	void testEqualsObject() {
		a.setMarkaModel("Miselin");
		a.setPrecnik(14);
		a.setSirina(140);
		a.setVisina(26);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("Miselin");
		b.setPrecnik(14);
		b.setSirina(140);
		b.setVisina(26);
		
		assertTrue(a.equals(b));
		
	}
	@ParameterizedTest
	@CsvSource ({
		
		"Miselin, 14, 140, 26, Miselin, 14, 140, 26, true",
		"Tojo, 14, 140, 26, Miselin, 14, 140, 26, false", 
		"Tojo, 14, 140, 26, Tojo, 15, 140, 26, false",
		"Miselin, 14, 140, 26, Miselin, 14, 145, 26, false",
		
	})
	void testEqualsObject(String MarkaModel1, int precnik1, int sirina1, int visina1, String MarkaModel2, int precnik2, int sirina2, int visina2, boolean eq) {
		a.setMarkaModel(MarkaModel1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel(MarkaModel2);
		b.setPrecnik(precnik2);
		b.setSirina(sirina2);
		b.setVisina(visina2);
		
		assertEquals(eq, a.equals(b));
	}

}
