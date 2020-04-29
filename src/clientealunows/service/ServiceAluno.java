/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientealunows.service;

/**
 *
 * @author caioc
 */
public class ServiceAluno {

    public static void inserir(localhost._8000.alunows.Aluno aluno) {
        localhost._8000.alunows.WebserviceAlunoService service = new localhost._8000.alunows.WebserviceAlunoService();
        localhost._8000.alunows.WebserviceAluno port = service.getWebserviceAlunoPort();
        port.inserir(aluno);
    }

    public static void alterar(localhost._8000.alunows.Aluno aluno) {
        localhost._8000.alunows.WebserviceAlunoService service = new localhost._8000.alunows.WebserviceAlunoService();
        localhost._8000.alunows.WebserviceAluno port = service.getWebserviceAlunoPort();
        port.alterar(aluno);
    }

    public static void remover(int id) {
        localhost._8000.alunows.WebserviceAlunoService service = new localhost._8000.alunows.WebserviceAlunoService();
        localhost._8000.alunows.WebserviceAluno port = service.getWebserviceAlunoPort();
        port.remover(id);
    }

    public static java.util.List<localhost._8000.alunows.Aluno> listar() {
        localhost._8000.alunows.WebserviceAlunoService service = new localhost._8000.alunows.WebserviceAlunoService();
        localhost._8000.alunows.WebserviceAluno port = service.getWebserviceAlunoPort();
        return port.listar();
    }
    
}
