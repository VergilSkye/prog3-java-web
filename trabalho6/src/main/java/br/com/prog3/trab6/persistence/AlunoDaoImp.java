package br.com.prog3.trab6.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import br.com.prog3.trab6.model.Aluno;

public class AlunoDaoImp implements AlunoDao {

	
	public String save(Aluno aluno) {		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();		
		
		try {			
			session.beginTransaction();
			Serializable result = session.save(aluno);		
			session.getTransaction().commit();	
			long r = Long.valueOf(String.valueOf(result)).longValue();
			if(r>0) {
				return "Inserido com sucesso.";				
			}
			else {
				return "Erro ao inserir.";
			}
		}catch(Exception e){
			return "Erro ao inserir.";
			
		}finally {
			session.close();
			session.getSessionFactory().close();
		}
	}

	public String update(Aluno aluno) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();		
		try {			
			Aluno Temp = session.get(Aluno.class, aluno.getMatricula());
			Temp.setNome(aluno.getNome());
			Temp.setRa(aluno.getRa());
			session.beginTransaction();
			session.saveOrUpdate(Temp);			
			session.getTransaction().commit();
			return "Alterado com sucesso.";			
		}catch(Exception e){
			return "Erro ao alterar.";
			
		}finally {
			session.close();
			session.getSessionFactory().close();
		}
		
	}
	public Aluno findByMatricula(int matricula) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Aluno al = session.get(Aluno.class,matricula);
		session.close();
		return al;		
	}
	
	public String delete(int matricula) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		try {			
			Aluno Temp = session.get(Aluno.class, matricula);			
			session.beginTransaction();
			session.delete(Temp);			
			session.getTransaction().commit();
			return "Excluído com sucesso.";		
		}catch(Exception e){
			return "Erro ao excluir.";
			
		}finally {
			session.close();
			session.getSessionFactory().close();
		}
	
	}

	public List<Aluno> list() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		@SuppressWarnings("unchecked")
		List<Aluno> AlunoList = session.createQuery("FROM Aluno").getResultList();
		session.close();
		session.getSessionFactory().close();
		return AlunoList;
	}

}
