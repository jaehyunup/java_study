 # Algorithm 



### 1. 재귀함수(exclusive function)을 구현할때에는 다소 Flat하게 바라보아야 한다. 일정 부분에서 생각하고 파라미터에 의해 따라가기 보다는 현재 상황에서 처리를 할 수있게끔 생각하면 오히려 더 쉽게 다가 올 수 있음.

### 2. O(NlogN) 정도만 만들어도 꽤 괜찮은 알고리즘이라고 생각 해도 된다.

### 3. 재귀함수를 짤때는 중복호출을 유의해야 한다. 중복호출이 너무 많이 발생한다면 메모이제이션을 활용해보자 

메모이제이션- 이미 한 연산의 결과는 저장해두고 다음에 같은값이 필요할때 연산은 하지않고 값을 그대로 가져오는것. 연산 오버헤드를 줄일 수 있다.

```
fibo(n)
    if n<1 then
        return n;
    else return fibo(n-1) + fibo(n-2)
```
위 코드에서는 연산 중복이 많이 발생한다. 

메모이제이션을 통해 해결해보자.

n+1 만큼의 메모이제이션 배열을 할당하고, 여기 값을 저장하여 사용한다면? fibo(n)까지의 값을 저장할 수 있다. 

```
fibo(n)
    if n >= 2 and memo[n] is zero then
        memo[n] = fibo(n-1) + fibo(n-2);
    return memo[n];
end fibo()
```

작은 메모리공간을 사용해서 엄청난 효과를 누릴 수 있다.


### 4. 순열

##### 순열 예시| N개의 서로 다른 색깔의 공 중에 r개를 뽑아서 나열하는 경우의 수 

입력의 크기가 고정되어있는 순열일때 여러번의 작업이 필요하다면, 여러개의 순열을 사용하기보다는 인덱스를 통해 순열 테이블을 생성하면 단 1회만 순열연산을 해도 좋을 수 있다.

> 순열은 어떻게 만들어 내면 좋을까? 

```
#pseudocode
for i1 from 1 to 3
    for i2 from 1 to 3
        if i2 != i1 then
            for i3 from 1 to 3
                if i3!=i1 and i3!=i2 then
                    print i1,i2,i3
```

재귀 호출을 통한 순열 생성
```
pseudocode
numbers [] :순열 저장 배열
isSelected[] : 인덱스에 해당하는 숫자가 사용중인 지 아닌지 빠르게 판단하기위해.(중복체크)

```

numbers[] 가 필요한 이유 : 재귀 호출을 사용하기 때문에 이전에 뽑힌 수를 알 수 있도록 해야한다.

isSelected[] : 메모리 공간을 약간 더 쓰고 비교횟수를 줄인다는 마인드


재귀의 파라미터는 결정요인이 되는것이 일반적임.


### 5.Kruskal 알고리즘

정점과 간선이 주어졌을때, 최소비용신장 그래프를 만드는 알고리즘입니다. Greedy 를 기반으로 구성되었으며 정점수(V)-1 만큼의 연산을 통해 그래프에서 최소비용신장 그래프를 도출할 수 있습니다.
  

```java 
public class MST_kruskalTest {
		static class Edge implements Comparable<Edge>	{
			int from,to,weight;			
			public Edge(int from, int to,int weight) {
				super();
				this.from=from;
				this.to=to;
				this.weight=weight;
			}
			@Override
			public int compareTo(Edge o) {
				// TODO Auto-generated method stub
				return Integer.compare(this.weight, o.weight);
			}			
		}	
		static int V,E;
		static Edge[] edgeList;
		static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList=new Edge[E];
		parents =new int[V];				
		int from,to,weight;
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(in.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			edgeList[i] =new Edge(from,to,weight);
		}
		int answer=0;
		int cnt=0;
		Arrays.parallelSort(edgeList);
		for(int i=0;i<edgeList.length;i++) {
			if(unionSet(edgeList[i].from, edgeList[i].to)) {
				answer+=edgeList[i].weight;
				if(++cnt==V-1) break;
			}
		}
		System.out.println(answer);		
	}
	
	public void makeSet() {
		for(int i=0;i<V;i++) {
			parents[i]=i;
		}
	}
	public static int findSet(int x) {
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);
	}
	public static boolean unionSet(int x,int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if(xRoot == yRoot) return false;	
		parents[yRoot]=xRoot;
		return true;
	}
}
```

### 6. Greedy 알고리즘

- 최적해를 구하는 데 사용되는 근시안적인 방법.
- 여러 결정중 한 순간 마다 그순간에 최적이라고 생각되는 것을 선택해 나가는 방식으로 최종적 해답에 도달한다.
- 하지만 각 지역적인 결정에서는 최적이지만, 최종적 결과는 최적이라는 보장이 없다.
- 즉, 순간순간의 최고의 선택이 결과적으로 최적의 결과가 될 수 있다고 믿고 구현하는 것이다.
- 이를 확인하기 위해 반례를 잘 찾아야 한다

#### Knapsack(배낭 짐싸기) 문제
도둑은 부자들의 물건을 훔치기위해 창고에 침입해서 배낭에 담아올 계획이다.
배낭은 담을수 있는 물건의 총 무게 W 가 정해져있고, 물건들은 각각 무게와 값이 정해져있다.

도둑은 배낭이 수용 할 수 있는 무게를 초과하지 않으면서 값이 많이 나갈 수 있게끔 가방에 물건을 담아야한다. 어떻게 해야할까?
|   | 무게 | 값 |
|---|---|---|
|물건1|5kg|50만원|
|물건2|10kg|60만원|
|물건3|20kg|140만원|

1. 무게당 값이 가장 높은 순서로 담아본다?  

|   | 무게 | 값 | 값/kg|
|---|---|---|---|
|물건1|5kg|50만원|10만원/kg|
|물건2|10kg|60만원|6만원/kg|
|물건3|20kg|140만원|7만원/kg|

최적해를 구하기 어렵다. 

2. 가장 비싼 순서와 가장 싼 순서대로 담아본다?

이또한 최적해를 구하기 어렵다


그럼 어떻게 처리해야할까?

가방의 무게인 W의 무게를 넘지않는 모든 물건의 경우의 수를 찾아서 최적해의 후보를 뽑고 그중 가장 가치값이 최대인 방법을 선택한다. 

이런 상황에서는 greedy가 맞지 않지만, 만약 greedy의 조건이 맞아 떨어지는 상황이라면 짧지만 완전탐색보다 훨씬 더 효율적인 방법으로 사용 해볼 수 있다.

예를들어, 물건을 자를 수 있는 문제였다면 무게당 값을 재서 가장 최대로 비싼것부터 넣는다면 greedy의 조건이 충분히 적용되어 질 수 있다. 

즉, 반레를 찾아야 하고 최적해를 도출 할 수 있을것 같을때 사용해야한다.

그니까 머리좋은사람은 빨리찾는다 이말인가 --;; 슬픔

 #### 7. nextPermutation
사전순으로 정렬해서, 특정 값을 찾아낼때 자주 이용된다(7자리의 문자열 에서 4번째 자리가 5인 수중에 가장 큰수 구하기) 뭐 이런것들? 자리수가 너무많다면 완탐돌리기 부담이다. 이럴때 nextPermutation을 쓰면 좋다. 조합을 구현하는 방법중 하나지만 완전한 조합을 구할때는 재귀와 방문배열을 이용하여 구현하는것이 더 좋다.




### 8. BinalyCounting
비트를 이용해서 부분집합을 만들어 낼 수 있는 방법.

```java
import java.util.Scanner;

public class BinaryCountingTest {
	/* 비트를 이용해서 만들어내는 부분집합*/
	static int N;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i]=sc.nextInt();
		}
		int caseCount = 1 << N;
		generateSubset(caseCount);
	}
	
	private static void generateSubset(int caseCount) {
		for (int flag = 0; flag < caseCount; flag++) {
			// flag의 각 비트자리를 확인하여 원소 선택 유/무를 판단한다.
			for (int j = 0; j < N; j++) {
				if ((flag & (1<<j)) !=0) { // flag와 1을 j만큼 shift 한것이 0이 아니면? 같은 자리수에 해당한다는것이다.
					System.out.print(numbers[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
```

N의 개수만큼 1에서 left shift 한 값은 모든 부분집합의 개수와 같게 되는것을 기반으로 비트를 이용해 만들어진 알고리즘이다. 