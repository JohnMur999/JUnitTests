package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        Configuration.browser = FIREFOX;
        Selenide.open("https://github.com/");
        Selenide.$("[data-target='qbsearch-input.inputButton']").click();
        Selenide.$("[id=query-builder-test]").setValue("selenide").pressEnter();
        Selenide.$("[data-testid='results-list']").$("div").$("[class='Link__StyledLink-sc-14289xe-0 dheQRw']").click();
        Selenide.$("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
