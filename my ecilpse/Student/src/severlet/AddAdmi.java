package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAdmi
 */
@WebServlet("/AddAdmi")
public class AddAdmi extends HttpServlet {
	private static final long serialVersionUID = 2519L;
	private static Database dataBase;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdmi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("newName");
		String password = request.getParameter("accountPassword");
		PrintWriter out = response.getWriter();
		dataBase = new Database();
		try {
			boolean flag = dataBase.insertUser(name, password);
			if(flag) {
				out.write("<script>");
				out.write("alert(\"添加管理员成功！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='admi.jsp'");//刷新并跳转到admin界面
			}
			else {
				out.write("<script>");
				out.write("alert(\"添加管理员失败！\")");
				out.write("</script>");	
				response.setHeader("refresh", "1;url='addAdmi.jsp'");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
