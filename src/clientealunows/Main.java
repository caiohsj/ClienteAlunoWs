/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientealunows;

import clientealunows.controller.ControllerAluno;
import clientealunows.views.TelaPrincipal;

/**
 *
 * @author Caio Henrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        ControllerAluno controller = new ControllerAluno(tela);
    }
    
}
