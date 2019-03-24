package zad4;

import zad3.Anagrams;

public class Main {
    public static void main(String[] args){
        StringBuilder wholeSite = new StringBuilder();


        Anagrams an = new Anagrams("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
        StringBuilder anagString = new StringBuilder();
        for(String anag :an.getSortedByAnQty().get(0))
        {
            anagString.append(anag).append(" ");
        }
        System.out.println(anagString.substring(0, anagString.length() - 1));
    }
}
