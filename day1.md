 # Study - Day 1

### 1 . boolean, byte,short, int, long, float, double, char 등등의 java primitive type들은 값의 범위가 정해져있다. 그렇다면 메모리를 효율적으로 사용하기 위해 size에 맞는 primitive type을 고민하여 써야할까? ex) -2~2 정수를 저장하기위해 byte형을 사용 해야하나?

```NO, JVM의 default type은 integer 이기 때문에 오히려 JVM이 더 많은 일을 할수있는 여지를 줄 수도 있다.```
  


### 2. java 의 type
```JVM의 Memory allocation & management 이용 primitive type은 정해진 메모리를 할당받고 reference type은 가변적으로 메모리를 할당받는다.```



### 3. 다음 코드에서 잘못된 것은?
```java
int a=10;
byte b =a;
```

`명시적 type casting이 필요하다. 이때, 큰 type 에서 작은 type 으로 변수를 할당한다면 값의 손실이 일어날 수 있다. **큰 type <- 작은type** : 자동 형변환 **작은 type <- 큰type**: 오류, 명시적 형변환(type casting)이 필요`


### 4. 자바 byte 메모리가 다음과 같다 했을때 해당되는 숫자는?  
<center>| 1 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | </center>

`-128 + 1 = 127  JVM이 음수를 표현하는 방식은 다음과 같다.왼쪽 첫번째 비트는 부호비트로, 1일때 -128에 나머지 7자리의 비트의 절대값을 더해줘서 음수를 연산하는 방식이다`






