import java.util.Scanner;
import java.util.HashSet;

public class InteractiveApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an algorithm to run:");
        System.out.println("1. Maximum Element (Iterative)");
        System.out.println("2. Element Uniqueness (Iterative)");
        System.out.println("3. Matrix Multiplication (Iterative)");
        System.out.println("4. Gaussian Elimination (Iterative)");
        System.out.println("5. Counting Binary Digits (Iterative)");
        System.out.println("6. Factorial (Recursive)");
        System.out.println("7. Tower of Hanoi (Recursive)");
        System.out.println("8. Fibonacci Numbers (Recursive)");

        System.out.print("Enter your choice (1-8): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the list of numbers separated by spaces: ");
                scanner.nextLine();
                String[] maxInput = scanner.nextLine().split(" ");
                int[] maxArr = new int[maxInput.length];
                for (int i = 0; i < maxInput.length; i++) {
                    maxArr[i] = Integer.parseInt(maxInput[i]);
                }
                System.out.println("Maximum Element: " + findMaximum(maxArr));
                break;

            case 2:
                System.out.print("Enter the list of numbers separated by spaces: ");
                scanner.nextLine();
                String[] uniqueInput = scanner.nextLine().split(" ");
                int[] uniqueArr = new int[uniqueInput.length];
                for (int i = 0; i < uniqueInput.length; i++) {
                    uniqueArr[i] = Integer.parseInt(uniqueInput[i]);
                }
                System.out.println("Element Uniqueness: " + isUnique(uniqueArr));
                break;

            case 3:
                System.out.print("Enter the number of rows for Matrix A: ");
                int rowsA = scanner.nextInt();
                System.out.print("Enter the number of columns for Matrix A (and rows for Matrix B): ");
                int colsA = scanner.nextInt();
                System.out.print("Enter the number of columns for Matrix B: ");
                int colsB = scanner.nextInt();

                System.out.println("Enter the elements of Matrix A row-wise:");
                int[][] A = new int[rowsA][colsA];
                for (int i = 0; i < rowsA; i++) {
                    for (int j = 0; j < colsA; j++) {
                        A[i][j] = scanner.nextInt();
                    }
                }

                System.out.println("Enter the elements of Matrix B row-wise:");
                int[][] B = new int[colsA][colsB];
                for (int i = 0; i < colsA; i++) {
                    for (int j = 0; j < colsB; j++) {
                        B[i][j] = scanner.nextInt();
                    }
                }

                int[][] result = multiplyMatrices(A, B);
                System.out.println("Resultant Matrix after Multiplication:");
                for (int[] row : result) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
                break;

            case 4:
                System.out.print("Enter the number of variables (size of the matrix): ");
                int n = scanner.nextInt();
                double[][] matrix = new double[n][n];
                double[] vector = new double[n];

                System.out.println("Enter the coefficients of the augmented matrix row-wise:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextDouble();
                    }
                    vector[i] = scanner.nextDouble();
                }

                double[] solution = gaussianElimination(matrix, vector);
                System.out.println("Solution Vector:");
                for (double sol : solution) {
                    System.out.print(sol + " ");
                }
                System.out.println();
                break;

            case 5:
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                System.out.println("Number of binary digits: " + countBinaryDigits(number));
                break;

            case 6:
                System.out.print("Enter a number: ");
                int factNum = scanner.nextInt();
                System.out.println("Factorial: " + factorial(factNum));
                break;

            case 7:
                System.out.print("Enter the number of disks: ");
                int disks = scanner.nextInt();
                System.out.println("Moves to solve Tower of Hanoi:");
                towerOfHanoi(disks, 'A', 'B', 'C');
                break;

            case 8:
                System.out.print("Enter a number: ");
                int fibNum = scanner.nextInt();
                System.out.println("Fibonacci number: " + fibonacci(fibNum));
                break;

            default:
                System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();
    }

    public static int findMaximum(int[] arr) {
        int maxElement = arr[0];
        for (int element : arr) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    public static boolean isUnique(int[] arr) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int element : arr) {
            if (uniqueElements.contains(element)) {
                return false;
            }
            uniqueElements.add(element);
        }
        return true;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static double[] gaussianElimination(double[][] matrix, double[] vector) {
        int n = vector.length;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                for (int j = i; j < n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
                vector[k] -= factor * vector[i];
            }
        }

        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = vector[i];
            for (int j = i + 1; j < n; j++) {
                solution[i] -= matrix[i][j] * solution[j];
            }
            solution[i] /= matrix[i][i];
        }
        return solution;
    }

    public static int countBinaryDigits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 2;
            count++;
        }
        return count;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
        } else {
            towerOfHanoi(n - 1, source, destination, auxiliary);
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            towerOfHanoi(n - 1, auxiliary, source, destination);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}