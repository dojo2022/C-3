package model;

import java.io.Serializable;


/**
 * Servlet implementation class rewardLevel
 */

public class rewardLevel implements Serializable{
	private String reward_level_id;
	private String reward_level_name;
	private String required_point;
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
	public String getRequired_point() {
		return required_point;
	}
	public void setRequired_point(String required_point) {
		this.required_point = required_point;
	}
}
