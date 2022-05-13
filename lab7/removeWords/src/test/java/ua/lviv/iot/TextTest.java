package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {
    // Тест №1
    @org.junit.jupiter.api.Test
    void removeWords1() {
        Text text = new Text("the op or on a in out");
        text.removeWords();
        assertEquals("op ", text.getText());
    }
    // Тест №2
    @org.junit.jupiter.api.Test
    void removeWords2() {
        Text text = new Text("Kyiv had been relatively unscathed in recent weeks, " +
                "and cafes and other businesses have started to reopen, while a growing " +
                "numbers of people have been out and about, enjoying the spring weather." +
                "Van den Bergh knew the Franks personally or meant to out them in particular.");
        text.removeWords();
        assertEquals("Kyiv had been relatively unscathed recent weeks, " +
                "and cafes and other businesses have started to reopen, while growing " +
                "numbers of people have been and about, enjoying spring weather." +
                "Van den Bergh knew Franks personally meant to them particular.",
                text.getText());
    }
    // Тест №3
    @org.junit.jupiter.api.Test
    void removeWords3() {
        Text text = new Text("kk in out");
        text.removeWords();
        assertEquals("kk ", text.getText());
    }
}