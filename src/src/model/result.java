/**
 *
 */
package model;

import java.io.Serializable;

/**
 * @author User
 *
 */
public class result implements Serializable {
	private String title;
	private String message;
	private String backTo;
	private String backToMessage;
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

