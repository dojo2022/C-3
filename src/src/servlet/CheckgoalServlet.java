package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalDao;
import model.user;

/**
 * Servlet implementation class CheckgoalServlet
 */
@WebServlet("/CheckgoalServlet")
public class CheckgoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからuserIDを取得
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");

		//リクエストパラメーターを書く！！
		request.setCharacterEncoding("UTF-8");
		String  goal_name = request.getParameter("goal_name");
		String  goal_detail = request.getParameter("goal_detail");
		System.out.println(goal_name);
		System.out.println(goal_detail);
		goalDao dao = new goalDao();
		//int plusPoint = dao.achRegist(user.getUser_id());
	}

}
