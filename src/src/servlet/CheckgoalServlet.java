package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalpointDao;
import dao.loginDao;
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
		user user_id = (user)session.getAttribute("id");

		//リクエストパラメーターを書く！！
		request.setCharacterEncoding("UTF-8");
		String  id = request.getParameter("id");
		goalpointDao dao = new goalpointDao();
		loginDao point = new loginDao();
		int plusPoint = dao.select(id);
		System.out.println("pluspoint"+plusPoint);
		dao.update(id);
		boolean update = point.pluspoint_update(user_id.getUser_id(), plusPoint);

		// ホームサーブレットにリダイレクトする
		response.sendRedirect("/app/HomeServlet");
	}

}
