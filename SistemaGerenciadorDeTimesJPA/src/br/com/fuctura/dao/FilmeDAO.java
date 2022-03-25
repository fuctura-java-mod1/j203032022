package br.com.fuctura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fuctura.model.Filme;
import br.com.fuctura.util.JPAUtil;

public class FilmeDAO {
	
	//estou "injetando" um EntityManagerFactory
	private EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
	
	public void salvar(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin(); //comeco

		gerenciador.persist(filme); //persist eh o metodo que salva na base
		
		transacao.commit(); //fim
		
		gerenciador.close();
		
	}
	
	public void excluir(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin();
		
		Filme filmeQueVaiExcluido = gerenciador.find(Filme.class, filme.getLinkyt());
		
		gerenciador.remove(filmeQueVaiExcluido);
		
		transacao.commit();
		
		gerenciador.close();
		
	}
	
	public Filme pesquisar(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		Filme fi = gerenciador.find(Filme.class, filme.getLinkyt());
		
		gerenciador.close();
		
		return fi;
	}
	
	public List<Filme>  pesquisarPorClassificacao(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		TypedQuery<Filme> consulta = gerenciador
					.createNamedQuery("Filme.findByClassificacao", Filme.class);
		
		consulta.setParameter("class", filme.getClassificacao());
		
		List<Filme> resultadoDaConsulta = consulta.getResultList();
		
		return resultadoDaConsulta;
	}
	
	public List<Filme>  pesquisarPorClassificacao(int menor, int maior) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		TypedQuery<Filme> consulta = gerenciador
					.createNamedQuery("findByIntervalo", Filme.class);
		
		consulta.setParameter("menor", menor);
		consulta.setParameter("maior", maior);
		
		List<Filme> resultadoDaConsulta = consulta.getResultList();
		
		return resultadoDaConsulta;
	}
	
	public List<Filme> pesquisarPorNome(String nome){
		EntityManager gerenciador = fabrica.createEntityManager();
		
		Query consulta = gerenciador.
				createQuery("select f from Filme f where f.nome like :nome");
		
		consulta.setParameter("nome", nome);
		
		List<Filme> resultadoDaConsulta = consulta.getResultList();
		
		return resultadoDaConsulta;
	}
	
}
