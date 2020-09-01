package com.ssafy.ws.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_1753_최단경로 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int V,E;
	static int[] D;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		String[] VE=br.readLine().split(" ");
		V=Integer.parseInt(VE[0]);
		E=Integer.parseInt(VE[1]);
		List<Node>[] graph=new ArrayList[V+1];
		int K=Integer.parseInt(br.readLine()); // 시작 정점 번호 
		D=new int[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		visited=new boolean[V+1];
		// ArrayList 0 초기화
		for (int i = 1; i < V+1; i++) {
			graph[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int[] uvw=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph[uvw[0]].add(new Node(uvw[1],uvw[2]));
		}
		
		D[K]=0; // 거리 배열의 K번째는 자기자신이기 때문에 0으로 변경
		for (int i = 1; i < V; i++) {
			/*가장 짧은 거리를 가진 ,가지않은 D배열의 인덱스값 찾기*/ 
			int min = Integer.MAX_VALUE;
			int index =-1;
			for (int j = 1; j < V+1; j++) {
				// 아직 처리하지않고, 가장 짧은 거리라면?
				if(!visited[j] && min >D[j]) {
					min=D[j];
					index=j;
				}
			}
			/*갈수있는길이 없다면? 종료하기*/
			if(index==-1) {
				break;
			}
			/*하나의 정점을 찾고나서, 그 다음 정점을 찾기전 갈수있는 값들의 가중치를 update 해준다*/
			for(Node node:graph[index]) { // 현재 정점에서 갈수있는 정점들의 모든 집합에 대해서
				// 선택된 간선이 아니여야하고
				// 현재 간선과 갈 간선의 합이 최소값이라면
				if(!visited[node.NUM] && D[node.NUM] > D[index]+node.W) {
					// 해당 간선 도착까지의 최소값 갱신한다
					D[node.NUM] = D[index]+node.W;
				}
			}
			visited[index]=true; // 해당 간선을 방문한것으로 변경
		}
		for (int i = 1; i < V+1; i++) {
			if(D[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else {
				System.out.println(D[i]);
			}
		}
		
	}
	static class Node {
		public int NUM;
		public int W;
		public Node(int num,int W) {
			this.NUM=num;
			this.W=W;
		}
		public Node() {}
	}
}
