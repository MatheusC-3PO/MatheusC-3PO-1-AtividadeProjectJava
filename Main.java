import java.util.Scanner;

public class ControleEstoque {
    public static void main(String[] args) {
        EstoqueEstoque estoque = new EstoqueEstoque();
        try (Scanner teclado = new Scanner(System.in)) {
            int opcao;
            int id;
            int qtd;
            double preco;
            String nome;
            
            do {
                System.out.println("\n=== Controle de Estoque ===");
                System.out.println("1. Cadastrar produto");
                System.out.println("2. Entrada no estoque");
                System.out.println("3. Saída do estoque");
                System.out.println("4. Listar produtos");
                System.out.println("0. Sair");
                System.out.print("\nEscolha uma opção: ");
                opcao = teclado.nextInt();
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("\nID: ");
                        id = teclado.nextInt();
                        teclado.nextLine(); // limpar buffer
                        System.out.print("Nome: ");
                        nome = teclado.nextLine();
                        System.out.print("Quantidade inicial: ");
                        qtd = teclado.nextInt();
                        System.out.print("Preço unitário: ");
                        preco = teclado.nextDouble();
                        
                        ProdutoEstoque novoProduto = new ProdutoEstoque(id, nome, qtd, preco);
                        estoque.cadastrarProduto(novoProduto);
                        System.out.println("\nProduto cadastrado com sucesso!");
                    }
                    
                    case 2 -> {
                        System.out.print("\nID do produto: ");
                        id = teclado.nextInt();
                        System.out.print("Quantidade a adicionar: ");
                        qtd = teclado.nextInt();
                        
                        if (estoque.entradaEstoque(id, qtd)) {
                            System.out.println("Entrada realizada com sucesso.");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                    }
                    
                    case 3 -> {
                        System.out.print("\nID do produto: ");
                        id = teclado.nextInt();
                        System.out.print("Quantidade a remover: ");
                        qtd = teclado.nextInt();
                        
                        if (estoque.saidaEstoque(id, qtd)) {
                            System.out.println("Saída realizada com sucesso.");
                        } else {
                            System.out.println("Produto não encontrado ou quantidade insuficiente.");
                        }
                    }
                    
                    case 4 -> estoque.listarProdutos();
                    
                    case 0 -> System.out.println("Saindo do sistema...");
                    
                    default -> System.out.println("Opção inválida.");
                }
                
            } while (opcao != 0);
        }
    }
}
