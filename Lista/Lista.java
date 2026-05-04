package Lista;

abstract class Lista {
    abstract int size();
    abstract boolean isEmpty();
    abstract boolean isFirst();
    abstract boolean isLast();
    abstract Object first();
    abstract Object last();
    abstract Object before();
    abstract Object after();
    abstract void replaceElements();
    abstract void swapElements();
    abstract void insertAfter();
    abstract void insertBefore();
    abstract void insertFirst();
    abstract void insertLast();
    abstract Object remove();
}