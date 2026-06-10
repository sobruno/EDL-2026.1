package ArvoreBinaria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreBinPesquisa extends ArvoreBin {

    private No raiz;
    private int tamanho;

    public ArvoreBinPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public int height(No node) {
        if (node == null)
            return -1;

        int esquerda = height(node.filhoEsq);
        int direita = height(node.filhoDir);

        return 1 + Math.max(esquerda, direita);
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public Iterator elements() {
        List<Object> elementos = new ArrayList<>();

        if (this.raiz != null)
            collectElements(this.raiz, elementos);

        return elementos.iterator();
    }

    @Override
    public Iterator nos() {
        List<No> nodes = new ArrayList<>();

        if (this.raiz != null)
            collectNos(this.raiz, nodes);

        return nodes.iterator();
    }

    @Override
    public No root() {
        return this.raiz;
    }

    @Override
    public No parent(No node) {
        if (node == null)
            return null;

        return node.pai;
    }

    @Override
    public Iterator children(No node) {
        List<No> filhos = new ArrayList<>();

        if (node == null)
            return filhos.iterator();

        if (node.filhoEsq != null)
            filhos.add(node.filhoEsq);
        if (node.filhoDir != null)
            filhos.add(node.filhoDir);

        return filhos.iterator();
    }

    @Override
    public boolean isInternal(No node) {
        if (node == null)
            return false;

        return hasLeft(node) || hasRight(node);
    }

    @Override
    public boolean isExternal(No node) {
        if (node == null)
            return false;

        return !isInternal(node);
    }

    @Override
    public boolean isRoot(No node) {
        return node == this.raiz;
    }

    @Override
    public int depth(No node) {
        if (node == null)
            return -1;

        int d = 0;
        No atual = node;

        while (atual != null && atual != this.raiz) {
            atual = atual.pai;
            d++;
        }

        if (atual == null)
            return -1;

        return d;
    }

    @Override
    public Object replace(No node, Object element) {
        if (node == null)
            return null;

        Object antigo = node.valor;
        node.valor = element;

        return antigo;
    }

    @Override
    public No leftChild(No node) {
        if (node == null)
            return null;

        return node.filhoEsq;
    }

    @Override
    public No rightChild(No node) {
        if (node == null)
            return null;

        return node.filhoDir;
    }

    @Override
    public boolean hasLeft(No node) {
        return node != null && node.filhoEsq != null;
    }

    @Override
    public boolean hasRight(No node) {
        return node != null && node.filhoDir != null;
    }

    @Override
    public No treeSearch(No node, Object element) {
        if (node == null || element == null)
            return null;

        int comparacao = compare(element, node.valor);

        if (comparacao == 0)
            return node;
        else if (comparacao < 0)
            return treeSearch(node.filhoEsq, element);
        else
            return treeSearch(node.filhoDir, element);
    }

    @Override
    public void insert(Object element) {
        if (element == null)
            return;

        No pai = null;
        No atual = this.raiz;

        while (atual != null) {
            pai = atual;
            int comparacao = compare(element, atual.valor);

            if (comparacao < 0)
                atual = atual.filhoEsq;
            else if (comparacao > 0)
                atual = atual.filhoDir;
            else
                return;
        }

        No novo = new No(element);
        novo.pai = pai;

        if (pai == null)
            this.raiz = novo;
        else if (compare(element, pai.valor) < 0)
            pai.filhoEsq = novo;
        else
            pai.filhoDir = novo;

        this.tamanho++;
    }

    @Override
    public void remove(No node) {
        if (node == null)
            return;

        if (node.filhoEsq == null)
            transplant(node, node.filhoDir);
        else if (node.filhoDir == null)
            transplant(node, node.filhoEsq);
        else {
            No predecessor = treeMaximum(node.filhoEsq);

            if (predecessor.pai != node) {
                transplant(predecessor, predecessor.filhoEsq);
                predecessor.filhoEsq = node.filhoEsq;
                if (predecessor.filhoEsq != null)
                    predecessor.filhoEsq.pai = predecessor;
            }

            transplant(node, predecessor);
            predecessor.filhoDir = node.filhoDir;
            if (predecessor.filhoDir != null)
                predecessor.filhoDir.pai = predecessor;
        }

        this.tamanho--;
    }

    @Override
    public No find(Object element) {
        if (element == null)
            return null;

        return treeSearch(this.raiz, element);
    }

    public String paraMatriz() {
        int h = height(this.raiz);
        if (this.raiz == null || h < 0)
            return "";

        int rows = h + 1;
        int cols = (1 << (h + 1)) - 1;
        String[][] matriz = new String[rows][cols];

        preencheMatriz(matriz, this.raiz, 0, 0, cols - 1);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String value = matriz[r][c];
                if (value == null)
                    sb.append("   ");
                else
                    sb.append(String.format("%3s", value));
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public void imprimirMatriz() {
        System.out.print(paraMatriz());
    }

    private void preencheMatriz(String[][] matriz, No node, int row, int left, int right) {
        if (node == null || row >= matriz.length || left > right)
            return;

        int mid = (left + right) / 2;
        matriz[row][mid] = node.valor.toString();

        preencheMatriz(matriz, node.filhoEsq, row + 1, left, mid - 1);
        preencheMatriz(matriz, node.filhoDir, row + 1, mid + 1, right);
    }

    private void collectElements(No node, List<Object> lista) {
        if (node == null)
            return;

        collectElements(node.filhoEsq, lista);
        lista.add(node.valor);
        collectElements(node.filhoDir, lista);
    }

    private void collectNos(No node, List<No> lista) {
        if (node == null)
            return;

        collectNos(node.filhoEsq, lista);
        lista.add(node);
        collectNos(node.filhoDir, lista);
    }

    private int compare(Object a, Object b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Elementos nulos não são permitidos.");

        if (a instanceof Comparable<?> && b instanceof Comparable<?>) {
            return ((Comparable)a).compareTo(b);
        }

        throw new IllegalArgumentException("Os valores devem implementar Comparable.");
    }

    private void transplant(No alvo, No substituto) {
        if (alvo.pai == null)
            this.raiz = substituto;
        else if (alvo == alvo.pai.filhoEsq)
            alvo.pai.filhoEsq = substituto;
        else
            alvo.pai.filhoDir = substituto;

        if (substituto != null)
            substituto.pai = alvo.pai;
    }

    private No treeMinimum(No node) {
        No atual = node;

        while (atual != null && atual.filhoEsq != null)
            atual = atual.filhoEsq;

        return atual;
    }

    private No treeMaximum(No node) {
        No atual = node;

        while (atual != null && atual.filhoDir != null)
            atual = atual.filhoDir;

        return atual;
    }
}

