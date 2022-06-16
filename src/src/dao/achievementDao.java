package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.goal;
import model.user;

public class achievementDao {

	//パターン１
	//アクセス修飾子 戻り値データ型
	//public List<goal> select(user param) {
		//List<goal> achievementList = new ArrayList<goal>();

		//return achievementList;
	//}

//	//パターン２
//	public List<goal> select(user user) {
//		System.out.print(user.getUser_id());
//
//		return null;
//	}

	//達成済みリスト用
	public List<goal> select(user param) {
		Connection conn = null;
		List<goal> achievementList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT goal_name FROM goal INNER JOIN goal_result ON goal.goal_id=goal_result.goal_id WHERE achievement_id='1' AND user_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			System.out.println(param.getUser_id());

			// SQL文を完成させる
			if  (param.getUser_id() != null) {
				pStmt.setString(1,param.getUser_id( ));


			}






			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//if()
			// 結果表をコレクションにコピーする<ここ改造>
			while (rs.next()) {
				goal card = new goal(
						//rs.getDate("starting_date"),
						//rs.getDate("ending_date"),
						rs.getString("goal_name"));
						//rs.getString("goal_detail"));
				achievementList.add(card);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			achievementList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			achievementList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					achievementList = null;
				}
			}
		}

		// 結果を返す
		return achievementList;
	}
}
