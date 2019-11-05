package ruspbstu.ict.lesson2.calculator;


import ruspbstu.ict.lesson2.calculator.operations.*;

import java.util.Arrays;
import java.util.List;

public class StaticOperationsLoader implements OperationsLoader {
    @Override
    public List<Operation> load() {
        return Arrays.asList(
                new AddOperation(),
                new SubOperation(),
                new DivOperation(),
                new MulOperation(),
                new PowerOperation()
        );
    }
}
