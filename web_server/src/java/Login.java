import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("/home.jsp");
        }else{
            response.sendRedirect("Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        if(usu.equals("admin") && pass.equals("admin")){
            sesion.setAttribute("usuario", usu);
            response.sendRedirect("Menu.jsp");
        } else {
            request.getSession().setAttribute("error", "Usuario no valido");
            response.sendRedirect("Login.jsp");
        }
    }
}
