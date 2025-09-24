    public class ProdutoEstoque {
    private final int id;
    private final String nome;
    private int quantidade;
    private final double precoUnitario;

    public ProdutoEstoque(int id, String nome, int quantidade, double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getId() {
        return id;
    }

    public void adicionarQuantidade(int qtd) {
        this.quantidade += qtd;
    }

    public boolean removerQuantidade(int qtd) {
        if (this.quantidade >= qtd) {
            this.quantidade -= qtd;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Quantidade: " + quantidade + " | Preço: R$" + precoUnitario;
   }
}    
