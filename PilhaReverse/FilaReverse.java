public class FilaReverse {
    private int inicio, fim, tamanho, capacidade;

    public FilaReverse(int cap){
        this.inicio = 0;
        this.fim = 0;
        this.tamanho= 0;
        this.capacidade = cap;
    }

    public boolean isEmpty(){
        return inicio==fim;
    }
}
