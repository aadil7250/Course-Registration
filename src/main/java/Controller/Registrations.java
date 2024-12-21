package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import Model.DAOServiceImpl;

@WebServlet("/allRegistration")
public class Registrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registrations() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("email")!=null) {
			
			DAOServiceImpl service = new DAOServiceImpl();
			service.connectDb();
			ResultSet result = service.allRegistration();
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_registrationlist.jsp");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
