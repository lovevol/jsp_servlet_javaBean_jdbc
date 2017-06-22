package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jdbc.SqlserverDB;
import model.UserTable;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String usr = request.getParameter("username");
		String pwd = request.getParameter("password");
		boolean validated = false;
		SqlserverDB sqlserverDB = new SqlserverDB();
		HttpSession session = request.getSession();
		UserTable userTable = null;
		userTable = (UserTable) session.getAttribute("user");
		if(userTable == null){
			String sql = "select * from userTable";
			ResultSet rs= sqlserverDB.executeQuery(sql);
			try {
				while(rs.next()){
					if(rs.getString(2).trim().compareTo(usr)==0&&rs.getString(3).trim().compareTo(pwd)==0){
						userTable = new UserTable();
						userTable.setId(rs.getInt(1));
						userTable.setName(rs.getString(2));
						userTable.setPassword(rs.getString(3));
						session.setAttribute("user", userTable);
						validated = true;
					}
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sqlserverDB.closeStatement();
			sqlserverDB.closeConnection();
		}
		else{
			validated = true;
		}
		if(validated){
			response.sendRedirect("main.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request, response);
	}
}
