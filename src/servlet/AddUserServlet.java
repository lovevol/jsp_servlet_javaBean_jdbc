package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.SqlserverDB;


@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name = request.getParameter("newusername");
		String password = request.getParameter("newpassword");
		String  sql = "insert into userTable(username,password) values('" +name+"','"+password+"')";
		SqlserverDB sqlserverDB = new SqlserverDB();
		int rs = 0;
		rs = sqlserverDB.executeUpdate(sql);
		if(rs!=0){
			response.sendRedirect("successful.jsp");
		}else{
			response.sendRedirect("failed.jsp");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request, response);
	}
}
