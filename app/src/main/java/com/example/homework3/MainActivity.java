package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String poem = "У лукоморья дуб зелёный;\nЗлатая цепь на дубе том:\nИ днём и ночью кот учёный\nВсё ходит по цепи кругом;\nИдёт направо — песнь заводит,\nНалево — сказку говорит.\nТам чудеса: там леший бродит,\nРусалка на ветвях сидит;\nТам на неведомых дорожках\nСледы невиданных зверей;\nИзбушка там на курьих ножках\nСтоит без окон, без дверей;\nТам лес и дол видений полны;\nТам о заре прихлынут волны\nНа брег песчаный и пустой,\nИ тридцать витязей прекрасных\nЧредой из вод выходят ясных,\nИ с ними дядька их морской;\nТам королевич мимоходом\nПленяет грозного царя;\nТам в облаках перед народом\nЧерез леса, через моря\nКолдун несёт богатыря;\nВ темнице там царевна тужит,\nА бурый волк ей верно служит;\nТам ступа с Бабою Ягой\nИдёт, бредёт сама собой,\nТам царь Кащей над златом чахнет;\nТам русский дух… там Русью пахнет!\nИ там я был, и мёд я пил;\nУ моря видел дуб зелёный;\nПод ним сидел, и кот учёный\nСвои мне сказки говорил.";



    private int numberOfCharacters;
    private int numberOfWords;
    private int numberOfCharactersL;
    private boolean fiveLetterWords;
    private String wordsCharactersA;

    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersL = numberOfСharactersL(poem);
        fiveLetterWords = fiveLetterWords(poem);
        wordsCharactersA = wordsCharactersA(poem);

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Число символов в строке" + numberOfCharacters + "\n" + "Число слов в строке" + numberOfWords + "\n" + "Число букв \"л\" в строке" + numberOfCharactersL + "\n" + "Наличие слова состоящего из пяти букв" + fiveLetterWords + "\n" + "Строка из слов начинающихся на букву\"а\" " + wordsCharactersA);
    }


    private String wordsCharactersA(String stringPoem) {
        String stringA = "";
        String stPoem = stringPoem.replace( "\n", " ").trim();
        String[] arrayPoem = stPoem.split(" ");

        for (String string : arrayPoem) {
            if (string.charAt(0) == 'а' | string.charAt(0) == 'А'){
                stringA += string + " ";
            }
        }
        return  stringA.trim();
    }

    private boolean fiveLetterWords(String inputString) {
        String[] words = inputString.split("\\s+"); // Разделение строки на слова
        for (String word : words) {
            if (word.length() == 5) { // Проверка длины слова
                return false; // Если не найдено слов из пяти букв, возвращаем false
            }
        }
        return true; // Если найдено слово из пяти букв, возвращаем true
    }

    private int numberOfСharactersL(String stringPoem) {
        int count = 0;
        for (int i = 0; i < stringPoem.length(); i++) {
            if (stringPoem.charAt(i) == 'л') {
                count++;
            }
        }
        return count;
    }
    private int numberOfWords(String stringPoem) {
        String stPoem = stringPoem.trim();
        int count = 0;
        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == ' ' | stPoem.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }
    private int numberOfCharacters(String stringPoem) {
        return stringPoem.length();
    }
}