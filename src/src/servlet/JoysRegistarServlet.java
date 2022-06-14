package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoysRegistarServlet
 */
@WebServlet("/JoysRegistarServlet")
public class JoysRegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}
		*/

		// joys登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/joysRegistar.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}
		*/

		//リクエストパラメータを取得する reward_level_id char (1));
		request.setCharacterEncoding("UTF-8");
		String reward_id = request.getParameter("reward_id");
		String user_id = request.getParameter("user_id");
		String reward_name = request.getParameter("reward_name");
		String reward_detail = request.getParameter("reward_detail");
		String reward_level_id = request.getParameter("reward_level_id");

		//データが送られてきたかコンソールで確認する用
		System.out.println(reward_id +" / " + user_id+" / " + reward_name+" / " + reward_detail+" / " + reward_level_id);

		// 登録処理を行う
		joysDAO bDao = new joysDAO();
		joys joys = new joys(reward_id, user_id, reward_name,reward_detail,reward_level_id);
		if (bDao.insert(bc)) {	// 登録成功
			//74行目は
			request.setAttribute("result",
					new Result("登録成功！", "ジョイスを登録しました。"));
		}
		else {
			request.setAttribute("result",
					new Result("登録失敗！", "ジョイスを登録できませんでした。" ));
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
