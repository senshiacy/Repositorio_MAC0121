/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Nathália Yukimi Uchiyama Tsuno
 * Numero USP: 14600541
 * Tarefa: E07
 * Data: 24 de Dezembro de 2023
 * 
 * Baseado em ... (breve e se aplicável)
 *
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/
import java.util.Arrays; // Para ordenar o array
public class ThreeSumQuad{
	public static void printAll(int[] a){
		int n = a.length;
		int count = 0;
		Arrays.sort(a);
		
		for(int i = 0; i < n - 2; i++){
			int lo = i + 1;
			int hi = n - 1;
			while(lo < hi){
				if(a[lo] + a[hi] < -a[i]){
					lo++;
				}
				else if(a[lo] + a[hi] > -a[i]){
					hi--;
				}
				else{
					int countLo = 1;
					int countHi = 1;
					int refHi = a[hi];
					int refLo = a[lo];
					lo++;
					hi--;
					boolean achei = true;
					if(a[hi + 1] == a[lo - 1]){
						while(lo < n && achei){
							if(refLo == a[lo]){
								countLo++;
								lo++;
							}
							else{
								achei = false;
							}
						}
					count = countLo * (countLo - 1)/ 2;
					for(int j = 0; j < count; j++){
						StdOut.println(a[i] + " " + refLo + " " + refHi);
					}
					}
					else{
						while(achei){
							if(refHi == a[hi]){
								countHi++;
								hi--;
							}
							else{
								achei = false;
							}
						}
						achei = true;
						while(achei){
							if(refLo == a[lo]){
								countLo++;
								lo++;
							}
							else{
								achei = false;
							}
						}
					count = countLo * countHi;
					for(int j = 0; j < count; j++){
						StdOut.println(a[i] + " " + refLo + " " + refHi);
					}
					}
				}
			}
		}
	}
	public static int count(int[] a){
		int n = a.length;
		int count = 0;
		Arrays.sort(a);
		
		for(int i = 0; i < n - 2; i++){
			int lo = i + 1;
			int hi = n - 1;
			while(lo < hi){
				if(a[lo] + a[hi] < -a[i]){
					lo++;
				}
				else if(a[lo] + a[hi] > -a[i]){
					hi--;
				}
				else{
					int countLo = 1;
					int countHi = 1;
					int refHi = a[hi];
					int refLo = a[lo];
					lo++;
					hi--;
					boolean achei = true;
					if(a[hi + 1] == a[lo - 1]){
						while(lo < n && achei){
							if(refLo == a[lo]){
								countLo++;
								lo++;
							}
							else{
								achei = false;
							}
						}
					count = count + countLo * (countLo - 1)/ 2;
					}
					else{
						while(achei){
							if(refHi == a[hi]){
								countHi++;
								hi--;
							}
							else{
								achei = false;
							}
						}
						achei = true;
						while(achei){
							if(refLo == a[lo]){
								countLo++;
								lo++;
							}
							else{
								achei = false;
							}
						}
					count = count + countLo * countHi;
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args){
		int[] a = StdIn.readAllInts();
	int count = count(a);
		StdOut.println(count);
		if(count < 30){
			printAll(a);
		}
	}
}
