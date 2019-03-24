package zad2;

import java.util.ArrayList;
import java.util.List;
import zad1.Selector;
import zad1.Mapper;

public class ListCreator<T> {
    ArrayList<T> arrayList;

    ListCreator(ArrayList<T> arrayList){
        this.arrayList = arrayList;
    }

    static <T> ListCreator<T> collectFrom(List<T> list){
        return new ListCreator<>(new ArrayList<>(list));
    }

    ListCreator<T> when(Selector<T> selecotr){
        ArrayList<T> toRemove = new ArrayList<>();
        for(T tVar : arrayList){
            if(!selecotr.select(tVar)){
                toRemove.add(tVar);
            }
        }

        for(T tVar : toRemove){
            arrayList.remove(tVar);
        }

        return this;
    }

    <V> ArrayList<V> mapEvery(Mapper<T, V> mapper){
        ArrayList<V> mapped = new ArrayList<>();

        for(T tVar : arrayList){
            mapped.add(mapper.map(tVar));
        }

        return mapped;
    }
}
