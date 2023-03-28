package agendaDTO;

import Dao.ContatoDAO;
import java.util.ArrayList;
import java.util.Date;

public class AgendaDTO {

    public static void main(String[] args) {
        // SALVANDO CONTATO NO BANCO
        ContatoDTO c1 = new ContatoDTO();
        ContatoDAO contatoD = new ContatoDAO();

        c1.setNome("Cecilia");
        c1.setIdade(25);
        c1.setTelefone(21658545);
        c1.setDataCadastro(new Date());

        contatoD.salvarContato(c1);

        //ATUALIZAR CONTATO
        ContatoDTO cont = new ContatoDTO();
        cont.setNome("Eduarda");
        cont.setIdade(36);
        cont.setTelefone(25263250);
        cont.setId(1);

        contatoD.AtualizarContato(cont);

        //PARA VER TODOS OS CONTATOS SALVOS NO BANCO DE DADOS
        ArrayList<ContatoDTO> lista = contatoD.ListaContatos();
        for (int num = 0; num < lista.size(); num++) {
            System.out.println(lista.get(num).getNome());
            System.out.println(lista.get(num).getIdade());
            System.out.println(lista.get(num).getDataCadastro());
            System.out.println(lista.get(num).getId());
        }

        //EXCLUIR CONTATO DO BANCO DE DADOS
        contatoD.ExcluirContato(3);
    }
}
