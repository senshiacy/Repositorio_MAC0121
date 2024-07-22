public class E02{

	public static long[] memo = new long[35];
	
	public static long n_ebfR(int N){
		if(N == 0 || N == 1){
			return 1;
		}
		
		else{
			long cont = 0;
			
			for(int i = 0; i < N ; i++){
				cont = cont + n_ebfR(i) * n_ebfR(N - i - 1);
			}

			return cont;
		}
	}
	public static long n_ebfM(int N){
		if(N == 0 || N == 1){
			memo[N] = 1;
			return 1;
		}
		
		else{
			if(memo[N] != 0){
				long num = memo[N];
				return num;
			}
			
			long cont = 0;
	
			for(int i = 0; i < N ; i++){
				cont = cont + n_ebfM(i) * n_ebfM(N - i - 1);
			}
			
			memo[N] = cont;
			
			return cont;
		}
	}
	
	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		StdOut.println(n_ebfM(num));
		StdOut.println(n_ebfR(num));
	}
}
