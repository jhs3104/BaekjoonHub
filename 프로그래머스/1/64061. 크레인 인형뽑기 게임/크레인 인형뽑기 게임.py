def solution(board, moves):
    answer = 0
    stack = []
    for move in moves:
        col = move -1
        for i in range(len(board)):
            if(board[i][col] != 0):
                doll = board[i][col]
                board[i][col] = 0
                if stack and stack[-1] == doll:
                    answer+=2
                    stack.pop()
                else:
                    stack.append(doll)
                break
    
    return answer