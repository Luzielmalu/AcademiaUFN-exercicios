import java.io.IOException;
import java.util.Scanner;


public class Principal{
	public static void main(String[] args) throws IOException {
		
		try (Scanner leitura = new Scanner(System.in)) {
			Log meuLogger = new Log("Log.txt");
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();

			meuLogger.logger.info("Primeiro valor inserido: " + String.valueOf(a));

			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			meuLogger.logger.info("Segundo valor inserido: " + String.valueOf(b));
			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " = " + resultado);
			meuLogger.logger.info("Resultado: " + String.valueOf(a) + operador + " " + String.valueOf(b) + " = " + resultado);
		}
	
	}
}

	




