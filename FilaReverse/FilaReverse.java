public class FilaReverse {
    private int inicio, fim, tamanho, capacidade;
    private int[] fila;
    private boolean contrario;

    public FilaReverse(int cap){
        this.capacidade = cap;
        this.fila = new int[cap];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
        this.contrario = false;
    }

    private void increaseCapacity(){
        int[] dobro = new int[capacidade * 2];

        for(int i = 0; i < tamanho; i++){
            dobro[i] = fila[(inicio + i) % capacidade];
        }

        fila = dobro;
        capacidade *= 2;
        inicio = 0;
        fim = tamanho;
    }

    private void reduct(){
        if(capacidade <= 1) {
            return;
        }

        int[] metade = new int[capacidade / 2];

        for(int i = 0; i < tamanho; i++){
            metade[i] = fila[(inicio + i) % capacidade];
        }

        fila = metade;
        capacidade /= 2;
        inicio = 0;
        fim = tamanho;
    }

    public void reverse(){
        contrario = !contrario;
    }

    public void enqueue(int value){
        if(tamanho == capacidade){
            increaseCapacity();
        }

        if(!contrario){
            fila[fim] = value;
            fim = (fim + 1) % capacidade;
        } else {
            inicio = (inicio - 1 + capacidade) % capacidade;
            fila[inicio] = value;
        }

        tamanho++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }

        int valor;

        if(!contrario){
            valor = fila[inicio];
            inicio = (inicio + 1) % capacidade;
        } else {
            fim = (fim - 1 + capacidade) % capacidade;
            valor = fila[fim];
        }

        tamanho--;

        if(tamanho <= capacidade / 3){
            reduct();
        }

        return valor;
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }
}