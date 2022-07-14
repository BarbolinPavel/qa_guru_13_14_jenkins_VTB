package pages.components;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    public void checkResult(String key, String value){
        $(".table-responsive").$(Selectors.byText(key)).parent().shouldHave(text(value));
    }
}