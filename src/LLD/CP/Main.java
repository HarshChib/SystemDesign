

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int upper__bound(long[] arr,int low, int high, long target){int n = arr.length;int mid = 0;while (low < high && low != n){mid = low + (high - low) / 2;if(target >= arr[mid]) {low = mid + 1;} else {high = mid;}}return low;}
    public static int lower__bound(long[] arr, int low, int high, long key) {int mid;while (low < high) {mid = low + (high - low) / 2;if (key <= arr[mid]) {high = mid;} else {low = mid + 1;}}if (low < arr.length && arr[low] < key) {low++;}return low;}
    public static int upper__boundL(int[] arr,int low, int high, long target){int n = arr.length;int mid = 0;while (low < high && low != n){mid = low + (high - low) / 2;if(target >= arr[mid]) {low = mid + 1;} else {high = mid;}}return low;}
    public static int lower__boundL(int[] arr, int low, int high, long key) {int mid;while (low < high) {mid = low + (high - low) / 2;if (key <= arr[mid]) {high = mid;} else {low = mid + 1;}}if (low < arr.length && arr[low] < key) {low++;}return low;}


    public static void sort(int[] a, Comparator<Integer> cmp) {
        int n = a.length;
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) arr[i] = a[i];
        Arrays.sort(arr, cmp);
        for(int i = 0; i < n; i++) a[i] = arr[i];}
    public static void sort(long[] a, Comparator<Long> cmp) {
        int n = a.length;
        Long[] arr = new Long[n];
        for(int i = 0; i < n; i++) arr[i] = a[i];
        Arrays.sort(arr, cmp);
        for(int i = 0; i < n; i++) a[i] = arr[i];}

    public static boolean check_pow_2(long n){long t= n&(n-1);if(t==0&&n!=0){return true;}return false;}
    public static long countUnsetBits(long n) {long x = n;n |= n >> 1;n |= n >> 2;n |= n >> 4;n |= n >> 8;n |= n >> 16;return Integer.bitCount((int) (x^ n));}
    public static long countSetBits(long n) {long count = 0;while (n > 0) {n &= (n - 1);count++;}return count;}

    public static boolean chekstringsubsq(String str,String ans){String tmp="";int l=0;for(int i=0;i<str.length()&&l<ans.length();i++){if(str.charAt(i)==ans.charAt(l)){tmp+= ans.charAt(l);l++;}}if(ans.equals(tmp))return false;return true;}
    public static long gcdec(long a, long b, long[] x, long[] y) {if (b == 0) {x[0] = 1;y[0] = 0;return a;}long[] x1 = new long[1];long[] y1 = new long[1];long d = gcdec(b, a % b, x1, y1);x[0] = y1[0];y[0] = x1[0] - y1[0] * (a / b);return d;}
    public static void coprime_1_to_n(long n) {long[] phi = new long[(int) (n+1)];for (long i = 0; i <= n; i++) phi[(int) i] = i;for (long i = 2; i <= n; i++) {if (phi[(int)i] == i) {for (long j = i; j <= n; j += i) phi[(int)j] -= phi[(int)j] / i;}}}
    public static long base_2log(long N) {long result = (int)(Math.log(N) / Math.log(2));return result;}
    public static void shuffleArray(int[] array) {int index;Random random = new Random();for (int i = array.length - 1; i > 0; i--) {index = random.nextInt(i + 1);if (index != i) {array[index] ^= array[i];array[i] ^= array[index];array[index] ^= array[i];}}}
    public static long subarrayXor(int[] arr, int n, long m) {HashMap<Long, Integer> HashTable = new HashMap<>();HashTable.put(0L, 1);int count = 0;long curSum = 0;for (int i = 0; i < n; i++) {curSum ^= arr[i];if (HashTable.containsKey(curSum ^ m)) count += HashTable.get(curSum ^ m);if (!HashTable.containsKey(curSum)) HashTable.put(curSum, 0);HashTable.put(curSum, HashTable.get(curSum) + 1);}return (count);}
    public static void reverseArray(int[] a) {int n = a.length;int arr[] = new int[n];for (int i = 0; i < n; i++) arr[i] = a[n - i - 1];for (int i = 0; i < n; i++) a[i] = arr[i];}
    public static void reverseArray(long[] a) {int n = a.length;long arr[] = new long[n];for (int i = 0; i < n; i++) arr[i] = a[n - i - 1];for (int i = 0; i < n; i++) a[i] = arr[i];}
    public static long sumOfMaximumOfSubsets(Long[] arr, int N,long mm) {Arrays.sort(arr, Collections.reverseOrder());long sum = arr[0]%=mm;for (int i = 1; i < N; i++) {sum = 2 * sum + arr[i];sum%=mm;}return sum%=mm;}
    public static long AndOperator_RANGE(long x, long y) {for (int i = 0; i < (Math.log(y) / Math.log(2)) + 1; i++) {if (y <= x) {return y;}if ((y & (1L << i)) != 0) {y &= ~(1L << i);}}return y;}
    private static List<Integer> getAllFactors(int num){List<Integer> list = new ArrayList<>(num);for (int i = 1; i * i <= num; ++i) {if (num % i != 0) continue;list.add(i);if (i*i < num) list.add(num / i);}Collections.sort(list);return list;}
    static long[] facts, factInvs;
    static long add(long a, long b,long Mod) {return (a+b)%Mod;}
    static long mul(long a, long b,long Mod) {return a*b%Mod;}
    static long nCk(int n, int k,long Mod) {return mul(facts[n], mul(factInvs[k], factInvs[n-k],Mod),Mod);}

    public static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    private static final int[][] directions = {{-1,+1},{-1,-1},{+1,+1},{+1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().split(" ")[0]);
//        int t = 1;
        while (t--> 0) {
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            String[] line3 = br.readLine().split(" ");
            long n = Long.parseLong(line1[0]);
            long q = Long.parseLong(line1[1]);
//            List<List<Integer>> list = new ArrayList<>();
//            for(int i = 0; i < 4; i++) {
//                List<Integer> temp = new ArrayList<>();
//                String[] line = br.readLine().split(" ");
//                for(int j = 0; j < line.length; j++) {
//                    temp.add(Integer.parseInt(line[j]));
//                }
//                list.add(temp);
//            }
            int[] arr = new int[(int)n];
            for (int i = 0; i < n; i++) {
                arr[i]=Integer.parseInt(line2[i]);;
            }
            int[] qry = new int[(int)q];
            for (int i = 0; i < q; i++) {
                qry[i]=Integer.parseInt(line3[i]);;
            }
//            int[] arr2 = new int[(int)n];
//            for (int i = 0; i < n; i++) {
//                arr2[i]=Integer.parseInt(line3[i]);
//            }

//            int[][] arr = new int[(int) n][(int) m];
//            for (int i = 0; i < n; i++) {
//                String[] line = br.readLine().split(" ");
//                for (int j = 0; j < m; j++) {
//                    arr[i][j]=Integer.parseInt(line[j]);
//                }
//            }
            solve(arr, qry, (int)n );
        }
    }

    private static void solve(int[] arr, int[] qry, int n) {
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(qry);
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0)
                q.add(new int[]{arr[i],i});
        }
        for(int i : qry) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] temp = q.poll();
                if(temp[0] % Math.pow(2,i)==0) {
                    q.add(new int[]{(int) (temp[0]+Math.pow(2,i-1)),temp[1]});
                }else {
                    q.add(new int[]{temp[0], temp[1]});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            arr[temp[1]] = temp[0];
        }
        printArray(arr);
    }



    public static Integer floor(int[] arr, int left, int right, long target) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }


    private static boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    public static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private static int xorOfFirstN(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else { // n % 4 == 3
            return 0;
        }
    }

    private static final Comparator<Pair<Integer, Integer>> pairComparator = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            // Compare first values in descending order
            int cmp = Integer.compare(p2.getSecond(), p1.getSecond());
            if (cmp != 0) {
                return cmp;
            }
            // If first values are equal, compare second values in ascending order
            return Integer.compare(p2.getSecond(), p1.getSecond());
        }
    };



    public static int findKthMinimum(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void relativeSort(int[] firstArray, int[] secondArray) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            list.add(new int[]{firstArray[i], secondArray[i]});
        }
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < list.size(); i++) {
            int[] pair = list.get(i);
            firstArray[i] = pair[0];
            secondArray[i] = pair[1];
        }
    }
    public static long roundUp(long a, long b) {
        return (a + b - 1) / b;
    }



    public static boolean isPrime(long number) {
        // Handle the edge cases
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // Check from 5 to sqrt(number) for factors
        long sqrt = (long) Math.sqrt(number);
        for (long i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static long gcd(long a, long b) {
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }


    private static long summation(int[] arr) {
        long sum = 0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }


    private static long summation(long start , long end){
        long n = (end - start +1);
        return (n* (start+end))/2;
    }


    private static void printArray(int[] arr) {
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static <T> T[] createArray(Class<T> type, int size) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(type, size);
        return array;
    }



    private static void countSort(int[] arr){
        int i =0;
        int n = arr.length;
        while(i<n) {
            int pos = arr[i]-1;
            if(arr[pos]!=arr[i]){
                swap(arr,i,pos);
            }else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j]= temp;
    }





    public static String printYes(){
        return "YES";
    }

    public static String printNo(){
        return "NO";
    }

}
