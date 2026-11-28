import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<Integer, int[]> pos = new HashMap<>();
        pos.put(1, new int[]{0,0});
        pos.put(2, new int[]{0,1});
        pos.put(3, new int[]{0,2});
        pos.put(4, new int[]{1,0});
        pos.put(5, new int[]{1,1});
        pos.put(6, new int[]{1,2});
        pos.put(7, new int[]{2,0});
        pos.put(8, new int[]{2,1});
        pos.put(9, new int[]{2,2});
        pos.put(0, new int[]{3,1});
        
        int[] l = new int[]{3,0};
        int[] r = new int[]{3,2};
        
        for(int number : numbers){
            if (number == 1 || number == 4 || number == 7){
                answer+="L";
                l = pos.get(number);
            }
            else if (number == 3 || number == 6 || number == 9){
                answer+="R";
                r = pos.get(number);
            }
            else {
                int[] p = pos.get(number);
                int dl = Math.abs(l[0] - p[0]) + Math.abs(l[1] - p[1]);
                int dr = Math.abs(r[0] - p[0]) + Math.abs(r[1] - p[1]);
                if(dl>dr){
                    answer+="R";
                    r = pos.get(number);
                }
                else if(dr>dl){
                    answer+="L";
                    l = pos.get(number);
                }
                else{
                    if(hand.equals("right")){
                        answer+="R";
                        r = pos.get(number);
                    } else{
                        answer+="L";
                        l = pos.get(number);
                    }
                }
                
            }
        }
        
        return answer;
    }
}