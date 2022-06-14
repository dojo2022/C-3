package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoysUpdateServlet
 */
@WebServlet("/JoysUpdateServlet")
public class JoysUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}
		*/

/*-------------------------------------------------------------------------------------------------------------*/
/* 0614 bcからひな形追加　引数、DAO部分変更 */
/*
		// リクエストパラメータを取得する　rewardテーブル
		String reward_id = request.getParameter("reward_id");
		String user_id = request.getParameter("user_id");
		String reward_name = request.getParameter("reward_name");
		String reward_detail = request.getParameter("reward_detail");
		String reward_level_id = request.getParameter("reward_level_id");

		//データが送られてきたかコンソールで確認する用
		System.out.println(reward_id +" / " + user_id+" / " + reward_name+" / " + reward_detail+" / " + reward_level_id);

		// 更新または削除を行う　　
		joysDAO bDao = new joysDAO();
		String btn  = request.getParameter("SUBMIT");

		if (request.getParameter("SUBMIT").equals("Update")) {   //←equals("")更新ボタンのvalue=""と一致させる
			if (bDao.update(new joys(reward_id, user_id, reward_name,reward_detail,reward_level_id))) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "Joysを更新しました。", "/app/JoysServlet.java"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "Joysを更新できませんでした。", "/app/JoysServlet.java"));
			}
		}
		else {
			if (bDao.delete(reward_id)) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "Joysを削除しました。", "/app/JoysServlet.java"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "Joysを削除できませんでした。", "/app/JoysServlet.java"));
			}
		}
*/
/*-------------------------------------------------------------------------------------------------------------*/


		// joys更新・削除画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/joysUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
