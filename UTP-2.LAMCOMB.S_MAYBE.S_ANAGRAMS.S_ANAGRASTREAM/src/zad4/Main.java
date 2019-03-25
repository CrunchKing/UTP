/**
 *
 *  @author Wyrzykowski Tadeusz S17315
 *
 */

package zad4;


import zad3.Anagrams;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Anagrams an = new Anagrams("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
    for(List<String> wlist : an.getSortedByAnQty()) {
      System.out.println(wlist.get(0) + " "
              + wlist.stream().filter(w->!w.equalsIgnoreCase(wlist.get(0))).collect(Collectors.joining(" ")));
    }
  }
}
