package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.loginDao;
import model.result;
import model.user;

/**
 * Servlet implementation class newuserServlet
 */
@WebServlet("/RegistarServlet")
public class RegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registar.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("user_id");
				String password = request.getParameter("password");

				//ログイン処理を行う
				loginDao lDao = new loginDao();
				user user = new user();
				user.setUser_id(user_id);
				user.setPassword(password);
				System.out.println(user_id);//コンソールチェック用
				System.out.println(password);//コンソールチェック用


				if (lDao.newuser(user)) {
					request.setAttribute("result", (new result("新規登録成功！", "登録に成功しました。", "/app/LoginServlet", "ログインページへ戻る" )));

					// 結果ページにフォワードする

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);



				}else {									// ログイン失敗
						// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
						request.setAttribute("result",
						new result("新規登録失敗！", "既に登録されています", "/app/LoginServlet","ログインページへ戻る"));


					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);
				}
	}
}