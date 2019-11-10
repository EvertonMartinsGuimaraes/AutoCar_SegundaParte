package br.edu.unibratec.autocar.interfaces;

import java.util.List;

@SuppressWarnings("hiding")
public interface ICarOperations<Object> {
		
		// inserir
		public void insert();
		// deletar registro pelo id
		public void delete(int id);
		// atualizar
		public void update(Object registro);
		// listar todos
		public List<Object> getAll();
		// listar pelo id
		public Object select();

}
