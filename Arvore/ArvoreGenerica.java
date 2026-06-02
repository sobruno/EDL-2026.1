package Arvore;
import java.util.Iterator;

public class ArvoreGenerica extends Arvore {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator elements() {
        return null;
    }

    @Override
    public Iterator nos() {
        return null;
    }

    @Override
    public No root() {
        return null;
    }

    @Override
    public No parent(No node) {
        return null;
    }

    @Override
    public Iterator children(No node) {
        return null;
    }

    @Override
    public boolean isInternal(No node) {
        return false;
    }

    @Override
    public boolean isExternal(No node) {
        return false;
    }

    @Override
    public boolean isRoot(No node) {
        return false;
    }

    @Override
    public int depth(No node) {
        return 0;
    }

    @Override
    public Object replace(No node, Object element) {
        return null;
    }
    
}
