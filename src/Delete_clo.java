

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelCust
 */
@WebServlet("/Delete_clo")
public class  Delete_clo extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_clo() {
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
String driverName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/apparel_management";
String user = "root";
String paassword = "root";
PrintWriter p = response.getWriter();
response.setContentType("text/html");

//String cloth_id = String.valueOf(request.getParameter("Cloth_idd"));
//String brand_na = request.getParameter("Brand_namee");
String useee = request.getParameter("Userr");
try {


Class.forName(driverName);
Connection con = DriverManager.getConnection(url, user, paassword);
String queryString1 = "Delete from Cloth where Cloth_id= ? ";
PreparedStatement ps1 = con.prepareStatement(queryString1);
ps1.setString(1, useee);
ps1.executeUpdate();

p.println("<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Deleted!! deleted cloth </h1></body></html>");

ps1.close();
con.close();
}
catch (ClassNotFoundException | SQLException e) {

e.printStackTrace();
}

}

}
