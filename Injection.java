import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VulnerableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String username = request.getParameter("username");
        Statement statement = connection.createStatement();
        String query = "SELECT secret FROM Users WHERE (username = '" + username + "' AND NOT role = 'admin')";  
       // String query = String.format("SELECT secret FROM Users WHERE (username = '%s' AND NOT role = 'admin')", username); 
        ResultSet result = statement.executeQuery(query);
        response.getWriter().println("<h1>Welcome, " + firstname + "!</h1>"); 
        String URL = request.getParameter("redirect");
        response.sendRedirect(URL); 
        response.addHeader("Access-Control-Allow-Origin", "*"); 
        response.addHeader("Access-Control-Allow-Methods", "GET,POST");}
}
