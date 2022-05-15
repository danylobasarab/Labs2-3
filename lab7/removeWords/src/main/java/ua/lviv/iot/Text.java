package ua.lviv.iot;

import java.util.Arrays;
import java.util.List;

public class Text {

    private String text;
    private List<String> words;
    public Text(String text)
    {
        this.text = text;
        words = Arrays.asList("a", "the", "or", "are", "on", "in", "out" );
    }

    public void removeWords()
    {
        String newString = "";
        // Кількість літер, що необхідно пропустити
        int skip = 0;

        for (int i = 0; i < text.length(); ++i)
        {
            // Шукаємо слова зі списку
            for (int j = 0; j< words.size(); ++j)
            {
                skip = 0;

                for (int k = 0; k< words.get(j).length(); ++k)
                {
                    if ((i+skip) >= text.length()){
                        break;
                    }
                    if (words.get(j).charAt(k) == text.charAt(i+skip)){
                        ++skip;
                    }
                    else{
                        skip = 0;
                        break;
                    }
                }

                boolean spaceStart = false;
                boolean spaceEnd = false;
                // Перевіряємо текст на пробіли перед і за словом
                if ((i > 0) && text.charAt(i - 1) == ' ') {
                    spaceStart = true;
                }
                else if(i==0){
                    spaceStart = true;
                }

                if (((i + skip) < text.length()) && text.charAt(i + skip) == ' ') {
                    spaceEnd = true;
                }
                else if((i + skip)==(text.length())){
                    spaceEnd = true;
                }

                if (spaceStart == true && spaceEnd == true && skip == (words.get(j).length())) {
                    break;
                }
                else {
                    skip = 0;
                }
            }
            i += skip;
            // Якщо в пропусканні літер нема потреби додаємо літеру
            if(skip == 0) {
                newString += text.charAt(i);
            }
        }

        text = newString;
    }
    public String getText(){
        return text;
    }
}
