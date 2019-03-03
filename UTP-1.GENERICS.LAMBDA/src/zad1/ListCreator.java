/**
 *
 *  @author Wyrzykowski Tadeusz S17315
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCreator <T, F> { // Uwaga: klasa musi być sparametrtyzowana

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public ListCreator (List<T> list){
        this.list = list;
    }

    public static <T, F> ListCreator<T, F> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    ListCreator<T, F> when(Selector<T> selector) {
        list.removeIf(t -> !selector.select(t));
        return this;
    }

    List<F> mapEvery(Mapper<T, F> mapper) {
        List<F> mapped = new ArrayList<>();

        list.forEach(t -> mapped.add(mapper.map(t)));

        return mapped;
    }
}  
