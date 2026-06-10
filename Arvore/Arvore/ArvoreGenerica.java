package Arvore;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ArvoreGenerica extends Arvore {

    private No raiz;
    private int tamanho;

    public ArvoreGenerica() {
        this.raiz = null;
        this.tamanho = 0;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public int height() {
        if(this.raiz == null)
            return -1;

        return height(this.raiz);
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public Iterator elements() {
        List<Object> elems = new ArrayList<Object>();

        if(this.raiz != null)
            collectElements(this.raiz, elems);

        return elems.iterator();
    }

    @Override
    public Iterator nos() {
        List<No> nodes = new ArrayList<No>();

        if(this.raiz != null)
            collectNos(this.raiz, nodes);

        return nodes.iterator();
    }

    @Override
    public No root() {
        return this.raiz;
    }

    @Override
    public No parent(No node) {
        if(node == null)
            return null;

        return node.pai;
    }

    @Override
    public Iterator children(No node) {
        if(node == null)
            return new ArrayList<No>().iterator();

        return node.filhos.iterator();
    }

    @Override
    public boolean isInternal(No node) {
        if(node == null)
            return false;

        return !node.filhos.isEmpty();
    }

    @Override
    public boolean isExternal(No node) {
        if(node == null)
            return false;

        return node.filhos.isEmpty();
    }

    @Override
    public boolean isRoot(No node) {
        return node == this.raiz;
    }

    @Override
    public int depth(No node) {
        if(node == null)
            return -1;

        if(this.raiz == null)
            return -1;

        int d = 0;
        No p = node;

        while(p != null && p != this.raiz) {
            p = p.pai;
            d++;
        }

        if(p == null)
            return -1;

        return d;
    }

    @Override
    public Object replace(No node, Object element) {
        if(node == null)
            return null;

        Object old = node.valor;
        node.valor = element;

        return old;
    }

    public No inserirRaiz(Object elemento) {
        if(this.raiz != null)
            return null;

        this.raiz = new No(elemento);
        this.tamanho++;

        return this.raiz;
    }

    public No inserirFilho(No pai, Object elemento) {
        if(pai == null)
            return null;

        No novo = new No(elemento);
        novo.pai = pai;

        pai.filhos.add(novo);

        this.tamanho++;

        return novo;
    }

    private int height(No node) {
        if(node == null)
            return -1;

        if(node.filhos.isEmpty())
            return 0;

        int max = 0;

        for(No f : node.filhos) {
            int h = height(f);

            if(h > max)
                max = h;
        }

        return 1 + max;
    }

    private void collectElements(No node, List<Object> list) {
        if(node == null)
            return;

        list.add(node.valor);

        for(No f : node.filhos)
            collectElements(f, list);
    }

    private void collectNos(No node, List<No> list) {
        if(node == null)
            return;

        list.add(node);

        for(No f : node.filhos)
            collectNos(f, list);
    }
}