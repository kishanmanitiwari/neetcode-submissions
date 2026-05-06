class Solution {
    private boolean gridCheck(char[][] board) {
    for (int row = 0; row < 9; row += 3) {
      for (int col = 0; col < 9; col += 3) {

        var gridSet = new HashSet<Character>();

        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            char elem = board[row + i][col + j];

            if (elem != '.' && !gridSet.add(elem)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  boolean isValidSudoku(char[][] board) {

    // row check
    for (int i = 0; i < 9; i++) {
      var rowSet = new HashSet<Character>();
      for (int j = 0; j < 9; j++) {
        char elem = board[i][j];
        if (elem != '.' && !rowSet.add(elem))
          return false;
      }
    }

    // column check
    for (int j = 0; j < 9; j++) {
      var colSet = new HashSet<Character>();
      for (int i = 0; i < 9; i++) {
        char elem = board[i][j];
        if (elem != '.' && !colSet.add(elem))
          return false;
      }
    }

    return gridCheck(board);
  }

}
