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

            Double result = this.operations
                    .get(segments[1])
                    .operation(
                            Double.parseDouble(segments[0]),
                            Double.parseDouble(segments[2])
                    );

            return this.formatter.format(result);
        } catch(Exception exception) {
            return "Invalid command to calc";
        }
    }
}  
