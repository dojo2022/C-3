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

import dao.goalDao;
import model.goal;
import model.user;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		}
		// セッションスコープからログインIDを受け取る
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");

		System.out.println(user.getUser_id());

		goalDao dao = new goalDao();
		List<goal> goalTodayList = dao.selectToday(user.getUser_id());

		// 検索結果をリクエストスコープに格納する
				request.setAttribute("goalTodayList", goalTodayList);

		// ホームページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからuserIDを取得
				HttpSession session = request.getSession();
				user user = (user)session.getAttribute("id");

				//リクエストパラメーターを書く！！
				request.setCharacterEncoding("UTF-8");
				String  tag = request.getParameter("tag");

				System.out.println(tag);
				goalDao dao = new goalDao();
				if (tag.equals("0")) {
					List<goal> goalTodayList = dao.selectToday(user.getUser_id());
					//検索結果をリクエストスコープに格納する
					request.setAttribute("goalTodayList", goalTodayList);
				}else {
					List<goal> goalTodayList = dao.selectTagToday(user.getUser_id(), tag);
					//検索結果をリクエストスコープに格納する
					request.setAttribute("goalTodayList", goalTodayList);
				}

				//goal.jspからコピペ「checked」対策
				request.setAttribute("tag", tag);


				// ホームページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
						dispatcher.forward(request, response);
			}
	}


