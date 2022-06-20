package model;

import java.io.Serializable;

public class difficulty implements Serializable {
	private String difficulty_id;
	private String difficulty_name;
	private int goal_point;
	public String getDifficulty_id() {
		return difficulty_id;
	}
	public String getDifficulty_name() {
		return difficulty_name;
	}
	public int getGoal_point() {
		return goal_point;
	}
	public void setDifficulty_id(String difficulty_id) {
		this.difficulty_id = difficulty_id;
	}
	public void setDifficulty_name(String difficulty_name) {
		this.difficulty_name = difficulty_name;
	}
	public void setGoal_name(int goal_name) {
		this.goal_point = goal_name;
	}


}
