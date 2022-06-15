package model;
import java.io.Serializable;
import java.sql.Date;

public class goal_result implements Serializable{
	private String id;
	private String goal_id;
	private Date achievement_date;
	private String achievement_id;
	public String getId() {
		return id;
	}
	public String getGoal_id() {
		return goal_id;
	}
	public Date getAchievement_date() {
		return achievement_date;
	}
	public String getAchievement_id() {
		return achievement_id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGoal_id(String goal_id) {
		this.goal_id = goal_id;
	}
	public void setAchievement_date(Date achievement_date) {
		this.achievement_date = achievement_date;
	}
	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}


}
