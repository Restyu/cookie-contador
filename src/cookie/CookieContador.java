package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieContador
 */
@WebServlet("/CookieContador")
public class CookieContador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieContador() {
        super();
    }

    Cookie cookie = new Cookie("contador","0");   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cookie.setMaxAge(60*60*24*7);
		int contador;
		contador = Integer.parseInt(cookie.getValue());
		contador++;
		cookie.setValue(String.valueOf(contador));
		response.addCookie(cookie);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Muestra cookies</title></head>"+
		"<BODY BGCOLOR=\"#FDF5E6\">" +
		"<H1 ALIGN=\"CENTER\">Numero de visitas </H1>" +
		"<p ALIGN=\"CENTER\">" + cookie.getValue()+ "</p>");
		out.println("</BODY></HTML>");
		
	}
}
