package web_controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/"})
public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null )
        {
            request.getSession().setAttribute("error", "Debe iniciar session primero");
            response.sendRedirect("Login.jsp");
        }
        else 
        {
            response.sendRedirect("Menu.jsp");
        }
        
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/
}
