/**
 *
 *  @author Chlebowicz Jakub S16506
 *
 */

package zad1;

import zad1.operation.*;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Calc {
    public DecimalFormat formatter = new DecimalFormat("#0.########");
    public Map<String, Operation> operations = new HashMap<>();

    public Calc() {
        this.operations.put("+", new AddOperation());
        this.operations.put("-", new SubtractOperation());
        this.operations.put("*", new MultiplicationOperation());
        this.operations.put("/", new DivisionOperation());
    }

    public String doCalc(String expression) {
        try {
            String[] segments = expression.split("[\\s]+");

            BigDecimal result = this.operations
                    .get(segments[1])
                    .operation(
                            new BigDecimal(segments[0]),
                            new BigDecimal(segments[2])
                    );

            return this.formatter.format(result);
        } catch(Exception exception) {
            return "Invalid command to calc";
        }
    }
}  
