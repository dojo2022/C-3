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

import dao.loginDao;
//import model.Bc;
//import model.user;
import model.user;


/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
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



		loginDao pDAO =new loginDao();
		List<user> profile = pDAO.select(user);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("profile", profile);

		//プロフィールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("user_id");
				String nickname = request.getParameter("nickname");
				int having_point =Integer.parseInt(request.getParameter("having_point"));
				int total_point = Integer.parseInt(request.getParameter("total_point"));
				String picture = request.getParameter("picture");

				// セッションスコープにIDを格納する(先生の書いたやつ）
				HttpSession session = request.getSession();
				user user = new user();
				user.setUser_id(user_id);
				session.setAttribute("id", user);

				//更新を行う
				loginDao pDao = new loginDao();
				user profile = new user(user_id,nickname, having_point, total_point,picture);
				if (request.getParameter("SUBMIT").equals("更新")) {
					if (bDao.update(bc)) {	// 更新成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/simpleBC/MenuServlet"));
						request.setAttribute("bc",bc);
						// 結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
						dispatcher.forward(request, response);

					}
				}

		// プロフィールサーブレットにリダイレクトする
					response.sendRedirect("/app/profileServlet");
	}*/


}
