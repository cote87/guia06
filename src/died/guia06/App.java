package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Alumno a1,a2,a3;
		a1=new Alumno("Juan",1);
		a2=new Alumno("Alejandro",2);
		a3=new Alumno("Luis",3);
		
		Curso c1,c2,c3;
		c1= new Curso(1,"Matematicas",2,100);
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.inscribir(a3);
		c1.setCreditos(10);
		
		System.out.println(c1.getClass() == Curso.class);
		
		c2= new Curso(1,"Lengua",2,100);
		c2.inscribir(a1);
		c2.inscribir(a2);
		c2.inscribir(a3);
		c2.setCreditos(10);
		
		c3= new Curso(1,"Fisica",2,100);
		c3.inscribir(a1);
		c3.inscribir(a2);
		c3.inscribir(a3);
		c3.setCreditos(10);
		
		a3.aprobar(c1);
		a3.aprobar(c2);
		a3.aprobar(c3);
		
		a2.aprobar(c3);
		
		c1.imprimirInscriptos();
		c1.imprimirInscriptosPorLibreta();
		c1.imprimirInscriptosPorCreditos();
	}
}
