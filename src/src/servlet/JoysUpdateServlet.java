package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.joysDao;
import model.result;
import model.rewardjoys;
import model.user;

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

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}

		//IDをキーにデータを取る
		//取ったらjspに渡す

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String reward_id = request.getParameter("reward_id");
//		String reward_name = request.getParameter("reward_name");
//		String reward_detail = request.getParameter("reward_detail");
//		String reward_level_id= request.getParameter("reward_level_id");

		
		//Daoを経由してreward_idに一致するデータを取得する。
		
		//取得したrewardjoysデータをリクエストスコープに格納する。
		

		// joys更新・削除画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/joysUpdate.jsp");
		dispatcher.forward(request, response);
	}






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String reward_id = request.getParameter("reward_id");
		String reward_name = request.getParameter("reward_name");
		String reward_detail = request.getParameter("reward_detail");
		String reward_level_id= request.getParameter("reward_level_id");

		//セッションスコープにIDを格納
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");

		System.out.println(user.getUser_id());

		// 更新または削除を行う
		joysDao jDao = new joysDao();

		if (request.getParameter("SUBMIT").equals("更新")) {
			System.out.println(request.getParameter("SUBMIT"));
			//jDao.update←jDaoのupdateメソッド内の処理でfalseがでているせい→trueにしたい
			rewardjoys value  = new rewardjoys();
			value.setReward_id(reward_id);
			value.setReward_name(reward_name);
			value.setReward_detail(reward_detail);
			value.setReward_level_id(reward_level_id);
			if (jDao.update(value)) {	// 更新成功
//			if (jDao.update(new rewardjoys( reward_name,  reward_detail, reward_level_id,reward_id))) {	// 更新成功
				request.setAttribute("result",
						new result("更新成功！", "レコードを更新しました。", "/app/JoysUpdateServlet", "ジョイス登録画面へ"));
			}
			else {		// 登録失敗
				System.out.println(request.getParameter("SUBMIT"));
				request.setAttribute("result",
				new result("登録失敗！", "レコードを更新できませんでした。", "/app/JoysUpdateServlet", "ジョイス登録画面へ"));
			}
		}
		else {
			if (jDao.delete(reward_id)) {	// 削除成功
				request.setAttribute("result",
						new result("削除成功！", "レコードを削除しました。", "/app/JoysUpdateServlet", "ジョイス画面へ"));
					}
			else {						// 削除失敗
				request.setAttribute("result",
						new result("削除失敗！", "レコードを削除できませんでした。", "/app/JoysUpdateServlet", "ジョイス画面へ"));
			}
		}

		// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
	}

}
