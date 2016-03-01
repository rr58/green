package tuntiprojekti.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tuntiprojekti.model.Henkilo;
import tuntiprojekti.model.dao.DAOPoikkeus;
import tuntiprojekti.model.dao.HenkiloDAO;





@WebServlet("/lisaa-henkilo")
public class LisaaHenkiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Lähettää  selaimelle taytteen tietojen lisayslomake
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			// Luodaan pizzaDAO ja käsketään hakemaan kaikki pizzat
			HenkiloDAO henkilodao = new HenkiloDAO();
			ArrayList<Henkilo> henkilot = henkilodao.findAll();
			
			// Talletetaan request-olion alle taytelista, jotta tiedot ovat käytössä jsp:llä
			request.setAttribute("henkilot", henkilot);
			
			String jsp = "/view/lisaa-henkilo.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		} catch (DAOPoikkeus e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Vastaanottaa tietoa selaimelta:
	 * 
	 * Haetaan lomakkeella syötetyn henkilön tiedot  request (pyyntö)-olion parametritiedoista
	 * ja lisätään henkilön tiedot tietokantaan.
	 * tietokantaan
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			//Haetaan lomakkeelta syötetyn täytteen tiedot request-oliolta
			
			String hlo_etunimi = request.getParameter("hlo_etunimi");
			String hlo_sukunimi = request.getParameter("hlo_sukunimi");
			
			String hlo_tunnitStr = request.getParameter("hlo_tunnit");
			int hlo_tunnit = new Integer(hlo_tunnitStr);
	
			//Luodaan uusi tayte edellisillä parametreillä
			Henkilo henkilo = new Henkilo(0,hlo_etunimi, hlo_sukunimi, hlo_tunnit, null);
			
			//Luodaan taytedao
			HenkiloDAO henkilodao = new HenkiloDAO();
			
			//Lisätään täytteen tiedot tietokantaan
			henkilodao.addHenkilo(henkilo);
			
		} catch (DAOPoikkeus e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}
		
		// päivitetään sivu
		response.sendRedirect("lisaa-henkilo");
	}

}
