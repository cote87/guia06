package died.guia06.exception;

public class LimiteDeCicloLectivoException extends CursoException {
	public LimiteDeCicloLectivoException(String a) {
		System.out.println("El alumno "+a+" ya se encuentra cursando en 3 materias del mismo ciclo lectivo.");
	}
}
