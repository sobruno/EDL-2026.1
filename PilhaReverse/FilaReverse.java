public class FilaReverse {
    private int inicio, fim, tamanho, capacidade;
    private int[] FilaArray;

    public FilaReverse(int cap){
        this.inicio = 0;
        this.fim =0;
        this.tamanho= 0;
        this.capacidade = cap;
        this.FilaArray = new int[capacidade];
    }

    public void increaseCapacity(){
        int capacidadeAntiga = this.capacidade;
        this.capacidade *= 2;
        Object[] ArrayGeralAumentado = new Object[this.capacidade];



    }

    public void reduct(){

    }

    public void reverse(){

    }

    public void enqueue(int value){
        if(tamanho==capacidade){
            increaseCapacity();
        }
        if(fim+1 == capacidade){
            fim=0;
        }

        FilaArray[fim] = value;
        tamanho++;
    }

    public int dequeue(){
        if(fim-1 < 0){
            fim=capacidade;
        }
        return fim;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return inicio==fim;
    }

}
