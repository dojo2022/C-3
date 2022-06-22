package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalDao;
import model.GoalInsert;
import model.user;

/**
 * Servlet implementation class GoalRegistarServlet
 */
@WebServlet("/GoalRegistarServlet")
public class GoalRegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalRegistarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 目標登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/homeRegistar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからログインIDを受け取る
		HttpSession session = request.getSession();
		user user_id = (user)session.getAttribute("id");

		//パラメータとして受け取る
		request.setCharacterEncoding("UTF-8");
		String goal_name = request.getParameter("goal_name");
		String goal_detail = request.getParameter("goal_detail");
		String term_id = request.getParameter("term_id");
		String difficulty_id = request.getParameter("difficulty_id");
		String sd = request.getParameter("starting_date");
		String ed = request.getParameter("ending_date");
		String tag_id = request.getParameter("tag_id");

		Date starting_date = new Date(0);
		Date ending_date = new Date(0);

		try {
			java.util.Date s_date = new SimpleDateFormat("yyyy-MM-dd").parse(sd);
			starting_date.setTime(s_date.getTime());
			java.util.Date e_date = new SimpleDateFormat("yyyy-MM-dd").parse(ed);
			ending_date.setTime(e_date.getTime());
			//SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			//starting_date = (Date) sdFormat.parse(sd);
			//ending_date = (Date) sdFormat.parse(ed);
		} catch (Exception e) {
			e.printStackTrace();
		}


		//登録処理を行う
		goalDao goalDao = new goalDao();
		GoalInsert goal = new GoalInsert();
		goal.setGoal_name(goal_name);
		goal.setGoal_detail(goal_detail);
		goal.setTerm_id(term_id);
		goal.setDifficulty_id(difficulty_id);
		goal.setStarting_date(starting_date);
		goal.setEnding_date(ending_date);
		goal.setTag_id(tag_id);

		String registar = goalDao.insert(user_id.getUser_id(), goal);
		System.out.println(registar);
		boolean a = goalDao.resultinsert(goal, registar);

	}

}
