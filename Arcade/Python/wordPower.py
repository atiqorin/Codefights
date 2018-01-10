def wordPower(word):
    num = {key: ord(key) - 96 for key in word}
    return sum([num[ch] for ch in word])
