package Lista.ListaDuplaLigada;

public class No {
    Object valor;
    No anterior;
    No proximo;

    public No(Object valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}
