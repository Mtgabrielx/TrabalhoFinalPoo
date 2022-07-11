package TrabalhoFinalPOO.Collection;

import TrabalhoFinalPOO.ClasseBasicas.Jogador;
import TrabalhoFinalPOO.Excecoes.*;

import java.util.ArrayList;

public class Time {
    public ArrayList<Jogador> listaJogadores= new ArrayList<Jogador>();
    private String nome;
    private int pontosJogoFinal;

    public Time(String nome){
        this.setNome(nome);
    }

    // um time é limitado a duas pessoas

    public void cadastrarJogador(Jogador novato) throws TimeCompletoException {
        if(listaJogadores.size() == 2){
            throw new TimeCompletoException();
        }
        else{
            if(this.validarJogador(novato)){
                listaJogadores.add(novato);
            }
        }
    }

    // procura por um jogador pelo seu id, caso o time esteja vazio ou o jogador nao exista, ele chama uma
    // exception

    public Jogador consultarJogador(int id) throws TimeVazioException {
        if(listaJogadores.isEmpty()){
            throw new TimeVazioException();
        }
        for(int i=0; i < listaJogadores.size(); i++){
            if( id == listaJogadores.get(i).getId()){
                return listaJogadores.get(i);
            }
        }
        return null;
    }

    public void excluirJogador(Jogador deSaida) throws JogadorInexistenteException, TimeVazioException{
        if(listaJogadores.isEmpty()){
            throw new TimeVazioException();
        }
        if(listaJogadores.contains(deSaida)){
            listaJogadores.remove(deSaida);
        }
        else{
            throw new JogadorInexistenteException();
        }

    }

    //verifica se um mesmo jogador ja existe no time, caso ele nao exista, ele eh valido para entrar

    public boolean validarJogador(Jogador jogador){
        boolean valido = true;
        if(listaJogadores.contains(jogador)){
            valido = false;
        }
        return valido;
    }

    public String apresentar(){
        String conteudo = ( "Time : "+ this.getNome() + ", pontos no jogo final: " +
                this.getPontosJogoFinal() + "\n");
        for(Jogador jogador: listaJogadores){
            conteudo += jogador.toString();
            conteudo += "\n";
        }
        return conteudo;
    }

    //calcula o total de pontos obtido em um jogo de acordo com o alvo acertado pelo jogador

    public int pontosObtidos() throws TimeVazioException{
        int pontos = 0;

        if(listaJogadores.isEmpty()){
            throw new TimeVazioException();
        }

        for(Jogador jogador: listaJogadores){ //cada jogador atira e a partir desse valor, é possível chegar a
            //quantidade de pontos que ele conseguiu com aquela tentativa
            double resultado = jogador.atirar();
            if(resultado < 1){
                pontos += pontos;
            }
            else if( resultado < 2){
                pontos += pontos + 1;
            }
            else if( resultado < 4){
                pontos += pontos + 3;
            }
            else if( resultado < 6){
                pontos += pontos + 5;
            }
            else if( resultado < 9){
                pontos += pontos + 7;
            }
            else{
                pontos += pontos + 10;
            }
        }
        setPontosJogoFinal(pontosJogoFinal);
        return pontos;
    }

    public int getPontosJogoFinal() {
        return pontosJogoFinal;
    }

    public void setPontosJogoFinal(int pontosJogoFinal) {
        this.pontosJogoFinal = pontosJogoFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void setListaJogadores(ArrayList<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }

    public int getNumeroJogadores() {
        return listaJogadores.size();
    }
}
