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
import model.result;
import model.user;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//dao isLoginOKをつかって、データベースと情報と比較してokなら
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int having_point =Integer.parseInt(request.getParameter("having_point"));
		int total_point = Integer.parseInt(request.getParameter("total_point"));
		String picture = request.getParameter("picture");

		//ログイン処理を行う
		loginDao lDao = new loginDao();
		if (lDao.isLoginOK(new user(user_id, password,nickname,having_point,total_point,picture))) {	// ログイン成功

		// セッションスコープにIDを格納する(先生の書いたやつ）
		//HttpSession session = request.getSession();
		//user user = new user();
		//user.setUser_id("makoto");
		//session.setAttribute("id", user);

		//セッションスコープにIDを格納
		HttpSession session = request.getSession();
		session.setAttribute("id", new user(user_id,password,nickname,having_point,total_point,picture));


		// ホームサーブレットにリダイレクトする
		response.sendRedirect("/app/HomeServlet");
	}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/app/LoginServlet","ログインページへ戻る"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}

}
}
