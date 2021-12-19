# 유용한 함수

- [정렬](#정렬)



## 정렬

파이썬에서 `list.sort()` 메서드로 리스트를 제자리에서 수정할 수 있다. (기본값: 오름차순)

- `sorted()` : 새로운 정렬된 리스트를 만드는 내장함수

```python
a = [5, 2, 3, 1, 4]
a.sort()
a		# [1, 2, 3, 4, 5]
```

내림차순으로 정렬할 경우, reverse매개 변수를 받아와 `True`로 지정한다.

**Ref**

- [정렬 HOW TO](https://docs.python.org/ko/3/howto/sorting.html)