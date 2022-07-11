package TrabalhoFinalPOO.ClasseBasicas;

import TrabalhoFinalPOO.ClasseBasicas.Jogador;
import TrabalhoFinalPOO.Collection.Time;
import TrabalhoFinalPOO.Excecoes.*;

public class TimesPreExistentes {
    public static Time getTimeAmarelo(){
        Time timeAmarelo = new Time("timeAmarelo");
        Jogador amarelo01 = new Jogador("Amarelo01",901,0.67,false);
        Jogador amarelo02 = new Jogador("amarelo02",902,0.47,false);
        try {
            timeAmarelo.cadastrarJogador(amarelo01);
            timeAmarelo.cadastrarJogador(amarelo02);
            return timeAmarelo;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeAmarelo;

    }

    public static Time getTimeCinza(){
        Time timeCinza = new Time("timeCinza");
        Jogador cinza1 = new Jogador("Cinza01",903,0.68,false);
        Jogador cinza02 = new Jogador("Cinza02",904,0.87,false);
        try {
            timeCinza.cadastrarJogador(cinza1);
            timeCinza.cadastrarJogador(cinza02);
            return timeCinza;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeCinza;
    }
//
  
    public static Time getTimeLaranja(){
        Time timeLaranja = new Time("timeLaranja");
        Jogador laranja1 = new Jogador("Laranja01",905,0.68,false);
        Jogador laranja02 = new Jogador("Laranja02",906,0.87,false);
        try {
            timeLaranja.cadastrarJogador(laranja1);
            timeLaranja.cadastrarJogador(laranja02);
            return timeLaranja;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeLaranja;
    }

    public static Time getTimeAzul(){
        Time timeAzul = new Time("timeAzul");
        Jogador azul1 = new Jogador("Azul01",907,0.64,false);
        Jogador azul02 = new Jogador("Azul02",908,0.85,false);
        try {
            timeAzul.cadastrarJogador(azul1);
            timeAzul.cadastrarJogador(azul02);
            return timeAzul;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeAzul;
    }

//
    public static Time getTimeReal(){
        Time timeReal = new Time("timeReal");
        Jogador real1 = new Jogador("Real01",909,0.59,false);
        Jogador real02 = new Jogador("Real02",910,0.71,false);
        try {
            timeReal.cadastrarJogador(real1);
            timeReal.cadastrarJogador(real02);
            return timeReal;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeReal;
    }

//
    public static Time getTimeVasco(){
        Time timeVasco = new Time("timeVasco");
        Jogador vasco1 = new Jogador("Vasco01",911,0.64,false);
        Jogador vasco02 = new Jogador("Vasco02",912,0.77,false);
        try {
            timeVasco.cadastrarJogador(vasco1);
            timeVasco.cadastrarJogador(vasco02);
            return timeVasco;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeVasco;
    }

//
    public static Time getTimeVerde(){
        Time timeVerde = new Time("timeVerde");
        Jogador verde1 = new Jogador("Verde01",913,0.69,false);
        Jogador verde02 = new Jogador("Verde02",914,0.78,false);
        try {
            timeVerde.cadastrarJogador(verde1);
            timeVerde.cadastrarJogador(verde02);
            return timeVerde;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeVerde;
    }

//
  public static Time getTimeVermelho(){
        Time timeVermelho = new Time("timeVermelho");
        Jogador vermelho1 = new Jogador("Vermelho01",915,0.77,false);
        Jogador vermelho02 = new Jogador("Vermelho02",916,0.85,false);
        try {
            timeVermelho.cadastrarJogador(vermelho1);
            timeVermelho.cadastrarJogador(vermelho02);
            return timeVermelho;
        } catch (TimeCompletoException e) {
            e.printStackTrace();
        }
        return timeVermelho;
    }

}

