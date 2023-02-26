package br.com.page;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class BookPage extends BasePage {

	public void setSearch(String book) {
		dsl.escrever("searchBox", book);

	}

	public void clickBook(String book) {
		dsl.clicarLink(book);
	}

	public void clickAddYourCollection() {
		dsl.clicarBotao(By.xpath("//*[@id='addNewRecordButton' and .='Add To Your Collection']"));
	}

}
