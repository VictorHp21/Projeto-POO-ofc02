// InputUtils.java
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T getValidInput(String prompt, Supplier<T> inputSupplier, Predicate<T> validation, String errorMessage) {
        T input;
        while (true) {
            System.out.print(prompt);
            try {
                input = inputSupplier.get();
                if (validation.test(input)) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Por favor, tente novamente.");
                scanner.nextLine();
            }
        }
    }
     // Método para verificar se uma string contém apenas números
     public static boolean isNumeric(String str) {
        return str.matches("\\d+"); // Verifica se contém apenas dígitos
    }
}
