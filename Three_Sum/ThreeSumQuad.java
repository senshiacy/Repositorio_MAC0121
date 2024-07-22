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
