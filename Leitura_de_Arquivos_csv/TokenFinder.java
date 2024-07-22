public class TokenFinder{
	// Variáveis de instância
	private final String line;
	private int cont;
	private final int tam;
	
	// Método de construção
	public TokenFinder(String argumento){
		line = argumento;
		cont = 0;
		tam = argumento.length();
	}
	
	// Método: nextToken()
	public String nextToken(){
		// Variáveis locais
		StringBuilder token = new StringBuilder();
		boolean ehToken = false;
		boolean ehAspas = false;
		
		while(cont < tam){
			char c = line.charAt(cont);
			if(ehToken){
				if(ehAspas){
					if(c == '"' && line.charAt(cont + 1) == '"'){
						cont++;
						token.append(c);
					}
					else if(c != '"'){
						token.append(c);
					}
					else{
						ehAspas = false;
					}
				}
				else{
					if(c == '"'){
						ehAspas = true;
					}
					else if(c != ','){
						token.append(c);
					}
					else{
						cont++;
						ehToken = false;
						return token.toString();
					}
				}
			}
			else{ // Começo da linha ou após uma vírgula
				if(c != ',' && c == '"'){
					ehToken = true;
					ehAspas = true;
				}
				else if(c != ',' && c != '"'){
					ehToken = true;
					token.append(c);
				}
				else if(c == ','){ // Vírgula no começo
					if(cont == 0){
						cont++;
						return "";
					}
					else if(line.charAt(cont - 1) == ',' ){ // Duas Vírgulas
						cont++;
						return "";
					}
				}
			}
			cont++;
		}
		if(ehToken){
			return token.toString();
		}
		return null;
	}
}
