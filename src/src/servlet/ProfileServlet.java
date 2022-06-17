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

import dao.achievementDao;
import dao.loginDao;
import model.goal;
import model.result;
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

	//プロフィール情報をとってくる
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


		achievementDao aDAO =new achievementDao();
		List<goal> achievementList = aDAO.select(user);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("achievementList", achievementList);


		//プロフィールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	//プロフィールを変更する処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				//String user_id = request.getParameter("user_id");
				String nickname = request.getParameter("nickname");
				//String picture = request.getParameter("picture");

				// セッションスコープにIDを格納する(先生の書いたやつ）
				//HttpSession session = request.getSession();
				//user user = new user();
				//user.setUser_id(user_id);
				//session.setAttribute("id", user);

				//セッションスコープにIDを格納
				//HttpSession session = request.getSession();
				//user user = (user)session.getAttribute("id");

				HttpSession session = request.getSession();
				user user = (user)session.getAttribute("id");
				user.setNickname(nickname);


				//更新を行う
				loginDao uDao = new loginDao();
				//user profile = new user(nickname );
				//profile.setUser_id(user.getUser_id());
				System.out.println(user);

				if (request.getParameter("update").equals("更新")) {
					if (uDao.update(user)) {	// 更新成功
						request.setAttribute("result",
						(new result("更新成功！", "更新に成功しました。", "/app/ProfileServlet", "プロフィールページへ戻る" )));



						// 結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
						dispatcher.forward(request, response);

					}
					else{request.setAttribute("result",
							(new result("更新失敗！", "更新に失敗しました。", "/app/ProfileServlet", "プロフィールページへ戻る" )));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);

					}
				}



	}


}
