class Solution {

    private int[][] matrix;

    public boolean checkValid(int[][] matrix) {
        this.matrix = matrix;
        return isValidRows() && isValidColumns();
    }

    private boolean isValidRows() {
        for (int i = 0; i < this.matrix[0].length; i++) {
            if (!this.isValidRow(i)) {
                return false;
            }
        }

        return true;
    }   

    private boolean isValidRow(int nRow) {
        int[] row = this.getRow(nRow);
        return this.isValidSequence(row);
    }

    private int[] getRow(int nRow) {
        int[] row = new int[this.matrix[0].length];
        for (int j = 0; j < row.length; j++) {
            row[j] = this.matrix[nRow][j];
        }

        return row;
    }

    private boolean isValidColumns() {
        for (int j = 0; j < this.matrix[0].length; j++) {
            if (!this.isValidColumn(j)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidColumn(int nColumn) {
        int[] column = this.getColumn(nColumn);
        return this.isValidSequence(column);
    }

    private int[] getColumn(int nColumn) {
        int[] column = new int[this.matrix[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = this.matrix[i][nColumn];
        }

        return column;
    }

    private static boolean isValidSequence(int[] sequence) {
        Set<Integer> integersFilled = new HashSet<>();
        for (int i = 0; i < sequence.length; i++) {
            if (!integersFilled.add(sequence[i])) {
                return false;
            }
        }

        return true;
    }
}