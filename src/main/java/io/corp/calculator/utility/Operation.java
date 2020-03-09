package io.corp.calculator.utility;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    CALCULATOR("calculator");

    private static final Operation[] valores = new Operation[]{CALCULATOR};

    private String signo;

    Operation(String signo) {
        this.signo = signo;
    }

    private String getSigno() {
        return this.signo;
    }

 
    @JsonCreator
    public static Operation fromvalue(String valor) {

        for (int i = 0; i < valores.length; ++i) {
            Operation opActual = valores[i];
            if (valor.equalsIgnoreCase(opActual.name()) ||
                    valor.equalsIgnoreCase(opActual.getSigno())) {
                return opActual;
            }
        }

        throw new RuntimeException("Operación no soportada para el valor: " + valor);
    }
}
