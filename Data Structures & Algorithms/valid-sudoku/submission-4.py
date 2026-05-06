class Solution:
    def isValidSudoku(self, board):
        seen = set()

        for r in range(9):
            for c in range(9):
                val = board[r][c]

                if val != '.':
                    if ('r', r, val) in seen or \
                       ('c', c, val) in seen or \
                       ('b', r//3, c//3, val) in seen:
                        return False

                    seen.add(('r', r, val))               # row check
                    seen.add(('c', c, val))               # column check
                    seen.add(('b', r//3, c//3, val))      # box check

        return True