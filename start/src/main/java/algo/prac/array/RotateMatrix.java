package algo.prac.array;

import java.util.Arrays;

public class RotateMatrix {

  // You are given an n x n 2D matrix representing an image, rotate the image by
  // 90 degrees (clockwise).

  // You have to rotate the image in-place, which means you have to modify the
  // input 2D matrix directly. DO NOT allocate another 2D matrix and do the
  // rotation.

  // 123 => 741
  // 456 => 852
  // 789 => 963

  // Solution
  // First reverse top to down and then rotate the symmetry
  //
  // 1 2 3 => 7 8 9 => 7 4 1
  // 4 5 6 => 4 5 6 => 8 5 2
  // 7 8 9 => 1 2 3 => 9 6 3
  //
  private static void rotate90ClockWise(int[][] matrix) {
    for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
      swapIn2DArray(matrix, i, j);
    }

    // exchange the symmetry
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int j2 = 0; j2 < matrix[0].length; j2++) {
      System.out.println(Arrays.toString(matrix[j2]));
    }

  }

  private static void swapIn2DArray(int[][] arr, int i, int j) {
    int[] temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Transpose the matrix first and then reverse each sub matrix horizontally
  private static void rotate90ClockWise1(int[][] matrix) {
    // first transapose the matrix
    // 1-2-3 => 1-4-7
    // 4-5-6 => 2-5-6
    // 7.8-9 => 3-6-9

    // Flip the matrix horizontally
    // 1-4-7 => 7-4-1
    // 2-5-6 => 6-5-2
    // 3-6-9 => 9-6-3

    // Transpose the matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // reverse the each sub matrix horizontally
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0, k = matrix[i].length - 1; j < k; j++, k--) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][k];
        matrix[i][k] = temp;
      }
    }

    // print the rotated matrix
    for (int[] is : matrix) {
      System.out.println(Arrays.toString(is));
    }
  }

  // Transpose the matrix and then flip the rows vertically
  private static void rotate90AntiClockWise(int[][] matrix) {
    // Tranpose the matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0, k = matrix.length - 1; j < k; j++, k--) {
        int temp = matrix[j][i];
        matrix[j][i] = matrix[k][i];
        matrix[k][i] = temp;

      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // rotate90ClockWise(matrix);
    rotate90ClockWise1(matrix);
  }
}
