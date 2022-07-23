package model;

import java.text.Normalizer;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Palavra {

	public static void main(String[] args) {
		String str = sortearPalavra();
		

		System.out.println("Palavra original -> " + str);
		System.out.println("Palavra tratada -> " + trataPalavra(str));
		
		System.out.println(verificaLetra("+"));

		for (int i = 1; i <= 1; i++) {
			System.out.println("CHUTE A " + i + "ª PALAVRA");
			Scanner palavraDigitada = new Scanner(System.in);

			for (int j = 1; j <= 5; j++) {
				System.out.println("CHUTE A " + j + "ª LETRA");
				System.out.println("Digite a letra");
				String letra = palavraDigitada.next();
				if(verificaLetra(String.valueOf(letra))) {
					System.out.println(String.valueOf(letra));
					
				}
				
			}
		}
		
	}

	public static String sortearPalavra() {
		String palavras[] = { "SAGAZ", "ÂMAGO", "ÊXITO", "MEXER", "TERMO", "SENSO", "NOBRE", "ALGOZ", "AFETO", "PLENA",
				"ÉTICA", "MÚTUA", "TÊNUE", "SUTIL", "VIGOR", "AQUÉM", "FAZER", "PORÉM", "AUDAZ", "SANAR", "SEÇÃO",
				"ASSIM", "INATO", "CERNE", "FOSSE", "IDEIA", "PODER", "DESDE", "MORAL", "MUITO", "TORPE", "JUSTO",
				"HONRA", "FÚTIL", "ANEXO", "SOBRE", "QUIÇÁ", "RAZÃO", "ETNIA", "ÍCONE", "SONHO", "TANGE", "ÉGIDE",
				"LAPSO", "MÚTUO", "AMIGO", "EXPOR", "HAVER", "HÁBIL", "TEMPO", "SEARA", "DENGO", "PESAR", "ENTÃO",
				"ÁVIDO", "POSSE", "GENRO", "BOÇAL", "COSER", "ARDIL", "CAUSA", "CORJA", "DIZER", "PÁRIA", "PROLE",
				"DETÉM", "TENAZ", "DEVER", "GRAÇA", "ÓBICE", "SABER", "CRIVO", "DIGNO", "ÁPICE", "ÂNSIA", "ÂNIMO",
				"CEDER", "BRADO", "COMUM", "SENDO", "GLEBA", "TEMOR", "ASSAZ", "CULTO", "ATROZ", "MUNDO", "PAUTA",
				"CENSO", "FUGAZ", "AINDA", "COZER", "VALHA", "DENSO", "NENÉM", "VÍCIO", "FORTE", "ESTAR", "VULGO",
				"REVÉS", "PUDOR" };

		Random random = new Random();
		return palavras[random.nextInt(99)];
	}

	public static String trataPalavra(String str) {
//		Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public static boolean verificaLetra (String letra) {
		return letra.matches("[^\\d]+ ");
	}

}
