package zad1.operation;

import java.math.BigDecimal;

public class AddOperation implements Operation {
    @Override
    public BigDecimal operation(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
