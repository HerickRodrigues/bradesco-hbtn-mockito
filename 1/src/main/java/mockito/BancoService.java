package mockito;

public class BancoService {
    private ContaRepository contaRepository;

    public BancoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public double consultarSaldo(String numeroConta) {
        Conta conta = contaRepository.buscarConta(numeroConta);
        if (conta == null) {
            return 0.0;
        }
        return conta.getSaldo();
    }

    public void depositar(String numeroConta, double valor) {
        Conta conta = contaRepository.buscarConta(numeroConta);
        if (conta == null) {
            conta = new Conta(numeroConta, valor);
        } else {
            conta.setSaldo(conta.getSaldo() + valor);
        }
        contaRepository.salvar(conta);
    }
}
