package ArvoreBinaria;

public class No {
    Object valor;
    No pai; 
    No filhoEsq;
    No filhoDir;

    public No(Object valor) {
        this.valor = valor;
        this.pai = null;
        this.filhoEsq = null;
        this.filhoDir = null;
    }
}