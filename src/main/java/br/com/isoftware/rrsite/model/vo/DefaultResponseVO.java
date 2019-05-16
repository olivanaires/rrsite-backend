package br.com.isoftware.rrsite.model.vo;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
public class DefaultResponseVO {

	private String message;

	public DefaultResponseVO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
