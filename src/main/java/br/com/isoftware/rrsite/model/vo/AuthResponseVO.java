package br.com.isoftware.rrsite.model.vo;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
public class AuthResponseVO {

	private String token;

	public AuthResponseVO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
