package br.com.test;

import static br.com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import br.com.core.BaseTeste;
import br.com.core.DSL;
import br.com.page.BookPage;
import br.com.page.LoginPage;
import br.com.page.ProfilePage;
import br.com.page.RegisterPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LivrariaTeste extends BaseTeste {
	private LoginPage pageLogin;
	private RegisterPage pageRegister;
	private ProfilePage pageProfile;
	private BookPage pageBook;
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://demoqa.com/login");
		dsl = new DSL();
		pageLogin = new LoginPage();
		pageRegister = new RegisterPage();
		pageProfile = new ProfilePage();
		pageBook = new BookPage();

	}

	@Test
	public void A_realizarCadastroComPasswordNumericoComMensagemErro() {
		assertEquals("Login", dsl.obterTexto(By.className("main-header")));
		pageLogin.clicarBotaoNewUser();
		assertEquals("Register", dsl.obterTexto(By.className("main-header")));
		pageRegister.setFirstName("José");
		pageRegister.setLastName("Cavalcanti");
		pageRegister.setUserName("JoseCavalcanti");
		pageRegister.setPassword("12345");
		DSL.scroll();
		dsl.aguardarElementoTela("register");
		pageRegister.clickButtonRegister();
		assertEquals("Please verify reCaptcha to register!", dsl.obterTexto("name"));

	}

	@Test
	public void B_adicionarEbookDaLivraria() throws InterruptedException {
		Assert.assertEquals("Login", dsl.obterTexto(By.className("main-header")));
		pageLogin.setUserName("josecristovao");
		pageLogin.setPassword("@Brasil123");
		pageLogin.clickButtonLogin();
		dsl.aguardarElementoTela("gotoStore");
		DSL.scroll();
		pageProfile.clickButtonGoToStore();
		dsl.aguardarElementoTela("searchBox");
		pageBook.setSearch("Git Pocket Guide");
		pageBook.clickBook("Git Pocket Guide");
		assertEquals("9781449325862", dsl.obterTexto(By.xpath("//*[@id='userName-value' and .='9781449325862']")));
		assertEquals("Richard E. Silverman",
				dsl.obterTexto(By.xpath("//*[@id='userName-value' and .='Richard E. Silverman']")));
		DSL.scroll();
		pageBook.clickAddYourCollection();
		Thread.sleep(3000);
		dsl.capturaMensagemPopEAceitar("Book added to your collection.");
		getDriver().get("https://demoqa.com/profile");
		assertEquals("Git Pocket Guide", dsl.obterTexto(By.linkText("Git Pocket Guide")));
		assertEquals("Richard E. Silverman", dsl.obterTexto(By.xpath("//*[.='Richard E. Silverman']")));

	}

}
