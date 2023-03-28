package agendaDTO;

import java.util.Date;

public class ContatoDTO {

    private int id;
    private String nome;
    private int idade;
    private Date dataCadastro;
    private int telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getTelefone() {

        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}
