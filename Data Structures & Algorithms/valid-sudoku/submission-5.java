class Solution {
    boolean isValidSudoku(char[][] board) {
    var seen = new HashSet<String>();

    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            char val = board[r][c];

            if (val != '.') {
                String rowKey = "r" + r + val;
                String colKey = "c" + c + val;
                String boxKey = "b" + (r / 3) + (c / 3) + val;

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
    }
    return true;
}
}
