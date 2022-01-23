package com.lexamenrf44;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class MethodSourceParameterizedGitHubSearchTests {

    static Stream<Arguments> selenideGitHubSearchTestDataProvider () {
        return Stream.of(
                Arguments.of("eroshenkoam/allure-example", "#68"),
                Arguments.of("selenide/selenide", "#1687")
        );
    }

    @MethodSource("selenideGitHubSearchTestDataProvider")
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска репозиториев разных автором с тестовыми данными: {0}")
    public void selenideGitHubSearchTest(String testData, String expectedResult) {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(testData);
        $(".header-search-input").submit();

        $(linkText(testData)).click();
        $(partialLinkText("Issues")).click();
        $(withText(expectedResult)).should(Condition.visible);

    }

}
