package com.ssafy.ws.step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {
	static int R,T,C;
	static int[][] map;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int cleanerTop;
	static int cleanerBottom;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] RCT=br.readLine().split(" ");
		R=Integer.parseInt(RCT[0]);
		C=Integer.parseInt(RCT[1]);
		T=Integer.parseInt(RCT[2]);
		map=new int[R+1][C+1];
		StringTokenizer st;
		for (int i = 1; i <= R; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) { // 공기청정기의 윗방향 위치
					cleanerBottom=i;
				}
			}
		}
		cleanerTop=cleanerBottom-1;
		int answer=0;
		for (int i = 0; i < T; i++) {
			second();	
		}
		for (int j = 1; j <= R; j++) {
			for (int k = 1; k <= C; k++) {
				answer+=map[j][k];
			}
		}
		System.out.println(answer+2);// 공기청정기의 값은 -2이다.
	}
	
	/* 1초 */
	public static void second() {
		/*1.미세먼지 확산*/
		diffusion();
		/*2. 공기청정기 가동*/
		map=startCleaner(); 
	}
	
	public static void diffusion() {
		int[][] difMap=new int[R+1][C+1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <=C; j++) {
				if(map[i][j]!=0 && map[i][j]/5 > 0) { // 0이 아닐때, 5로 1 이상나누어질때 분배가능
//					System.out.println("확산기준 R: "+i+" C: "+j);
					int Arc=map[i][j]/5; // 확산되는 양
					int diffCount=0;
					for (int k = 0; k < dx.length; k++) { // 사방탐색
						if(j+dx[k]>0 && j+dx[k] <=C && i+dy[k] >0 && i+dy[k] <=R && map[i+dy[k]][j+dx[k]]!=-1) { 
//							System.out.println("확산할 곳 R: "+(i+dy[k])+" C: "+(j+dx[k]));
							//범위를 벗어나지않고, 공기청정기의 위치가 아닐때
							diffCount+=1;
							//미세먼지 확산시키기
							difMap[i+dy[k]][j+dx[k]]+=Arc;
						}
					}
					difMap[i][j] += (map[i][j]/5 * diffCount)*-1;
					//i,j 위치에는 빼질 미세먼지의 양을 대입
				}
			}
		}	
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <=C; j++) {
				map[i][j]+=difMap[i][j];
			}
		}
	}
	
	public static int[][] startCleaner() {
		int[][] newMap=arrCopy(map);
		newMap[cleanerTop][2]=0; // 바람이 처음나오는곳은 무조건 0
		for (int i = 3; i <= C; i++) { // 우측방향 바람진행(반대로복사)
			newMap[cleanerTop][i]=map[cleanerTop][i-1];
		}	
		for (int i = cleanerTop-1; i >0; i--) { // 우측위방향 바람진행(반대로복사)
			newMap[i][C]=map[i+1][C];
		}
		for (int i = C-1; i > 0; i--) { // 우측방향 바람진행(반대로복사)
			newMap[1][i]=map[1][i+1];
		}
		for (int i = 2; i < cleanerTop; i++) { // 우측방향 바람진행(반대로복사)
			newMap[i][1]=map[i-1][1];
		}
		newMap[cleanerBottom][2]=0;//바람이 처음나오는곳은 무조건 0
		for (int i = 3; i <= C; i++) { // 우측방향 바람진행(반대로복사)
			newMap[cleanerBottom][i]=map[cleanerBottom][i-1];
		}	
		for (int i = cleanerBottom+1; i <= R; i++) { //우측아래로 진행
			newMap[i][C]=map[i-1][C];
		}
		for (int i = C-1; i > 0; i--) { // 좌측방향 바람진행
			newMap[R][i]=map[R][i+1];
		}
		for (int i = cleanerBottom+1; i <R; i++) { // 좌측 윗방향 바람진행
			newMap[i][1]=map[i+1][1];
		}
		return newMap;
	}
	
	public static int[][] arrCopy(int [][] arr){
		int [][] newArr=new int[arr.length][arr[0].length];
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[i].length; j++) {
				newArr[i][j]=arr[i][j];
			}
		}
		return newArr;
	}
}
