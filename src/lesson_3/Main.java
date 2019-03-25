package lesson_3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.


 */

import java.text.MessageFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {
                "вода", "небо", "вода", "песок", "дерево",
                "огнь", "воздух", "воздух", "песок", "камень",
                "лес", "прыжок", "небо", "сахар", "солнце",
                "луна", "ночь", "вода", "движение", "вода"};

        findUniqueWords(words);
        findDupl(words);

    }

    private static HashMap createMap(String[] words) {
        HashMap<String, Integer> dupl = new HashMap<>();
        for (String w : words)
            if (dupl.get(w) == null) dupl.put(w, 1);
            else dupl.put(w, dupl.get(w) + 1);
        return dupl;
    }

    private static void findUniqueWords(String[] words) {
        HashMap<String, Integer> dupl = createMap(words);
        System.out.println("Уникальные слова из заданного массива: ");
        for (Map.Entry<String, Integer> d : dupl.entrySet()) System.out.println(d.getKey());
    }

    private static void findDupl(String[] words) {
        HashMap<String, Integer> dupl = createMap(words);
        System.out.println("Слова, которые дублируются: ");
        for (Map.Entry<String, Integer> d : dupl.entrySet()) {
            if (d.getValue() > 1)
                System.out.println(MessageFormat.format("Слово : {0} ,встречается {1} раз", d.getKey(), d.getValue()));
        }
    }
}
