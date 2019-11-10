package br.edu.unibratec.autocar.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Car;

public class CarDAO{
	
	private SessionFactory sessionFactory;
	
	public CarDAO() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = new Configuration()
				.configure().buildSessionFactory();
	}

	public void insert(Car registro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(registro);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(ICarModel registro) {
		// TODO Auto-generated method stub
		
	}

	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Car getWithId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Car registro) {
		// TODO Auto-generated method stub
		
	}

}
