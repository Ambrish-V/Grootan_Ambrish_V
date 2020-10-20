
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registerdb")
public class registerdb extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out=response.getWriter();
 String Sname=request.getParameter("Sname");
 String age=request.getParameter("age");
 String country=request.getParameter("Country");
 String dob=request.getParameter("dob");
 String gender=request.getParameter("gender");
 String languages=request.getParameter("languages");
 String color=request.getParameter("color");
 String emailid=request.getParameter("email");
 String webadd=request.getParameter("webadd");
 String phone=request.getParameter("phone");
 String cgpa=request.getParameter("cgpa");
 String url="jdbc:mysql://localhost:3306/round_2_db";
 String sqlusername="root";
 String sqlpassword="Wipronascom@123";
 String query="insert into round_2_data (student_name,student_age,country,dob,gender,languages,color,email,webadd,mobile,cgpa) values('"+Sname+"','"+age+"','"+country+"','"+dob+"','"+gender+"','"+languages+"','"+color+"','"+emailid+"','"+webadd+"','"+phone+"','"+cgpa+"')";
 try{
     try {
         Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(registerdb.class.getName()).log(Level.SEVERE, null, ex);
     }
     Connection con=DriverManager.getConnection(url,sqlusername,sqlpassword);
     Statement smt = con.createStatement();
     smt.executeUpdate(query);
     out.println("Successfully created!");
     RequestDispatcher rd=request.getRequestDispatcher("/round_2_form.html");
     rd.include(request,response);
     con.close();
 }catch(SQLException ex)
 {
    out.println(ex);
 }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
