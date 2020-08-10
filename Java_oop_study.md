 # OOP 란?
한글로 객체지향 프로그래밍. 
**데이터와 이를 처리하는 루틴을 하나의 독립된 객체로 동작하는 것을 지향하는 것을 말합니다.**

**절차지향 프로그래밍 언어의 대표격인 C와 뭐가 다른가?**  

기존 절차지향 프로그래밍은 C는 각 명령어의 작성을 실행 순서대로 합니다. 즉 ,위에서 아래로 일련의 실행 코드들이 작성되어 진다는 것입니다.  
하지만 OOP 언어를 사용한다면 아래와 같은 특징을 가지는 방식으로의 프로그래밍이 가능합니다.
<br/><br/>

### 1. OOP의 특징
- 추상화  
현실 세계에 존재하는 객체의 주요특징을 추출하는 것
- 캡슐화  
하나의 클래스 안에 데이터와 기능을 담아 정의하고, 중요한 데이터나 복잡한 기능등은 숨기고, 외부에서 사용에 필요한 기능만을 공개하는 것.
- 상속성  
객체를 정의할때 기존 존재하는 객체의 속성과 기능을 상속받아 더 발전된 형태로 정의하는것
- 다형성  
같은 타입 또는 같은 기능의 호출로 다양한 효과를 가져오는것. 예를 들면 오버라이딩,오버로딩 등이 있다.


Java는 Object Oriented Programming 을 지향하고 있습니다.
조금 더 좋은, 그리고 안전한 코드를 작성하기 위해서 이 OOP에 대한 이해가 충분하게 필요하고 이에 부합하는 다양한 코드 작성 패턴을 학습 해야한다고 생각합니다.
  


### 2. Class ? Object ?
Object - 시스템의 대상이 되는 모든 것.  
예를 들면 쇼핑몰 시스템에서, 상품/고객/주문 등등을 Object로 표현하게 됩니다.   
Object는 **구체적**인 표현 대상이 있습니다. 상품 Object는 쇼핑몰에서 판매하는 A상품,B상품 등을 표현 할 수있습니다.  
Class는 이런 Object를 분석해서 공통적인 내용들을 추상화 해서 Programming 언어로 표현한 것입니다. 


> OOP와 절차지향 프로그래밍의 근본적 차이점은, OOP는 현실세계의 Object를 분석해서 특정한 기준에 따라 Classification 하여 Class로 정의하고 이 Class 를 통해서 객체를 만들어내어 일련의 알고리즘을 진행하는 것이라 생각합니다.


### 3. Class는 어떻게 만들어야 할까요?
Class를 만들기 전에, Class만의 정적인 특성과 동적인 특성을 파악해야합니다.  
정적인 특성은 attribute, 동적인 특성을 behavior 라고 합니다.  
이러한 특성은 Class가 어떤 시스템에서 사용되느냐에 따라서 다르게 정의 될 수 있습니다.

만약 휴대폰 쇼핑몰에서 Galaxy Note라는 클래스를 만든다고 하면, [이름과 색상, 가격]은 정적 특성인 attribute가 될것이고 동적 특성에는 [개인에 맞게 할부원금을 계산하는 행위] 등 있겠습니다.

다른 예로, 만약 삼성에서 제조관리 시스템을 제작하기위해 똑같이 Galaxy Note라는 클래스를 만든다면 [시리얼넘버,재질,조립상태]등이 정적 특성으로 분류되어 질것이고, 동적 특성에는 [불량을 확인하는 행위]가 있겠습니다.

즉, 시스템의 의도나 목적에 따라 같은 현실객체를 정의한 클래스라도 다른형태로 나타날 수 있습니다.
그러니 이런 현실세계의 Object를 Class로 도출하는 과정이 아주 중요 하다고 볼 수 있겠습니다.


### 4. 아스날


### 5. 클래스 한눈에 알아보기
```java
public class Phone {
    public String name;
    public char color;
    public int price;
    public static double SWversion;

    public int getRealDebt(){ 
        return 10000;
    }
    public phone(){
        this.name="galaxy";
        this.color="black";
        this.price="1000";
        this.SWversion="1.0";
    }
}
```
휴대폰이라는 클래스는 이름, 색깔, 가격 그리고 SW 버전이라는 attribute를 가지고 있습니다. 그리고 getRealDebt라는 메소드도 가지고 있죠.  
**이중 static이 함께 선언된 SWversion** 은 무슨 의미일까요? 이를 알기위해서는 메모리 저장 영역에 대한 이야기가 필요합니다.

## - 메모리에는 어떻게 저장될까?
![메모리](./instance_memory.png)

> 함수코드는 Method Area에, Stack에는 런타임에 호출되어지는 메소드가, 실제로 선언과 호출에 의해 발생하는 메모리 할당은 heap에 객체 별로 독립적으로.

나는 이렇게 저장될것이라고 이해했다.
그렇다. Static으로 선언된 인스턴스는, method area라는 공용 메모리 공간에 저장되고, 다른 곳에서도 이 인스턴스에 접근이 가능하다.
>***인스턴스는 어떤 원본(추상적인 개념)으로부터 ‘생성된 복제본’을 의미합니다.***

클래스를 메모리에 올리기위해 new를 한다면 이 클래스는 소프트웨어적으로 인스턴스화 되었다고 볼 수 있고, new를 할때마다 힙에 각각의 메모리 공간을 할당받는다. 
**메모리 구조가 이렇게 되어있기 때문에 같은 클래스에서 생성된 인스턴스라도 값이 다를수 있다는 말이다.**



### 6. 배열을 array List처럼 자연스럽게 늘리는방법
java에서 배열은 메모리의 순서로 지정된 공간을 칭하고 index를 통해 메모리에 접근한다고 알려져있다. 하지만 이런 순차자료구조는 배열의 변경이나 삭제등에서 나타나는 오버헤드나 여타 다른 성능적인 불리함을 가지고있다 더 많은 기능을 가진 클래스로 List 클래스가 존재한다. (ArrayList,LinkedList 등)

ArrayList에서는  data 가 append 되었을때 메모리를 늘려주게 되는데.
이것은 Arrays.copyOf() 메소드가 이용된다. 이것을 구현 해보자.

ArrayList clone coding
1. 값을 넣을 공간이 있는지 확인한다.
2. 공간을 추가한 새로운 배열을 생성한다.
3. 기존 배열의 내용을 새롭게 생성한 배열로 복사한다.
4. 기존 배열을 가르키는 변수에 새로운 배열의 주소값을 입력한다.

```java
/*Movie 클래스*/
public class Movie {
    private String title;
	private String director;
	private int grade;
}
```

```java
/*영화를 담는 DAO 클래스인 MovieMgr*/
public class MovieMgr {
	private static MovieMgr INSTANCE;	
	private MovieMgr(){		
	}
	public static MovieMgr getInstance() {
		if(INSTANCE == null) {
			INSTANCE=new MovieMgr();
		}
		return INSTANCE;
	}
	private Movie[] movies = new Movie[100];
	// 데이터가 들어갈 위치와 입력된 데이터의 크기
	
	private int index;//
	/** 파라메터로 전달된 화 정보를 전달받아 배열에 저장한다. */
	public void add(Movie m) {		
		movies[index]=m;
		index++;
		
	}
}
```

MovieMgr 클래스는 movie 클래스를 저장할수있는 클래스이다.
내부적으로 배열을 가지고있고 add메서드를 실행할때 movies 배열에 movie 인스턴스를
저장 할 수 있다. 


```java
public void add(Movie m) {
		movies[index]=m;
		index++;	
	}
```
이렇게 만들어버린다면, index가 선언된 movies 배열의 크기이상으로 넘어갈때 error를 발생시킬것이다. 여기서 Arrays.copyOf() 메서드와 같이 구현을 한다면.

```java
public void add(Movie m) {	
		//1 .체크
		if (index == movies.length) {
			// 2. 기존 배열의 2배로 새로운 배열 생성(임의의 값으로 더 큰새로운 배열을 생성해도 된다.)
			Movie[] temp = new Movie[index*2]; //새로운 배열
			// 3. 기존 배열의 내용을 새로 만들어질 더 큰 공간의 빈 배열로 복사한다.
			for(int i=0; i<index*2 ;i++) {
				temp[i]= movies[i]; 
			}
			// 4.새롭게 생성된 배열의 주소값을 기본 변수에 대입한다.
			movies=temp;
		}
		movies[index]=m;
		index++;
	}
```


```java
public void add(Movie m) {	
		//1 .체크
		if (index == movies.length) {
			Arrays.copyOf(movies,index *2 );
		}
		movies[index]=m;
		index++;
	}
```

두개의 코드는 같은 결과를 얻을 수 있다.

이 테스트는 우리가 자연스럽게 쓰고있던 것들도 누군가 구현한 것 이라는것을 더 실감하게 되는 테스트인것 같다.. 앞으로 api라고 맨날 모르고 쓰지말고 어떻게 만들어졌는지도 확인해보면서 써야겠습니다.



### 7. 상속 
자바는 class 상속(extends) 를 통해 부모-자식 클래스 관계를 표현하며, 확장성을 제공한다고 볼 수 있습니다.

Java는 단일상속만 가능합니다. 즉
```java
class test extends super1,super2{
	
}
```
와 같은 코드를 실행시킨다면 에러가 발생하게됩니다.

> 다중 상속이 안되면 어떻게 여러가지 공통점들을 분리해낼 수 있나요?  

그것을 위해 java에서는 interface를 제공하고있습니다. 나중에 설명하도록 하겠습니다.

extneds와 implements의 차이는 의도의 차이라고 생각합니다. 

extends는 부모의 메소드를 그대로 사용하던가, 아니면 자신만의 메소드로 더 확장시켜서 어떤 확장의 의도를 가진 개념이고.  

implements는 메소드의 행위 자체를 인터페이스에서 구현하지않고 implements받은 클래스에서 구현되는것을 강조하여, 어떤 행위의 다양성을 부여하는 의도를 가지고 있다고 생각합니다.

#### Object 클래스
자바에서는 트리구조로 클래스들을 관리하는데 object 클래스는 모든 클래스의 root 가 되는 근본이 있는 클래스입니다.  
유저가 어떤 클래스를 생성할때에 직접 명시하지 않아도 컴파일러단에서 알아서 object class를 상속하게 됩니다.
우리는 그래서 toString을 오버라이딩 해서 사용할 수 있는 편안함을 느끼고있는 것이죠(출력시에 자동 형변환도 되고!). 

> 배열도 Object에 저장되어지지만 좀 특별한 경우가 있다.

```java
Object o = 123;
```
위와 같은 경우에는 어떻게 표시되어질까?   
123이라는 값은 상수 리터럴 이니까 객체가 아니라서 Object에 삽입하지 못할 것 같지만 , java 1.5버전부터 컴파일러단에서 다음과 같은 형태로 자동 변환해주어 가능해졌다고 한다
```java
Object o = Integer(123);
```

### 8.인터페이스
추상화의 꽃! 인터페이스입니다.
인터페이스는 **mathods의 추상화**한것이고 class와 독립적인 개념으로 interface라고 이름을 지었다고 합니다.

인터페이스는 관련된 methods 들을 "선언"만 할 수 있습니다. 구현의 책임은 interface를 implements 하는 클래스에게 전적으로 위임한 것입니다.

상속은 재사용에 초점이 맞추어져있고, 인터페이스는 어떤 규정이나 약속 이라는 느낌으로 생각하면 맞겠습니다.

예시를 들어보면.
즉 phone이라는 부모클래스의 자식클래스로 두개의 클래스를 만들었다고 생각해봅시다.
  
FolderblePhone과 nomalphone 두개 가장 큰 차이는 접히느냐?안접히느냐? 라는 차이가있습니다. 하지만 폰이라는 점은 같죠.

그렇게 했을때 가장 이상적인 상속관계는  

부모 Phone  
자식 folderblePhone,nomalPhone  
다음과 같아지겠습니다. 
여기서 부모 클래스에 phone에 접히는 기능을 추가해버린다면? nomalPhone도 접히는 메소드를 받아버리고, 이에 아무행동을 하지않는것으로 재정의를 해야되겠죠?

그래서 interface를 통해 접고,펼치는 행위를 만들어주어서 folderblePhone 클래스에 implements 를 해주어야 합니다.


#### 시나리오
A와 B는 I라는 같은행위를 가지고 있고, 이를 인터페이스로 정의하였습니다. 

A는 B의 전부를 원하는게아니라, 필요한 어떤 method의 수행을 원하고있습니다. 하지만 A는 그 사용하고싶은 method가 내부적으로 어떻게 구현 되어 있는지도 관심 없고 관심을 가져서도 안됩니다.  

B역시 A가 필요로 하는 모든것에 대해 자신의 method 의 모든것을 노출하고 싶지않고, 호출 방법과 결과에 대한 기본적인 사항만 공유되기를 바랍니다. 

이때 인터페이스를 사용하면 B는 자신의 code를 공개하지않고 A에게 메소드를 제공할 수 있습니다.


물론 인터페이스도 추상클래스를 통해 body를 구현할 수 있습니다. 
> java 8 버전부터 default 메소드가 추가되면서 기존에 추상 class를 통해 인터페이스의 바디를 구현했지만, 본래의 의미가 조금 퇴색되었다는 의견이 많고, 원래있던 추상 class의 역할도 애매해지게 되었습니다.


