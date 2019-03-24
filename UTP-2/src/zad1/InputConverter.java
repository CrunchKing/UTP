package zad1;

import java.util.function.Function;

public class InputConverter<T> {
    private T t;

    public InputConverter(T t){
        this.t = t;
    }

    public <Q, W> W convertBy(Function... functions) {
        Object input = t;
        Object result = null;

        for (Function function : functions) {
            result = function.apply(input);
            input = result;
        }

        return (W)result;
    }
}
