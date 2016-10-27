package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 * Необходимо реализовать программу, получающую две матрицы из целых чисел типа int,
 * перемножает их и результат произведения выводит в поток вывода.
 * Матрицы подаются как аргументы программы в следующем формате
 * N M X Y A_1_1 ... A_N_M B_1_1 ... B_X_Y
 * где N и M - размерность первой матрицы A (количество строк и столбцов),
 * A_1_1 ... A_N_M - элементы матрицы A,
 * X и Y - размерность второй матрицы B,
 * B_1_1 ... B_X_Y - элементы матрицы B.
 * Например, для умножения единичной матрицы размером 2 на 2 на вектор (-1, -1)
 * необходимо на вход приложению пожать следующие аргументы
 * 2 2 2 1 1 0 0 1 -1 -1
 *
 * В консоль должен распечататься вектор
 * -1
 * -1
 *
 * Кроме того, приложение должно уметь валидировать аргументы и выводить информацию о том,
 * почему матрицы умножить не получится. Например, нельзя перемножить матрицы размером 3 на 3 и 2 на 2.
 */
public class MatrixMultiplication {
    private static Matrix firstMatrix;
    private static Matrix secondMatrix;

    private static void parseMatrices(String... args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        for (int i = 0; i < 4; ++i) {
            if (Integer.parseInt(args[i]) <= 0) {
                throw new IllegalArgumentException("Dimensions cannot be non-positive");
            }
        }

        if (Integer.parseInt(args[1]) !=Integer.parseInt(args[2])) {
            throw new IllegalArgumentException("Cannot multiply matrices with such dimensions");

        }

        int cnt = 0;
        int n = Integer.parseInt(args[cnt++]);
        int m = Integer.parseInt(args[cnt++]);
        int k = Integer.parseInt(args[cnt++]);
        int j = Integer.parseInt(args[cnt++]);

        if (args.length != n * m + k * j + 4) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        int[][] firstArray = new int[n][m];
        int[][] secondArray = new int[k][j];

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < m; l++) {
                firstArray[i][l] = Integer.parseInt(args[cnt++]);
            }
        }

        for (int i = 0; i < k; i++) {
            for (int l = 0; l < j; l++) {
                secondArray[i][l] = Integer.parseInt(args[cnt++]);
            }
        }

        firstMatrix = new Matrix(firstArray);
        secondMatrix= new Matrix(secondArray);
    }

    public static void main(String... args) {
        parseMatrices(args);
        Matrix result = firstMatrix.multiplyBy(secondMatrix);
        result.printMatrix();
    }
}
