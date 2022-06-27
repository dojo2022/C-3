package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalDao;
import dao.goalupdateDao;
import model.GoalInsert;
import model.goal;
import model.result;
import model.user;

/**
 * Servlet implementation class GoalUpdateServlet
 */
@WebServlet("/GoalUpdateServlet")
public class GoalUpdateServlet extends HttpServlet {
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

		//今日の日付を取得する
				LocalDate today = LocalDate.now();
				request.setAttribute("today",today);

		//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String goal_id = request.getParameter("goal_id");


				System.out.println(goal_id);

				//Daoを経由してreward_idに一致するデータを取得する。
				//Daoから取得したデータと
				//インスタンスの生成
				goalupdateDao gDao = new goalupdateDao();
				List<goal> goalList = gDao.selectGoal_id(goal_id);




				//取得したrewardjoysデータをリクエストスコープに格納する。
				//リクエストスコープに変数から取出した値を格納
				request.setAttribute("goalList",goalList);
			  //request.setAttribute(  "human"  ,human);

		// 目標更新・削除画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goalUpdate.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession sessiont = request.getSession();
		if (sessiont.getAttribute("id") == null) {
			response.sendRedirect("/app/LoginServlet");
			return;
		}
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String goal_name = request.getParameter("goal_name");
		String goal_detail = request.getParameter("goal_detail");
	    String sd = request.getParameter("starting_date");
		String ed= request.getParameter("ending_date");
		String difficulty_id = request.getParameter("difficulty_id");
		String term_id = request.getParameter("term_id");
		String goal_id = request.getParameter("goal_id");
		String tag_id =request.getParameter("tag_id");

		Date starting_date=  new Date(0);
		Date ending_date =  new Date(0);

		try {
			java.util.Date s_date = new SimpleDateFormat("yyyy-MM-dd").parse(sd);
			starting_date.setTime(s_date.getTime());
			java.util.Date e_date = new SimpleDateFormat("yyyy-MM-dd").parse(ed);
			ending_date.setTime(e_date.getTime());

       }catch(Exception e){}

		System.out.println(starting_date);

		//セッションスコープにIDを格納
		// セッションスコープの保存領域を確保
		HttpSession session = request.getSession();
		user user_id = (user)session.getAttribute("id");

		//System.out.println(user.getUser_id());

		// 削除と登録を行う
		//削除
		goalupdateDao gDao = new goalupdateDao();


		if (request.getParameter("SUBMIT").equals("更新")) {
			System.out.println(request.getParameter("SUBMIT"));
			//jDao.update←jDaoのupdateメソッド内の処理でfalseがでているせい、これをtrueにしたい
			//→falseの原因はコンストラクタが正しく記述されておらず
			//反映されていないことに気づけなかったため。

			//デフォルトコンストラクタ
			//goal value  = new goal();
			/*
			beansに逐一使用するコンストラクタを宣言するのではなく、
			↑↓のようにデフォルトコンストラクタと元々はif文に
			入っていた引数を一つずつ記述することで
			beansにコンストラクタを宣言することなく処理ができる。
			*/
			//value.setGoal_name(goal_name);
			//value.setGoal_detail(goal_detail);
			//value.setStarting_date(starting_date);
			//value.setEnding_date(ending_date);
			//value.setDifficulty_id(difficulty_id);
			//value.setTerm_id(term_id);
			//value.setGoal_id(goal_id);



			 if (gDao.delete(goal_id)) {	// 削除

				//登録
					goalDao goalDao = new goalDao();
					GoalInsert goal = new GoalInsert();
					goal.setGoal_name(goal_name);
					goal.setGoal_detail(goal_detail);
					goal.setTerm_id(term_id);
					goal.setDifficulty_id(difficulty_id);
					goal.setStarting_date(starting_date);
					goal.setEnding_date(ending_date);
					goal.setTag_id(tag_id);

					boolean result = false;
					String registar = goalDao.insert(user_id.getUser_id(), goal);
					System.out.println("目標番号"+registar);
					if(!registar.equals(null)) {
						if(term_id.equals("2")) {
							result = goalDao.resultinsert(goal, registar, sd, ed);
						}else {
							result = goalDao.resultinsert(goal, registar);
						}
					}

					if(result){//目標の更新
						request.setAttribute("result",
								new result("更新成功！", "目標を更新しました。", "/app/GoalServlet", "目標一覧画面へ"));
					}	else {		// 更新失敗
						System.out.println(request.getParameter("SUBMIT"));
						request.setAttribute("result",
						new result("更新失敗！", "目標を更新できませんでした。", "/app/GoalServlet", "目標一覧登録画面へ"));
					}
			}

			 else {						// 削除失敗
					request.setAttribute("result",
							new result("削除失敗！", "目標を削除できませんでした。", "/app/GoalServlet", "目標一覧画面へ"));
			}
		}
		else {








			if (gDao.delete(goal_id)) {	// 削除成功
				System.out.println("削除"+goal_id);
				request.setAttribute("result",
						new result("削除成功！", "目標を削除しました。", "/app/GoalServlet", "目標一覧画面へ"));
					}
			else {						// 削除失敗
				request.setAttribute("result",
						new result("削除失敗！", "目標を削除できませんでした。", "/app/GoalServlet", "目標一覧画面へ"));
			}

		}

		// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
	}

}


