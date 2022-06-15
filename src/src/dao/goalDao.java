package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.goal;
import model.goal_result;
import model.user;

public class goalDao {

	//パターン１
	//アクセス修飾子 戻り値データ型
	public List<goal> select(String id){
		List<goal> goalList = new ArrayList<goal>();

		return goalList;
	}

	//パターン２
	public List<goal> select(user user){
		System.out.print(user.getUser_id());

		return null;
	}

	//目標一覧用
	public List<goal> selectAll(goal param, goal_result result) {
		Connection conn = null;
		List<goal> goalList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT goal_name,goal_detail  FROM goal INNER JOIN goal_result ON goal.goal_id = goal_result.goal_id WHERE user_id = '?' AND achievement_id = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			}
			if (result.getAchievement_id() != null) {
				pStmt.setString(1, result.getAchievement_id());
			}
		}catch(Exception e) {

		}

		return goalList;
	}
}
