package br.edu.unibratec.autocar.interfaces;

import java.util.List;

import br.edu.unibratec.autocar.model.Car;

@SuppressWarnings("hiding")
public interface ICarOperations<Object> {

	// inserir
	public void insert(Car car);

	// deletar registro pelo id
	public void delete(int id);

	// atualizar
	public void update(Car car);

	// listar todos
	public List<Object> getAll();

	// listar pelo id
	public Object select(int in);

}
