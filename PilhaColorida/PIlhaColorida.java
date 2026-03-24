package PilhaColorida;

public class PIlhaColorida {
    private Object[] ArrayGeral;
    private int tamanho;
    private int capacidade;
    private int topoPilhaPreta;
    private int topoPilhaVermelha;

    public PIlhaColorida(int cap){
        this.ArrayGeral = new Object[capacidade];
        this.tamanho = 0;
        this.capacidade=cap;
        this.topoPilhaPreta = capacidade;
        this.topoPilhaVermelha = -1;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getCapacidade(){
        return this.tamanho;
    }

    public int getTopoPilhaPreta(){
        return this.tamanho;
    }

    public int getTopoPilhaVermelha(){
        return this.tamanho;
    }

    public void increaseCapacity(){
    //pendente
    }

    public void reduct(){
    //pendente
    }

    public void pushPPreta(int value){
    //pendente

        ArrayGeral[topoPilhaPreta--] = value;
        this.tamanho++;
    }

    public void pushPVermelha(int value){
    //pendente
        ArrayGeral[topoPilhaVermelha++] = value;
        this.tamanho++;

    }

    public void popPPreta(){
        if(topoPilhaPreta == capacidade){
            throw new casePilhaVazia("A pilha preta não possui elementos para serem retirados");
        }

        ArrayGeral[topoPilhaPreta++] = null;
        this.tamanho--;
    }

    public void popPVermelha(){
        if(topoPilhaVermelha == -1){
            throw new casePilhaVazia("A pilha vermelha não possui elementos para serem retirados");
        }

        ArrayGeral[topoPilhaVermelha--] = null;
        this.tamanho--;
    }

}
