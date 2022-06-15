package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.user;

public class loginDao {

	// ログインできるならtrueを返す
	public boolean isLoginOK(user user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from user where user_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUser_id());
			pStmt.setString(2, user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
//新規登録
	public boolean newuser(user user) {
		Connection conn = null;
		boolean newuser = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from user where user_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUser_id());
			pStmt.setString(2, user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				newuser = false;

			} else {
				String Resql = "INSERT INTO user (user_id, password) VALUES (?, ?)";
				PreparedStatement regist = conn.prepareStatement(Resql);
				regist.setString(1, user.getUser_id());
				regist.setString(2, user.getPassword());
				regist.executeUpdate();
				newuser = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			newuser = false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			newuser = false;

		} finally {

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					newuser = false;
				}
			}
		}
		// 結果を返す
		return newuser;
	}
}
