package br.com.isoftware.rrsite.model.vo;

import javax.validation.constraints.NotBlank;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
public class LoginRequestVO {
	
	@NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
