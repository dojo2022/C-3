package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.goal;

public class goalupdateDao {

	public boolean update(goal goal) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SQL文を準備する
			String sql = "update goal set goal_name=?, goal_detail=?, starting_date=?, ending_date=?, difficulty_id=?, term_id=?  where goal_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (goal.getGoal_name() != null && !goal.getGoal_name().equals("")) {
				pStmt.setString(1, goal.getGoal_name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (goal.getGoal_detail() != null && !goal.getGoal_detail().equals("")) {
				pStmt.setString(2, goal.getGoal_detail());
			}
			else {
				pStmt.setString(2, null);
			}

			if (goal.getStarting_date() != null && !goal.getStarting_date().equals("")) {
				pStmt.setDate(3, goal.getStarting_date());
			}
			else {
				pStmt.setString(3, null);
			}

			if (goal.getEnding_date() != null && !goal.getEnding_date().equals("")) {
				pStmt.setDate(4, goal.getEnding_date());
			}
			else {
				pStmt.setString(4, null);
			}

			if (goal.getDifficulty_id() != null && !goal.getDifficulty_id().equals("")) {
				pStmt.setString(5, goal.getDifficulty_id());
			}
			else {
				pStmt.setString(5, null);
			}

			if (goal.getTerm_id() != null && !goal.getTerm_id().equals("")) {
				pStmt.setString(6, goal.getTerm_id());
			}
			else {
				pStmt.setString(6, null);
			}

			if (goal.getGoal_id() != null && !goal.getGoal_id().equals("")) {
				pStmt.setString(7, goal.getGoal_id());
			}
			else {
				pStmt.setString(7, null);
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


		}

