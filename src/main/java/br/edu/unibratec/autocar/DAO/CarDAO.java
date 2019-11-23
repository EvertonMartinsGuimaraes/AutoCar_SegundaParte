package br.edu.unibratec.autocar.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.unibratec.autocar.controller.CarController;
import br.edu.unibratec.autocar.interfaces.ICarModel;
import br.edu.unibratec.autocar.model.Car;

public class CarDAO{
	
	private static CarDAO instance;
	private SessionFactory sessionFactory;
	
	public static CarDAO getInstance() {
		if (instance == null) {
			instance = new CarDAO();

		}
		return instance;
	}
	
	private CarDAO() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void insert(Car car) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Car car = session.load(Car.class, id);
		session.delete(car);		
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(Car car) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(car);		
		
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Car> getAll() {
		List<Car> result = new ArrayList<Car>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Car").list();
		session.close();
		return result;
	}

	public Car getWithId(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Car car = session.get(Car.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return car;
	}

}
