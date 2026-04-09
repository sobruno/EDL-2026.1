public class FilaLigada implements Fila {
    private No Inicio;
    private No Fim;

    public FilaLigada(){
        this.Inicio = null;
        this.Fim = null;
    }

    public int size(){

        if(Inicio == null){
            return 0;
        }
        if(Inicio == Fim){
            return 1;
        }

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

        if(isEmpty()){
            this.Inicio = Prox;
            this.Fim = Prox;
            Prox.setElemento(o);
        }

        //gema do enqueue
        Fim.setProximo(Prox);
        Prox.setProximo(null);

        Fim = Prox;

    }

    public Object dequeue(){

        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }

        if(Inicio == Fim){
            Object valor = Inicio.getElemento();
            Inicio = null;
            Fim = null;
            return valor;
        }

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
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }

        return Inicio.getElemento();
    }

}
