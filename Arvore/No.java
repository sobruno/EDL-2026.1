package Arvore;

public class No {
    Object valor;
    No Pai;
    No Filho;

    public No(Object valor){
        this.valor = valor;
        this.Pai = null;
        this.Filho = null;
    }
}
