from sys import stdin as s

N = int(s.readline())

s0 = ['m', 'o', 'o']

# n: 몇번째 글자인지, depth: 차수, b_len: 이전 차수의 길이
def moo(n, depth, before):
    # 다음 길이
    new_len = 2 * before + depth + 3

    # n이 3이하이면 바로 출력한다.
    if n <= 3:
        print(s0[n-1])
        return

    # new_len의 길이가 구해야하는 인자보다 작은 경우 -> 더 늘려야한다.
    if new_len < n:
        moo(n, depth+1, new_len)
    else:
        # n은 b_len(이전 길이)보다 무조건 크다. -> 가운데/뒤 파트만 확인한다.

        # 가운데
        if before < n <= before + depth + 3:
            if n - before != 1:
                print("o")
            else:
                print("m")      # 1일때만 m으로 채워져있다.
            return
        # 뒤 -> 이전 파트를 확인한다.
        else:
            moo(n-(before+depth+3), 1, 3)

# n은 2부터 셋팅
moo(N, 1, 3)