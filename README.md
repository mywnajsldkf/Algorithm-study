# Algorithm-study🏄‍♀️

### 헷갈리는 문법 정리(python)

- [연산자](#파이썬-사칙연산을-위한-연산자)
- [While문](#while)



##### 파이썬 사칙연산을 위한 연산자

- `+` : 덧셈

- `-` : 뺄셈
- `*` : 곱하기

- `**` : 거듭 제곱
- `/` : 나누기
- `//` : 나누기 연산 후 소수점 이하의 수를 버리고, 정수 부분의 수만 구함
- `%` : 나누기 연산 후 몫이 아닌 나머지를 구함



##### while

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
