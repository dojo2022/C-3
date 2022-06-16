package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.joysDao;
import model.reward;
import model.user;

/**
 * Servlet implementation class JoysServlet
 */
@WebServlet("/JoysServlet")
public class JoysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessiont = request.getSession();
		if (sessiont.getAttribute("user_id") == null) {
			response.sendRedirect("/app/LoginServlet");
			System.out.println(sessiont);
			return;
*/
		}//31 32 sessiont

/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");
*/
/*
		//セッションスコープにIDを格納
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");
*/
		//System.out.println(get.user_id());

		//パターン１
		//引数をidを文字列とした場合
		//dao.select(user.getUser_id());


		//リクエストパラメータを取得する
/* 		  名刺管理アプリではJSPにフォームの記載があったためリクパラ必須だった(フォームで送られたデータを取得するため)
		request.setCharacterEncoding("UTF-8");
		String reward_id = request.getParameter("reward_id");
		String user_id = request.getParameter("user_id");
		String reward_name = request.getParameter("reward_name");
		String reward_detail = request.getParameter("reward_detail");
*/

		// 検索処理を行う
		joysDao jDao = new joysDao();
		List<reward> rewardList = jDao.select(user.getUser_id());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("rewardList", rewardList);

		// joys一覧閲覧画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/joys.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
