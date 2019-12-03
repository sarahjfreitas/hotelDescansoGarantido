package Util;

public class ResponseMessage {
	public boolean status;
	public String message;
	
	public ResponseMessage() {}
	public ResponseMessage(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
}
