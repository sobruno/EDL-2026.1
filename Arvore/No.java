package Arvore;

import java.util.ArrayList;
import java.util.List;

public class No {
    Object valor;
    No pai; 
    List<No> filhos; 

    public No(Object valor) {
        this.valor = valor;
        this.pai = null;
        this.filhos = new ArrayList<>(); 
    }
}