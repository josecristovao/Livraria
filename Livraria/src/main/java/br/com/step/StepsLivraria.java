package br.com.step;

import static br.com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.com.core.DSL;
import br.com.page.BookPage;
import br.com.page.LoginPage;
import br.com.page.ProfilePage;
import br.com.page.RegisterPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsLivraria {

	private LoginPage pageLogin;
	private RegisterPage pageRegister;
	private ProfilePage pageProfile;
	private BookPage pageBook;
	private DSL dsl;

	public StepsLivraria() {
		this.dsl = new DSL();
		this.pageLogin = new LoginPage();
		this.pageRegister = new RegisterPage();
		this.pageProfile = new ProfilePage();
		this.pageBook = new BookPage();

	}

	@Dado("que acesso o site {string}")
	public void queAcessoSite(String url) {
		getDriver().get(url);
		assertEquals("Login", dsl.obterTexto(By.className("main-header")));
	}

	@Quando("desejo criar um novo usuário")
	public void desejoCriarUmNovoUsuario() {
		pageLogin.clicarBotaoNewUser();
		assertEquals("Register", dsl.obterTexto(By.className("main-header")));

	}

	@E("digito o nome {string}")
	public void digitoNome(String name) {
		pageRegister.setFirstName(name);

	}

	@E("digito o sobrenome {string}")
	public void digitoSobrenome(String lastName) {
		pageRegister.setLastName(lastName);
	}

	@E("digito o userName {string}")
	public void digitoUserName(String userName) {
		pageRegister.setUserName(userName);
	}

	@E("digito o password {string}")
	public void digitoPassword(String password) {
		pageRegister.setPassword(password);
	}

	@E("clico no botão register")
	public void clicoBotaoRegister() {
		DSL.scroll();
		dsl.aguardarElementoTela("register");
		pageRegister.clickButtonRegister();
	}

	@Então("o sistema apresenta a mensagem de erro {string}")
	public void sistemaApresentaMensagemErro(String frase) {
		assertEquals(frase, dsl.obterTexto("name"));
	}

	@Quando("digito os dados do login")
	public void digitoDadosLogin() {
		Assert.assertEquals("Login", dsl.obterTexto(By.className("main-header")));
		pageLogin.setUserName("josecristovao");
		pageLogin.setPassword("@Brasil123");

	}

	@E("clico no botão login")
	public void clicoBotaoLogin() {
		pageLogin.clickButtonLogin();
	}

	@E("clico no botão go to store")
	public void clicoBotaoGoToStore() {
		dsl.aguardarElementoTela("gotoStore");
		DSL.scroll();
		pageProfile.clickButtonGoToStore();
	}

	@E("digito o nome do livro {string}")
	public void digitoNomeLivro(String livro) {
		dsl.aguardarElementoTela("searchBox");
		pageBook.setSearch(livro);
	}

	@E("clico no livro desejado {string}")
	public void clicoLivroDesejado(String book) {
		pageBook.clickBook(book);
	}

	@E("faço a validação do ISBN do livro {string}")
	public void validacaoISBNdoLivro(String ISBN) {
		assertEquals(ISBN, dsl.obterTexto(By.xpath("//*[@id='userName-value' and .='" + ISBN + "']")));

	}

	@E("faço a validação do nome do autor do livro {string}")
	public void validacaoNomedoAutorLivro(String nomeAutor) {
		assertEquals(nomeAutor, dsl.obterTexto(By.xpath("//*[@id='userName-value' and .='" + nomeAutor + "']")));
		DSL.scroll();

	}

	@E("adiciono o livro a minha coleção")
	public void adicionoLivropraMinhaColecao() throws InterruptedException {
		pageBook.clickAddYourCollection();
		Thread.sleep(3000);
	}

	@E("aperto botão ok e valido mensagem popUp {string}")
	public void apertoBotaoOkeValidoMensagemPopUp(String mensgem) {
		dsl.capturaMensagemPopEAceitar(mensgem);
	}

	@E("vou para página inicial do meu perfil")
	public void irPaginaInicialPerfil() {
		getDriver().get("https://demoqa.com/profile");
	}

	@Então("verifico se o livro correto foi adicionado com sucesso {string}")
	public void verificoSeOLivroFoiAdicionadoCorretamente(String nomeLivro) {
		assertEquals(nomeLivro, dsl.obterTexto(By.linkText(nomeLivro)));
	}

	@Então("verifico se o autor correto foi adicionado com sucesso {string}")
	public void verificoSeAutorDoLivroFoiAdicionadoCorretamente(String autor) {
		assertEquals(autor, dsl.obterTexto(By.xpath("//*[.='" + autor + "']")));
	}

}
