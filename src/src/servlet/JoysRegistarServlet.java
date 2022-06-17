package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.joysDao;
import model.result;
import model.rewardjoys;
import model.user;

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

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessiont = request.getSession();
		if (sessiont.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}

		//セッションスコープにIDを格納
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");

		System.out.println(user.getUser_id());
/*
		joysDao dao = new joysDao();
		List<rewardjoys> rewardList = dao.selectAll(user.getUser_id());
*/
		// joys登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/joysRegistar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String reward_name = request.getParameter("reward_name");
			String reward_detail = request.getParameter("reward_detail");
			String reward_level_id= request.getParameter("reward_level_id");

			//セッションスコープにIDを格納
			HttpSession session = request.getSession();
			user user = (user)session.getAttribute("id");

			System.out.println(user.getUser_id());

			//登録処理を行う
			joysDao jDao = new joysDao();
			rewardjoys joys = new rewardjoys();
			joys.setReward_name(reward_name);
			joys.setReward_detail(reward_detail);
			joys.setReward_level_id(reward_level_id);
			//joys.setUser_id(user.getUser_id());


			if (jDao.insert(user.getUser_id(),joys)) {	// 登録成功
				request.setAttribute("result",
				new result("登録成功！", "レコードを登録しました。", "/app/JoysRegistarServlet", "ジョイス登録画面へ"));
			}
			else {												// 登録失敗
				request.setAttribute("result",
				new result("登録失敗！", "レコードを登録できませんでした。", "/app/JoysRegistarServlet", "ジョイス登録画面へ"));
			}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
