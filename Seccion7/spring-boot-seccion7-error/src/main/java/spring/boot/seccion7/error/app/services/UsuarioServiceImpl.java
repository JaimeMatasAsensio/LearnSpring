package spring.boot.seccion7.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import spring.boot.seccion7.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	private List<Usuario> lista;
	
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		lista.add(new Usuario(1, "aaa", "aaaa"));
		lista.add(new Usuario(2, "bbb", "bbbb"));
		lista.add(new Usuario(3, "ccc", "cccc"));
		lista.add(new Usuario(4, "ddd", "dddd"));
		lista.add(new Usuario(5, "eee", "eeee"));
	}

	@Override
	public List<Usuario> listar() {
		
		return this.lista;
	}

	@Override
	public Optional<Usuario> obtenerPorId(Integer id) {
		
		return this.lista.stream().filter(e -> e.getId().equals(id)).findAny();
		
	}
	
}
