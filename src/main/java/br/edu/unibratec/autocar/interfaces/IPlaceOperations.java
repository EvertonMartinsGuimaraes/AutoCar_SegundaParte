package br.edu.unibratec.autocar.interfaces;

import java.util.List;

@SuppressWarnings("hiding")
public interface IPlaceOperations<Object> {

	// inserir
	public void insert(Object registre);
	// deletar registro pelo id
	public void delete(int id);
	// atualizar
	public void update(Object registre);
	// listar todos
	public List<Object> getAll();
	// listar pelo id
	public Object select(int id);
}
