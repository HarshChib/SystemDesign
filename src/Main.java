import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s = "gfg";
         dist(s, s.length()-1, "");
    }
    static int dist(String s, int i, String temp){
        if(i<0)return 0;
        int count = 1;
        Set<Character> set = new HashSet<>();
        for(int x=i; x >= 0; x--){
            if(!set.contains(s.charAt(x))){
                set.add(s.charAt(x));
                count += dist(s,x-1 , s.charAt(x)+temp);
            }
        }
        return count;
    }
    public static int countPartitions(int n, int diff, int arr[]){
        int sum =0;
        for(int i:arr)sum+=i;
        if(sum-diff < 0 || (sum-diff)%2 !=0) return 0;
        int target = (sum - diff)/2;
        int[][] dp = new int[n][target+1];
        if(arr[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }
        if(arr[0]!=0 && arr[0] <= target){
            dp[0][arr[0]] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int pick = 0;
                if(j-arr[i] >= 0){
                    pick = dp[i-1][j-arr[i]];
                }
                int notPick = dp[i-1][arr[i]];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }
}