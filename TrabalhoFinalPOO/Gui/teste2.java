package TrabalhoFinalPOO.Gui;

import TrabalhoFinalPOO.Collection.Time;

import javax.swing.*;
import java.awt.*;

public class teste2 extends JFrame {

    //tabela usada para exibir as informacoes de um time
    public teste2(Time time){
    	setResizable(false);
    	getContentPane().setBackground(new Color(245, 245, 220));
        String[] titulos = {"Nome Jogador", "ID ", "Prescisão", "lesionado"};
        String[][] valores = new String[2][4];

            for(int i=0; i < time.listaJogadores.size(); i++){
                valores[i][0] = time.listaJogadores.get(i).getNome();
                valores[i][1] = String.valueOf(time.listaJogadores.get(i).getId());
                valores[i][2] = String.valueOf(time.listaJogadores.get(i).getPrecisao());
                valores[i][3] = String.valueOf(time.listaJogadores.get(i).isLesionado());
            }

            JTable tabela = new JTable(valores,titulos);
            tabela.setBackground(new Color(245, 245, 220));
            JScrollPane paneTabela = new JScrollPane(tabela);
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(paneTabela);
            this.setSize(500,100);
            this.setVisible(true);

    }
}

