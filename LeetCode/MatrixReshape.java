package LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/reshape-the-matrix/
public class MatrixReshape {

    //slower, extract separately then put into new matrix
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        List<Integer> list = new ArrayList<Integer>();

        int oldc = mat[0].length;
        int oldr = mat.length;

        for (int i = 0; i < oldr; i++) {
            for (int j = 0; j < oldc; j++)
                list.add(mat[i][j]);
        }


        int[][] res = new int[r][c];
        int k = -1;
        if ((oldr * oldc) == (r * c)) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    res[i][j] = list.get(++k);
            }


            return res;
        } else {
            return mat;
        }

    }
        //faster
        public int[][] matrixReshape2(int[][] mat, int r, int c) {
            int oldc = mat[0].length;
            int oldr = mat.length;

            int[][] res = new int[r][c];

            int m = 0;
            int n = 0;
            if ((oldr * oldc) == (r * c)) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++)
                    {
                        //no need to reset M because m is rows, and it will not reset back to 0
                        //only columns go back to 0
                        if (n == mat[0].length) {
                            n = 0;
                            m++;
                        }

                        res[i][j] = mat[m][n];
                        n++;
                    }
                }


                return res;
            } else {
                return mat;
            }


        }
    }

