package com.lexamenrf44;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class ValueSourceParameterizedGitHubSearchTests {

    @ValueSource(strings = {"eroshenkoam/allure-example", "selenide/selenide"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска репозиториев разных автором с тестовыми данными: {0}")
    public void selenideGitHubSearchTest(String testData) {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(testData);
        $(".header-search-input").submit();

        $(linkText(testData)).should(Condition.visible);
        // $(partialLinkText("Issues")).click();
        // $(withText("#68")).should(Condition.visible);

    }

}
