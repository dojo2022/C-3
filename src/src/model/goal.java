package model;

import java.io.Serializable;
import java.sql.Date;

public class goal implements Serializable {
	private String goal_id;
	private String user_id;
	private String goal_name;
	private String goal_detail;
	private String tag_id;
	private Date starting_date;
	private Date endint_date;
	private String difficulty_id;
	private String term_id;
	public String getGoal_id() {
		return goal_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getGoal_name() {
		return goal_name;
	}
	public String getGoal_detail() {
		return goal_detail;
	}
	public String getTag_id() {
		return tag_id;
	}
	public Date getStarting_date() {
		return starting_date;
	}
	public Date getEndint_date() {
		return endint_date;
	}
	public String getDifficulty_id() {
		return difficulty_id;
	}
	public String getTerm_id() {
		return term_id;
	}
	public void setGoal_id(String goal_id) {
		this.goal_id = goal_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setGoal_name(String goal_name) {
		this.goal_name = goal_name;
	}
	public void setGoal_detail(String goal_detail) {
		this.goal_detail = goal_detail;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}
	public void setEndint_date(Date endint_date) {
		this.endint_date = endint_date;
	}
	public void setDifficulty_id(String difficulty_id) {
		this.difficulty_id = difficulty_id;
	}
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	public goal(String goal_id, String user_id, String goal_name, String goal_detail, String tag_id, Date starting_date,
			Date endint_date, String difficulty_id, String term_id) {
		super();
		this.goal_id = goal_id;
		this.user_id = user_id;
		this.goal_name = goal_name;
		this.goal_detail = goal_detail;
		this.tag_id = tag_id;
		this.starting_date = starting_date;
		this.endint_date = endint_date;
		this.difficulty_id = difficulty_id;
		this.term_id = term_id;
	}


}
