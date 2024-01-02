package spring.boot.seccion7.error.app.errors;

public class UsuarioNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(String id) {
		super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
	}
	
	
}
