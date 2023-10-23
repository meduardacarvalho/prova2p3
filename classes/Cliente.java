package classes;

public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private String endereco;
    private boolean bomcliente;
    private Item[] carrinhoDeCompras = new Item[100];
    private int carrinhotam = 0;

    public Cliente(String nome, int idade, String cpf, String endereco, boolean bomcliente) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bomcliente = bomcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isBomCliente() {
        return this.bomcliente;
    }

    public void setBomCliente(boolean bomcliente) {
        this.bomcliente = bomcliente;
    }

    public Item[] getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(Item[] carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public int getCarrinhoTam() {
        return this.carrinhotam;
    }

    public void setCarrinhoTam(int carrinhoTam) {
        this.carrinhotam = carrinhoTam;
    }

    public void adicionar(Item compra) {
        if (carrinhotam < carrinhoDeCompras.length) {
            carrinhoDeCompras[carrinhotam] = compra;
            carrinhotam++;
        }
    }

    public void cancelar(int codigo) {
        for (int i = 0; i < carrinhotam; i++) {
            if (carrinhoDeCompras[i] != null && carrinhoDeCompras[i].getCodigo() == codigo) {
                carrinhoDeCompras[i] = null;
                break;
            }
        }
    }

    public double finalizarCompra() {
        double total = 0;
        for (int i = 0; i < carrinhotam; i++) {
            if (carrinhoDeCompras[i] != null) {
                total += carrinhoDeCompras[i].getValor();
                carrinhoDeCompras[i].decrementarEstoque();
            }
        }
        carrinhoDeCompras = new Item[100];
        carrinhotam = 0;
        return total;
    }
}