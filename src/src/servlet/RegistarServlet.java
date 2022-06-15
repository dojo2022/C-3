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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
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


				if (lDao.newuser(user)) {
					request.setAttribute("result", (new result("", "登録に成功しました。", "", "" )));

					// 結果ページにフォワードする

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);



				}else {									// ログイン失敗
						// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
						request.setAttribute("result",
						new result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/app/LoginServlet","ログインページへ戻る"));






					//} else {

					// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
					//request.setAttribute("result", (new Result("", "既に登録されています。", "", "", "")));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
					dispatcher.forward(request, response);
				}
	}
}