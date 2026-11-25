def solution(park, routes):
    H, W = len(park), len(park[0])
    move = {'N': (-1, 0), 'S': (1, 0), 'W': (0, -1), 'E': (0, 1)}

    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                r, c = i, j

    for route in routes:
        d, n = route.split()
        dr, dc = move[d]
        nr, nc = r, c
        ok = True
        for _ in range(int(n)):
            nr += dr
            nc += dc
            if not (0 <= nr < H and 0 <= nc < W) or park[nr][nc] == 'X':
                ok = False                
                break
        if ok:
            r, c = nr, nc
    return [r,c]