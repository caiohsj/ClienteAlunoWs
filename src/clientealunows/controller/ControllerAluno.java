/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientealunows.controller;


import clientealunows.service.ServiceAluno;
import clientealunows.views.TelaPrincipal;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import localhost._8000.alunows.Aluno;

/**
 *
 * @author Caio Henrique
 */
public class ControllerAluno {
    private TelaPrincipal tela;
    private JTable tabela;
    private JButton botaoEditar;
    private JButton botaoNovo;
    private JButton botaoExcluir;
    private JButton botaoSalvar;
    private JTextField campoNome;
    private JTextField campoMedia;
    private JTextField campoFaltas;
    private Aluno alunoAtual;
    
    
    public ControllerAluno(TelaPrincipal janela) {
        alunoAtual = null;
        tela = janela;
        tabela = tela.getTabela();
        botaoEditar = tela.getBotaoEditar();
        botaoNovo = tela.getBotaoCadastrar();
        botaoExcluir = tela.getBotaoExcluir();
        botaoSalvar = tela.getBotaoSalvar();
        botaoSalvar.setEnabled(false);
        inicializarCampos();
        inicializarTabela();
        acaoBotaoEditar();
        acaoBotaoNovo();
        acaoBotaoSalvar();
        acaoBotaoExcluir();
    }
    
    private void inicializarTabela() {
        String[] colunas = {"ID", "Nome", "Media", "Faltas"};
        List<Aluno> lista = ServiceAluno.listar();
        Object[][] data = {};
        DefaultTableModel tb = new DefaultTableModel(data, colunas);
        for (Aluno aluno : lista) {
            Object[] ob = {aluno.getId(),aluno.getNome(),aluno.getMedia(),aluno.getFaltas()};
            tb.addRow(ob);
        }
        tabela.setModel(tb);
    }
    
    private void acaoBotaoEditar() {
        List<Aluno> lista = ServiceAluno.listar();
        botaoEditar.addActionListener((e) -> {
            botaoNovo.setEnabled(false);
            botaoExcluir.setEnabled(false);
            botaoSalvar.setEnabled(true);
            
            campoNome.setEditable(true);
            campoMedia.setEditable(true);
            campoFaltas.setEditable(true);
            int linha = tabela.getSelectedRow();
            if(linha >= 0) {
                alunoAtual = lista.get(linha);
                campoNome.setText(alunoAtual.getNome());
                campoMedia.setText(Double.toString(alunoAtual.getMedia()));
                campoFaltas.setText(Integer.toString(alunoAtual.getFaltas()));
            }
        });
    }
    
    private void acaoBotaoNovo() {
        botaoNovo.addActionListener((e) -> {
            alunoAtual = null;
            botaoNovo.setEnabled(false);
            botaoExcluir.setEnabled(false);
            botaoEditar.setEnabled(false);
            botaoSalvar.setEnabled(true);
            
            campoNome.setEditable(true);
            campoMedia.setEditable(true);
            campoFaltas.setEditable(true);
        });
    }
    
    private void acaoBotaoSalvar() {
        botaoSalvar.addActionListener((e) -> {
            if(alunoAtual == null) {
                Aluno novoAluno = new Aluno();
                novoAluno.setNome(campoNome.getText());
                novoAluno.setMedia(Double.parseDouble(campoMedia.getText()));
                novoAluno.setFaltas(Integer.parseInt(campoFaltas.getText()));
                ServiceAluno.inserir(novoAluno);
            } else {
                alunoAtual.setNome(campoNome.getText());
                alunoAtual.setMedia(Double.parseDouble(campoMedia.getText()));
                alunoAtual.setFaltas(Integer.parseInt(campoFaltas.getText()));
                ServiceAluno.alterar(alunoAtual);
                inicializarTabela();
            }
            
            limparCampos();
            
            campoNome.setEditable(false);
            campoMedia.setEditable(false);
            campoFaltas.setEditable(false);
            
            botaoNovo.setEnabled(true);
            botaoExcluir.setEnabled(true);
            botaoEditar.setEnabled(true);
            botaoSalvar.setEnabled(false);
            
            inicializarTabela();
        });
    }
    
    private void acaoBotaoExcluir() {
        botaoExcluir.addActionListener((e) -> {
            botaoNovo.setEnabled(true);
            botaoExcluir.setEnabled(true);
            botaoEditar.setEnabled(true);
            botaoSalvar.setEnabled(false);
            
            int linha = tabela.getSelectedRow();
            if(linha >= 0) {
                ServiceAluno.remover(linha);
                inicializarTabela();
            }
        });
    }

    private void inicializarCampos() {
        campoNome = tela.getCampoNome();
        campoMedia = tela.getCampoMedia();
        campoFaltas = tela.getCampoFaltas();
        
        campoNome.setEditable(false);
        campoMedia.setEditable(false);
        campoFaltas.setEditable(false);
    }
    
    private void limparCampos() {
        campoNome.setText("");
        campoMedia.setText("");
        campoFaltas.setText("");
    }
}
