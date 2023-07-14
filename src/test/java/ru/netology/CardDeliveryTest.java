package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class CardDeliveryTest {
    int days = 3;
    NewDate deliveryDate = new NewDate();
    @Test
    void shouldRegisterCard() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(deliveryDate.newDate(days));
        $("[data-test-id='name'] input").setValue("Сноу Джон");
        $("[data-test-id='phone'] input").setValue("+79991112233");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id ='notification']").shouldHave(text("Встреча успешно забронирована на " + DeliveryDate.newDate(days)), Duration.ofSeconds(15));
    }
}
