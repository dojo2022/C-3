package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.joyspointDao;
import dao.loginDao;

/**
 * Servlet implementation class CheckjoysServlet
 */
@WebServlet("/CheckjoysServlet")
public class CheckjoysServlet extends HttpServlet {
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
		String user = (String)session.getAttribute("id");

				//リクエストパラメーターを書く！！
			//消費ポイントを返す
				request.setCharacterEncoding("UTF-8");
				String  id = request.getParameter("reward_id");

				joyspointDao dao = new joyspointDao();
				int minuspoint = dao.select(id);

			//ポイントを引き算
				loginDao point = new loginDao();

				boolean update = point.minuspoint_update(user, minuspoint);

				// アップデートサーブレットにリダイレクトする
				response.sendRedirect("/app/JousUpdateServlet");
	}

}
