package pages.components;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class SelectComponent {
    public void setStateSity(String value){
        $("#stateCity-wrapper").$(Selectors.byText(value)).click();
    }
}