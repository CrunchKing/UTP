package zad1;

import java.util.function.Function;

public class InputConverter<T> {

    private T t;

    public InputConverter(T t) {
        this.t = t;
    }

    public <A, B> B convertBy(Function... functions) {
        Object input = t;
        Object result = null;

        for (Function<A, B> f : functions) {
            result = f.apply((A) input);
            input = result;
        }

        return (B) result;
    }

}
