package Hash;

public class ItemHash extends Item {
    private final Object chave;
    private final Object valor;

    public ItemHash(Object chave, Object valor) {
        if (chave == null) throw new IllegalArgumentException("Chave não pode ser nula.");
        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public Object key() {
        return chave;
    }

    @Override
    public Object value() {
        return valor;
    }

    @Override
    public String toString() {
        return "ItemHash{chave=" + chave + ", valor=" + valor + '}';
    }
}
 