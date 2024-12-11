def solveNQueens(n):
    def backtrack(row, cols, diags, anti_diags, current):
        if row == n:
            result.append([''.join(row) for row in current])
            return
        
        # Get all valid columns as bit positions
        available_positions = ((1 << n) - 1) & ~(cols | diags | anti_diags)
        
        while available_positions:
            # Get the rightmost '1' bit (position of next queen)
            position = available_positions & -available_positions
            # Remove this position from available_positions
            available_positions &= available_positions - 1
            
            # Get column index from bitmask
            col = bin(position).count('0') - 1
            
            # Place queen and recurse
            current[row][col] = 'Q'
            backtrack(row + 1, 
                      cols | position, 
                      (diags | position) << 1, 
                      (anti_diags | position) >> 1, 
                      current)
            # Backtrack: Remove queen
            current[row][col] = '.'

    result = []
    board = [['.' for _ in range(n)] for _ in range(n)]
    backtrack(0, 0, 0, 0, board)
    return result

# Example usage
n = 4
solutions = solveNQueens(n)
print(solutions)
