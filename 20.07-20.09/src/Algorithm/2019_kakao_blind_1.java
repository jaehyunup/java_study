import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map=new HashMap<String,String>();
        Queue<String> q=new LinkedList<String>();
        List<String> a=new ArrayList<String>();
        String[] answer = {};
        for(int i=0;i<record.length;i++){
            String[] com=record[i].split(" ");
            /*닉네임이 바뀐다 ? - 나갔다 새로운 닉네임으로 다시 참여한다.issue=> uid를 이용한 닉네임관리*/
            /*                  - 채팅방에서 닉네임을 변경한다.issue=> 닉네임 변경하면 이전에 채팅에 영향이 옴.큐를 이용 
                결론 : 큐를 이용해 uid로 메시지를 생성하고, 마지막에 uid에 해당하는 값으로 변경해주는 연산이 필요
                큐는 O(N)연산이기 때문에 N이 100,000이더라도 큰 오버헤드가 없을것이라고 생각
            */
            if(com.length==2){ // 명령어 개수가 2개일때는 Leave 밖에없음.
                q.offer(com[1]+"님이 나갔습니다.");
                continue;
            }
            switch(com[0]){
                case "Enter": // 입장시
                    map.put(com[1],com[2]); //UID에 해당하는 닉네임 값을 변경하고
                    q.offer(com[1]+"님이 들어왔습니다.");
                    break;
                case "Change":// 닉네임변경시
                    map.put(com[1],com[2]); // uid값에 해당하는 닉네임을 업데이트한다.
                    break;
                default:
                    break;
            }
        } 
        int qsize=q.size();
            for(int j=0;j<qsize;j++){
                String[] fullText=q.poll().split("님");    //큐값을 뺴내고
                String curNick=map.get(fullText[0]); //UID에 해당하는 닉네임 가져오기
                String posifixText=fullText[1]; // 뒤에 붙을 텍스트(님 추가 해주어야함)
                String originText=new StringBuilder(curNick).append("님").append(posifixText).toString();
                a.add(curNick+"님"+posifixText);
            }
            answer=a.toArray(new String[a.size()]);
        return answer;
    }
}