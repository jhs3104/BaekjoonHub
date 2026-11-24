def solution(name, yearning, photo):
    answer = []
    d = dict(zip(name,yearning))
    
    for people in photo:
        total = 0
        for p in people:
            total += d.get(p,0)
        answer.append(total)
    return answer