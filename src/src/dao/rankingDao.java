package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.user;

public class rankingDao {

	// 引数user_rewardで検索項目を指定し、検索結果のリストを返す
	public List<user> select() {
		Connection conn = null;
		List<user>rankingList = new ArrayList<user>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備・完成させる
			String sql = "SELECT TOP 5 nickname, total_point FROM USER ORDER BY total_point DESC;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする  ここを改造
			while (rs.next()) {
				user ranking = new user(
						rs.getString("nickname"),
						rs.getInt("total_point")
						);
				rankingList.add(ranking);
			}

			System.out.println(rankingList);
		}
		catch (SQLException e) {
			e.printStackTrace();
			rankingList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			rankingList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					rankingList = null;
				}
			}
		}

		// 結果を返す
		return rankingList;


	}
}
