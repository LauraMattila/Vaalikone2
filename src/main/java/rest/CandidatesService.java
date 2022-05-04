package rest;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;
import dao.Dao;


//@WebServlet(name = "candidatesservice", urlPatterns = {"/candidatesservice"})
@Path("/candidatesservice")
public class CandidatesService{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
	
	@Context 
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAllEhdokkaat() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokkaat> list=em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/candidatesadmin.jsp");
		request.setAttribute("ehdokkaat", list);
		try {
		rd.forward(request, response);
		}
		catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
	
	
	@GET
	@Path("/readone/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readEhdokkaat(@PathParam("EHDOKAS_ID") int i) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=em.find(Ehdokkaat.class, i);
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidatestoedit.jsp");
		request.setAttribute("ehdokkaat", f);
		try {
		rd.forward(request, response);
		}
		catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/readoneadd")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readEhdokkaatadd() {
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidatestoadd.jsp");
		try {
		rd.forward(request, response);
		}
		catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
		public void addEhdokkaat(@FormParam("EHDOKAS_ID") String id, @FormParam("SUKUNIMI") String snimi, @FormParam("ETUNIMI") String enimi, @FormParam("puolue") String puolue, @FormParam("kotipaikkakunta") String kotipaikkakunta, @FormParam("ika") int ika,@FormParam("miksi_eduskuntaan") String miksi_eduskuntaan,@FormParam("mita_asioita_haluat_edistaa") String mita_asioita_haluat_edistaa,@FormParam("ammatti") String ammatti) {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			Ehdokkaat f=new Ehdokkaat(id, snimi,enimi,puolue ,kotipaikkakunta,ika,miksi_eduskuntaan,mita_asioita_haluat_edistaa,ammatti);
			if (f!=null) {
				em.merge(f);//The actual update line
			}
			em.getTransaction().commit();
			readAllEhdokkaat();
	}
	
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateEhdokkaat(@FormParam("EHDOKAS_ID") String id, @FormParam("SUKUNIMI") String snimi, @FormParam("ETUNIMI") String enimi, @FormParam("puolue") String puolue, @FormParam("kotipaikkakunta") String kotipaikkakunta, @FormParam("ika") int ika,@FormParam("miksi_eduskuntaan") String miksi_eduskuntaan,@FormParam("mita_asioita_haluat_edistaa") String mita_asioita_haluat_edistaa,@FormParam("ammatti") String ammatti) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokkaat f=new Ehdokkaat(id, snimi,enimi,puolue ,kotipaikkakunta,ika,miksi_eduskuntaan,mita_asioita_haluat_edistaa,ammatti);
		if (f!=null) {
			em.merge(f);//The actual update line
		}
		em.getTransaction().commit();
		readAllEhdokkaat();
	}
	
		

	
	@GET
    @Path("/delete/{EHDOKAS_ID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("EHDOKAS_ID") int i) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone2");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Ehdokkaat f=em.find(Ehdokkaat.class, i);
        if (f!=null) {
            em.remove(f);//The actual insertion line
        }
        em.getTransaction().commit();
        readAllEhdokkaat();
		
	}
}