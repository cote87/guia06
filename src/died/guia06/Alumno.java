package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	

	public Alumno() {
		super();
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
	}

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	public boolean equals(Alumno alumno) {
		return (this.getNroLibreta() == alumno.getNroLibreta());
	}

	@Override
	public int compareTo(Alumno alumno) {
		return this.getNombre().compareTo(alumno.getNombre());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void addCursando(Curso curso) {
		if(!aprobados.contains(curso))
			this.cursando.add(curso);
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void addAprobado(Curso curso) {
		if(cursando.contains(curso)) {
			this.cursando.remove(curso);
		}
		this.aprobados.add(curso);
	}


}
