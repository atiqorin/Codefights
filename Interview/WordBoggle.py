def wordBoggle(board, words):
    if(len(words) == 0):
        return []
    else:
        found= []
        for word in words:
            res = backtrack(board, [], word, 0, -1)
            if(res == 1):
                found.append(word)
        return sorted(list(found))

def backtrack(board, visited, word, start, last):
    if(start == len(word)):
        return 1
    indexes = [(x, y) for x, row in enumerate(board) for y, c in enumerate(row) if c == word[start]]
    if(len(indexes) == 0):
        return 0
    
    for index in indexes:
        if(last == -1 or (visited.count(index) == 0) and ((abs(index[0]-last[0])< 2) and abs(index[1] - last[1]) < 2)):
            res = backtrack(board, visited + [index], word, start + 1, index)
            if(res == 1):
                return 1
    return 0