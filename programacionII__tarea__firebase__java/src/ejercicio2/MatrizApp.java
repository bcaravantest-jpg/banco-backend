package ejercicio2;

import java.util.Random;

public class MatrizApp {

	public static void main(String[] args) {
		int[][] m = new int[3][3];
		Random r = new Random();


		// Llenar con 1..9
		for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		m[i][j] = r.nextInt(9) + 1; // 1 a 9
		}
		}


		// Imprimir matriz
		System.out.println("Matriz 3x3:");
		for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		System.out.printf("%3d ", m[i][j]);
		}
		System.out.println();
		}


		// Sumas de filas y columnas
		int[] sumFilas = new int[3];
		int[] sumCols = new int[3];
		for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		sumFilas[i] += m[i][j];
		sumCols[j] += m[i][j];
		}
		}


		System.out.println("\nSuma por fila:");
		for (int i = 0; i < 3; i++) {
		System.out.println("Fila " + i + ": " + sumFilas[i]);
		}
		System.out.println("\nSuma por columna:");
		for (int j = 0; j < 3; j++) {
		System.out.println("Columna " + j + ": " + sumCols[j]);
		}
		}
		}
