package model;

import java.io.Serializable;
import java.sql.Date;

public class GoalInsert implements Serializable  {
	private String goal_name;
	private String goal_detail;
	private String term_id;
	private String difficulty_id;
	private Date starting_date;
	private Date ending_date;
	private String tag_id;

	public String getGoal_name() {
		return goal_name;
	}
	public String getGoal_detail() {
		return goal_detail;
	}
	public String getTerm_id() {
		return term_id;
	}
	public String getDifficulty_id() {
		return difficulty_id;
	}
	public Date getStarting_date() {
		return starting_date;
	}
	public Date getEnding_date() {
		return ending_date;
	}
	public String getTag_id() {
		return tag_id;
	}

	public void setGoal_name(String goal_name) {
		this.goal_name = goal_name;
	}
	public void setGoal_detail(String goal_detail) {
		this.goal_detail = goal_detail;
	}
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	public void setDifficulty_id(String difficulty_id) {
		this.difficulty_id = difficulty_id;
	}
	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}
	public void setEnding_date(Date ending_date) {
		this.ending_date = ending_date;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}



}
