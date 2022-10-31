package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import persistence.Airline;
import persistence.Dest;
import persistence.Passenger;
import persistence.Source;

public class HibernateUtil {
		
	public static SessionFactory buildsessionfactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Source.class)
				.addAnnotatedClass(Dest.class)
				.addAnnotatedClass(Airline.class)
				.addAnnotatedClass(Passenger.class);
			
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		return sf;
		
	}
}
