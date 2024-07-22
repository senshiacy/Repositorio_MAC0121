/*
 * $ java-introcs RandomInts 10 1000 121 | java-introcs DivideBrute .
 * 0: 34 27 167 169 922 (sum: 1319)
 * 1: 360 721 240 (sum: 1321)
 * 2: 880 458 (sum: 1338)
 * 1319 (sum: 3978 / ideal: 1326 / mod 3 = 0)
 * $ java-introcs RandomInts 15 100 121 | java-introcs DivideBrute .
 * 0: 34 27 67 22 21 18 (sum: 189)
 * 1: 69 60 40 19 (sum: 188)
 * 2: 80 58 24 12 14 (sum: 188)
 * 188 (sum: 565 / ideal: 188 / mod 3 = 1)
 * $ 
 */

public class Divide
{
    private static boolean verbose;
    private static int best = 0; // best value so far
    private static int best_max = 0;
    private static int[] b;  // best division so far
    private static boolean achei = false;
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static int soma = 0;
    
    public static void enumerate(int[] val, int[] a, int k) {
    
    if (achei){
    	return;
    }
    
	if (k == a.length) {
	    int t = Math.min(Math.min(A, B), C);
	    int m = Math.max(Math.max(A, B), C);
	    
		if (t > best) {
			best = t;
			best_max = m;
			copy(b, a);
	    }
	    
	    if (best >= Math.floor(soma/3)){
    	achei = true;
    	}
    	
	    return;
	} 
	A += val[k];
	if (A <= best_max + 1 ){
		a[k] = 0;
		enumerate(val, a, k + 1);
	}
	A -= val[k];
	B += val[k];
	if ( B <= best_max + 1 ){
		a[k] = 1;
		enumerate(val, a, k + 1);
	}
	B -= val[k];
	C += val[k];
	if (C <= best_max + 1 ){
		a[k] = 2;
		enumerate(val, a, k + 1);
	}
	C -= val[k];
    }

    public static int scheduleBrute(int[] val) {
	int[] a = new int[val.length];
	a[0] = 0;
	A += val[0];
	soma = sum(val);
	double max = Math.ceil(sum(val)/3);
	best_max = (int) max;
	best_max += 1;
	b = new int[val.length];
	enumerate(val, a, 1);
	return best;
    }

    public static int sum(int[] val) {
	int N = val.length, S = 0; 
	for (int i = 0; i < N; i++) S += val[i];
	return S;
    }

    public static void show(int[] a, int[] val) {
	for (int i = 0; i < 3; i++) 
	    show(a, val, i);
    }

    public static void show(int[] a, int[] val, int i) {    
	int N = a.length, s;
	StdOut.print( i + ": ");
	s = 0;
	for (int j = 0; j < N; j++) {
	    if (a[j] == i) {
		s += val[j];
		StdOut.print(val[j] + " ");
	    } 
	}
	StdOut.println("(sum: " + s + ")");
    }

    public static void copy(int[] a, int[] b) {
	for (int i = 0; i < a.length; i++) a[i] = b[i];
    }     
    
    public static void main(String[] args)
    {
	verbose = args.length > 0;
	int[] val = StdIn.readAllInts();
	int opt = scheduleBrute(val);
	int sum = sum(val);
	if (opt >= sum / 3)
	    StdOut.println("There is a solution");
	else 
	    StdOut.println("There is no solution");
	if (verbose) { 
	    StdOut.println("Optimal value: " + opt
			   + " (sum: " + sum + " / want: " + sum/3
			   + " / sum mod 3 = " + sum % 3 +")");
	    if (verbose) show(b, val);
	} 
    }
}
