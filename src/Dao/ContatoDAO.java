package Dao;

import agendaDTO.ContatoDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

public class ContatoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ContatoDTO> lista = new ArrayList<>();
//CRUD - INSERIR DADOS

    public void salvarContato(ContatoDTO contatos) {
        String sql = "INSERT INTO Contato(nome, idade, dataCadastro, telefone) VALUES(?, ?, ?, ?)";

        //CRIA A CONEXÃO COM O BANCO DE DADOS
        conn = new Conectar().conexaoBD();
        try {
            //CRIAMOS UMA PREPAREDSTATEMENT, ONDE EXECUTA UM COMANDO SQL
            pstm = conn.prepareStatement(sql);

            //PASSANDO PARÃMENTROS PARA OS VALUES
            pstm.setString(1, contatos.getNome());
            pstm.setInt(2, contatos.getIdade());
            pstm.setDate(3, new Date(contatos.getDataCadastro().getTime()));
            pstm.setInt(4, contatos.getTelefone());
            //EXECUTAR O COMANDO SQL
            pstm.execute();

            System.out.println("Contato salvo com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);

        }
    }

    // CRUD - READ (SELECT)
    public ArrayList<ContatoDTO> ListaContatos() {
        String sql = "select * FROM contato";

        try {
            conn = new Conectar().conexaoBD();
            pstm = conn.prepareStatement(sql);
            System.out.println("Lista de contatos");
            rs = pstm.executeQuery();

            while (rs.next()) {
                ContatoDTO cont = new ContatoDTO();

                //RECUPERANDO O ID
                cont.setId(rs.getInt("Id"));
                //RECUPERANOD O NOME
                cont.setNome(rs.getString("nome"));
                //RECUPERANDO A IDADE
                cont.setIdade(rs.getInt("idade"));
                //RECUPERANDO A DATA DE CADASTRO
                cont.setDataCadastro(rs.getDate("dataCadastro"));
                //RECUPERAR TELEFONE
                cont.setTelefone(rs.getInt("telefone"));

                //ADICIONANDO O CONT CRIANDO, NA LISTA DE CONTATOS DO ARRAYLIST
                lista.add(cont);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return lista;
    }

    // CRUD - UPDATE
    public void AtualizarContato(ContatoDTO contato) {

        String sql = "UPDATE contato SET nome = ?, idade = ?, telefone = ? WHERE id = ?";
        try {
            conn = new Conectar().conexaoBD();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setInt(3, contato.getTelefone());

            pstm.setInt(4, contato.getId());
            pstm.execute();
            System.out.println("Contato Atualizado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());

        }
    }

    public void ExcluirContato(int id) {
        String sql = "DELETE FROM contato WHERE id = ?";
        try {
            conn = new Conectar().conexaoBD();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
            System.out.println("Contato excluido com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }

}
