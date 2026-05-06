package Vetor;

import Vetor.VetorArray.VetorArray;
import Vetor.VetorDuplaLigado.VetorDuplaLigado;

public class Teste_Vetor {

    public static void main(String[] args) {

        System.out.println("=== Testando VetorArray ===");
        testarVetor(new VetorArray(5));

        System.out.println("\n=== Testando VetorDuplaLigado ===");
        testarVetor(new VetorDuplaLigado());
    }

    public static void testarVetor(Vetor v) {

        // inserções
        v.insertAtRank(0, "A");
        v.insertAtRank(1, "B");
        v.insertAtRank(2, "C");

        // mostrar elementos
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Pos " + i + ": " + v.elementAtRank(i));
        }

        // replace
        v.replaceAtRank(1, "X");

        System.out.println("\nApós replace:");
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Pos " + i + ": " + v.elementAtRank(i));
        }

        // remove
        Object removido = v.removeAtRank(1);
        System.out.println("\nRemovido: " + removido);

        System.out.println("\nEstado final:");
        for (int i = 0; i < v.size(); i++) {
            System.out.println("Pos " + i + ": " + v.elementAtRank(i));
        }
    }
}