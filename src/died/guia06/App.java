package died.guia06;

import java.util.ArrayList;
import java.util.List;

import died.guia06.exception.CursoException;
import died.guia06.exception.RegistroAuditoriaException;

public class App {

	public static void main(String[] args) throws CursoException, RegistroAuditoriaException {
		
		System.out.println("\nSITUACIÓN PRIMER CUATRIMESTRE\n");
		
		//Se crean 5 alumnos
		
		Alumno juan,alejandro,luis1,luis2,juan2;
		juan=new Alumno("Juán",1234);
		alejandro=new Alumno("Alejandro",1235);
		luis1=new Alumno("Luis",1236);
		luis2=new Alumno("Luis",1237);
		juan2=new Alumno("Juan",1234);
		
		List<Alumno> alumnosTotales= new ArrayList<Alumno>();
		alumnosTotales.add(juan);
		alumnosTotales.add(juan2);
		alumnosTotales.add(luis1);
		alumnosTotales.add(luis2);
		alumnosTotales.add(alejandro);
		
		//IDENTIDAD DE ALUMNOS
		System.out.println("Identidad de alumnos:");
		// Luis con numero de libreta 1236 es distinto a Luis con numero de libreta 1237
		if(luis1.equals(luis2)) {
			System.out.println("Es el mismo Luis");
		}
		else{
			System.out.println("Hay dos personas diferentes llamadas Luis");
		};
				
		// Aparentemente, Juán fue cargado por error dos veces, una con acento y otra sin acento, pero comparten el mismo numero de libreta.
				
		if(juan.equals(juan2)) {
			System.out.println("Es el mismo Juán cargado dos veces");
		}
		else{
			System.out.println("Hay dos personas diferentes llamadas Juán");
		};
		
		
		//Se crean 5 cursos
		//Para cursar Física se necesitan 15 puntos que solo lo puede dar Matemática.
		Curso matematica,lengua,fisica,informatica,dibujo;
		matematica= new Curso(1,"Matematicas",1,100);
		matematica.setCreditos(15);
		matematica.setCreditosRequeridos(0);
		
		lengua= new Curso(2,"Lengua",1,100);
		lengua.setCreditos(10);
		lengua.setCreditosRequeridos(0);
		
		fisica= new Curso(3,"Fisica",2,100);
		fisica.setCreditos(10);
		fisica.setCreditosRequeridos(15);
		
		informatica= new Curso(4,"Informática",1,100);
		informatica.setCreditos(3);
		informatica.setCreditosRequeridos(0);
		
		dibujo= new Curso(5,"Dibujo",1,100);
		dibujo.setCreditos(0);
		dibujo.setCreditosRequeridos(0);
		
		//COMIENZA EL PRIMER CUATRIMESTRE		
		//Se inscriben los 4 alumnos a Matemática, Informática y Lengua, materias que no poseen requisitos de créditos
		try {
			matematica.inscribirAlumno(juan);
		}catch(Exception e) {
			System.out.println("El alumno "+juan.getNombre()+" no se pudo inscribir");
		}
		try {
			matematica.inscribirAlumno(alejandro);
		}catch(Exception e) {
			System.out.println("El alumno "+alejandro.getNombre()+" no se pudo inscribir");
		}
		try {
			matematica.inscribirAlumno(luis1);
		}catch(Exception e) {
			System.out.println("El alumno "+luis1.getNombre()+" no se pudo inscribir");
		}
		try {
			matematica.inscribirAlumno(luis2);
		}catch(Exception e) {
			System.out.println("El alumno "+luis2.getNombre()+" no se pudo inscribir");
		}
		
		
		try {
			lengua.inscribirAlumno(juan);
		}catch(Exception e) {
			System.out.println("El alumno "+juan.getNombre()+" no se pudo inscribir");
		}
		try {
			lengua.inscribirAlumno(alejandro);
		}catch(Exception e) {
			System.out.println("El alumno "+alejandro.getNombre()+" no se pudo inscribir");
		}
		try {
			lengua.inscribirAlumno(luis1);
		}catch(Exception e) {
			System.out.println("El alumno "+luis1.getNombre()+" no se pudo inscribir");
		}
		try {
			lengua.inscribirAlumno(luis2);
		}catch(Exception e) {
			System.out.println("El alumno "+luis2.getNombre()+" no se pudo inscribir");
		}
		
		
		try {
			informatica.inscribirAlumno(juan);
		}catch(Exception e) {
			System.out.println("El alumno "+juan.getNombre()+" no se pudo inscribir");
		}
		try {
			informatica.inscribirAlumno(alejandro);
		}catch(Exception e) {
			System.out.println("El alumno "+alejandro.getNombre()+" no se pudo inscribir");
		}
		try {
			informatica.inscribirAlumno(luis1);
		}catch(Exception e) {
			System.out.println("El alumno "+luis1.getNombre()+" no se pudo inscribir");
		}
		try {
			informatica.inscribirAlumno(luis2);
		}catch(Exception e) {
			System.out.println("El alumno "+luis2.getNombre()+" no se pudo inscribir");
		}
		
		
		//Esta inscripción no se va a llevar a cabo porque Juan ya se inscribió a 3 materias del mismo ciclo lectivo
		try {
			dibujo.inscribirAlumno(juan);
		}
		catch(Exception e) {
			System.out.println("Continúa la ejecución de App...");
		}
		
		matematica.imprimirInscriptos();
		lengua.imprimirInscriptosPorCreditos();
		fisica.imprimirInscriptos();
		informatica.imprimirInscriptosPorLibreta();
		dibujo.imprimirInscriptos();
		
		//FIN DEL PRIMER CUATRIMESTRE
		
		//Juan y Alejandro aprueban Matemática
		juan.aprobar(matematica);
		alejandro.aprobar(matematica);
		
		//Juan, Luis1 y Luis2 aprueban Lengua
		juan.aprobar(lengua);
		luis1.aprobar(lengua);
		luis2.aprobar(lengua);
		
		//Alejandro y luis2 aprueban informatica
		alejandro.aprobar(informatica);
		alejandro.aprobar(informatica);
		
		//INICIO DEL SEGUNDO CUATRIMESTRE
		System.out.println("\nSITUACIÓN INICIO SEGUNDO CUATRIMESTRE");
		
		//Todos los alumnos se intentan inscribir a Fisica, solo alejandro y juan cumplen con las condiciones
		try {
			fisica.inscribirAlumno(juan);
		}catch(Exception e) {
			System.out.println("El alumno "+juan.getNombre()+" no se pudo inscribir");
		}
		try {
			fisica.inscribirAlumno(alejandro);
		}catch(Exception e) {
			System.out.println("El alumno "+alejandro.getNombre()+" no se pudo inscribir");
		}
		try {
			fisica.inscribirAlumno(luis1);
		}catch(Exception e) {
			System.out.println("El alumno "+luis1.getNombre()+" no se pudo inscribir");
		}
		try {
			fisica.inscribirAlumno(luis2);
		}catch(Exception e) {
			System.out.println("El alumno "+luis2.getNombre()+" no se pudo inscribir");
		}
		
		//FIN DEL SEGUNDO CUATRIMESTRE
		luis1.aprobar(matematica);
		alejandro.aprobar(fisica);
		
		//IMPRIMO LA SITUACIÓN FINAL DE TODOS LOS ALUMNOS		
		System.out.println(alumnosTotales);
	}
}
