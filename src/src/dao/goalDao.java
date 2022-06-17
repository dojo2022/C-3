package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<goal> selectTagGoal(String id, String type) {
		return null;
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
			String sql = "SELECT goal_name,goal_detail  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = ? AND starting_date <= curdate() AND ending_date >=  curdate() AND achievement_id = '2'";

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
}
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	/*public boolean insert( card) {
		Connection conn = null;
		boolean result = false;	//登録に成功したらtrueに書き換えるコードをこの後書く

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する　＜＜ここを改造する＞＞
			String sql = "insert into BC (number, post_code, name, company_name, department_name, address, email, telephon_number, fax_number) values (?, ?, ?,? , ?, ?, ?, ?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる <<改造＞＞
			if (card.getNumber() != null && !card.getNumber().equals("")) {
				pStmt.setString(1, card.getNumber());
			}
			else {
				pStmt.setString(1, null);
			}
		}
	}*/
