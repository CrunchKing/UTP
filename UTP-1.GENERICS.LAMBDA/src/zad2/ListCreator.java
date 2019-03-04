/**
 * @author Wyrzykowski Tadeusz S17315
 */

package zad2;


import zad1.Mapper;
import zad1.Selector;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {

    private ArrayList<T> list;

    private ListCreator(ArrayList<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(new ArrayList<>(list));
    }

    public ListCreator<T> when(Selector<T> selector) {
        list.removeIf(value -> !selector.select(value));

        return this;
    }

    public <F> List<F> mapEvery(Mapper<T, F> mapper) {
        List<F> mapped = new ArrayList<>();
        list.forEach(t -> mapped.add(mapper.map(t)));

        return mapped;
    }
}
