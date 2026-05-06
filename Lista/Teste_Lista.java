package Lista;

import Lista.ListaArray.ListaArray;
import Lista.ListaDuplaLigada.ListaDuplaLigada;

public class Teste_Lista {

    public static void main(String[] args) {

        System.out.println("=== Testando ListaArray ===");
        testarLista(new ListaArray(10));

        System.out.println("\n=== Testando ListaDuplaLigada ===");
        testarLista(new ListaDuplaLigada());
    }

    public static void testarLista(Lista lista) {

        lista.insertFirst("A");
        lista.insertLast("B");
        lista.insertLast("C");

        Object p = lista.first();
        lista.insertAfter(p, "X"); // A X B C

        System.out.println("Após inserções:");
        imprimir(lista);

        Object pos = lista.after(lista.first());
        lista.replaceElement(pos, "Z");

        System.out.println("\nApós replace:");
        imprimir(lista);

        lista.swapElements(lista.first(), lista.last());

        System.out.println("\nApós swap:");
        imprimir(lista);

        Object removido = lista.remove(lista.first());
        System.out.println("\nRemovido: " + removido);

        System.out.println("\nEstado final:");
        imprimir(lista);
    }

    private static void imprimir(Lista lista) {
        Object p = lista.first();

        while (true) {
            System.out.print(lista.element(p) + " ");
            if (lista.isLast(p)) break;
            p = lista.after(p);
        }
        System.out.println();
    }
}
