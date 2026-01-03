class Solution {

    private static char[][] board;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return this.isValidRows() && this.isValidColumns() && this.isValidBoxes();
    }

    private boolean isValidRows() {
        for (int i = 0; i < this.board[0].length; i++) {
            if (!this.isValidRow(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidRow(int nRow) {
        char[] row = this.getRow(nRow);
        return this.isValidSequence(row);
    }

    private char[] getRow(int nRow) {
        char[] row = new char[this.board[1].length];
        for (int j = 0; j < row.length; j++) {
            row[j] = this.board[nRow][j];
        }

        return row;
    }

    private static boolean isValidSequence(char[] sequence) {
        Set<Character> numbers = new HashSet<Character>();
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != '.' && !numbers.add(sequence[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidColumns() {
        for (int j = 0; j < this.board[1].length; j++) {
            if (!this.isValidColumn(j)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidColumn(int nColumn) {
        char[] column = this.getColumn(nColumn);
        return this.isValidSequence(column);
    }

    private char[] getColumn(int nColumn) {
        char[] column = new char[this.board[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = this.board[i][nColumn];
        }

        return column;
    }

    private boolean isValidBoxes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int firstIndexLine = 3 * i;
                int firstIndexColumn = 3 * j;

                // System.out.println(firstIndexLine);
                // System.out.println(firstIndexColumn);

                char[][] subBox = this.getSubBox(firstIndexLine, firstIndexColumn);
                // System.out.println(Arrays.deepToString(subBox));

                if (!this.isValidBox(subBox)) {
                    return false;
                }
            }
            
        }

        return true;
    }

    private char[][] getSubBox(int firstIndexLine, int firstIndexColumn) {
        char[][] subBox = new char[3][3];
        for (int i = 0; i < subBox[0].length; i++) {
            for (int j = 0; j < subBox[1].length; j++) {
                subBox[i][j] = this.board[firstIndexLine + i][firstIndexColumn + j];
            }
        }

        return subBox;
    }    

    private static boolean isValidBox(char[][] box) {
        Set<Character> numbers = new HashSet<Character>();
        for (int i = 0; i < box[0].length; i++) {
            for (int j = 0; j < box[1].length; j++) {
                if (box[i][j] != '.' && !numbers.add(box[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}