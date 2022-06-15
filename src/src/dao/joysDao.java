package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.reward;
import model.user;
//select,insert,update,deleteは基本だから通常作っておくのがベース。
//ただ、全部作るのは大変だから必要なもののみまずは作る
public class joysDao {

	// 引数user_rewardで検索項目を指定し、検索結果のリストを返す
	public List<reward> select(reward user_reward) {
		Connection conn = null;
		List<reward> cardList = new ArrayList<reward>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/app", "sa", "");

			//パターン１
			//アクセス修飾子 戻り値データ型
			public List<reward> select(String id){
				List<reward> rewardList = new ArrayList<reward>();

				return rewardList;
			}
/*
			// SQL文を準備する
			String sql = "select reward_id,user_id, reward_name, reward_detail from reward WHERE NUMBER LIKE ? AND NAME LIKE ? AND ADDRESS LIKE ? AND TEL LIKE ? AND MAIL LIKE ? AND ATTR LIKE ? AND REMARKS LIKE ? ORDER BY NUMBER";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる  reward_level_id
			if (reward.getReward_id() != null) {
				pStmt.setString(1, "%" + reward.getReward_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			if (reward.getUser_id() != null) {
				pStmt.setString(2, "%" + reward.getUser_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			if (reward.getReward_name() != null) {
				pStmt.setString(3, "%" + reward.getReward_name() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			if (reward.getReward_detail() != null) {
				pStmt.setString(4, "%" + reward.getReward_detail() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
*/




			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする  ここを改造
			while (rs.next()) {
				reward card = new reward(
				rs.getString("reward_id"),
				rs.getString("user_id"),
				rs.getString("reward_name"),
				rs.getString("reward_detail"),
				rs.getString(""),
				rs.getString(""),
				rs.getString("")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

}
