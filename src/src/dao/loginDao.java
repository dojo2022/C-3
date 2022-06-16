package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


//プロフィールの表示
//引数paramで検索項目を指定し、検索結果のリストを返す
	public List<user> select(user param) {
		Connection conn = null;//初期化
		List<user> profile = new ArrayList<user>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			//ドライバ（DBMSを操作するプログラム）を読み込む作業、h2のドライバに接続するときの名前

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C3", "sa", "");
			//データーベースに接続するためのユーザーIDとPW、データベースのh2コンソールから持ってくる

			// SQL文を準備する<<ここに改造>>
			String sql = "SELECT user_id, password, nickname, having_point, total_point, picture FROM user WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);//connはConnectionクラスのインスタンス、SQL文に入っている？に後から入力できるようにした

			// SQL文を完成させる　？の数だけセットする必要がある
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id() );
			}//最初に出た？1個目という意味



			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここも改造>>検索した結果を格納
			while (rs.next()) {
				user usercard = new user(
				rs.getString("user_id"),
				rs.getString("password"),
				rs.getString("nickname"),
				rs.getInt("having_point"),
				rs.getInt("total_point"),
				rs.getString("picture")

				);
				profile.add(usercard);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			profile = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			profile = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					profile = null;
				}
			}
		}

		// 結果を返す
		return profile;
	}
}





