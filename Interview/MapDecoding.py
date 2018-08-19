def mapDecoding(message):
    n = len(message)
    if(n == 0):
        return 1
    dp = [0] * (n + 1)
    dp[0] = 1
    if(message[0] == '0'):
        dp[1] = 0
    else:
        dp[1] = 1
    mod = 1000000007
    for i in range(2, n + 1):
        sub1 = int(message[i-1:i])
        sub2 = int(message[i-2:i])
        if(sub1 != 0):
            dp[i] += dp[i-1] % mod
        if(sub2 > 9 and sub2 < 27):
            dp[i] += dp[i-2] % mod
    return dp[n]
