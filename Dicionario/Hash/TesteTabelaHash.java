package Hash;

public class TesteTabelaHash {

    public static void main(String[] args) {
        testeBasico();
        System.out.println();
        testarLinearProbing();
        System.out.println();
        testarHashDuplo();
        System.out.println();
        testarRehashAutomatico(TabelaHash.TipoColisao.LINEAR_PROBING);
        System.out.println();
        testarRehashAutomatico(TabelaHash.TipoColisao.HASH_DUPLO);
        System.out.println();
        testarRemocaoComAvailable();
    }

    private static void testeBasico() {
        System.out.println("===== TESTE BÁSICO =====");
        TabelaHash tabela = new TabelaHash(TabelaHash.TipoColisao.LINEAR_PROBING);

        tabela.insertItem(10, "A");
        tabela.insertItem(5, "B");
        tabela.insertItem(15, "C");
        tabela.insertItem(2, "D");
        tabela.insertItem(8, "E");

        System.out.println("findElement(15): " + tabela.findElement(15));
        System.out.println("removeElement(5): " + tabela.removeElement(5));
        System.out.println("findElement(5) após remover: " + tabela.findElement(5));
        System.out.println("Tamanho da tabela: " + tabela.size());
    }

    private static void testarLinearProbing() {
        System.out.println("===== TESTE: LINEAR PROBING =====");
        TabelaHash tabela = new TabelaHash(13, TabelaHash.TipoColisao.LINEAR_PROBING);

        int[] chaves = {18, 41, 22, 44, 59, 32, 31, 73};
        for (int chave : chaves) {
            tabela.insertItem(chave, "valor" + chave);
        }

        tabela.imprimir();

        System.out.println("findElement(44) = " + tabela.findElement(44));
        System.out.println("findElement(100) = " + tabela.findElement(100));
        System.out.println("size() = " + tabela.size());
        System.out.println("alfa = " + tabela.calcularFatorDeCarga());

        assertEquals("valor44", tabela.findElement(44), "Busca de chave existente (44)");
        assertEquals(null, tabela.findElement(100), "Busca de chave inexistente (100)");
        assertEquals(8, tabela.size(), "Tamanho após 8 inserções");
    }

    private static void testarHashDuplo() {
        System.out.println("===== TESTE: HASHING DUPLO =====");
        TabelaHash tabela = new TabelaHash(13, TabelaHash.TipoColisao.HASH_DUPLO);

        int[] chaves = {18, 41, 22, 44, 59, 32, 31, 73};
        for (int chave : chaves) {
            tabela.insertItem(chave, "valor" + chave);
        }

        tabela.imprimir();

        System.out.println("findElement(31) = " + tabela.findElement(31));
        System.out.println("findElement(999) = " + tabela.findElement(999));
        System.out.println("size() = " + tabela.size());
        System.out.println("alfa = " + tabela.calcularFatorDeCarga());

        assertEquals("valor31", tabela.findElement(31), "Busca de chave existente (31)");
        assertEquals(null, tabela.findElement(999), "Busca de chave inexistente (999)");
        assertEquals(8, tabela.size(), "Tamanho após 8 inserções");
    }

    private static void testarRehashAutomatico(TabelaHash.TipoColisao tipo) {
        System.out.println("===== TESTE: REHASH AUTOMÁTICO (" + tipo + ") =====");
        TabelaHash tabela = new TabelaHash(7, tipo);
        int capacidadeInicial = tabela.capacidade();
        System.out.println("Capacidade inicial: " + capacidadeInicial);

        for (int i = 0; i < 10; i++) {
            tabela.insertItem(i, "item" + i);
            System.out.println("Após inserir " + i + ": N=" + tabela.capacidade() +
                    " n=" + tabela.size() +
                    " alfa=" + String.format("%.3f", tabela.calcularFatorDeCarga()));
        }

        System.out.println("Capacidade final: " + tabela.capacidade());
        assertTrue(tabela.capacidade() > capacidadeInicial,
                "Capacidade deve ter aumentado após rehash automático");

        boolean todosEncontrados = true;
        for (int i = 0; i < 10; i++) {
            if (!("item" + i).equals(tabela.findElement(i))) {
                todosEncontrados = false;
            }
        }
        assertTrue(todosEncontrados, "Todos os itens devem ser recuperáveis após rehash");
        assertEquals(10, tabela.size(), "size() deve permanecer 10 após rehash");
    }

    private static void testarRemocaoComAvailable() {
        System.out.println("===== TESTE: REMOÇÃO E MARCADOR AVAILABLE =====");
        TabelaHash tabela = new TabelaHash(13, TabelaHash.TipoColisao.LINEAR_PROBING);

        tabela.insertItem(18, "dezoito");
        tabela.insertItem(31, "trintaeum");

        System.out.println("Antes da remoção:");
        tabela.imprimir();

        Object removido = tabela.removeElement(18);
        System.out.println("removeElement(18) retornou: " + removido);
        assertEquals("dezoito", removido, "Elemento removido deve ser 'dezoito'");

        Object buscaApósRemocao = tabela.findElement(31);
        System.out.println("findElement(31) após remover 18: " + buscaApósRemocao);
        assertEquals("trintaeum", buscaApósRemocao,
                "Busca por 31 deve funcionar mesmo após remoção de 18 (AVAILABLE)");

        System.out.println("findElement(18) após remoção: " + tabela.findElement(18));
        assertEquals(null, tabela.findElement(18), "18 não deve mais ser encontrado");

        System.out.println("removeElement(999) [inexistente] = " + tabela.removeElement(999));
        assertEquals(null, tabela.removeElement(999), "Remoção de chave inexistente retorna null");

        System.out.println("size() final = " + tabela.size());
        assertEquals(1, tabela.size(), "Apenas 'trintaeum' deve restar na tabela");

        tabela.imprimir();
    }

    private static void assertEquals(Object esperado, Object obtido, String descricao) {
        boolean ok = (esperado == null) ? (obtido == null) : esperado.equals(obtido);
        System.out.println((ok ? "[OK]   " : "[FALHOU] ") + descricao +
                " | esperado=" + esperado + " obtido=" + obtido);
    }

    private static void assertTrue(boolean condicao, String descricao) {
        System.out.println((condicao ? "[OK]   " : "[FALHOU] ") + descricao);
    }
}