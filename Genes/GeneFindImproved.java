/******************************************************************************
 *  Compilation:  javac GeneFindImproved.java
 *  Execution:    java GeneFindImproved start stop < input.txt
 *
 *  To find a gene in a genome, we scan for the start codon,
 *  remember its index, then scan for the next stop codon.
 *  If the length of the intervening sequence is a multiple of 3,
 *  we have found a gene.
 * 
 * $ java-introcs GeneFindImproved < DATA/genomeTiny.txt
 * ATGCATAGCGCATAG
 * ATGTGCTAG
 * $ java-introcs GeneFindImproved < DATA/genomeVirus.txt
 * ATGTGTCCCCCTCACACTCCCAAATTCGCGGGCTTCTGCCTCTTAGACCACTCTACCCTATTCCCCACACTCACCGGAGCCAAAGCCGCGGCCCTTCCGTTTCTTTGCTTTTGA
 * ATGGAAAAATACATAACTGAGAATAGGAAAGTTCAGATCAAGGTCAGGAACAAAGAAACAGCTGAATACCAAACAGGATATCTGTGGTAA
 * [...]
 * ATGTATTTAGAAAAATAA
 * $ 
 ******************************************************************************/

public class GeneFindImproved {

    public static boolean isStop(String c) {
	return c.equals("TAA") || c.equals("TAG") || c.equals("TGA");
    }

    public static void main(String[] args)  {

        // read in data
	String start = "ATG";
        String genome = StdIn.readAll();

        // find genes
        int beg = -1;
        for (int i = 0; i < genome.length() - 2; i++) {
            String codon = genome.substring(i, i + 3);

            // start codon
            if (codon.equals(start)) beg = i;

            // stop codon
            if (isStop(codon) && beg != -1 && beg + 3 <= i) {
                // check putative gene alignment
		String gene = genome.substring(beg, i + 3);		
                if (gene.length() % 3 == 0) {
                    StdOut.println(gene);
                    beg = -1;
                }
            }
        }
    }
}
