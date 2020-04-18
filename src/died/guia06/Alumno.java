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
		
	public Alumno(String nombre, Integer nroLibreta) {
		this();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}

	public Integer creditosObtenidos() {
		Integer creditos=0;
		for(Curso c:aprobados) {
			creditos = creditos + c.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		if(cursando.contains(c)) {
			aprobados.add(c);
			cursando.remove(c);
		}
	}

	public void inscripcionAceptada(Curso c) {
		if(!aprobados.contains(c))
			cursando.add(c);
	}
	
	public boolean equals(Alumno alumno) {
		return (this.getNroLibreta() == alumno.getNroLibreta());
	}

	@Override
	public int compareTo(Alumno alumno) {
		return this.getNombre().compareTo(alumno.getNombre());
	}
	
	@Override
	public String toString() {
		return "Nombre= "+this.nombre+" Nº de Libreta= "+this.getNroLibreta()+" Créditos= "+this.creditosObtenidos();
		
	}

	//Getters and Setters
	
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

	public List<Curso> getAprobados() {
		return aprobados;
	}

}
