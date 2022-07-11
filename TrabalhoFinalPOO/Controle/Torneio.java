package TrabalhoFinalPOO.Controle;

import TrabalhoFinalPOO.Collection.Time;
import TrabalhoFinalPOO.Excecoes.*;

import java.io.*;
import java.util.ArrayList;

public class Torneio {

    public ArrayList<Time> times= new ArrayList<Time>();

    public void cadastrarTime(Time novo) throws TrabalhoFinalPOO.Excecoes.TimeJaExistenteException {
        times.add(novo);
    }

    public void excluirTime(Time saindo) throws TrabalhoFinalPOO.Excecoes.TimeInexistenteException {
        if(times.contains(saindo)){
            times.remove(saindo);
        }else{
            throw new TrabalhoFinalPOO.Excecoes.TimeInexistenteException();
        }

    }

    //consulta se um time esta cadastrado no torneio
    public Time consultarTime(String procurando) throws TrabalhoFinalPOO.Excecoes.TimeInexistenteException {
        for(Time time: times){
            if(time.getNome().equals(procurando)){
                return time;
            }
        }
        throw new TrabalhoFinalPOO.Excecoes.TimeInexistenteException();
    }

    // verifica se um time ja esta cadastrado no torneio
    public Boolean validar(Time time){
        return times.contains(time);
    }

    // comeca o torneio, assim, cria um copia dos times cadastrados, e , ate os 4 finalistas, ele apaga os que perderam
    // e repoem os que ganharam, quando chega nos 4 finalistas, ele pega os dois primeiros e coloca oq perdeu no final,
    // depois ele pega o 2 e o 3 na array e coloca oq perdeu no final. Assim, ele repete esse processo mais 1 vez
    // resultando em um array ordenado, com o 1 lugar na primeira possicao e o 4 na ultima. Por fim, ele gera um arquivo
    // dando informacoes sobre o ganhador

    public ArrayList<Time> comecarTorneio() throws TrabalhoFinalPOO.Excecoes.TimeIncompletoException, TrabalhoFinalPOO.Excecoes.TimeVazioException {
    	ArrayList<Time> finalistas = (ArrayList<Time>) times.clone();

        while (finalistas.size()!=4){
            Time primeiro = finalistas.get(0);
            Time segundo = finalistas.get(1);
            if(primeiro.getListaJogadores().isEmpty() || segundo.getListaJogadores().isEmpty()){
                throw new TrabalhoFinalPOO.Excecoes.TimeVazioException();
            }

            if(primeiro.getListaJogadores().size() < 2 || segundo.getListaJogadores().size() < 2){
                throw new TimeIncompletoException();
            }
            finalistas.remove(primeiro);
            finalistas.remove(segundo);
            int pontuacaoPrimeiro = primeiro.pontosObtidos();
            int pontuacaoSegundo = segundo.pontosObtidos();
            if(pontuacaoPrimeiro > pontuacaoSegundo){
                finalistas.add(primeiro);
            }
            else{
                finalistas.add(segundo);
            }
        }

        for(int i=0; i < 4; i++){
            Time primeiro = finalistas.get(0);
            Time segundo = finalistas.get(1);
            if(i%2!=0){
                primeiro = finalistas.get(1);
                segundo = finalistas.get(2);

            }
            int pontuacaoPrimeiro = primeiro.pontosObtidos();
            int pontuacaoSegundo = segundo.pontosObtidos();

            if(pontuacaoPrimeiro > pontuacaoSegundo){
                finalistas.remove(segundo);
                finalistas.add(segundo);
            }
            else{
                finalistas.remove(primeiro);
                finalistas.add(primeiro);
            }
        }

        File file = new File("Arquivo.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);  //classe otimizada de escrita

            bw.write("Informações do time campeão");
            bw.newLine();
            String stringCampeao = finalistas.get(0).apresentar();
            bw.write(stringCampeao);
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalistas;
    }
}
