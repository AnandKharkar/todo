package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class registerservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
//		System.out.println("name"+username);
//		System.out.println("email"+email);
//		System.out.println("password"+password);

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//database connection

	    final String INSERT_QUERY ="INSERT INTO fitness(Username,Email,Password) VALUES(?,?,?)";
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///demo","root","Anand");
				 PreparedStatement ps = con.prepareStatement(INSERT_QUERY);)
		{
			ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
           
            int count = ps.executeUpdate();
            if(count == 0)
            {
            	res.sendRedirect("home.jsp");
            }
            else
            {
            	res.sendRedirect("login.jsp");
            }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		pw.close();
	}
}
