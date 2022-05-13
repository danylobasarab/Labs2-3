
package ua.lviv.iot;

public class Main {
    public static void main(String[] args) {

        Text text0 = new Text("kk in out");
        System.out.println(text0.getText());
        text0.removeWords();
        System.out.println(text0.getText());


        Text text = new Text("the op or on a in out");
        System.out.println(text.getText());
        text.removeWords();
        System.out.println(text.getText());

        Text text2 = new Text("Kyiv had been relatively unscathed in recent weeks, " +
                "and cafes and other businesses have started to reopen, while a growing " +
                "numbers of people have been out and about, enjoying the spring weather." +
                "Van den Bergh knew the Franks personally or meant to out them in particular.");
        System.out.println(text2.getText());
        text2.removeWords();
        System.out.println(text2.getText());
    }
}