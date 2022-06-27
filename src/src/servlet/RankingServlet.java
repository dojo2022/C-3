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

import dao.rankingDao;
import model.user;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
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


		rankingDao rDao = new rankingDao();


		//String[] aaa = new String[5];
		//{ "", "", "" ,"" ,"" }

		//List<String> bbb = new ArrayList<String>();
		//{}
		//bbb.add("test");
		//{ "test" }
		//bbb.add("test1");

		List<user> rankingList = rDao.select();
		//rankingList = [ user, user, user, user, user, user, user, user, user, user ]


		System.out.println(rankingList);

		for (user user : rankingList) {
			System.out.println(user.getNickname());
		}

		//検索結果をリクエストスコープに格納する
		request.setAttribute("rankingList", rankingList);


		//	ランキング＝結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
		dispatcher.forward(request, response);
	}


}
