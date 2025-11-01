package ejercicio4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciApp {
	private static final Map<Integer, Long> memo = new HashMap<>();


	public static long fib(int n) {
	if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
	if (n <= 1) return n;
	if (memo.containsKey(n)) return memo.get(n);
	long val = fib(n - 1) + fib(n - 2);
	memo.put(n, val);
	return val;
	}


	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("BIENVENIDOS ¿Cual es el termino que tendra n al mostrar? n = ");
	while (!sc.hasNextInt()) { System.out.print("Invalido. Intente de nuevo: "); sc.next(); }
	int n = sc.nextInt();
	if (n <= 0) {
	System.out.println("n debe ser > 0");
	} else {
	System.out.println("Primeros " + n + " terminos:");
	for (int i = 0; i < n; i++) {
	System.out.print(fib(i) + (i < n - 1 ? ", " : "\n"));
	}
	}
	sc.close();
	}
	}
