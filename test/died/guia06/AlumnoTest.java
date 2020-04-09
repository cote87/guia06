package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a;
	Curso c;
	
	@BeforeEach
	public void init() {
		a = new Alumno("Juan",1234);
		c = new Curso(1,"Matematicas",2,100);
	}
	
	@Test
	void testCreditosObtenidos() {
		int esperado = 0;
		assertEquals(esperado,a.creditosObtenidos());
	}

	@Test
	void testAprobar() {
		a.aprobar(c);
	}

	@Test
	void testInscripcionAceptada() {
		a.inscripcionAceptada(c);
	}

}
