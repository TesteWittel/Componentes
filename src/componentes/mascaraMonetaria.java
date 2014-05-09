
package componentes;

public class mascaraMonetaria {

	public static void main(String[] args) {
		
		String valor = "3625950";
		String result = criaMascara(valor);
		
		System.out.println("Resultado: "+result);
	}
	
	public static String criaMascara(String valor) {
		// Inicializando as variaveis
		String convertido;
		String real;
		String centavo;
		int tamValor = 0;

		// Verifica o tamanho da string passada pelo componente
		tamValor = valor.length();
		System.out.println("Tamanho da String" + tamValor);

		// Pegando os valores correspondente ao valores de reais
		real = valor.substring(0, tamValor - 2);
		System.out.println("Real :" + real);

		// Verifica se a variavel real está¡ vazia para sair como invalido
		if (real.length() < 1) {
			convertido = "invalido";
		}

		else {
			// Pega o valores de centavos das duas ultimas posicão
			centavo = valor.substring(tamValor - 2, tamValor);
			System.out.println("Centavo :" + centavo);

			// Concatena os valores com a virgula para passar a máscara
			convertido = real + "," + centavo;
			System.out.println("Mascara Montada :" + convertido);
		}
		// Retorno para o componente
		return convertido;
	}
}
