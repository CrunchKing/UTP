package zad3;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Anagrams {

    private ArrayList<String> allWords = new ArrayList<>();
    private ArrayList<ArrayList<String>> lists;

    public Anagrams(String allWords)
    {
        if(allWords.startsWith("http"))
        {
            try (InputStream is = new URL(allWords).openConnection().getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                 Stream<String> stream = reader.lines()) {
                stream.forEach(s -> this.allWords.add(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(allWords));
                String line = reader.readLine();
                while (line != null) {
                    this.allWords.addAll(Arrays.asList(line.split(" ")));
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ArrayList<String>> getSortedByAnQty() {
        lists = new ArrayList<>();

        for(String word : allWords)
        {
            boolean found = false;
            for(ArrayList<String> list : lists)
            {
                String firstWord = list.get(0);
                if(firstWord.length() == word.length())
                {
                    boolean isAnagram = true;

                    for(char letter : firstWord.toCharArray())
                    {
                        int occursMain = 0;
                        int occursGain = 0;

                        for(char c : firstWord.toCharArray())
                        {
                            if(c == letter)
                                occursMain++;
                        }

                        for(char c : word.toCharArray())
                        {
                            if(c == letter)
                                occursGain++;
                        }

                        if(occursGain != occursMain) {
                            isAnagram = false;
                            break;
                        }
                    }

                    if(isAnagram) {
                        found = true;
                        list.add(word);
                    }
                }
            }
            if(!found)
            {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(word);
                lists.add(tmp);
            }
        }

        lists.sort((l, ll) -> ll.size() - l.size());

        return lists;
    }

    public ArrayList<String> getAnagramsFor(String next) {
        for(ArrayList<String> list : lists)
        {
            String firstWord = list.get(0);
            if(firstWord.length() == next.length())
            {
                boolean isAnagram = true;

                for(char letter : firstWord.toCharArray())
                {
                    int occursMain = 0;
                    int occursGain = 0;

                    for(char c : firstWord.toCharArray())
                    {
                        if(c == letter)
                            occursMain++;
                    }

                    for(char c : next.toCharArray())
                    {
                        if(c == letter)
                            occursGain++;
                    }

                    if(occursGain != occursMain) {
                        isAnagram = false;
                        break;
                    }
                }

                if(isAnagram) {
                    return list;
                }
            }
        }

        return new ArrayList<>();
    }
}
