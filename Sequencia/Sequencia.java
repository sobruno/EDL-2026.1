package Sequencia;

 abstract class Sequencia {
  abstract int size();
  abstract boolean isEmpty();

  abstract Object elementAtRank();
  abstract void replaceAtRank();
  abstract void insertAtRank();
  abstract Object removeAtRank();

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

  abstract void atRank();
  abstract void rankOf();
}
