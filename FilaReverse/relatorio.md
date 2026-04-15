# Relatório – Fila com Reversão em O(1)

## Introdução
Nesta prática foi implementada uma estrutura de dados do tipo fila utilizando array circular.  
Além das operações básicas, foi adicionada a funcionalidade de reversão em tempo constante O(1), sem mover os elementos.

## Objetivo
- Implementar uma fila com array circular  
- Garantir enqueue e dequeue em O(1)  
- Implementar reverse() em O(1)  
- Adicionar aumento e redução dinâmica do array  

## Metodologia
A fila foi construída utilizando:
- Um vetor (array)
- Dois índices: `inicio` e `fim`
- Uma variável `tamanho`
- Uma variável booleana `reverse`

O array circular foi implementado com o uso do operador `%`, permitindo reaproveitar posições.

A reversão foi feita apenas invertendo a variável `reverse`, sem alterar os dados.

## Funcionamento

### Enqueue
- Normal: insere no fim  
- Reverso: insere no início  

### Dequeue
- Normal: remove do início  
- Reverso: remove do fim  

### Reverse
- Apenas alterna o valor da variável booleana  
- Não move elementos (O(1))  

### Redimensionamento
- Aumenta quando a fila enche  
- Diminui quando chega a 1/3 da capacidade  
- Reorganiza os elementos ao redimensionar  

## Resultados
- Operações eficientes em O(1)  
- Reversão instantânea  
- Uso eficiente de memória  
- Funcionamento correto após múltiplas reversões  

## Conclusão
A prática mostrou que é possível alterar o comportamento da fila sem modificar os dados, apenas ajustando a lógica.  
Também reforçou o uso de array circular e otimização com redimensionamento dinâmico.
