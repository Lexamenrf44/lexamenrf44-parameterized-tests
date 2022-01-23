package com.lexamenrf44;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@DisplayName("Parameterized tests class")
public class ParameterizedGitHubSearchTests {

    @ValueSource(strings = {"eroshenkoam/allure-example"})
    @ParameterizedTest
    @DisplayName("Searching gitHub issues")
    public void issueSearchTest(String testData) {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(testData);
        $(".header-search-input").submit();

        $(linkText(testData)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.visible);

    }

}
