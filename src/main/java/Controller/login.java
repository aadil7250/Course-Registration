package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.DAOServiceImpl;


@WebServlet("/verfiylogin")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		System.out.println(email);
//		System.out.println(password);
		DAOServiceImpl service= new DAOServiceImpl();
		service.connectDb();
		boolean status = service.verifylogin(email, password);
		if(status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errorMsg","Invalid Username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
