package com.ssafy.hw.step14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class boj_14889_스타트와링크 {
	static int[][] map; 
	static int[] numbers;
	static boolean[] visited;
	static int N;
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		numbers=new int[N];
		visited=new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i]=i+1;
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 1; j <=N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		combi(N/2,0,0);
		System.out.println(answer);
	}
	public static void combi(int r,int count,int depth) {
		if(r==count) {
			List<Integer> teamS=new ArrayList<Integer>();
			List<Integer> teamL=new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				/*visited=true 는 스타트팀
				 *visited=false 는 링크팀*/
				if(visited[i]) {
					teamS.add(numbers[i]);
				}else {
					teamL.add(numbers[i]);
				}
				
			}
			int startScore=0;
			int linkScore=0;
			for (int i = 0; i < teamS.size(); i++) { 
				for (int j = i+1; j < teamS.size(); j++) {
					int startIJ=map[teamS.get(i)][teamS.get(j)];
					int startJI=map[teamS.get(j)][teamS.get(i)];
					startScore+=startIJ+startJI;
					int linkIJ=map[teamL.get(i)][teamL.get(j)];
					int linkJI=map[teamL.get(j)][teamL.get(i)];
					linkScore+=linkIJ+linkJI;
				}
				
				
			}
			/*스타트팀과 링크팀 사이의 능력치 차이 반환*/
			answer=Math.min(answer,Math.abs(startScore-linkScore));
			return ;
			
		}
		if(depth==N) { // N/2까지 depth가 통과한다면, 못뽑은거니 리턴
			return;
		}
		visited[depth]=true;
		combi(r,count+1,depth+1);
		visited[depth]=false;
		combi(r,count,depth+1);
	}
	
}
