class NearestGreater {
    int[] nearestGreater(int[] a) {
        int[] st = new int[3 * a.length];
        constructRMQ(a, st);
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int left = RMQ(a, st, 0, i - 1);
            if (left != -1 && a[left] <= a[i]) {
                left = -1;
            }
            int l = left;
            while (l != -1) {
                l = RMQ(a, st, l + 1, i - 1);
                if (l != -1 && a[l] > a[i]) {
                    left = l;
                }
            }

            int right = RMQ(a, st, i + 1, a.length - 1);
            if (right != -1 && a[right] <= a[i]) {
                right = -1;
            }
            int r = right;
            while (r != -1) {
                r = RMQ(a, st, i + 1, r - 1);
                if (r != -1 && a[r] > a[i]) {
                    right = r;
                }
            }
            if (left == -1 && right == -1) {
                ans[i] = -1;
            } else if (left == -1) {
                ans[i] = right;
            } else if (right == -1) {
                ans[i] = left;
            } else {
                if (i - left > right - i) {
                    ans[i] = right;
                } else {
                    ans[i] = left;
                }
            }
        }
        return ans;
    }

    void constructRMQ(int[] arr, int[] st) {
        int n = arr.length;

        constructRMQUtil(arr, st, 0, n - 1, 0);
    }

    int constructRMQUtil(int[] arr, int[] st, int s, int e, int si) {
        if (s == e) {
            st[si] = s;
            return st[si];
        }
        int mid = s + (e - s) / 2;
        int left = constructRMQUtil(arr, st, s, mid, si * 2 + 1);
        int right = constructRMQUtil(arr, st, mid + 1, e, si * 2 + 2);
        if (arr[left] >= arr[right]) {
            st[si] = left;
        } else {
            st[si] = right;
        }
        return st[si];
    }

    int RMQ(int[] arr, int[] st, int s, int e) {
        if (s < 0 || e >= arr.length || s > e) {
            return -1;
        }
        return RMQUtil(arr, st, 0, arr.length - 1, s, e, 0);
    }

    int RMQUtil(int[] arr, int[] st, int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si];
        }
        if (se < qs || ss > qe) {
            return -1;
        }
        int mid = ss + (se - ss) / 2;
        int left = RMQUtil(arr, st, ss, mid, qs, qe, 2 * si + 1);
        int right = RMQUtil(arr, st, mid + 1, se, qs, qe, 2 * si + 2);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else if (arr[left] >= arr[right]) {
            return left;
        } else {
            return right;
        }
    }
}