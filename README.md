# Algorithm-study🏄‍♀️

### 목차

- [python](#python)
- [Algorithm](#Algorithm)



# python

- [연산자](#파이썬-사칙연산을-위한-연산자)
- [While문](#while)
- [자료형](#자료형)



##  파이썬 사칙연산을 위한 연산자

- `+` : 덧셈

- `-` : 뺄셈
- `*` : 곱하기

- `**` : 거듭 제곱
- `/` : 나누기
- `//` : 나누기 연산 후 소수점 이하의 수를 버리고, 정수 부분의 수만 구함
- `%` : 나누기 연산 후 몫이 아닌 나머지를 구함



## while

반복해서 수행할 경우에 사용한다.

> 기본 구조

``` python
while <조건문>:
  수행할 문장1
  수행할 문장2
  ...
```



> 빠져나가기

`break` 문을 사용하여 함수가 중지되도록 설정한다.



> while문의 맨 처음으로 돌아가기

while문은 조건해 맞지않으면 while문을 빠져나간다. 프로그래밍 중 while문을 빠져나가지 않고 while문의 맨 처음으로 돌아가도록 하고 싶은 경우 `continue` 를 사용한다.



> 무한 루프

while문의 조건문을 별도 설정하지 않을 경우 항상 true로 참이므로 무한으로 수행된다.



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



## 자료형

### python의 자료형

| 자료형(Data Type) | 표현방법 |
| -- | ------------------ |
| 숫자(int)         | a = 10   |
| 문자열(str) | a = '10' |
| 리스트(list) | a=[10,20,30] |
| 튜플(tuple) | a=(10,20,30) |
| 집합(set) | a={10,20,30} |
| 딕셔너리(dict) | a=[1:'키', 2:'몸무게'] |

### 리스트

list = [element1, element2, element3, ...]

- 대괄호([])로 감싸고 요소는 쉼표(,)로 구분한다.

#### 인덱싱

```python
a = [1,2,3]
a[0] 			# 1
a[-1]			# 3
```



#### 슬라이싱

```python
a = [1,2,3,4,5]
b = a[:2]				# [1,2]
```



#### 리스트 관련 함수들

- 리스트에 요소 추가(append)

  ```python
  a = [1,2,3]
  a.append(4)
  a				# [1,2,3,4]
  ```

  - 리스트 안에는 자료형도 추가할 수 있음

- 리스트 정렬(sort)

  ```python
  a = [1, 4, 3, 2]
  a.sort()
  a			# [1, 2, 3, 4]
  
  a = ['a', 'c', 'b']
  a.sort()
  a			# ['a', 'b', 'c']
  ```

- 리스트 뒤집기(reverse)

  리스트를 역순으로 뒤집어 준다. 리스트 요소들을 순서대로 정렬한 다음 다시 역순으로 정렬하는 것이 아닌 현재의 리스트를 그대로 거꾸로 뒤집는다.

  ```python
  a = ['a', 'c', 'b']
  a.reverse()
  a			# ['b', 'c', 'a']
  ```

- 위치 반환(index)

  index(x) 리스트에 x 값이 있으면 x의 위치 값을 돌려준다.

  ```python
  a = [1, 2, 3]
  a.index(3)		# 2
  a.index(0)		# 값이 없으므로 value Error
  ```

- 리스트에 요소 삽입(insert)

  insert(a,b)는 리스트의 a번째 위치에 b를 삽입하는 함수이다.

  

  ```python
  a = [1, 2, 3]
  a.insert(0, 4)
  a					# [4, 1, 2, 3] 
  ```

- 리스트 요소 제거(remove)

  remove(x)는 리스트에서 첫 번째로 나오는 x를 삭제한다.

  ```python
  a = [1, 2, 3, 1, 2, 3]
  a.remove(3)
  a 			 # [1, 2, 1, 2, 3]
  ```

- 리스트 요소 끄집어내기(pop)

  pop()은 리스트의 맨 마지막 요소를 돌려주고 그 요소는 삭제한다.

  ```python
  a = [1,2,3]
  a.pop()		# 3
  a					# [1, 2]
  ```

- 리스트에 포함된 요소 x의 개수 세기(count)

  count(x)는 리스트 안에 x가 몇 개 있는지 조사하여 그 개수를 돌려주는 함수이다.

  ```python
  a = [1,2,3,1]
  a.count(1)		# 2
  ```

- 리스트 확장(extend)

  extend(x)에서 x에는 리스트만 올 수 있으며 원래의 a 리스트에 x 리스트를 더한다.

  ```python
  a = [1,2,3]
  a.extend([4,5])
  a					# [1,2,3,4,5]
  ```



### 튜플

```python
t1 = (1, 2, 3)
```

- 리스트는 값의 생성, 삭제, 수정이 가능하지만 튜플은 그 값을 바꿀 수 없다.



### 딕셔너리

대응 관계를 나타낼 수 있는 자료형, 연관 배열(Associative array) 또는 해시(Hash)라고 한다.

리스트나 튜플처럼 순차적으로(sequential) 해당 요소값을 구하지 않고 Key를 통해 Value를 얻는다. 즉 baseball이라는 단어의 뜻을 찾기 위해 사전의 내용을 순차적으로 모두 검색하는 것이 아닌 baseball이라는 단어가 있는 곳만 펼쳐 본다.

**딕셔너리의 모습**

```python
{Key1:Value1, Key2:Value2, Key3:Value3, ...}
```

#### 딕셔너리 쌍 추가하기

```python
a = {1: 'a'}
a[2] = 'b'
a					# {1: 'a', 2: 'b'}
```



#### 딕셔너리 요소 삭제하기

del 함수를 사용해서 del a[key]처럼 입력하면 지정한 Key에 해당하는 {key : value} 쌍이 삭제된다.

```python
del a[1]
a					# {2: 'b'} 
```



#### 딕셔너리에서 Key 사용해 Value 얻기

`딕셔너리변수이름[Key]` 를 사용한다. 



#### 딕셔너리 만들 때 주의할 사항

1. Key는 고유한 값이므로 중복되는 Key값을 설정해 놓으면 하나를 제외한 나머지 것들이 모두 무시된다.
2. Key에 리스트는 쓸 수 없지만, 튜플을 쓸 수 있다. 딕셔너리의 Key는 Key가 변하는 값인지 변하지 않는 값인지에 따라 달려있다.



#### 딕셔너리 관련 함수

- Key 리스트 만들기(keys)

  ```python
  a = {'name': 'pey', 'phone':'01000000000', 'birth':'1994'}
  a.keys()
  dict_keys(['name', 'phone', 'birth'])
  ```

- Value 리스트 만들기(values)

  ```python
  a.values()
  dict_values(['pey', '01000000000', '1994'])
  ```

- Key, value 쌍 얻기(items)

  ```python
  a.items()
  dict_items([('name', 'pey'),('phone','01000000000'),('birth', '1994')])
  ```

- Key: Value 쌍 모두 지우기(clear)

  ```python
  a.clear()
  a		# {}
  ```

- Key로 Value 얻기(get)

  ```python
  a.get('name')			# 'pey'
  a.get('phone')		# '01000000000'
  ```

- 해당 Key가 딕셔너리 안에 있는지 조사하기(in)

  ```python
  'name' in a			# True
  'july' in a 		# False
  ```



### 집합

집합은 set 키워드를 사용해 만들 수 있다. 

```python
s1 = set([1,2,3])	
s1		# {1, 2, 3}
s2 = set("Hello")
s2 		# {'e','H','l','o'}
```

- 비어 있는 집합 자료형은 `s=set()` 로 만들 수 있다.



#### 특징

- 중복을 허용하지 않는다.
- 순서가 없다. -> 인덱싱으로 값을 얻을 수 없다.



#### 집합 자료형 관련 함수들

- 값 1개 추가하기(add)

  이미 만들어진 set 자료형에 값을 추가할 수 있다. 1개의 값만 추가(add)할 경우에 사용한다.

  ```python
  s1 = set([1,2,3])
  s1.add(4)
  s1	# {1,2,3,4}
  ```

- 값 여러 개 추가하기(update)

  여러 개의 값을 한꺼번에 추가(update)할 때 사용한다.

  ```python
  s1 = set([1,2,3])
  s1.update([4,5,6])
  s1	# {1, 2, 3, 4, 5, 6}
  ```

- 특정 값 제거하기(remove)

  특정 값을 제거하고 싶을 때는 다음과 같이 한다.

  ```python
  s1 = set([1,2,3])
  s1.remove(2)
  s1	# {1, 3}
  ```

  



# Algorithm

- [유클리드 호제법](#유클리드-호제법)
- [이진탐색](#이진탐색)



## 유클리드 호제법

최대 공약수를 구하는 문제에서 쓰인다. 최대 공약수는 2개의 정수에서 2부터 두 자연수 중 작은 자연수까지 모두 나누어보면서 가장 큰 공약수를 구하는 방법도 있다. 

- 이 경우 시간 복잡도는 **O(N)**이다.

유클리드 호제법을 사용할 경우 시간복잡도를 **O(logN)**으로 줄일 수 있다.



실수 a,b가 있고 a를 b로 나눈 나머지를 r이라고 할 때, a와 b의 최대공약수를 (a,b)라고 하면, `(a,b) = (b,r)`이 성립한다.

```
GCD(A,B) = GCD(B, A%B)
if A%B = 0 
	GCD = B
else GCD(B, A%B)
```



**알고리즘**

1. 입력으로 두 수 m,n(m>n)이 들어온다.
2. n이 0이면, m을 출력하고 알고리즘을 종료한다.
3. m이 n으로 나누어 떨어지면, n을 출력하고 알고리즘을 종료한다.
4. 그렇지 않으면 m을 n으로 나눈 나머지를 새롭게 m에 대입하고 m과 n을 바꾸고 3번으로 돌아와 반복한다.



```python
def gcd(m,n):
  if m < n:
    m,n = n, m
   if n == 0:
    return m
  if m % n == 0:
    return n
 	else:
    return gcd(n, m%n)
```

```python
def gcd(m,n):
  while n!= 0:
    t = m%n
    (m,n) = (n,t)
   return abs(m)
```



## 이진탐색

- 시간 복잡도: O(logN) [보충설명](https://jwoop.tistory.com/9)

- 반드시 오름차순으로 **정렬된 상태**에서 시작하며, 정렬된 자료를 반으로 나누어 탐색한다.

- 현재의 중앙값과 찾는 값을 비교한다.
  - 중앙값 > 찾는 값: 중앙 값 기준으로 왼쪽(작은 부분) 탐색
  - 중앙값 < 찾는 값: 중앙 값 기준으로 오른쪽(큰 부분) 탐색



### 탐색 프로세스

- left를 0으로 초기화, right를 검색하는 리스트(배열)의 마지막 원소의 인덱스로 초기화한다.
  - right를 검색하는 리스트(배열)의 마지막 원소의 인덱스 -> 리스트(배열)의 크기-1
- mid 변수를 (left+right)/2로 설정하여 계속해서 탐색한다.
- left > right가 되는 순간까지 탐색 한다.
  - 그전에 해당 값을 찾으면 탐색이 종료된다.



> 예제 1~8에서 7찾기

1. 배열을 생성한다.
   - left = 배열의 시작, array[0]
   - right = 배열의 마지막, array[7] (=len(array))

<img src="image/이진탐색1.jpeg" alt="이진탐색1" style="zoom:50%;" />

2. mid를 찾는다.

   - mid = (left + right)/2

   <img src="image/이진탐색2.jpeg" alt="이진탐색2" style="zoom:50%;" />

3. mid값(4) < 찾는 값(7) 이다. left를 mid + 1로 이동시킨다. mid는 이동시킨 left와 right사이의 값이 된다.

   <img src="image/이진탐색3.jpeg" alt="이진탐색3" style="zoom:50%;" />

4. mid값(6) < 찾는 값(7)이다. 다시 위의 과정을 수행하였을 때 mid=(left+right)/2의 값을 넣어준다. array[6]=7으로 값을 찾았기 때문에 탐색을 종료한다.

   <img src="image/이진탐색4.jpeg" alt="이진탐색4" style="zoom:50%;" />

### 구현

> binary search

```python
# target : 찾는 값
# data : target이 들어있는 배열
def binary_search(target, data):
  data.sort()
  left = 0
  right = len(data) - 1 
  
  while left <= right:
    mid = (left+right) // 2
    
    if data[mid] == target:
      return mid						# 값을 찾음
   	elif data[mid] < target:
      left = mid + 1
    elif data[mid] > target:
      right = mid - 1
    
    return None
```



> 재귀적 구현

```python
def binary_search_recursion(target, left, right, data):
  if left > right:
    return None
  
  mid = (left+right)//2
  
  if data[mid] == target:
    return mid
  elif data[mid] > target:
    right = mid -1
   elif data[mid] < target:
    left = mid + 1 
   
  return binary_search_recursion(target, left, right, data)
  
```

