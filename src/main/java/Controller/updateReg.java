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


@WebServlet("/updateReg")
public class updateReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateReg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDb();
		service.updateReg(email, mobile);
		
		ResultSet result = service.allRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/all_registrationlist.jsp");
		rd.forward(request, response);
	}

}
