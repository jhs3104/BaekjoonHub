import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int H = park.length;
        int W = park[0].length();
        
        HashMap<String,int[]> move = new HashMap<>();
        move.put("E",new int[]{0,1});
        move.put("W",new int[]{0,-1});
        move.put("S",new int[]{1,0});
        move.put("N",new int[]{-1,0});
        
        int r= 0, c = 0;
        for (int i =0; i<H; i++){
            for(int j=0; j<W; j++){
                if (park[i].charAt(j) == 'S'){
                    r=i;
                    c=j;
                }
            }
        }
        
        for (String route : routes){
            String[] parts = route.split(" ");
            int[] dir = move.get(parts[0]);        
            int n = Integer.parseInt(parts[1]);
            int nr = r;
            int nc = c;
            
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                nr += dir[0];
                nc += dir[1];
                if (nr < 0 || nr >= H || nc < 0 || nc >= W || park[nr].charAt(nc) == 'X') {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                r = nr;
                c = nc;
            }
        }
        return new int[]{r, c};
    }
}