package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Create a square matrix
        double[][] matrixData = {
                {4, -2, 1},
                {1, 1, 2},
                {1, 2, 3}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for the matrix:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for the matrix:");
        int columns = scanner.nextInt();
        double[][] matrixInput = new double[rows][columns];
        System.out.println("Enter the matrix elements row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrixInput[i][j] = scanner.nextDouble();
            }
        }

        RealMatrix matrix = MatrixUtils.createRealMatrix(matrixInput);

        // Compute the eigen decomposition
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);

        // Get the eigenvalues and eigenvectors
        double[] eigenvalues = eigenDecomposition.getRealEigenvalues();
        RealMatrix eigenvectors = eigenDecomposition.getV();

        // Display the eigenvalues
        System.out.println("Eigenvalues:");
        for (int i = 0; i < eigenvalues.length; i++) {
            System.out.println(eigenvalues[i]);
        }

        // Display the eigenvectors
        System.out.println("\nEigenvectors:");
        for (int i = 0; i < eigenvectors.getRowDimension(); i++) {
            RealVector eigenvector = eigenvectors.getRowVector(i);
            System.out.println(eigenvector);
        }
    }
}
