package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GoalInsert;
import model.goal;

public class goalDao {

	//パターン１
	//アクセス修飾子 戻り値データ型
	public List<goal> select(String id) {
		List<goal> goalList = new ArrayList<goal>();

		return goalList;
	}

	//	//パターン２
	//	public List<goal> select(user user) {
	//		System.out.print(user.getUser_id());
	//
	//		return null;
	//	}

	//目標一覧用
	public List<goal> selectAll(String id) {
		Connection conn = null;
		List<goal> goalList = new ArrayList<goal>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT distinct starting_date, ending_date, goal_name,goal_detail  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = ? AND achievement_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (id != null) {
				pStmt.setString(1, id);
				pStmt.setString(2, "2");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//if(term_idが２の時、selectをしなおす、リザルトセットを書き換える)
			// 結果表をコレクションにコピーする<ここ改造>
			while (rs.next()) {
				goal card = new goal(
						rs.getDate("starting_date"),
						rs.getDate("ending_date"),
						rs.getString("goal_name"),
						rs.getString("goal_detail"));
				goalList.add(card);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			goalList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			goalList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					goalList = null;
				}
			}
		}

		// 結果を返す
		return goalList;
	}
											//1 , 2, 3, 4, 5
	public List<goal> selectTagGoal(String id, String tag) {
		Connection conn = null;
		List<goal> goalList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT goal_name,goal_detail  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = ? AND tag_id = ? AND achievement_id = '2'";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (id != null) {
				pStmt.setString(1, id);
			}
			if (tag != null) {
				pStmt.setString(2, tag);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする<ここ改造>
			while (rs.next()) {
				goal card = new goal(
						rs.getString("goal_name"),
						rs.getString("goal_detail"));
				goalList.add(card);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			goalList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			goalList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					goalList = null;
				}
			}
		}

		// 結果を返す
		return goalList;
	}


	//今日やることリスト
	public List<goal> selectToday(String id) {
		Connection conn = null;
		List<goal> goalTodayList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT goal_name,goal_detail, id  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = ? AND starting_date <= curdate() AND ending_date >=  curdate() AND achievement_id = '2'";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (id != null) {
				pStmt.setString(1, id);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする<ここ改造>
			while (rs.next()) {
				goal card = new goal(
						rs.getString("goal_name"),
						rs.getString("goal_detail"),
						rs.getString("id"));
				goalTodayList.add(card);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			goalTodayList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			goalTodayList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					goalTodayList = null;
				}
			}
		}

		// 結果を返す
		return goalTodayList;
	}

	//今日やることリストのタグ用
	public List<goal> selectTagToday(String id, String tag) {
		Connection conn = null;
		List<goal> goalTodayList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT goal_name,goal_detail  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = ? AND starting_date <= curdate() AND ending_date >=  curdate()AND tag_id = ? AND achievement_id = '2'";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (id != null) {
				pStmt.setString(1, id);
			}
			if (tag != null) {
				pStmt.setString(2, tag);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする<ここ改造>
			while (rs.next()) {
				goal card = new goal(
						rs.getString("goal_name"),
						rs.getString("goal_detail"));
				goalTodayList.add(card);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			goalTodayList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			goalTodayList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					goalTodayList = null;
				}
			}
		}

		// 結果を返す
		return goalTodayList;
	}


// 引数userとGoalInsertで指定されたレコードを登録し、成功したら目標番号を返す
public String insert(String user, GoalInsert goal) {
	Connection conn = null;
	String result = null;	//登録に成功したらtrueに書き換えるコードをこの後書く

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

		// SQL文を準備する　＜＜ここを改造する＞＞
		String sql = "INSERT INTO goal (user_id ,goal_name, goal_detail, tag_id, starting_date, ending_date, difficulty_id, term_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる <<改造＞＞

			pStmt.setString(1, user);
			pStmt.setString(2, goal.getGoal_name());
			pStmt.setString(3, goal.getGoal_detail());
			pStmt.setString(4, goal.getTag_id());
			pStmt.setDate(5, goal.getStarting_date());
			pStmt.setDate(6, goal.getEnding_date());
			pStmt.setString(7, goal.getDifficulty_id());
			pStmt.setString(8, goal.getTerm_id());


		// SQL文を実行する
		if (pStmt.executeUpdate() == 1) {
			ResultSet rs = pStmt.getGeneratedKeys();
	        if (rs.next()) {
	            System.out.println(rs.getString(1));
	        }
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 結果を返す
	return result;
}
//引数目標番号と日付で指定されたレコードを登録し、成功したらtrueを返す
public boolean resultinsert(GoalInsert goal, String goal_id) {
	Connection conn = null;
	boolean result = false;	//登録に成功したらtrueに書き換えるコードをこの後書く

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

		// SQL文を準備する　＜＜ここを改造する＞＞
		switch (goal.getTerm_id()){
		case "1":
			String sql = "goal_result(goal_id, achievement_day, achievement_id) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる <<改造＞＞

			if (goal_id != null && !goal_id.equals("")) {
				pStmt.setString(1, goal_id);
			}
			else {
				pStmt.setString(1, null);
			}
			if (goal.getStarting_date() != null && !goal.getStarting_date().equals("")) {
				pStmt.setDate(2, goal.getStarting_date());
			}
			else {
				pStmt.setString(2, null);
			}
				pStmt.setString(3, "2");

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
			break;
		case "2":
			String sqlq = "goal_result(goal_id, achievement_day, achievement_id) VALUES (?, ?, ?)";
			PreparedStatement pStmtq = conn.prepareStatement(sqlq);
			// SQL文を完成させる <<改造＞＞
			if (goal_id != null && !goal_id.equals("")) {
				pStmtq.setString(1, goal_id);
			}
			else {
				pStmtq.setString(1, null);
			}
			if (goal.getStarting_date() != null && !goal.getStarting_date().equals("")) {
				pStmtq.setDate(2, goal.getStarting_date());
			}
			else {
				pStmtq.setString(2, null);
			}
				pStmtq.setString(3, "2");

			// SQL文を実行する
			if (pStmtq.executeUpdate() == 1) {
				result = true;
			}

	case "3":
		String sqlqq = "goal_result(goal_id, achievement_id) VALUES (?, ?)";
		PreparedStatement pStmtqq = conn.prepareStatement(sqlqq);
		// SQL文を完成させる <<改造＞＞
		if (goal_id != null && !goal_id.equals("")) {
			pStmtqq.setString(1, goal_id);
		}
		else {
			pStmtqq.setString(1, null);
		}
			pStmtqq.setString(2, "2");

		// SQL文を実行する
		if (pStmtqq.executeUpdate() == 1) {
			result = true;
		}
	}
}
catch (SQLException e) {
	e.printStackTrace();
}
catch (ClassNotFoundException e) {
	e.printStackTrace();
}
finally {
	// データベースを切断
	if (conn != null) {
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

// 結果を返す
return result;
}
}

