function maximalSquare(matrix) {
    var dp = []
    for (var i = 0; i < matrix.length; i++) {
        dp.push([]);
        for (var j = 0; j < matrix[i].length; j++) {
            dp[i].push(Number(matrix[i][j]));
        }
    }
    var max = 0;
    for (var i = 0; i < dp.length; i++) {
        if (dp[i][0] == 1) {
            max = 1;
            break;
        }
    }
    if (dp[0]) {
        for (var i = 0; i < dp[0].length; i++) {
            if (dp[0][i] == 1) {
                max = 1;
                break;
            }
        }
    }

    for (var i = 1; i < dp.length; i++) {
        for (var j = 1; j < dp[i].length; j++) {
            if (matrix[i][j] == '1') {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            } else {
                dp[i][j] = 0;
            }
        }
    }
    return max * max;
}
