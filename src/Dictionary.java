import java.util.ArrayList;

public class Dictionary {
    private ArrayList<String> dict;
    private ArrayList<String> translatedDict;


    public Dictionary(){
        dict = new ArrayList<>();
        translatedDict = new ArrayList<>();
    }

    public void addWord(String word, String mot){
        word = word.trim();
        mot = mot.trim();
        dict.add(word);
        addTranslation(mot);
    }

    public void addTranslation(String mot){
        translatedDict.add(mot);
    }


    public void remove(String word){
        String mot;
        mot = search(word);
        dict.remove(word);
        translatedDict.remove(mot);
    }

    public String search(String word){
        if(dict.contains(word)) return translatedDict.get(dict.indexOf(word));
        else return "Word not found";
    }

    public void writeToFile(){

    }


}
