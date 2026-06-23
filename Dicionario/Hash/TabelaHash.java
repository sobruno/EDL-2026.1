package Hash;

import java.util.ArrayList;
import java.util.List;

public class TabelaHash {

    public enum TipoColisao {
        LINEAR_PROBING,
        HASH_DUPLO
    }

    private static final Item AVAILABLE = new ItemHash(new Object(), null);

    private Item[] tabela;
    private int tamanho;
    private final TipoColisao tipoColisao;
    private static final double LIMITE_FATOR_DE_CARGA = 0.5;

    private long totalColisoes;

    public TabelaHash(int capacidadeInicial, TipoColisao tipoColisao) {
        if (capacidadeInicial < 7) capacidadeInicial = 7;
        this.tipoColisao = tipoColisao;
        int tamanhoTabela = proximoPrimo(capacidadeInicial);
        tabela = new Item[tamanhoTabela];
        tamanho = 0;
        totalColisoes = 0;
    }

    public TabelaHash(TipoColisao tipoColisao) {
        this(11, tipoColisao);
    }

    private int hash1(Object chave) {
        int mod = chave.hashCode() % tabela.length;
        return mod < 0 ? mod + tabela.length : mod;
    }

    private int hash2(Object chave) {
        int q = proximoPrimoMenorQue(tabela.length);
        int kModQ = chave.hashCode() % q;
        if (kModQ < 0) kModQ += q;
        return q - kModQ;
    }

    private int probe(Object chave, int i) {
        int base = hash1(chave);
        if (tipoColisao == TipoColisao.LINEAR_PROBING) return (base + i) % tabela.length;
        int passo = hash2(chave);
        return (base + i * passo) % tabela.length;
    }

    public void insertItem(Object chave, Object valor) {
        if (chave == null) throw new IllegalArgumentException("Chave não pode ser nula.");
        inserirItem(new ItemHash(chave, valor));
    }

    private void inserirItem(Item novoItem) {
        Object chave = novoItem.key();
        int indiceDisponivel = -1;

        for (int i = 0; i < tabela.length; i++) {
            int idx = probe(chave, i);
            Item atual = tabela[idx];

            if (atual == null) {
                if (indiceDisponivel == -1) indiceDisponivel = idx;
                break;
            }
            if (atual == AVAILABLE) {
                if (indiceDisponivel == -1) indiceDisponivel = idx;
                continue;
            }
            if (atual.key().equals(chave)) {
                tabela[idx] = novoItem;
                return;
            }
            totalColisoes++;
        }

        if (indiceDisponivel == -1) throw new IllegalStateException("Tabela hash cheia: não foi possível inserir.");
        tabela[indiceDisponivel] = novoItem;
        tamanho++;
        if (calcularFatorDeCarga() > LIMITE_FATOR_DE_CARGA) rehash();
    }

    public Object findElement(Object chave) {
        for (int i = 0; i < tabela.length; i++) {
            int idx = probe(chave, i);
            Item atual = tabela[idx];
            if (atual == null) return null;
            if (atual != AVAILABLE && atual.key().equals(chave)) return atual.value();
        }
        return null;
    }

    public Object removeElement(Object chave) {
        for (int i = 0; i < tabela.length; i++) {
            int idx = probe(chave, i);
            Item atual = tabela[idx];
            if (atual == null) return null;
            if (atual != AVAILABLE && atual.key().equals(chave)) {
                Object valorRemovido = atual.value();
                tabela[idx] = AVAILABLE;
                tamanho--;
                return valorRemovido;
            }
        }
        return null;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public List<Object> keys() {
        List<Object> resultado = new ArrayList<>();
        for (Item item : tabela) {
            if (item != null && item != AVAILABLE) resultado.add(item.key());
        }
        return resultado;
    }

    public List<Object> elements() {
        List<Object> resultado = new ArrayList<>();
        for (Item item : tabela) {
            if (item != null && item != AVAILABLE) resultado.add(item.value());
        }
        return resultado;
    }

    public double calcularFatorDeCarga() {
        return (double) tamanho / tabela.length;
    }

    private void rehash() {
        Item[] tabelaAntiga = tabela;
        int novoTamanho = proximoPrimo(tabelaAntiga.length * 2);

        tabela = new Item[novoTamanho];
        tamanho = 0;

        for (Item item : tabelaAntiga) {
            if (item != null && item != AVAILABLE) {
                inserirItem(item);
            }
        }
    }

    public void forcarRehash() {
        rehash();
    }

    public int capacidade() {
        return tabela.length;
    }

    public long getTotalColisoes() {
        return totalColisoes;
    }

    private static boolean ehPrimo(int numero) {
        if (numero < 2) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; (long) i * i <= numero; i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    private static int proximoPrimo(int valorInicial) {
        int candidato = Math.max(valorInicial, 2);
        if (candidato % 2 == 0) candidato++;
        while (!ehPrimo(candidato)) {
            candidato += 2;
        }
        return candidato;
    }

    private static int proximoPrimoMenorQue(int N) {
        int candidato = N - 1;
        while (candidato >= 2 && !ehPrimo(candidato)) {
            candidato--;
        }
        return Math.max(candidato, 2);
    }

    public void imprimir() {
        System.out.println("Tabela (N=" + tabela.length + ", n=" + tamanho +
                ", alfa=" + String.format("%.3f", calcularFatorDeCarga()) +
                ", tipo=" + tipoColisao + ")");
        for (int i = 0; i < tabela.length; i++) {
            Item item = tabela[i];
            String conteudo;
            if (item == null) {
                conteudo = "-- vazio --";
            } else if (item == AVAILABLE) {
                conteudo = "[AVAILABLE]";
            } else {
                conteudo = item.key() + " -> " + item.value();
            }
            System.out.println("  [" + i + "] " + conteudo);
        }
    }
}