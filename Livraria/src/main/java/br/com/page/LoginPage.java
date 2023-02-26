package br.com.page;

import br.com.core.BasePage;

public class LoginPage extends BasePage {

	public void clicarBotaoNewUser() {
		dsl.clicarBotao("newUser");
	}

	public void setUserName(String userName) {
		dsl.escrever("userName", userName);

	}

	public void setPassword(String password) {
		dsl.escrever("password", password);

	}

	public void clickButtonLogin() {
		dsl.clicarBotao("login");
	}

}
