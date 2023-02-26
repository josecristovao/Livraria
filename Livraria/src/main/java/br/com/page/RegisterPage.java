package br.com.page;

import br.com.core.BasePage;

public class RegisterPage extends BasePage {

	public void setFirstName(String firstName) {
		dsl.escrever("firstname", firstName);

	}

	public void setLastName(String lastName) {
		dsl.escrever("lastname", lastName);

	}

	public void setUserName(String userName) {
		dsl.escrever("userName", userName);

	}

	public void setPassword(String password) {
		dsl.escrever("password", password);

	}

	public void clickButtonRegister() {
		dsl.clicarBotao("register");
	}

}
