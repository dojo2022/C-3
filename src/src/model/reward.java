package model;

import java.io.Serializable;


/**
 * Servlet implementation class reward
 */

	public class reward implements Serializable{
		private String reward_id;
		private String user_id;
		private String reward_name;
		private String reward_detail;
		private String reward_level_id;
		public reward(String string, String string2, String string3, String string4) {
			// TODO 自動生成されたコンストラクター・スタブ
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
	}



