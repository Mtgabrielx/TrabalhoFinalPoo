package TrabalhoFinalPOO.Fachada;

import TrabalhoFinalPOO.ClasseBasicas.Jogador;
import TrabalhoFinalPOO.Collection.Time;
import TrabalhoFinalPOO.Controle.*;
import TrabalhoFinalPOO.Excecoes.*;
import TrabalhoFinalPOO.Controle.Torneio;
import TrabalhoFinalPOO.Excecoes.JogadorInexistenteException;

import java.util.ArrayList;

public class Fachada {
    TrabalhoFinalPOO.Controle.Torneio torneio;
    private static Fachada fachada;
    private Fachada(){
        torneio = new Torneio();
    }

    public static Fachada getInstance(){
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }

    public ArrayList<Time> comecarTorneio() throws TrabalhoFinalPOO.Excecoes.TimeIncompletoException, TrabalhoFinalPOO.Excecoes.TimeVazioException {
        return torneio.comecarTorneio();
    }

    public int totalTimes(){
        return torneio.times.size();
    }

    public ArrayList<Time> getTimes(){
        return torneio.times;
    }

    //adiciona o time
    public void adicionarTime(Time time){
        try {
            torneio.cadastrarTime(time);
        } catch (TrabalhoFinalPOO.Excecoes.TimeJaExistenteException e) {
            e.printStackTrace();
        }
    }
    //remove o time
    public void excluirTime(String nomeTime) throws TrabalhoFinalPOO.Excecoes.TimeInexistenteException {
        try {
            Time time = torneio.consultarTime(nomeTime);
            torneio.excluirTime(time);

        } catch (TrabalhoFinalPOO.Excecoes.TimeInexistenteException e) {
            throw new TrabalhoFinalPOO.Excecoes.TimeInexistenteException();
        }
    }
    //consulta o time
    public Time consultarTime(String nomeTime){
        try {
            return torneio.consultarTime(nomeTime);

        } catch (TrabalhoFinalPOO.Excecoes.TimeInexistenteException e) {
            e.printStackTrace();
        }
        return null;
    }

    //verifica se um time ja esta cadastrado
    public boolean validarTime(String nomeTime) {
        try {
            return torneio.validar(torneio.consultarTime(nomeTime));
        } catch (TrabalhoFinalPOO.Excecoes.TimeInexistenteException e) {
            return false;
        }
    }

    //cadastra um jogador
    public void cadastrarJogador(String time, Jogador jogador) throws TrabalhoFinalPOO.Excecoes.TimeCompletoException {

        Time consultando = consultarTime(time);
        if(consultando.getNumeroJogadores() == 2){
            throw new TrabalhoFinalPOO.Excecoes.TimeCompletoException();
        }else{
            consultando.cadastrarJogador(jogador);
        }

    }

    //verifica se um jogador pertence a um dado time
    public Time jogadorPertenceTime(int id){
        Time procurado = null;
        for(Time time: torneio.times){
            try {
                Jogador jogador = time.consultarJogador(id);
                if(jogador != null && jogador.getId() == id){
                    return time;
                }
            } catch (TimeVazioException e) {
                e.printStackTrace();
            }
        }
        return procurado;
    }

    //consulta um jogador
    public Jogador consultarJogador(int id) throws TrabalhoFinalPOO.Excecoes.JogadorInexistenteException {
        for(Time time: torneio.times){
            try {
                Jogador jogador = time.consultarJogador(id);
                if( jogador!= null && jogador.getId() == id){
                    return jogador;
                }
            } catch (TrabalhoFinalPOO.Excecoes.TimeVazioException ignored) {
            }
        }
        throw new TrabalhoFinalPOO.Excecoes.JogadorInexistenteException();
    }

    //excluir um jogador
    public void excluirJogador(int id) throws TrabalhoFinalPOO.Excecoes.JogadorInexistenteException {
        try {
            Jogador jogador = this.consultarJogador(id);
            this.jogadorPertenceTime(id).excluirJogador(jogador);
        } catch ( TrabalhoFinalPOO.Excecoes.TimeVazioException | TrabalhoFinalPOO.Excecoes.JogadorInexistenteException e) {
            e.printStackTrace();
            throw new JogadorInexistenteException();
        }

    }
}
