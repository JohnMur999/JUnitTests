package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class BestContributorSelenide {
    @Test
    void isSolntsevIsFirstContributor() {
        Configuration.browser = FIREFOX;
        Configuration.browserSize = "1920x1080"; // Вынужденная мера из-за FireFox (bug).
        Selenide.open("https://github.com/selenide/selenide");
        Selenide.$(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        Selenide.$(".Popover").shouldHave(text("Andrei Solntsev"));
    }
}
