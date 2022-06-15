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

	// 引数user_rewardで検索項目を指定し、検索結果のリストを返す
	public List<reward> select(reward user_reward) {
		Connection conn = null;
		List<reward> cardList = new ArrayList<reward>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/app", "sa", "");

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
			if (param.getName() != null) {
				pStmt.setString(2, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getAddress() != null) {
				pStmt.setString(3, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			if (param.getTel() != null) {
				pStmt.setString(4, "%" + param.getTel() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			if (param.getMail() != null) {
				pStmt.setString(5, "%" + param.getMail() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}

			if (param.getAttr() != null) {
				pStmt.setString(6, "%" + param.getAttr() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}

			if (param.getRemarks() != null) {
				pStmt.setString(7, "%" + param.getRemarks() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする  ここを改造
			while (rs.next()) {
				Bc card = new Bc(
				rs.getString("NUMBER"),
				rs.getString("NAME"),
				rs.getString("ADDRESS"),
				rs.getString("TEL"),
				rs.getString("MAIL"),
				rs.getString("ATTR"),
				rs.getString("REMARKS")
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
