package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.reward;
//select,insert,update,deleteは基本だから通常作っておくのがベース。
//ただ、全部作るのは大変だから必要なもののみまずは作る
public class joysDao {

	//パターン１
	//アクセス修飾子 戻り値データ型
	public List<reward> select(String id){
		List<reward> rewardList = new ArrayList<reward>();

		return rewardList;
	}

	// 引数user_rewardで検索項目を指定し、検索結果のリストを返す
	public List<reward> selectAll(String id) {
		Connection conn = null;
		List<reward> rewardList = new ArrayList<reward>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT  reward.reward_name,reward.reward_detail,reward_level.required_point\r\n"
					+ "			FROM reward \r\n"
					+ "			INNER JOIN reward_level ON reward.reward_level_id = reward_level.reward_level_id \r\n"
					+ "			WHERE reward.user_id = 'kawakami' ORDER BY reward_level.reward_level_id ASC";


			//↑SQL select reward_id,user_id, reward_name, reward_detail from reward WHERE reward.user_id = ? ORDER BY reward_level.reward_level_id ASC

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる  reward_level_id
			if (id != null) {
				pStmt.setString(1,id);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする  ここを改造
			while (rs.next()) {
				reward card = new reward(
				rs.getString("reward_id"),
				rs.getString("user_id"),
				rs.getString("reward_name"),
				rs.getString("reward_detail"));
				rewardList.add(card);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			rewardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			rewardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					rewardList = null;
				}
			}
		}

		// 結果を返す
		return rewardList;
	}

}
