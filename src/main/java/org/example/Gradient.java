package org.example;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.linear.RealMatrix;

public class Gradient implements MultivariateDifferentiableFunction {
    private final RealMatrix matrix;

    public Gradient(RealMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public DerivativeStructure value(DerivativeStructure[] variables) {
        int n = variables.length;
        DerivativeStructure result = variables[0].getField().getZero();

        // Compute the function value
        for (int i = 0; i < n; i++) {
            DerivativeStructure term = variables[i];
            for (int j = 0; j < n; j++) {
                term = term.multiply(matrix.getEntry(i, j)).multiply(variables[j]);
            }
            result = result.add(term);
        }
        return result;
    }

    @Override
    public double value(double[] point) {
        // Placeholder implementation, replace with your specific function
        // Example: f(x, y, z) = x^2 + y^2 + z^2
        double result = 0.0;
        for (double coordinate : point) {
            result += coordinate * coordinate;
        }
        return result;
    }
}
