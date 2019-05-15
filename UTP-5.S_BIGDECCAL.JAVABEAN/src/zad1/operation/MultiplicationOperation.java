package zad1.operation;

import java.math.BigDecimal;

public class MultiplicationOperation implements Operation {
    @Override
    public BigDecimal operation(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}
