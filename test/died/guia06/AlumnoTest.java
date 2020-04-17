package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a;
	Curso c1,c2;
	
	@BeforeEach
	public void init() {
		a = new Alumno("Juan",1234);
		c1 = new Curso(1,"Matematicas",2,100);
		c2 = new Curso(2,"Lengua",1,50);
		a.inscripcionAceptada(c1);
	}
	
	@Test
	void testCreditosObtenidos() {
		int esperado = 0;
		assertEquals(esperado,a.creditosObtenidos());
	}

	@Test
	void testAprobar() {
		a.aprobar(c1);
		assertFalse(a.getCursando().contains(c1));
		assertTrue(a.getAprobados().contains(c1));
	}

	@Test
	void testInscripcionAceptada() {
		a.inscripcionAceptada(c2);
		assertTrue(a.getCursando().contains(c2));
	}

}
