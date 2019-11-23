package br.edu.unibratec.autocar.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import br.edu.unibratec.autocar.interfaces.IPlaceOperations;
import br.edu.unibratec.autocar.model.Place;

public class PlaceDAO implements IPlaceOperations<Place> {
	
	private static PlaceDAO instance;
	private SessionFactory sessionFactory;

	public static PlaceDAO getInstance() {
		if (instance == null) {
			instance = new PlaceDAO();

		}
		return instance;
	}
	
	private PlaceDAO() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void insert(Place place) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(place);
		session.getTransaction().commit();
		session.close();

	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Place place = session.load(Place.class, id);
		session.delete(place);		
		
		session.getTransaction().commit();
		session.close();
	}

	public void update(Place place) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(place);		
		
		session.getTransaction().commit();
		session.close();

	}

	public List<Place> getAll() {
		List<Place> result = new ArrayList<Place>();
		Session session = sessionFactory.openSession();
		result = session.createQuery("from Place").list();
		session.close();
		return result;
	}

	public Place select(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Place place = session.get(Place.class, id);
		
		session.getTransaction().commit();
		session.close();
		
		return place;
	}

}
