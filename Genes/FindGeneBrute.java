/* 
 * $ java-introcs FindGeneBrute < DATA/genomeTiny.txt
 * ATGCATAGCGCATAG
 * ATGTGCTAG
 * $ 
 */

public class FindGeneBrute
{
    private static boolean numerical;
    
    public static void main(String[] args)
    {
	numerical = args.length > 0;	
	String genome = StdIn.readString();
	int N = genome.length();
	int g = 0;

	for (int i = 0; i < N; i++)
	    for (int j = i + 6; j <= N; j++) {
		String x = genome.substring(i, j);
		if (PotentialGene.isPotentialGene(x)) {
		    if (!numerical)
			StdOut.println(x);
		    g++;
		}
	    }
	if (numerical)
	    StdOut.println(g);
    }
}
