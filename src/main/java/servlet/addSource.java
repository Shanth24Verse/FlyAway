package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.Source;
import util.HibernateUtil;

/**
 * Servlet implementation class addSource
 */
@WebServlet("/addSource")
public class addSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSource() {
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
		String asource = request.getParameter("asource");
		
		SessionFactory sf = HibernateUtil.buildsessionfactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Source source = new Source();
		source.setSname(asource);
		
		session.save(source);
		tx.commit();
		
			
		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		 rd.forward(request, response);
		 
	}

}
