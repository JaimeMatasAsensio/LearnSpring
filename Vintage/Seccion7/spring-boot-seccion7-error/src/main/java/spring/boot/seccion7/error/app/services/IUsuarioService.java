package spring.boot.seccion7.error.app.services;

import java.util.List;
import java.util.Optional;

import spring.boot.seccion7.error.app.models.domain.Usuario;

public interface IUsuarioService {
	public List<Usuario> listar();
	
	public Optional<Usuario> obtenerPorId(Integer id);
}
