package TrabalhoFinalPOO.ClasseBasicas;

public class Jogador {
    private String nome;
    private int id;
    private double precisao, lesao;
    private boolean lesionado;

    public Jogador(String nome, int id, double precisao, boolean lesionado){
        this.setNome(nome);
        this.setId(id);
        this.setPrecisao(precisao);// valor entre [0,1]
        this.setLesionado(lesionado);
    }

    private void podeLesionar(){
        double lesaoDebuff = Math.random(); // a lesao causa uma diminuicao de precisao maxima de 0.2 no atirar
        if(lesaoDebuff* 10 <= 2){
            this.lesionado = true;
            this.setLesao(lesaoDebuff);
        }
    }

    // o acerto dele é calculado como a precisao dele multiplicada por 0.7 e somada a um numero aleatorio entre
    // 0 e 1 multiplicado por 0.3. No final tudo é multiplicado por 10 e esse número é arredondado para cima e retornado
    // como resultado

    public double atirar(){
        double casualidade = Math.random();
        if(lesionado){
            return ( (casualidade*0.3+ precisao*0.7) * 10 - lesao ); // caso ele esteja machucado a lesao diminui sua
            // precisao, note que a lesao eh um numero entre 0 e 1
        }
        else{
            this.podeLesionar();
            return ( (casualidade*0.3+ precisao*0.7) * 10 ); // caso ele nao esteja machucado, ele atira normalmente
            // contudo fica lesionado posteriormente
        }
    }


    // apresentacao do jogador
    public String toString(){
        String apresentacao;
        if(this.isLesionado()){
            apresentacao = ("Nome: " + this.getNome()+ ", ID: " + this.id + ", prescisao: " +
                    getPrecisao() + ", lesionado: sim");
        }
        else{
            apresentacao = ("Nome: " + this.getNome()+ ", ID: " + this.id + ", prescisao: " +
                    getPrecisao() + ", lesionado: não");
        }
        return apresentacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public double getPrecisao() {
        return precisao;
    }

    public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }

    public void setLesao(double chanceLesionar) {
        this.lesao = chanceLesionar;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }
}
