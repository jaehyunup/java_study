 # Data structure 



## 1.스택
####  스택의 특성  
- 물건을 쌓아올린듯 자료를 쌓아올린 형태의 자료구조이다.
- 스택에 저장된 자료는 선형 구조를 갖는다.  
- 후입선출구조 LIFO(후입선출)
  - 마지막에 삽입한 자료를 가장 먼저 꺼내는 방식

#### 연산은 어떻게 할까요?
API name = Java.util.Stack 
- 삽입  
stack.push(item)
- 삭제  
stack.pop()
- 공백확인  
stack.isEmpty()
- 최상위원소 확인  
stack.peek()

peek()과 pop()의 차이는 실제로 스택에서 직접 꺼내느냐? 아니면 스택의 가장 위쪽 부분(top)에 해당하는 원소를 꺼내지 않고 들여다 보느냐의 차이이다. 

#### 어떤곳에 사용해야할까요?
가장 대표적인 알고리즘 문제로는 괄호 검사이다.

[{((,()))}]  이런 String 이 들어왔을때 괄호가 잘 닫혔있는지,or 닫히지 않은 괄호가 있는지 확인할때 stack을 이용하면 될것입니다.


### 스택은 Function call 에 사용되어 집니다
프로그램에서의 함수 호출과 복귀에 따른 수행 순서를 관리하기위해 Stack을 이용합니다. ex) JVM Stacks

### 스택 사용해보기

#### 1. 인터넷 브라우저 시뮬레이터 만들어보기
- 스택을 활용하여 뒤로가기 버튼,앞으로 가기 버튼이 있는 인터넷 브라우저를 만들어 봅시다.   

> 앞으로 가는 history와 뒤로가는 history를 위해 두개의 스택 구현이 필요함.



## 2. 큐

#### 큐의 특성
큐는 선입선출 구조로 구성되어있다. 즉 대기열과 같이 먼저 기다린 사람이 먼저 나가는 구조로 구성된다. 

#### 연산은 어떻게 할까요?

##### 큐는 필요한 연산을 선언해둔 컬렉션 클래스를 이용할 수 도 있고,큐 인터페이스에 넣어서 사용할 수 있습니다.

Java api =java.util.Queue()

- 생성
  - Queue::offer(item) 큐의 뒤쪽에 원소삽입  
- 원소 빼내기(Front에서 원소를 빼내기)
  - Queue::poll()
- 큐 생성하기
  - Queue::createQueue()
- 큐 크기 확인
  - Queue::size()
- 큐 원소 존재 여부 확인
  - Queue::isEmpty()


#### 큐를 선언해봅시다.
```java
//첫번쨰 방식
LinkedList<String> queue2= new LinkedList<String>;
System.out.println(queue.size()+"//"+queue.isEmpty());
queue.offer("1");
System.out.println(queue.size()+"//"+queue.isEmpty());


//두번째 방식
Queue<Integer> queue2=new LinkedList<>();
System.out.println(queue.size()+"//"+queue.isEmpty());
queue.offer(1);
System.out.println(queue.size()+"//"+queue.isEmpty());
```
첫번째 방식과 두번째 방식은 뭐가 다를까요?  
첫번째 방식과 다르게 두번째 방식은 제너릭타입으로 선언된 Queue 인터페이스에 LinkedList 를 넣어 이용합니다.  

객체지향언어의 장점인 다형성과 관련된 얘기인데, LinkedList에 Queue에 필요한 메서드들이 구현되어있긴 하지만! 인스턴스의 의도가 큐를 사용하기위함 이기 때문에. 
 의도에 맞게끔 사용할 수 있게끔 제너릭타입 인터페이스를 이용하여 용도를 제한한다고 생각하면 쉽겠습니다.

즉, Linkedlist에는 큐에서 사용되는 offer,poll 메서드도 있지만 이외에도 offerlast,offerfirst와 같은 다양한 메서드들이 있고, 이는 dequeue 라는 자료구조에서 이용되어집니다.

우리는 Queue를 쓰는데 이런 메서드들에 대한 요구가 없습니다.
그렇기 때문에 이를 이용할 수 없게 제한 해야한다는 것입니다. 
> 한줄요약 : Queue 를 만들었으면 Queue에 맞게끔 쓰기위해 Queue 인터페이스를 이용해야 올바른 코딩 방법이다.

```java
package com.ssafy.live03;

import java.util.LinkedList;
import java.util.Queue;

public class myChu {
	public static void main(String[] args) {
		// 마이쮸 나눠주기 시뮬레이션
//		1번이 한개의 마이쮸를 받는다
//		1번이 다시 줄을 선다
//		2번이 줄을 선다
//		1번이 두개의 마이쮸를 받는다
//		1번이 다시 줄을 선다
//		3번이 들어와 줄을 선다
//		2번이 한개의 마이쮸를 받는다
//		2번이 다시 줄을 선다
//		4번이 들어와 줄을 선다
//		1번이 세개의 마이쮸를받는다
//		1번이 다시줄을 선다
//		5번이 줄을 선다
//		3번이 한개의 마이쮸를 받는다
//			.
//			.
//			.
//		마이쮸가 20개있을때 마지막것을 누가 가져갈까?
		int item=20;
		int person=1;
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.offer(new int[] {person,1});
		while(item > 0) {
			System.out.println(queue.toString());
			if(!queue.isEmpty()){
				int[] p=queue.poll();
				int avaliableCnt= (item >= p[1] )?p[1]:item;
				item -=avaliableCnt;
				if(item==0) {
					System.out.println("마지막 마이쭈 당첨자 : "+p[0]+"가져간개수: "+avaliableCnt);
					break;
				}else {
					++p[1];
					queue.offer(p);
					queue.offer(new int[] {++person,1});
				}
			}
		}
		
	}
}

```



### 3.우선순위 큐 (Priority Queue)

- 우선순위와 함께 원소들을 저장하는 큐
- FIFO 순서가 아니라 우선순위가 높은 순서대로 먼저 나가게 된다.
- Heap(Tree) 자료구조를 이용해 만들어짐
  - 최대힙을 사용하냐,최소힙을 사용하냐에 따라 출력을 먼저 할 우선순위가 큰지 작은지 결정 해줄 수 있다.

  