package classes;
public class ClienteEspecial extends Cliente {
    private int pontos;
    private double saldo;

    public ClienteEspecial(String nome, int idade, String cpf, String endereco, boolean bomCliente, int pontos, double saldo) {
        super(nome, idade, cpf, endereco, bomCliente);
        this.pontos = pontos;
        this.saldo = saldo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double finalizarCompra() {
        double total = super.finalizarCompra();
        double desconto = total * 0.05;

        if (desconto > 0) {
            saldo = saldo + desconto;
            if (saldo > 100) {
                pontos = pontos + 5;
                saldo = saldo - 100;
            }
        }

        return total;
    }

    public double finalizarCompra(int pontosPorItem) {
        double total = super.finalizarCompra();
        for (int i = 0; i < getCarrinhoTam(); i++) {
            Item item = getCarrinhoDeCompras()[i];
            if (item != null) {
                int pontosNecessarios = pontosPorItem * item.getCodigo();
                if (pontos >= pontosNecessarios) {
                    getCarrinhoDeCompras()[i] = null;
                    pontos = pontos - pontosNecessarios;
                }
            }
        }
        return total;
    }
}