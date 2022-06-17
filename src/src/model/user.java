package model;
import java.io.Serializable;
public class user implements Serializable {

	private String user_id;//ユーザーID
	private String password;//パスワード
	private String nickname;//ニックネーム
	private int having_point;//保持ポイント
	private int total_point;//累計ポイント
	private String picture;//画像パス


	//引数があるコンストラクタ
	public user(String user_id, String password, String nickname, int having_point, int total_point, String picture) {

		super();
		this.user_id =user_id;
		this.password=password;
		this.nickname=nickname;
		this.having_point=having_point;
		this.total_point=total_point;
		this.picture=picture;
	}

		//引数が無いコンストラクタ

	public user(String nickname, int total_point) {

		super();
		this.user_id ="";
		this.password="";
		this.nickname=nickname;
		this.having_point=0;
		this.total_point=total_point;
		this.picture="";

	}
	//getter,setter

	public user() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public user(String nickname2) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.nickname= nickname2;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getHaving_point() {
		return having_point;
	}

	public void setHaving_point(int having_point) {
		this.having_point = having_point;
	}

	public int getTotal_point() {
		return total_point;
	}

	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}






}
