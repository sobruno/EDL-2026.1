package Sequencia;

import Sequencia.Sequencia;
import Lista.ListaVaziaException;
import Lista.InvalidIndexException;

public class SequenciaDuplaLigada extends Sequencia {

    private No inicio;
    private No fim;
    private int size;

    public SequenciaDuplaLigada() {
        inicio = null;
        fim = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private No no(Object p) {
        if (!(p instanceof No)) {
            throw new InvalidIndexException("Posição inválida");
        }
        return (No) p;
    }

    private No getNo(int r) {
        if (r < 0 || r >= size) {
            throw new InvalidIndexException("Rank inválido");
        }

        No atual;

        if (r < size / 2) {
            atual = inicio;
            for (int i = 0; i < r; i++) {
                atual = atual.proximo;
            }
        } else {
            atual = fim;
            for (int i = size - 1; i > r; i--) {
                atual = atual.anterior;
            }
        }

        return atual;
    }

    @Override
    public Object first() {
        if (isEmpty()) throw new ListaVaziaException("Lista vazia");
        return inicio;
    }

    @Override
    public Object last() {
        if (isEmpty()) throw new ListaVaziaException("Lista vazia");
        return fim;
    }

    @Override
    public Object before(Object p) {
        No n = no(p);
        if (n.anterior == null) throw new InvalidIndexException("Sem anterior");
        return n.anterior;
    }

    @Override
    public Object after(Object p) {
        No n = no(p);
        if (n.proximo == null) throw new InvalidIndexException("Sem próximo");
        return n.proximo;
    }

    @Override
    public boolean isFirst(Object p) {
        return no(p) == inicio;
    }

    @Override
    public boolean isLast(Object p) {
        return no(p) == fim;
    }

    @Override
    public void replaceElement(Object p, Object o) {
        no(p).valor = o;
    }

    @Override
    public void swapElements(Object p, Object q) {
        No n1 = no(p);
        No n2 = no(q);

        Object temp = n1.valor;
        n1.valor = n2.valor;
        n2.valor = temp;
    }

    @Override
    public void insertFirst(Object o) {
        insertAtRank(0, o);
    }

    @Override
    public void insertLast(Object o) {
        insertAtRank(size, o);
    }

    @Override
    public void insertBefore(Object p, Object o) {
        int r = rankOf(p);
        insertAtRank(r, o);
    }

    @Override
    public void insertAfter(Object p, Object o) {
        int r = rankOf(p);
        insertAtRank(r + 1, o);
    }

    @Override
    public Object remove(Object p) {
        int r = rankOf(p);
        return removeAtRank(r);
    }

    @Override
    public Object atRank(int r) {
        return getNo(r);
    }

    @Override
    public Object elemAtRank(int r) {
        return getNo(r).valor;
    }

    @Override
    public void replaceAtRank(int r, Object o) {
        getNo(r).valor = o;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > size) {
            throw new InvalidIndexException("Rank inválido");
        }

        No novo = new No(o);

        if (size == 0) {
            inicio = fim = novo;
        }
        else if (r == 0) {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        else if (r == size) {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        else {
            No atual = getNo(r);

            novo.proximo = atual;
            novo.anterior = atual.anterior;

            atual.anterior.proximo = novo;
            atual.anterior = novo;
        }

        size++;
    }

    @Override
    public Object removeAtRank(int r) {
        No atual = getNo(r);
        Object valor = atual.valor;

        if (size == 1) {
            inicio = fim = null;
        }
        else if (atual == inicio) {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
        else if (atual == fim) {
            fim = fim.anterior;
            fim.proximo = null;
        }
        else {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        }

        size--;
        return valor;
    }

    @Override
    public int rankOf(Object p) {
        No atual = inicio;
        int r = 0;

        while (atual != null) {
            if (atual == p) return r;
            atual = atual.proximo;
            r++;
        }

        throw new InvalidIndexException("Posição não pertence à lista");
    }

    @Override
    public Object element(Object p) {
        return no(p).valor;
    }
}