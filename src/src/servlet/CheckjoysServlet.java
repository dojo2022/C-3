package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.joyspointDao;
import dao.loginDao;
import model.result_reward;
import model.user;

/**
 * Servlet implementation class CheckjoysServlet
 */
@WebServlet("/CheckjoysServlet")
public class CheckjoysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからuserIDを取得
		HttpSession session = request.getSession();
		user user_id = (user)session.getAttribute("id");

				//リクエストパラメーターを書く！！
				//消費ポイントを返す
				request.setCharacterEncoding("UTF-8");
				String  id = request.getParameter("reward_id");

				joyspointDao dao = new joyspointDao();
				int minuspoint = dao.select(id);

				System.out.println("pluspoint"+minuspoint);

				//ポイントを引き算
				loginDao point = new loginDao();

				boolean update = point.minuspoint_update(user_id.getUser_id(), minuspoint);

				if (update) {	// 更新成功

						request.setAttribute("result_joys",
								new result_reward("交換成功！", "あなたはjoys名ができるようになりました", "今の保持ポイントはhaving_point","/app/JoysServlet", "Joys一覧画面へ"));
					}
					else {		// 更新失敗
						request.setAttribute("result_joys",
						new result_reward("交換失敗！", "レコードを更新できませんでした。","今の保持ポイントは", "/app/JoysServlet", "Joys一覧画面へ"));
					}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_joys.jsp");
				dispatcher.forward(request, response);
	}

}
