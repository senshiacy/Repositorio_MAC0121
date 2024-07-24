# Número de Expressões Bem Formadas

## Descrição
Considere o alfabeto $\sum={(,),z}$ (O alfabeto $\sum$ tem três elementos: os parênteses e z).  
Definimos o conjunto $B\subset\sum*$ das *palavras bem formadas* ou *expressões bem formadas* sobre $\sum$ da seguinte forma recursiva:

1. $z\in B$ e
2. se $s\in B$ e $t\in B$, então $(st)\in B$

Mais formalmente, $B$ é definido como o menor subconjunto de $\sum*$ que satisfaz 1. e 2.

Seja $b(N)$ o número de palavras bem formadas sobre $\sum$ com $N$ pares de parênteses.  
Assim, $b(0)=1$, $b(1)=1$, $b(2)=2$ e $b(3)=5$.
Por exemplo, $b(2)=2$ devido às expressões bem formadas $(z(zz))$ e $((zz)z)$ e o fato que não há outras expressões bem formadas com dois pares de parênteses (isto é algo que podemos verificar por inspeção).
