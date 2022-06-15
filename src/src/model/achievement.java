package model;

import java.io.Serializable;
/**
 * Servlet implementation class achievement
 */

public class achievement implements Serializable{
	private String achievement_id;//1,2
	private String achievement_name;//達成、未達成
	public String getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}
	public String getAchievement_name() {
		return achievement_name;
	}
	public void setAchievement_name(String achievement_name) {
		this.achievement_name = achievement_name;
	}


}