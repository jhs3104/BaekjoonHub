def solution(numbers, hand):
    answer = ''
    pos = {
    1: (0, 0), 2: (0, 1), 3: (0, 2),
    4: (1, 0), 5: (1, 1), 6: (1, 2),
    7: (2, 0), 8: (2, 1), 9: (2, 2),
               0: (3, 1),
    }
    left = (3, 0)     
    right = (3, 2) 

    for num in numbers:
        target = pos[num]
        if num in [1, 4, 7]:
            use = 'L'
        elif num in [3, 6, 9]:
            use = 'R'
        else :
            l = abs(left[0] - target[0]) + abs(left[1] - target[1])
            r = abs(right[0] - target[0]) + abs(right[1] - target[1])
            if l - r > 0:
                use = 'R'
            elif r - l > 0:
                use = 'L'
            else:
                use = 'L' if hand == "left" else 'R'
        answer += use
        if use == 'L':
            left = target    
        else:
            right = target
    return answer