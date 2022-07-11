package TrabalhoFinalPOO.Gui;

import TrabalhoFinalPOO.Collection.Time;

import javax.swing.*;
import java.awt.*;

public class Tabela extends JFrame {

    //tabela usada para exibir as informacoes de um time
    public Tabela(Time time){
    	getContentPane().setBackground(new Color(245, 245, 220));
        String[] titulos = {"Nome do jogador", "ID ", "Prescisão", "Lesionado"};
        String[][] valores = new String[2][4];

            for(int i=0; i < time.listaJogadores.size(); i++){
                valores[i][0] = time.listaJogadores.get(i).getNome();
                valores[i][1] = String.valueOf(time.listaJogadores.get(i).getId());
                valores[i][2] = String.valueOf(time.listaJogadores.get(i).getPrecisao());
                if(time.listaJogadores.get(i).isLesionado() == true) {
                	valores[i][3] = "Sim";
                }
                if(time.listaJogadores.get(i).isLesionado() == false) {
                	valores[i][3] = "Não";
                }
            }

            JTable tabela = new JTable(valores,titulos);
            tabela.setBackground(new Color(245, 245, 220));
            setTitle(time.getNome());
            JScrollPane paneTabela = new JScrollPane(tabela);
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(paneTabela);
            this.setBounds(700, 200, 500, 97);
            this.setSize(500,97);
            setResizable(false);
            this.setBackground(new Color(255, 255, 224));
            this.setVisible(true);

    }
}


