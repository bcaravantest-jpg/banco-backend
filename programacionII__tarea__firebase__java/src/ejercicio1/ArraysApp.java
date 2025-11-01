package ejercicio1;

import java.util.Scanner;

public class ArraysApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		System.out.println("Ingrese 10 numeros enteros:");
		for (int i = 0; i < nums.length; i++) {
		System.out.print("Numero " + (i + 1) + ": ");
		while (!sc.hasNextInt()) {
		System.out.print("Valor invalido. Intente de nuevo: ");
		sc.next();
		}
		nums[i] = sc.nextInt();
		}


		int min = nums[0], max = nums[0];
		long suma = 0;
		for (int n : nums) {
		if (n < min) min = n;
		if (n > max) max = n;
		suma += n;
		}
		double promedio = suma / (double) nums.length;


		System.out.println("\nResultado:");
		System.out.println("Mayor: " + max);
		System.out.println("Menor: " + min);
		System.out.printf("Promedio: %.2f%n", promedio);
		sc.close();
		}
		}
