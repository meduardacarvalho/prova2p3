package classes;
public class Funcionario extends ClienteEspecial {
    private String setor;
    private int id;
    private double salario;

    public Funcionario(String nome, int idade, String cpf, String endereco, boolean bomCliente, int pontos, double saldo,
                       String setor, int id, double salario) {
        super(nome, idade, cpf, endereco, bomCliente, pontos, saldo);
        this.setor = setor;
        this.id = id;
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void renovarEstoque(int codigoItem, int qtd) {
        int carrinhoTam = getCarrinhoTam();
        Item[] carrinhoDeCompras = getCarrinhoDeCompras();

        for (int i = 0; i < carrinhoTam; i++) {
            Item item = carrinhoDeCompras[i];
            if (item != null && item.getCodigo() == codigoItem) {
                item.setQtdestoque(item.getQtdestoque() + qtd);
                break;
            }
        }
    }

    public void bloquearItem(Item item) {
        item.setDisponibilidade(false);
    }
}

