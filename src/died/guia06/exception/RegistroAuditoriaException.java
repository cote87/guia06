package died.guia06.exception;
import java.io.IOException;

public class RegistroAuditoriaException extends IOException {
	public RegistroAuditoriaException() {
		System.out.println("No se pudo crear el registro.");
	}
}
