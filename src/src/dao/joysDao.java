package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.rewardjoys;
//select,insert,update,deleteは基本だから通常作っておくのがベース。
//ただ、全部作るのは大変だから必要なもののみまずは作る
public class joysDao {
/*
	//パターン１
	//アクセス修飾子 戻り値データ型
	public List<rewardjoys> select(String id){
		List<rewardjoys> rewardList = new ArrayList<rewardjoys>();

		return rewardList;
	}
*/
	// 引数user_rewardで検索項目を指定し、検索結果のリストを返す
	public List<rewardjoys> selectAll(String id) {
		Connection conn = null;
		List<rewardjoys> rewardList = new ArrayList<rewardjoys>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT reward.reward_id,reward.reward_name,reward.reward_detail,reward_level.required_point FROM reward INNER JOIN reward_level ON reward.reward_level_id = reward_level.reward_level_id WHERE reward.user_id = ? ORDER BY CAST(reward.reward_id AS INT) ASC";

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
				rewardjoys reward = new rewardjoys();
				reward.setReward_id(rs.getString("reward_id"));
				//reward.setUser_id(rs.getString("user_id"));
				reward.setReward_name(rs.getString("reward_name"));
				reward.setReward_detail(rs.getString("reward_detail"));
				reward.setRequired_point(rs.getInt("required_point"));
				rewardList.add(reward);
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


//登録画面
	// 引数rewardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(String user_id,rewardjoys reward) {
		Connection conn = null;
		boolean result = false;

		//デバッグ用
		System.out.println(reward.toString());

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "insert into reward (reward_name,reward_detail, reward_level_id,user_id) values (?,?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			//エラー＃４がセットされてない→？と同数下記にif文を追加
			// SQL文を完成させる
			if (reward.getReward_name() != null && !reward.getReward_name().equals("")) {
				pStmt.setString(1, reward.getReward_name());
			}
			else {
				pStmt.setString(1,"");
			}
			if (reward.getReward_detail() != null && !reward.getReward_detail().equals("")) {
				pStmt.setString(2, reward.getReward_detail());
			}
			else {
				pStmt.setString(2,"");
			}
			if (reward.getReward_level_id() != null && !reward.getReward_level_id().equals("")) {
				pStmt.setString(3, reward.getReward_level_id());
			}
			else {
				pStmt.setString(3,"");
			}

			pStmt.setString(4, user_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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


//更新
	// 引数rewardで指定されたレコードを更新し、成功したらtrueを返す
	// 「レコードを更新できませんでした」
	//→デバッグ、更新のため入力した内容は入ってた
	//１JSPに更新内容入力送信　ここはおｋ
	//２Joysアプデサブで入力内容受け取る(if)　elseで更新の失敗、削除の成功できたのでここもおｋ
	//３ｊダオがテーブルにデータ反映させる　終わり
	public boolean update(rewardjoys reward) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "update reward set reward_name=?, reward_detail=?, reward_level_id=? where reward_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (reward.getReward_name() != null && !reward.getReward_name().equals("")) {
				pStmt.setString(1, reward.getReward_name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (reward.getReward_detail() != null && !reward.getReward_detail().equals("")) {
				pStmt.setString(2, reward.getReward_detail());
			}
			else {
				pStmt.setString(2, null);
			}

			if (reward.getReward_level_id() != null && !reward.getReward_level_id().equals("")) {
				pStmt.setString(3, reward.getReward_level_id());
			}
			else {
				pStmt.setString(3, null);
			}

			if (reward.getReward_id() != null && !reward.getReward_id().equals("")) {
				pStmt.setString(4, reward.getReward_id());
			}
			else {
				pStmt.setString(4, null);
			}

			// SQL文を実行する
			int ret = pStmt.executeUpdate();//retが０になる；；
			System.out.println( ret );
			if ( ret == 1) {//更新数１の意味
				result = true;
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




//削除
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String reward_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "delete from reward where reward_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, reward_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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


	// 引数reward_idで一致するデータを取得する　JoysUpdate49
	public List<rewardjoys> selectReward_id(String id) {
		Connection conn = null;
		List<rewardjoys> rewardList = new ArrayList<rewardjoys>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT reward.reward_name,reward.reward_detail,reward.reward_level_id FROM reward INNER JOIN reward_level ON reward.reward_level_id = reward_level.reward_level_id WHERE reward.reward_id=?";
			//↑SQL select reward_id,user_id, reward_name, reward_detail from reward WHERE reward.user_id = ? ORDER BY reward_level.reward_level_id ASC

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (id != null) {
				pStmt.setString(1,id);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする  ここを改造
			while (rs.next()) {
				rewardjoys reward = new rewardjoys();
				reward.setReward_id(rs.getString("reward_id"));
				//reward.setUser_id(rs.getString("user_id"));
				reward.setReward_name(rs.getString("reward_name"));
				reward.setReward_detail(rs.getString("reward_detail"));
				reward.setRequired_point(rs.getInt("required_point"));
				rewardList.add(reward);
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
