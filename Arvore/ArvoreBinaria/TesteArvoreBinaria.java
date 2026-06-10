package ArvoreBinaria;

public class TesteArvoreBinaria {
    public static void main(String[] args) {
        ArvoreBinPesquisa arvore = new ArvoreBinPesquisa();

        arvore.insert(10);
        arvore.insert(5);
        arvore.insert(15);
        arvore.insert(2);
        arvore.insert(8);
        arvore.insert(22);
        arvore.insert(12);
        arvore.insert(18);
        arvore.insert(30);
        arvore.insert(95);

        System.out.println("Árvore após inserções:");
        arvore.imprimirMatriz();

        System.out.println("Continuando a inserir 25:");
        arvore.insert(25);
        arvore.imprimirMatriz();

        System.out.println("Remover 5:");
        No no5 = arvore.find(5);
        if (no5 != null)
            arvore.remove(no5);
        arvore.imprimirMatriz();
    }
}
