package died.guia06;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import died.guia06.exception.CursoException;
import died.guia06.exception.RegistroAuditoriaException;

class CursoTest {
	
	Curso curso,curso2;
	Alumno alumno,alumno2;
	
	@BeforeEach
	public void init() {
		curso = new Curso(1,"Matemática",2,35);
		curso.setCreditos(15);
		curso.setCreditosRequeridos(30);
		
		curso2 = new Curso(1,"Lengua",2,35);
		curso2.setCreditos(30);
		curso2.setCreditosRequeridos(0);
		
		alumno = new Alumno();
		alumno.setNombre("Juan");
		alumno2 = new Alumno();
		alumno2.setNombre("María");
	}
	
	@Test
	void testCurso() {
		assertTrue(curso.getClass() == Curso.class);	
	}

	@Test
	void testInscribir() {
		assertFalse(curso.inscribir(alumno));
		assertTrue(curso2.inscribir(alumno));
	}
	
	@Test
	void testInscribirAlumno() throws CursoException, RegistroAuditoriaException {
		try {
			curso.inscribirAlumno(alumno);
		}
		catch(Exception e) {
			System.out.println("El alumno "+alumno.getNombre()+" no se pudo inscribir");
		}
		curso2.inscribirAlumno(alumno);
	}

	@Test
	void testImprimirInscriptos() {
		curso.imprimirInscriptos();
	}

	@Test
	void testImprimirInscriptosPorLibreta() {
		curso.imprimirInscriptosPorLibreta();
	}

	@Test
	void testImprimirInscriptosPorCreditos() {
		curso.imprimirInscriptosPorCreditos();
	}

	@Test
	void testGetCreditos() {
		assertTrue(curso.getCreditos() == 15);
	}

	@Test
	void testGetCicloLectivo() {
		assertTrue(curso.getCicloLectivo()==2);
	}

	@Test
	void testGetId() {
		assertTrue(curso.getId() == 1);
	}

	@Test
	void testSetId() {
		curso.setId(2);
		assertTrue(curso.getId() == 2);
	}

	@Test
	void testGetNombre() {
		assertTrue(curso.getNombre() == "Matemática");
	}

	@Test
	void testSetNombre() {
		curso.setNombre("Lengua");
		assertTrue(curso.getNombre() == "Lengua");
	}

	@Test
	void testGetCreditosRequeridos() {
		assertTrue(curso.getCreditosRequeridos() == 30);
	}

	@Test
	void testSetCreditosRequeridos() {
		curso.setCreditosRequeridos(20);
		assertTrue(curso.getCreditosRequeridos() == 20);
	}

	@Test
	void testGetCupo() {
		assertTrue(curso.getCupo() == 35);
	}

	@Test
	void testGetInscriptos() {
		assertTrue(curso.getInscriptos().size() == 0);
		curso2.inscribir(alumno);
		
		//No se puede inscribir un alumno sin los creditos minimos
		curso.inscribir(alumno);
		assertFalse(curso.getInscriptos().contains(alumno));
		
		//Se aprueba un curso para obtener los creditos minimos y luego se agrega
		alumno.aprobar(curso2);
		curso.inscribir(alumno);
		assertTrue(curso.getInscriptos().contains(alumno));
	}

	@Test
	void testGetLog() {
		curso.getLog();
	}

	@Test
	void testSetCicloLectivo() {
		curso.setCicloLectivo(5);
		assertTrue(curso.getCicloLectivo()==5);
	}

	@Test
	void testSetCreditos() {
		curso.setCreditos(5);
		assertTrue(curso.getCreditos()==5);
	}

}
