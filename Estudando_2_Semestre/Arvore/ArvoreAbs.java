package Arvore;
import java.util.Iterator;


public abstract class Arvore{
    public abstract int size();
    public abstract int height(No node);
    public abstract boolean isEmpty();
    public abstract Iterator elements();
    public abstract Iterator nos();
    public abstract No root();

    public abstract No parent(No node);
    public abstract Iterator children(No node);

    public abstract boolean isInternal(No node);
    public abstract boolean isExternal(No node);
    public abstract boolean isRoot(No node);
    public abstract int depth(No node);

    public abstract Object replace(No node, Object element);

    public abstract No leftChild(No node);
    public abstract No rightChild(No node);

    public abstract boolean hasLeft(No node);
    public abstract boolean hasRight(No node);

    protected abstract No treeSearch(No node, Object element);

    public abstract void insert(Object element);
    public abstract void remove(No node);
    public abstract No find(Object element);

    protected abstract void transplant(No alvo, No substituto);
    protected abstract No treeMaximum (No node);
}