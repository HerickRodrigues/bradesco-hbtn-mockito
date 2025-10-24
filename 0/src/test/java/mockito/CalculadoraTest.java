package mockito;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

    @Mock
    private ServicoMatematico servico;

    @InjectMocks
    private Calculadora calculadora;

    @Test
    public void testSomarComMock() {
        // configura o mock para retornar 5 quando somar(2,3) for chamado
        when(servico.somar(2, 3)).thenReturn(5);

        int resultado = calculadora.calcular(2, 3);

        // verifica que o resultado é o valor configurado no mock
        assertEquals(5, resultado);
    }
}
