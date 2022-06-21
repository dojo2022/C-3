package model;
import java.io.Serializable;

public class result_reward implements Serializable{
	private String title;
	private String message;
	private String pointmessage;
	private String backTo;
	private String backToMessage;


	public result_reward(String title, String message, String pointmessage, String backTo, String backToMessage) {
		this.title =title;
		this.message=message;
		this.pointmessage=pointmessage;
		this.backTo=backTo;
		this.backToMessage=backToMessage;

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPointmessage() {
		return pointmessage;
	}
	public void setPointmessage(String pointmessage) {
		this.pointmessage = pointmessage;
	}
	public String getBackTo() {
		return backTo;
	}
	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
	public String getBackToMessage() {
		return backToMessage;
	}
	public void setBackToMessage(String backToMessage) {
		this.backToMessage = backToMessage;
	}


}
