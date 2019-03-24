package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    private T t;

    public Maybe(T t)
    {
        this.t = t;
    }

    public static <U> Maybe<U> of(U t)
    {
        return new Maybe<>(t);
    }

    public void ifPresent(Consumer cons)
    {
        if(t != null)
            cons.accept(t);
    }

    public <U> Maybe<U> map(Function<T, U> func)
    {
        return t != null ? new Maybe<>(func.apply(t)) : new Maybe<>(null);
    }

    public T get() {
        if(t == null)
            throw new NoSuchElementException("maybe is empty");
        else return t;
    }

    public boolean isPresent(){
        return t != null;
    }

    public T orElse(T defVal) {
        return t == null ? defVal : t;
    }

    public Maybe<T> filter(Predicate<T> pred)
    {
        if(t == null || pred.test(t))
            return this;
        else
            return new Maybe<>(null);
    }

    @Override
    public String toString() {
        if(t == null)
            return "Maybe is empty";
        else
            return "Maybe has value " + t;
    }
}
