package mockito;

public class Calculadora {
    private final ServicoMatematico servico;

    public Calculadora(ServicoMatematico servico) {
        this.servico = servico;
    }

    public int calcular(int a, int b) {
        return servico.somar(a, b);
    }
}
