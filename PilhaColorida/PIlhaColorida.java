package PilhaColorida;

public class PIlhaColorida {
    private int tamanho;
    private int capacidade;
    private Object[] ArrayGeral;
    private int topoPilhaPreta;
    private int topoPilhaVermelha;

    public PIlhaColorida(int cap){
        this.tamanho = 0;
        this.capacidade=cap;
        this.ArrayGeral = new Object[capacidade];
        this.topoPilhaPreta = capacidade;
        this.topoPilhaVermelha = -1;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    public int getTopoPilhaPreta(){
        return this.topoPilhaPreta;
    }

    public int getTopoPilhaVermelha(){
        return this.topoPilhaVermelha;
    }

    public Object getArrayGeral(int value){
        return this.ArrayGeral[value];
    }

    public void increaseCapacity(){
        int capacidadeAntiga = this.capacidade;
        this.capacidade *= 2;
        Object[] ArrayGeralAumentado = new Object[this.capacidade];

        //for para inserir pilha preta
        for (int i=topoPilhaPreta; i < capacidadeAntiga; i++){
            ArrayGeralAumentado[i + capacidadeAntiga] = ArrayGeral[i];
        }

        //for para inserir pilha vermelha
        for(int i=topoPilhaVermelha; i >= 0; i--){
            ArrayGeralAumentado[i] = ArrayGeral[i];
        }

        this.topoPilhaPreta += capacidadeAntiga;
        this.ArrayGeral = ArrayGeralAumentado;
    }

    public void reduct(){
        if (tamanho <= capacidade / 3 && capacidade > 1){
            int capacidadeAntiga = this.capacidade;
            this.capacidade /= 2;
            Object[] ArrayGeralAumentado = new Object[this.capacidade];

            int tamanhoPilhaPreta = capacidadeAntiga - this.topoPilhaPreta;
            int novoTopoPilhaPreta = this.capacidade - tamanhoPilhaPreta;

            //for para inserir pilha preta
            for (int i = 0; i < tamanhoPilhaPreta; i++) {
                ArrayGeralAumentado[novoTopoPilhaPreta + i] = ArrayGeral[topoPilhaPreta + i];
            }

            //for para inserir pilha vermelha
            for (int i = topoPilhaVermelha; i >= 0; i--) {
                ArrayGeralAumentado[i] = ArrayGeral[i];
            }

            this.topoPilhaPreta = novoTopoPilhaPreta;
            this.ArrayGeral = ArrayGeralAumentado;
        }
    }

    public void pushPPreta(int value){
        if(tamanho==capacidade){
            increaseCapacity();
        }
        ArrayGeral[--topoPilhaPreta] = value;
        this.tamanho++;
        
    }

    public void pushPVermelha(int value){
        if(tamanho==capacidade){
            increaseCapacity();
        }
        ArrayGeral[++topoPilhaVermelha] = value;
        this.tamanho++;

    }

    public void popPPreta(){
        if(topoPilhaPreta == capacidade){
            throw new casePilhaVazia("A pilha preta não possui elementos para serem retirados");
        }

        ArrayGeral[topoPilhaPreta++] = null;
        this.tamanho--;
        reduct();
    }

    public void popPVermelha(){
        if(topoPilhaVermelha == -1){
            throw new casePilhaVazia("A pilha vermelha não possui elementos para serem retirados");
        }

        ArrayGeral[topoPilhaVermelha--] = null;
        this.tamanho--;
        reduct();
    }

}
