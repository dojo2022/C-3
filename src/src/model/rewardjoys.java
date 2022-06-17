package model;

import java.io.Serializable;

public class rewardjoys extends reward implements Serializable{


		// TODO 自動生成されたコンストラクター・スタブ

		private String reward_id;
		private String user_id;
		private String reward_name;
		private String reward_detail;
		private String reward_level_id;
		private String reward_level_name;
		private int required_point;
//引数あり
		public rewardjoys(String reward_id, String user_id, String reward_name,String reward_detail,String reward_level_id, String reward_level_name, int required_point) {
		super();
		this.reward_id =reward_id;
		this.user_id =user_id;
		this.reward_name =reward_name;
		this.reward_detail =reward_detail;
		this.reward_level_id =reward_level_id;
		this.reward_level_name =reward_level_name;
		this.required_point =required_point;
	}
		//引数がないコンストラクタ
		public rewardjoys() {
		super();
			this.reward_id ="";
			this.user_id="";
			this.reward_name="";
			this.reward_detail="";
			this.reward_level_id="";
			this.reward_level_name="";
			this.required_point =0;
		}

 public String getReward_id() {
			return reward_id;
		}
		public void setReward_id(String reward_id) {
			this.reward_id = reward_id;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getReward_name() {
			return reward_name;
		}
		public void setReward_name(String reward_name) {
			this.reward_name = reward_name;
		}
		public String getReward_detail() {
			return reward_detail;
		}
		public void setReward_detail(String reward_detail) {
			this.reward_detail = reward_detail;
		}


	public String getReward_level_id() {
		return reward_level_id;
	}
	public void setReward_level_id(String reward_level_id) {
		this.reward_level_id = reward_level_id;
	}
	public String getReward_level_name() {
		return reward_level_name;
	}
	public void setReward_level_name(String reward_level_name) {
		this.reward_level_name = reward_level_name;
	}
	public int getRequired_point() {
		return required_point;
	}
	public void setRequired_point(int required_point) {
		this.required_point = required_point;
	}


}
