/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Nathália Yukimi Uchiyama Tsuno
 * Numero USP: 14600541
 * Tarefa: E04
 * Data: 17 de Novembro de 2023
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

	public class FindGene{
	
		public static int cont = 0;
		public static boolean numerical;
	
		public static void FindGene(String dna){
			int tam = dna.length();
			int tmp = 0;
			int start = 0;
			boolean achei = false;
			while (start <= tam - 3 ){
				String codon = dna.substring(start, start+3);
				if ( codon.equals("ATG")){
					int end = start + 3;
					if( (start - tmp) % 3 == 0){
						end = Math.max(end, tmp);
					}
					while ((! achei) && end <= tam - 3){
						codon = dna.substring(end, end+3);
						if (codon.equals("TAG") || codon.equals("TAA") || codon.equals("TGA")){
							if( !numerical ){
								StdOut.println(dna.substring(start, end + 3));
							}
							cont++;
							achei = true;
						}
						else{
							end += 3;
							}
					}
					tmp = end;
					achei = false;
				}
				start += 1;
			}
			
		return;
		}
		
		public static void main(String[] args){
			String dna = StdIn.readString();
			numerical = args.length > 0;
			FindGene(dna);
			if( numerical ){
				StdOut.println(cont);
			}
		}
		
	}
