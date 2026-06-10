package HeapFilaPrioridade;

public class No {
    Item valor;
    No pai;
    No filhoEsq;
    No filhoDir;

    public No(Item valor) {
        this.valor = valor;
        this.pai = null;
        this.filhoEsq = null;
        this.filhoDir = null;
    }
}