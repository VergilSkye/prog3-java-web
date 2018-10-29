package br.com.prog3.test;

import java.util.List;
import br.com.prog3.trab6.model.Aluno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Runner {
	
	@Test
	public void crud() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		create(session);
		read(session);
		
		update(session);
		read(session);
		
		delete(session);
		read(session);
		
		session.close();
	}
	
	private void delete(Session session) {
		System.out.println("Deleting Aluno record...");
		Aluno al = session.get(Aluno.class, 666);		
		
		session.beginTransaction();
		session.delete(al);
		session.getTransaction().commit();
	}
	
	private void update(Session session) {
		System.out.println("Updating Deise RA...");
		Aluno Deise = session.get(Aluno.class, 4);
		Deise.setRa("NoWhere");		
		session.beginTransaction();
		session.saveOrUpdate(Deise);
		session.getTransaction().commit();
	}

	private void create(Session session) {
		System.out.println("Creating Aluno records...");
		Aluno Marrie = new Aluno();
		Marrie.setMatricula(1212121);
		Marrie.setNome("Marrie de S1");
		Marrie.setRa("franca");
		
		Aluno Henri = new Aluno();
		Henri.setMatricula(10101001);
		Henri.setNome("Henrique1");
		Henri.setRa("M Morte");		
		
		
		session.beginTransaction();
		session.save(Marrie);
		session.save(Henri);
		session.getTransaction().commit();
	}
	
	private void read(Session session) {
		
		//Session session1 = factory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Aluno> AlunoList = session.createQuery("FROM Aluno").getResultList();
		
		
		
		System.out.println("Reading Aluno records...");
		System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
		for (Aluno al : AlunoList) {
			System.out.println();
			System.out.printf("%-30.30s  %-30.30s%n", al.getNome(), al.getRa());
		}
	}
}

