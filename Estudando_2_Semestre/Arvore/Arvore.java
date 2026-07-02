package Arvore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arvore extends ArvoreAbs{

    private No raiz;
    private int tamanho;
    
    public Arvore() {
        this.raiz=null;
        this.tamanho=0;
    }

    public int size() {
        return this.tamanho;
    }

    public int height(No node) {
        return 1;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public Iterator elements() {
            return 1;
    }

    public Iterator nodes() {
        return 1;
    }

    public No root() {
        return this.raiz;
    }

    public No parent(No node) {
        if(node == null)
            return null;

        return node.pai;
    }

    public Iterator children(No node) {
        List<No> filhos = new ArrayList<>();

        if (node == null)
            return filhos.iterator();

        if(hasLeft(node))
            filhos.add(node.filhoEsq);

        if(hasRight(node))
            filhos.add(node.filhoDir);
        
        return filhos.iterator();
    }

    public boolean isInternal(No node) {
        if(node == null)
            return false;

        return hasLeft(node) || hasRight(node);
    }

    public boolean isExternal(No node) {
        if(node==null)
            return false;

        return !isInternal(node);
    }

    public boolean isRoot(No node) {
        return node == this.raiz;
    }

    public int depth(No node) {
        return 1;
    }

    public Object replace(No node, Object element) {
        if(node == null)
            return null;

        Object antigo = node.valor;
        node.valor = element;
        return antigo;
    }

    public No leftChild(No node) {
        if(node == null)
            return null;

        return node.filhoEsq;
    }

    public No rightChild(No node) {
        if(node == null)
            return null;

        return node.filhoDir;
    }

    public boolean hasLeft(No node) {
        return node != null && node.filhoEsq != null;
    }

    public boolean hasRight(No node) {
        return node != null && node.filhoDir != null;
    }

    protected No treeSearch(No node, Object element) {
        if(isExternal(node))
            return node;

        if(k<node.valor)
            return treeSearch(node.filhoEsq, element);

        else if(k==node.valor)
            return node;

        else
            return treeSearch(node.filhoDir);
    }

    public void insert(Object element) {
    }

    public void remove(No node) {
    }

    public No find(Object element) {
        return treeSearch(this.raiz, element);
    }

    private void transplant(No alvo, No substituto) {
    }

    private No treeMaximum(No node) {
        No temp = node;
        while(temp !=null && temp.filhoDir != null)
            temp= temp.filhoDir;

        return temp;
    }

}
