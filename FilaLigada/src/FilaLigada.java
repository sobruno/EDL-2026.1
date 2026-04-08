public class FilaLigada implements Fila {
    private No Inicio;
    private No Fim;

    public FilaLigada(){
        this.Inicio = null;
        this.Fim = null;
    }

    public int size(){

        //gema do size
        No leao = Inicio;
        int tamanho = 0;
        while (leao.getProximo()!=null){
            leao = leao.getProximo();
            tamanho++;
        }
        return tamanho;
    }

    public void enqueue(Object o){
        No Prox = new No();
        Prox.setElemento(o);

        //gema do enqueue
        Fim.setProximo(Prox);
        Prox.setProximo(null);

        Fim = Prox;

    }

    public Object dequeue(){

        //gema do dequeue
        No leao = Inicio;
        Inicio = Inicio.getProximo();

        leao.setProximo(null);

        return leao.getElemento();
    }

    public boolean isEmpty(){

        if(size() != 0){
            return false;
        }

        return true;
    }

    public Object first(){
        return Inicio;
    }

}
