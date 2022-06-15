package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.loginDao;
import model.user;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}

		//検索処理を行う
		//領分的にはloginDaoだけど、joysDaoで扱った方がいいのか、新規Daoを作成すべきか？
		loginDao loginDao = new loginDao();
		List<user> ranking = loginDao.select(new user());

		//検索結果をリクエストスコープに格納する
		request.setAttribute("ranking", loginDao);

		//	ランキング＝結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
		dispatcher.forward(request, response);
	}


}
