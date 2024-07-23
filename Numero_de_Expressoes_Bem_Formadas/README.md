# Número de Expressões Bem Formadas

## Descrição
Considere o alfabeto $ \sum={(,),z} $ (O alfabeto $\sum$ tem três elementos: os parênteses e z).  
Definimos o conjunto $B\subset\sum*$ das *palavras bem formadas* ou *expressões bem formadas* sobre $\sum$ da seguinte forma recursiva:

1. $z\in B$ e
2. se $s\in B$ e $t\in B$, então $(st)\in B$

Mais formalmente, $B$ é definido como o menor subconjunto de $\sum*$ que satisfaz 1. e 2.
