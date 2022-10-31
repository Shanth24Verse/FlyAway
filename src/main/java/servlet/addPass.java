package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.Passenger;
import util.HibernateUtil;

/**
 * Servlet implementation class addPass
 */
@WebServlet("/addPass")
public class addPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mnum = request.getParameter("mnum");
		// int mnum = Integer.valueOf(request.getParameter("mnum"));
		
		SessionFactory sf = HibernateUtil.buildsessionfactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		


		
		
		Passenger passenger = new Passenger();
		passenger.setPfname(fname);
		passenger.setPlname(lname);
		passenger.setPmnum(mnum);
		
		session.save(passenger);
		
		tx.commit();
		
			
		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/payment.html");
		 rd.forward(request, response);
	}

}
