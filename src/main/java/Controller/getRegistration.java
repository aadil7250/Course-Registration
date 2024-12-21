package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mysql.cj.Session;

import Model.DAOServiceImpl;


@WebServlet("/saveRegistation")
public class getRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public getRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(true);
			if(session.getAttribute("email")!=null) {
				String name = request.getParameter("name");
				String course = request.getParameter("course");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				
				DAOServiceImpl service= new DAOServiceImpl();
				service.connectDb();
				service.saveReg(name,course,email,mobile);
				
				request.setAttribute("msg", "Record Saved!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
	}

}
