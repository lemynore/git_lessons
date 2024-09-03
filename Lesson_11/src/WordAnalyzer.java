import java.util.*;

public class WordAnalyzer {
    public static void main(String[] args) {
        // 1. Создание массива слов
        String[] words = {
                "линкор", "епископ", "линкор", "лакомство", "епископ",
                "лента", "лакомство", "лента", "линкор", "колготки",
                "епископ", "табак", "лента", "колготки", "линкор",
                "табак", "лакомство", "колготки", "лента", "епископ"
        };

        // 2. Использование коллекций для хранения уникальных слов и их частоты
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Преобразование слова в нижний регистр
            String normalizedWord = word.toLowerCase();
            wordCountMap.put(normalizedWord, wordCountMap.getOrDefault(normalizedWord, 0) + 1);
        }

        // 3. Вывод уникальных слов
        System.out.println("Уникальные слова:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word);
        }

        // 4. Вывод частоты каждого слова
        System.out.println("\nЧастота каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
