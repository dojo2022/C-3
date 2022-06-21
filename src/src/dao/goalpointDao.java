package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.difficulty;

public class goalpointDao {
	//サーブレットに難易度の点数を返す
	public int select( String id) {
		Connection conn = null;
		int pluspoint = 0;
		//List<goal> goal_pointList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection(":file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT  goal_point FROM goal INNER JOIN difficulty ON goal.difficulty_id = difficulty.difficulty_id INNER JOIN  goal_result ON goal.goal_id = goal_result.goal_id WHERE id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);


			System.out.println(id);

			// SQL文を完成させる

			if  (id != null) {
				pStmt.setString(1,id);

			}


			// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						//1件しかデータがない場合
						//pointcardにuserテーブルのintのやつ代入
						difficulty  plus_point = new difficulty();
						if(rs.next()) {
							plus_point.setGoal_point(rs.getInt("goal_point"));
						}

						//持ってきたポイント数を変数に代入
					     pluspoint = plus_point	.getGoal_point();


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
		return pluspoint;

	}

	//達成評価変更
		public boolean update(String id ){
			Connection conn = null;
			boolean update = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

				// SQL文を準備する
				//更新処理
				String sqlu = "UPDATE  goal_result SET achievement_id = '1'  WHERE id=?";
				PreparedStatement pStmtu = conn.prepareStatement(sqlu);

				pStmtu.setString(1, id );
				if (pStmtu.executeUpdate() == 1) {
					update = true;
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
							return update;
						}
		}





