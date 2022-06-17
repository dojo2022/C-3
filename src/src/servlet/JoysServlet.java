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
import model.rewardjoys;
import model.user;

/**
 * Servlet implementation class JoysServlet
 */
@WebServlet("/JoysServlet")
public class JoysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessiont = request.getSession();
		if (sessiont.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			System.out.println(sessiont);
			return;

		}//31 32 sessiont


		//セッションスコープにIDを格納
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");


		//セッションスコープにIDを格納
//	HttpSession session = request.getSession();
//		user user = (user)session.getAttribute("id");

		//System.out.println(get.user_id());


		// 検索処理を行う
		joysDao jDao = new joysDao();
		List<rewardjoys> rewardList = jDao.selectAll(user.getUser_id());

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
