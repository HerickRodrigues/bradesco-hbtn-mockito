package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BancoServiceTest {


    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository repo = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("123", 100.0);

        // Definindo comportamento do mock
        when(repo.buscarConta("123")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService service = new BancoService(repo);

        // Testando consulta de saldo
        double saldo = service.consultarSaldo("123");

        // Verificando se o saldo está correto
        assertEquals(100.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(repo).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository repo = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("456", 50.0);

        // Definindo comportamento do mock
        when(repo.buscarConta("456")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService service = new BancoService(repo);

        // Executando depósito
        service.depositar("456", 25.0);

        // Verificando se o saldo foi atualizado
        assertEquals(75.0, conta.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(repo).buscarConta("456");
        verify(repo).salvar(conta);
    }
}
