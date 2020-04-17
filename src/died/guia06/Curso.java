package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso{

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	private Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditosRequeridos= 0;
		this.creditos = 0;
	}	

	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
	}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		try {
			if(this.cumpleCondicionesDeInscripcion(a)) {
				a.inscripcionAceptada((Curso)this);
				inscriptos.add(a);
				return true;
			}
			log.registrar(this, "inscribir ",a.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	private boolean cumpleCondicionesDeInscripcion(Alumno a) {
		if(this.cupo() && this.tieneCreditosMinimos(a) && !superaLimiteDeCicloLectivo(a)) {
			return true;
		}
		else
			return false;
	}


	private boolean tieneCreditosMinimos(Alumno a) {
		if(a.creditosObtenidos() >= this.creditosRequeridos)
			return true;
		return false;
	}


	private boolean superaLimiteDeCicloLectivo(Alumno a) {
		int coincidencias =0;
		for(Curso c: a.getCursando()) {
			if(c.getCicloLectivo() == this.cicloLectivo)
				coincidencias++;
		}
		if(coincidencias >= 3)
			return true;
		return false;
	}


	private boolean cupo() {
		if( inscriptos.size() < this.cupo)
			return true;
		return false;
	}


	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			System.out.println("\nLista de alumnos");
			Collections.sort(this.getInscriptos());
			for(Alumno a: this.inscriptos) {
				System.out.println(a.getNombre());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void imprimirInscriptosPorLibreta() {
		try {
			System.out.println("\nLista de alumnos por libreta");
			Collections.sort(this.getInscriptos(),new CompararAlumnosPorLibreta());
			for(Alumno a: this.inscriptos) {
				System.out.println(a.getNombre()+", N� Libreta = "+a.getNroLibreta());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void imprimirInscriptosPorCreditos() {
		try {
			System.out.println("\nLista de alumnos por cr�ditos");
			Collections.sort(this.getInscriptos(),new CompararAlumnosPorCreditos());
			for(Alumno a: this.inscriptos) {
				System.out.println(a.getNombre() +", Cr�ditos = " +a.creditosObtenidos());
			}
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Getters y Setters

	public int getCreditos() {
		return this.creditos;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		if(creditosRequeridos >= 0)
			this.creditosRequeridos = creditosRequeridos;
	}

	public Integer getCupo() {
		return cupo;
	}

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public Registro getLog() {
		return log;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public void setCreditos(Integer creditos) {
		if(creditos >= 0)
			this.creditos = creditos;
	}	

}
