package principal;

import java.sql.Connection;
import java.util.Scanner;

import conexao.Conexao;
import dao.ProdutoDAO;
import model.Produto;

public class Main {

    public static void main(String[] args) {

        // Testa a conexão com o banco
        Connection conexao = Conexao.conectar();

        if (conexao == null) {
            System.out.println("O programa será encerrado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        int opcao;

        do {

            System.out.println("\n====================================");
            System.out.println("       SISTEMA DE PRODUTOS");
            System.out.println("====================================");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    Produto novoProduto = new Produto();

                    System.out.print("\nDescrição: ");
                    novoProduto.setDescricao(scanner.nextLine());

                    System.out.print("Preço: ");
                    novoProduto.setPreco(scanner.nextDouble());

                    System.out.print("Estoque: ");
                    novoProduto.setEstoque(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Categoria: ");
                    novoProduto.setCategoria(scanner.nextLine());

                    dao.cadastrar(novoProduto);

                    break;

                case 2:

                    dao.listar();

                    break;

                case 3:

                    Produto produtoAtualizado = new Produto();

                    System.out.print("\nID do produto: ");
                    produtoAtualizado.setIdProduto(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Nova descrição: ");
                    produtoAtualizado.setDescricao(scanner.nextLine());

                    System.out.print("Novo preço: ");
                    produtoAtualizado.setPreco(scanner.nextDouble());

                    System.out.print("Novo estoque: ");
                    produtoAtualizado.setEstoque(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Nova categoria: ");
                    produtoAtualizado.setCategoria(scanner.nextLine());

                    dao.atualizar(produtoAtualizado);

                    break;

                case 4:

                    System.out.print("\nID do produto que deseja excluir: ");
                    int id = scanner.nextInt();

                    dao.excluir(id);

                    break;

                case 0:

                    System.out.println("\nEncerrando o sistema...");

                    try {
                        conexao.close();
                        System.out.println("Conexão com o banco encerrada.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                default:

                    System.out.println("\nOpção inválida!");

            }

        } while (opcao != 0);

        scanner.close();

    }

}