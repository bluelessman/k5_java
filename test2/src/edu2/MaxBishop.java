package edu2;

public class MaxBishop {
    private static final int DIM = 8;
    private static final int DIM_M_1 = DIM-1;
    private static final int DIM_SQ = DIM*DIM;
    static boolean[] leftToRight = new boolean[2*DIM];
    static boolean[] rightToLeft = new boolean[2*DIM];
    static int total = 0;
    static boolean[] matrix = new boolean[DIM_SQ];

    static int maxBishops = 0;

    public static void main(String[] args) {
        maxBishop(0,0);
    }

    public static void maxBishop(int start, int numPlaced) {

        for (int p = start; p < DIM_SQ; p++) {
            int i = p / DIM;
            int j = p - i * DIM;
            if (!rightToLeft[i + j] && !leftToRight[DIM_M_1 + i - j]) {
                place(i,j);
                maxBishop(p+1, numPlaced+1);
                remove(i,j);
            }
        }
        if (numPlaced >= maxBishops) {
        	++total;
        	System.out.println("total :"+ total);
            maxBishops = numPlaced;
            printBoard(matrix, numPlaced);
        }
    }

    static void place(int i, int j) {
        matrix[i*DIM+j] = true;
        rightToLeft[i + j] = true;
        leftToRight[DIM_M_1 + i - j] = true;
    }

    static void remove(int i, int j) {
        matrix[i*DIM+j] = false;
        rightToLeft[i + j] = false;
        leftToRight[DIM_M_1 + i - j] = false;
    }
    
    static void printBoard(boolean[] matrix, int bishops) {
        System.out.println("\n"+bishops+" bishops:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i*DIM+j] ? 'B' : '.');
            }
            System.out.println();
        }
    }
}
