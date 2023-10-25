/*Створити клас, який складається з виконавчого методу, що виконує дію з
матрицею(ями)  C=A+B із зазначеним типом елементів INT та дію із результуючою
матрицею С : Обчислити суму найбільших елементів в стовпцях матриці з
парними номерами та найменших елементів в стовпцях матриці з
непарними номерами.
Вивести на екран результати першої та другої дій.
Необхідно обробити всі виключні ситуації, що можуть виникнути під час виконання
програмного коду.
Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
V17
C5 : C=A+B
C7 : INT
C11 : Обчислити суму найбільших елементів в стовпцях матриці з
парними номерами та найменших елементів в стовпцях матриці з
непарними номерами
*/
public class Main {
    public static void main(String[] args) {
        try {
            int rows = 4;
            int cols = 4;

            int[][] A = new int[rows][cols];
            int[][] B = new int[rows][cols];

            // Заповнення матриці A і B випадковими значеннями
            initializeMatrix(A);
            initializeMatrix(B);

            // Вивід матриць А і В
            System.out.println("Матриця A:");
            printMatrix(A);
            System.out.println("\nМатриця В:");
            printMatrix(B);

            // Додавання матриць A і B та отримуємо матрицю C
            int[][] C = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }

            // Результат операції додавання
            System.out.println("\nРезультат додавання матриць A і B:");
            printMatrix(C);

            // Сума найбільших та найменших елементів в стовпцях матриці C
            int sumMaxEl = sumMaxElementsInEvenColumns(C);
            int sumMinEl = sumMinElementsInOddColumns(C);

            // Результати обчислень
            System.out.println("\nСума найбільших елементів в стовпцях з парними номерами: " + sumMaxEl);
            System.out.println("Сума найменших елементів в стовпцях з непарними номерами: " + sumMinEl);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
    // Метод для ініціалізації матриці випадковими значеннями
    public static void initializeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100); // Випадкове ціле число від 0 до 99
            }
        }
    }

    // Метод для обчислення суми найбільших елементів в стовпцях матриці з парними номерами
    public static int sumMaxElementsInEvenColumns(int[][] matrix) {
        int sum = 0;
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int j = 0; j < cols; j += 2) {
            int max = matrix[0][j];
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }

    // Метод для обчислення суми найменших елементів в стовпцях матриці з непарними номерами
    public static int sumMinElementsInOddColumns(int[][] matrix) {
        int sum = 0;
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int j = 1; j < cols; j += 2) {
            int min = matrix[0][j];
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += min;
        }
        return sum;
    }

    // Метод для виводу матриці на екран
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}