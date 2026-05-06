package Lista;

public abstract class Lista {
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract boolean isFirst(Object p);
    public abstract boolean isLast(Object p);
    public abstract Object first();
    public abstract Object last();
    public abstract Object before(Object p);
    public abstract Object after(Object p);
    public abstract void replaceElement(Object p, Object o);
    public abstract void swapElements(Object p, Object q);
    public abstract void insertAfter(Object p, Object o);
    public abstract void insertBefore(Object p, Object o);
    public abstract void insertFirst(Object o);
    public abstract void insertLast(Object o);
    public abstract Object remove(Object p);

    public abstract Object element(Object p);
}