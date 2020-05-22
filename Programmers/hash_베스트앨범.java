package Programmers;

import java.util.*;

public class hash_����Ʈ�ٹ� {
  public static int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> hm = new HashMap<String, Integer>();
    for(int i=0; i<genres.length; i++) {  // �帣�� ����� Ƚ���� ���
      hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
    }
    // ��������� ���� : �����
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(Integer num : hm.values()) {
      pq.add(num);
    }
    
    //��� �帣�� ����� Ƚ���� �ٸ��Ƿ� rankHash�� Key, Value�� �ٲ� HashMap ����
    HashMap<Integer, String> rankHashReverse = new HashMap<Integer, String>();
    for (String key : hm.keySet()) {
        rankHashReverse.put(hm.get(key), key);
    }

    String[] genresType = new String[pq.size()]; // ��������� ���� : �帣 
    int len=pq.size();
    for(int i=0; i<len; i++) {
      genresType[i]= rankHashReverse.get(pq.poll());
    }
    
    Map<String, PriorityQueue<Pair>> sortMap = new HashMap<String, PriorityQueue<Pair>>();
    for(int i=0; i<genres.length; i++) {
      if(!sortMap.containsKey(genres[i])) {
        sortMap.put(genres[i], new PriorityQueue<>());
      }
      sortMap.get(genres[i]).add(new Pair(i, plays[i]));
    }
    
    ArrayList<Integer> resultList = new ArrayList<>();
    for(int i=0; i<genresType.length; i++) {
      Pair tmp = sortMap.get(genresType[i]).poll();
      resultList.add(tmp.index);
      if(sortMap.get(genresType[i]).peek()!=null) {
        tmp=sortMap.get(genresType[i]).poll();
        resultList.add(tmp.index);
      }
    }
    int[] answer = new int[resultList.size()];
    for(int i=0; i<resultList.size(); i++) {
      answer[i]=resultList.get(i);
    }
    return answer;
  }
  
  public static class Pair implements Comparable<Pair>{
    int index,cnt;
    public Pair(int index, int cnt) {
      this.index=index;
      this.cnt=cnt;
    }
    @Override
    public int compareTo(Pair o) {
      if(cnt>o.cnt) {
        return -1;
      }
      else if(cnt==o.cnt) {
        if(index>o.index) {
          return 1;
        }else {
          return -1;
        }
      }
      else {
        return 1;
      }
    }
  }
  public static void main(String[] args) throws Exception{
    String[] genres= {"classic", "pop", "classic", "classic", "pop"};
    int[] plays= {500, 600, 150, 800, 2500};
    System.out.println(solution(genres, plays));
  }
}
