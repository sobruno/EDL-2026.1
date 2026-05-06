package Sequencia;

import Sequencia.SequenciaDuplaLigada;

public class Teste_Sequencia {

    public static void main(String[] args) {

        System.out.println("=== Testando SequenciaDuplaLigada ===");
        testarSequencia(new SequenciaDuplaLigada());
    }

    public static void testarSequencia(Sequencia seq) {

        // 🔹 Inserções por rank
        seq.insertAtRank(0, "A");
        seq.insertAtRank(1, "B");
        seq.insertAtRank(2, "C");
        seq.insertAtRank(1, "X"); // A X B C

        System.out.println("Após inserções:");
        imprimir(seq);

        // 🔹 Acesso por rank
        System.out.println("\nElemento no rank 2: " + seq.elemAtRank(2));

        // 🔹 Replace por rank
        seq.replaceAtRank(1, "Z");

        System.out.println("\nApós replace:");
        imprimir(seq);

        // 🔹 Remove por rank
        Object removido = seq.removeAtRank(2);
        System.out.println("\nRemovido: " + removido);

        System.out.println("\nEstado final:");
        imprimir(seq);

        // 🔹 Teste posição (lista)
        Object p = seq.first();
        System.out.println("\nPrimeiro elemento (via posição): " + seq.element(p));

        // 🔹 Before / After
        Object prox = seq.after(p);
        System.out.println("Depois do primeiro: " + seq.element(prox));

        // 🔹 Insert usando posição
        seq.insertAfter(p, "Y");

        System.out.println("\nApós insertAfter:");
        imprimir(seq);

        // 🔹 RankOf
        System.out.println("\nRank do elemento inserido:");
        System.out.println(seq.rankOf(seq.after(p)));
    }

    private static void imprimir(Sequencia seq) {
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.elemAtRank(i) + " ");
        }
        System.out.println();
    }
}