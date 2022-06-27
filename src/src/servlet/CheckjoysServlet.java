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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessiont = request.getSession();
		if (sessiont.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String  id = request.getParameter("reward_id");
		String reward_name= request.getParameter("reward_name");
		//String nickname =request.getParameter("nickname");
		int having_point =Integer.parseInt(request.getParameter("having_point"));
		System.out.println(id);


		//セッションスコープからuserIDを取得
		HttpSession session = request.getSession();
		user user_id = (user)session.getAttribute("id");

				//リクエストパラメーターを書く！！
				//消費ポイントを返す


				joyspointDao dao = new joyspointDao();
				int minuspoint = dao.select(id);

				System.out.println("pluspoint"+minuspoint);

				//ポイントを引き算
				loginDao point = new loginDao();

				boolean update = point.minuspoint_update(user_id.getUser_id(), minuspoint);

				int minushaving_point = having_point-minuspoint;

				//セッションスコープにIDを格納
				HttpSession result = request.getSession();
				result.setAttribute("reward_name", reward_name);
				result.setAttribute("having_point",having_point);
				result.setAttribute("minushaving_point",minushaving_point);


				if (update) {	// 交換成功
					//結果ページにフォワードする

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_joys.jsp");
					dispatcher.forward(request, response);
						}
					else {		// 交換失敗
						//結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result_joys_false.jsp");
						dispatcher.forward(request, response);
					}
				//セッションスコープに表示内容を格納
				//HttpSession minus = request.getSession();
				//minus.setAttribute("reward_name", reward_name);
				//minus.setAttribute("having_point", having_point);



	}

}
