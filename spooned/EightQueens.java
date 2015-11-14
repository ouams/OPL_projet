// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class EightQueens {
    public static void main(java.lang.String[] args) {
        EightQueens.solveNQueens(8);
        java.util.ArrayList<char[][]> solutions = EightQueens.getAllNQueens(8);
        java.lang.System.out.println(solutions.size());
        for (int i = 0 ; i < (solutions.size()) ; i++) {
            java.lang.System.out.println(("\n\nSolution " + (i + 1)));
            if (EightQueens.queensAreSafe(solutions.get(i)))
                EightQueens.printBoard(solutions.get(i));
            else
                java.lang.System.out.println("UH OH!!!!! BETTER FIX IT!!!!!");
            
        }
    }

    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = new char[]{ 'q' , '.' };
        assert (((board != null) && ((board.length) > 0)) && (EightQueens.isSquare(board))) && (EightQueens.onlyContains(board, validChars)) : "Violation of precondition: queensAreSafe";
        return true;
    }

    public static java.util.ArrayList<char[][]> getAllNQueens(int size) {
        java.util.ArrayList<char[][]> solutions = new java.util.ArrayList<char[][]>();
        char[][] board = EightQueens.blankBoard(size);
        EightQueens.solveAllNQueens(board, 0, solutions);
        return solutions;
    }

    public static void solveAllNQueens(char[][] board, int col, java.util.ArrayList<char[][]> solutions) {
        if (col == (board.length)) {
            solutions.add(EightQueens.makeCopy(board));
        } else {
            for (int row = 0 ; row < (board.length) ; row++) {
                board[row][col] = 'q';
                if (EightQueens.queensAreSafe(board))
                    EightQueens.solveAllNQueens(board, (col + 1), solutions);
                
                board[row][col] = '.';
            }
        }
    }

    public static char[][] makeCopy(char[][] mat) {
        assert mat != null;
        char[][] copy = new char[mat.length][mat[0].length];
        for (int r = 0 ; r < (mat.length) ; r++)
            for (int c = 0 ; c < (mat[0].length) ; c++)
                copy[r][c] = mat[r][c];
        return copy;
    }

    public static void printBoard(char[][] board) {
        for (int r = 0 ; r < (board.length) ; r++) {
            for (int c = 0 ; c < (board[r].length) ; c++)
                java.lang.System.out.print(board[r][c]);
            java.lang.System.out.println();
        }
    }

    public static void solveNQueens(int n) {
        char[][] board = EightQueens.blankBoard(n);
        boolean solved = EightQueens.canSolve(board, 0);
        if (solved) {
            java.lang.System.out.println((("Solved the " + n) + " queen problem."));
            EightQueens.printBoard(board);
        } else
            java.lang.System.out.println((("Can\'t solve the " + n) + " queen problem."));
        
    }

    public static boolean canSolve(char[][] board, int col) {
        if (col == (board.length))
            return true;
        
        boolean solved = false;
        for (int row = 0 ; (row < (board.length)) && (!solved) ; row++) {
            board[row][col] = 'q';
            if (EightQueens.queensAreSafe(board))
                solved = EightQueens.canSolve(board, (col + 1));
            
            if (!solved)
                board[row][col] = '.';
            
        }
        return solved;
    }

    private static char[][] blankBoard(int size) {
        char[][] result = new char[size][size];
        for (int r = 0 ; r < size ; r++)
            java.util.Arrays.fill(result[r], '.');
        return result;
    }

    private static boolean inbounds(int row, int col, char[][] mat) {
        return (((row >= 0) && (row < (mat.length))) && (col >= 0)) && (col < (mat[0].length));
    }

    private static boolean isSquare(char[][] mat) {
        assert mat != null : "Violation of precondition: isSquare";
        final int numRows = mat.length;
        int row = 0;
        boolean square = true;
        while (square && (row < numRows)) {
            square = ((mat[row]) != null) && ((mat[row].length) == numRows);
            row++;
        }
        return square;
    }

    private static boolean onlyContains(char[][] mat, char[] valid) {
        assert (mat != null) && (valid != null) : "Violation of precondition: onlyContains";
        int row = 0;
        int col;
        boolean correct = true;
        while (correct && (row < (mat.length))) {
            col = 0;
            while (correct && (col < (mat[row].length))) {
                correct = EightQueens.contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }

    private static boolean contains(char[] list, char c) {
        assert list != null : "Violation of precondition: contains";
        boolean found = false;
        int index = 0;
        while ((!found) && (index < (list.length))) {
            found = (list[index]) == c;
            index++;
        }
        return found;
    }
}

