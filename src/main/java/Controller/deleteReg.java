package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import Model.DAOServiceImpl;


@WebServlet("/deleteReg")
public class deleteReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteReg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDb();
		service.deleteReg(email);
		
		ResultSet result = service.allRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_registrationlist.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
