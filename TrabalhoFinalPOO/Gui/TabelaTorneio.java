package TrabalhoFinalPOO.Gui;

import TrabalhoFinalPOO.Collection.*;
import TrabalhoFinalPOO.Collection.Time;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TabelaTorneio extends JFrame {
    // tabela usada para exibir as posicoes dos times finalistas
    public TabelaTorneio(ArrayList<Time> times){
    	getContentPane().setBackground(new Color(245, 245, 220));
        String[] titulos = {"Colocação", "Nome do time"};
        String[][] valores = new String[4][3];

        for(int i=0; i < times.size(); i++){
            valores[i][0] = String.valueOf(i+1);
            valores[i][1] = times.get(i).getNome();
        }

        JTable tabela = new JTable(valores,titulos);
        tabela.setBackground(new Color(245, 245, 220));
        JScrollPane paneTabela = new JScrollPane(tabela);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(paneTabela);
        this.setSize(500,129);
        setTitle("Vencedores");
        this.setBounds(700, 297, 500, 129);
        setResizable(false);
        this.setBackground(new Color(255, 255, 224));
        this.setVisible(true);

    }
}
