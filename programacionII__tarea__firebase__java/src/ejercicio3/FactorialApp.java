package ejercicio3;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialApp {
	public static BigInteger factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("El numero debe ser >= 0");
		if (n == 0 || n == 1) return BigInteger.ONE;
		return BigInteger.valueOf(n).multiply(factorial(n - 1));
		}


		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un número entero: ");
		while (!sc.hasNextInt()) { System.out.print("Invalido. Intente de nuevo: "); sc.next(); }
		int n = sc.nextInt();
		System.out.println(n + "! = " + factorial(n));
		sc.close();
		}
		}
