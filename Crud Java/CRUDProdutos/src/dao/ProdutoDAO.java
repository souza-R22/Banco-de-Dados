package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import model.Produto;

public class ProdutoDAO {

    public void cadastrar(Produto produto) {

        String sql = "INSERT INTO produtos(descricao, preco, estoque, categoria) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getEstoque());
            stmt.setString(4, produto.getCategoria());

            stmt.executeUpdate();

            System.out.println("\nProduto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto.");
            e.printStackTrace();
        }

    }

    public void listar() {

        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n===== LISTA DE PRODUTOS =====");

            while (rs.next()) {

                System.out.println("-----------------------------");
                System.out.println("ID: " + rs.getInt("id_produto"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Preço: R$ " + rs.getDouble("preco"));
                System.out.println("Estoque: " + rs.getInt("estoque"));
                System.out.println("Categoria: " + rs.getString("categoria"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos.");
            e.printStackTrace();
        }

    }

    public void atualizar(Produto produto) {

        String sql = "UPDATE produtos SET descricao=?, preco=?, estoque=?, categoria=? WHERE id_produto=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getEstoque());
            stmt.setString(4, produto.getCategoria());
            stmt.setInt(5, produto.getIdProduto());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("\nProduto atualizado com sucesso!");
            } else {
                System.out.println("\nProduto não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto.");
            e.printStackTrace();
        }

    }

    public void excluir(int id) {

        String sql = "DELETE FROM produtos WHERE id_produto=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("\nProduto excluído com sucesso!");
            } else {
                System.out.println("\nProduto não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto.");
            e.printStackTrace();
        }

    }

}