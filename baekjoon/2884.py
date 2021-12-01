H, N = map(int, input().split())


def alarm_minute(h, n):
    minutes = h*60+n

    minutes = minutes - 45

    if(minutes < 0):
        minutes = minutes + 60*24

    return minutes


def alarm_time(minutes):
    minute = minutes % 60
    hour = minutes // 60

    return hour, minute


minutes = alarm_minute(H, N)

print(" ".join(map(str, alarm_time(minutes))))
