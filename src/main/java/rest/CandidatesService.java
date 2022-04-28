package rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Candidates;
import dao.Dao;

@Path("/candidatesservice")
public class CandidatesService {
//Reading all the rows from table prey.
	@GET
	@Path("/read")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Candidates> list=null;
		Dao dao=new Dao("jdbc:mysql://localhost:3306/vaalikone?autoReconnect=true&useSSL=false", "root", "rimanali123");
		
		if (dao.getConnection()) {
			
			list=dao.readAllCandidates();
		}
		else {
			
			System.out.println("No connection to database");
		}
		
		request.setAttribute("ehdokkaat", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidatestoedit.jsp");
		rd.forward(request, response);
	}
	
	@GET
	@Path("/readCandidates")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidates> readAllCandidates() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidates> list=em.createQuery("select * from ehdokkaat").getResultList();
		em.getTransaction().commit();
		return list;
	}
//Adding one prey object into the table prey	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidates postCandidates(Candidates candidates) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(candidates);//The actual insertion line
		em.getTransaction().commit();
		return candidates;
	}
	
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidates> updateCandidates(Candidates candidates) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Candidates f=em.find(Candidates.class, candidates.getId());
		if (f!=null) {
			em.merge(candidates);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Candidates> list=readAllCandidates();		
		return list;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Candidates> deleteCandidates(@PathParam("id") int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Candidates f=em.find(Candidates.class, id);
		if (f!=null) {
			em.remove(f);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Candidates> list=readAllCandidates();		
		return list;
	}
	
}