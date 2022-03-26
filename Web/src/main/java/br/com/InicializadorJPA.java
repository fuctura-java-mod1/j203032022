package br.com;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InitResources
 *
 */
@WebListener
public class InicializadorJPA implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializadorJPA() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("Carregando o JPA");
		//Remover o comentário da linha de baixo quando finalizar a configuração do JPA
    	//JPAUtil.getEntityManagerFactory();
    }
	
}
