package HeapFilaPrioridade;

public class TesteFilaPrioridade {
    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade();

        fila.insert(new ItemPrioridade(10, "A"));
        fila.insert(new ItemPrioridade(5, "B"));
        fila.insert(new ItemPrioridade(15, "C"));
        fila.insert(new ItemPrioridade(2, "D"));
        fila.insert(new ItemPrioridade(8, "E"));

        System.out.println("Minimo atual: " + fila.min());
        System.out.println("Removendo min: " + fila.removeMin());
        System.out.println("Novo minimo: " + fila.min());
        System.out.println("Tamanho da fila: " + fila.size());
    }
}
