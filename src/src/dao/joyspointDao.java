package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.rewardjoys;

public class joyspointDao {



	//サーブレットにjoysの消費ポイントを返す
	public int select( String reward_id) {
		Connection conn = null;
		int minuspoint = 0;
		//List<goal> goal_pointList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT required_point FROM reward INNER JOIN reward_level ON reward.reward_level_id = reward_level.reward_level_id WHERE reward_id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);


			System.out.println(reward_id);

			// SQL文を完成させる

			if  (reward_id!= null) {
				pStmt.setString(1,reward_id);

			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//1件しかデータがない場合
			//pointcardにuserテーブルのintのやつ代入
			rewardjoys  minus_point = new rewardjoys();
			if(rs.next()) {
				minus_point.setRequired_point(rs.getInt("required_point"));
			}

			//持ってきたポイント数を変数に代入
			minuspoint = minus_point.getRequired_point();


		}catch ( Exception e ) {

		} finally {


			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {


				}
			}
		}

		// 結果を返す
		return minuspoint;

	}
}
