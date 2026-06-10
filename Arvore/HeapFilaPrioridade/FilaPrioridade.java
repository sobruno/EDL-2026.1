package HeapFilaPrioridade;

public class FilaPrioridade {

    private No raiz;
    private int tamanho;

    public FilaPrioridade() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public int size() {
        return this.tamanho;
    }

    public void insert(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item não pode ser nulo.");

        No novo = new No(item);

        if (this.raiz == null) {
            this.raiz = novo;
        } else {
            int pos = this.tamanho + 1;
            No pai = findParentForPosition(pos);

            novo.pai = pai;
            if (isLeftChild(pos))
                pai.filhoEsq = novo;
            else
                pai.filhoDir = novo;

            upHeap(novo);
        }

        this.tamanho++;
    }

    public Item min() {
        return this.raiz == null ? null : this.raiz.valor;
    }

    public Item removeMin() {
        if (this.raiz == null)
            return null;

        Item minimo = this.raiz.valor;

        if (this.tamanho == 1) {
            this.raiz = null;
            this.tamanho = 0;
            return minimo;
        }

        No ultimo = findNode(this.tamanho);
        this.raiz.valor = ultimo.valor;

        if (ultimo.pai.filhoEsq == ultimo)
            ultimo.pai.filhoEsq = null;
        else
            ultimo.pai.filhoDir = null;

        this.tamanho--;
        downHeap(this.raiz);

        return minimo;
    }

    private void upHeap(No node) {
        while (node.pai != null && compare(node.valor, node.pai.valor) < 0) {
            swap(node, node.pai);
            node = node.pai;
        }
    }

    private void downHeap(No node) {
        while (true) {
            No menor = node;

            if (node.filhoEsq != null && compare(node.filhoEsq.valor, menor.valor) < 0)
                menor = node.filhoEsq;

            if (node.filhoDir != null && compare(node.filhoDir.valor, menor.valor) < 0)
                menor = node.filhoDir;

            if (menor == node)
                break;

            swap(node, menor);
            node = menor;
        }
    }

    private void swap(No a, No b) {
        Item temp = a.valor;
        a.valor = b.valor;
        b.valor = temp;
    }

    private No findNode(int position) {
        String path = Integer.toBinaryString(position).substring(1);
        No atual = this.raiz;

        for (char passo : path.toCharArray()) {
            if (passo == '0')
                atual = atual.filhoEsq;
            else
                atual = atual.filhoDir;
        }

        return atual;
    }

    private No findParentForPosition(int position) {
        String path = Integer.toBinaryString(position).substring(1);
        String parentPath = path.substring(0, path.length() - 1);
        No atual = this.raiz;

        for (char passo : parentPath.toCharArray()) {
            if (passo == '0')
                atual = atual.filhoEsq;
            else
                atual = atual.filhoDir;
        }

        return atual;
    }

    private boolean isLeftChild(int position) {
        String path = Integer.toBinaryString(position);
        return path.charAt(path.length() - 1) == '0';
    }

    private int compare(Item a, Item b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Itens nulos não são permitidos.");

        Object chaveA = a.key();
        Object chaveB = b.key();

        if (chaveA == null || chaveB == null)
            throw new IllegalArgumentException("Chaves nulas não são permitidas.");

        if (!(chaveA instanceof Comparable) || !(chaveB instanceof Comparable))
            throw new IllegalArgumentException("Chaves devem implementar Comparable.");

        return ((Comparable) chaveA).compareTo(chaveB);
    }
}
