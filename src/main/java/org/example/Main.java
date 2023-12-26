package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
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
        User user1 = new User("Vatsal", 18);
        System.out.println(user1.getName());
        System.out.println(user1.getAge());
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        Map<String, Integer> users = new HashMap<>();
        users.put("Vatsal", 18);
        users.put("Yug", 18);
        System.out.println(users.get("Vatsal"));

        String symbol = "AAPL";  // Apple stock symbol

        try {
            String stockData = Stock.getStockData(symbol);
            System.out.println("Stock Data: " + stockData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DerivativeStructure x = new DerivativeStructure(1, 3, 0, 2.5);
// Basically, x --> x^2.
        DerivativeStructure x2 = x.pow(2);
//Linear combination: y = 4x^2 + 2x
        DerivativeStructure y = new DerivativeStructure(4.0, x2, 2.0, x);
        System.out.println("y    = " + y.getValue());
        System.out.println("y'   = " + y.getPartialDerivative(1));
        System.out.println("y''  = " + y.getPartialDerivative(2));
        System.out.println("y''' = " + y.getPartialDerivative(3));

        SwingUtilities.invokeLater(() -> SwingWindow.createAndShowGUI());

        RealMatrix matrix = MatrixUtils.createRealMatrix(matrixInput);

        // Compute the eigen decomposition
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);

        Gradient gradient = new Gradient(matrix);
        double[] point = {1.0, 2.0, 3.0};
        double[] gradient_points = new double[]{gradient.value(point)};
        System.out.println("Gradient at point:");
        for (double value : gradient_points) {
            System.out.println(value);
        }

        RealMatrix matrix_1 = createTrigMatrix();

        // Use the Gradient class
        Gradient gradient_1 = new Gradient(matrix_1);

        // Evaluate the gradient at a specific point
        double[] point_1 = {1.0, 2.0};
        double[] gradientValues = new double[]{gradient.value(point)};

        // Display the gradient
        System.out.println("Gradient at point:");
        double[] values = new double[gradientValues.length];
        for (int i = 0; i < gradientValues.length; i++) {
            values[i] = gradientValues[i];
            System.out.println(values[i]);
        }

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
    private static RealMatrix createTrigMatrix() {
        double[][] matrixData = {
                {Math.sin(1.0), Math.cos(2.0)},
                {Math.tan(1.0), Math.sin(2.0)}
        };
        return MatrixUtils.createRealMatrix(matrixData);
    }
}