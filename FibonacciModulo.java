import java.util.Scanner;

public class FibonacciModulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto para que se lea la entrada
        System.out.print("INGRESA EL PRIMER DIGITO: ");
        long n = scanner.nextLong(); // Leer el valor de n
        System.out.print("INGRESA EL SEGUNDO DIGITO DIGITO: ");
        int m = scanner.nextInt();   // Leer el valor de m
        scanner.close(); // Cerrar el Scanner

        System.out.println("EL RESULTADO ES: " + fibonacciModulo(n, m)); // Imprimir el resultado
    }

    // Método para calcular Fibonacci(n) mod m
    public static long fibonacciModulo(long n, int m) {
        // Encontrar el período de Pisano
        int pisanoPeriod = getPisanoPeriod(m);

        // Calcular el índice reducido de Fibonacci utilizando el período de Pisano
        n = n % pisanoPeriod;

        // Calcular Fibonacci(n) mod m
        return calculateFibonacciMod(n, m);
    }

    // Método para encontrar el período de Pisano
    public static int getPisanoPeriod(int m) {
        long previous = 0;
        long current = 1;
        for (int i = 0; i < m * m; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;

            // El período Pisano siempre comienza con 01
            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }
        return m;
    }

    // Método para calcular Fibonacci(n) mod m
    public static long calculateFibonacciMod(long n, int m) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }

        return current;
    }
}