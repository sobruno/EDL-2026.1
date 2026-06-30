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
        return this.raiz;
    }

    public Iterator children(No node) {
        return 1;
    }

    public boolean isInternal(No node) {
        return 1;
    }

    public boolean isExternal(No node) {
        return 1;
    }

    public boolean isRoot(No node) {
        return node == this.raiz;
    }

    public int depth(No node) {
        return 1;
    }

    public Object replace(No node, Object element) {
        return 1;
    }

    public No leftChild(No node) {
        return this.raiz;
    }

    public No rightChild(No node) {
        return this.raiz;
    }

    public boolean hasLeft(No node) {
        return 1;
    }

    public boolean hasRight(No node) {
        return 1;
    }

    protected No treeSearch(No node, Object element) {
        return this.raiz;
    }

    public void insert(Object element) {
    }

    public void remove(No node) {
    }

    public No find(Object element) {
        return this.raiz;
    }

    private int compare(Object a, Object b) {
        return 1;
    }

    private void transplant(No alvo, No substituto) {
    }

    private No treeMaximum(No node) {
        return this.raiz;
    }

}
