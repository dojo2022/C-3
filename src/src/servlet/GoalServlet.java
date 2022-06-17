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
 * Servlet implementation class GoalServlet
 */
@WebServlet("/GoalServlet")
public class GoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("id");

		System.out.println(user.getUser_id());

		goalDao dao = new goalDao();

		//パターン１
		//引数をidを文字列とした場合
		//dao.select(user.getUser_id());
		List<goal> goalList = dao.selectAll(user.getUser_id());

//System.out.println(goalList.get(0));

//		//パターン２
//		//userオブジェクトをまるごと引数として渡してあげる
//		dao.select(user);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("goalList", goalList);

		// 目標一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
