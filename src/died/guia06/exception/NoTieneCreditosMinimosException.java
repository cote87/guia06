package died.guia06.exception;

import died.guia06.Alumno;

public class NoTieneCreditosMinimosException extends CursoException {
	public NoTieneCreditosMinimosException(String a) {
		System.out.println("El alumno "+a+" no posee los cr�ditos m�nimos para inscribirse al curso.");
	}

}
