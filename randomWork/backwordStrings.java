package randomWork;

public class backwordStrings {
    public static void main(String[] args) {
        String input = "Hallo Welt wie gehts";
        String randomized = randomizeWords(input);
        System.out.println(randomized);
    }

    public static String randomizeWords(String input) {
        // Teile den Eingabe-String in Wörter auf
        String[] words = input.split(" ");
        // Durchlaufe jedes Wort und vertausche die Buchstaben
        for (int i = 0; i < words.length; i++) {
            char[] characters = words[i].toCharArray();

            for (int j = 0; j < characters.length; j++) {
                int randomIndex = (int)((Math.random()*characters.length)-1);
                char temp = characters[j];
                characters[j] = characters[randomIndex];
                characters[randomIndex] = temp;
            }

            // Setze das vertauschte Wort zurück
            words[i] = new String(characters);
        }

        // Verbinde die vertauschten Wörter zurück zu einem String
        return String.join(" ", words);
    }
}