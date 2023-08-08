import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		
		String s1 = "ravi", s2 = "vira";
		
		//int arr[] = {1,1,2,2};
		//shuffleUsingShift(arr, 2);
//		int arr[][] = {{0,0,0,0,0,0,0,0},{0,0,1,1,1,0,0,0},{0,1,0,1,0,0,0,0},
//					   {0,1,1,0,1,1,0,0},{0,1,0,1,0,1,0,0},{0,0,0,1,1,0,1,1},
//					   {0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0}};
		
		int arr[][] = {{0,1,1,1,0,0,0},{1,0,1,0,0,0,0}, {1,1,0,1,1,0,0},
				       {1,0,1,0,1,0,0},{0,0,1,1,0,1,1}, {0,0,0,0,1,0,0},
				       {0,0,0,0,1,0,0}};
		//bfs(arr, 4, 7);
		
		System.out.println(isAnagram("anagram test", "nagaram estt"));
	}
	
	public static boolean isAnagram(String s, String t) {
		if(s == t) return true;
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        
        TreeMap<Character, Integer> hash1 = new TreeMap<>();
        TreeMap<Character, Integer> hash2 = new TreeMap<>();
        for(int i=0; i<s.length(); i++) {
        	Character ch1 = s.charAt(i);
        	Character ch2 = t.charAt(i);
        	if(hash1.containsKey(ch1)) {
        		hash1.put(ch1, hash1.get(ch1)+1);
        	} else {
        		hash1.put(ch1, 1);
        	}
        	
        	if(hash2.containsKey(ch2)) {
        		hash2.put(ch2, hash2.get(ch2)+1);
        	} else {
        		hash2.put(ch2, 1);
        	}
        }
        System.out.println(hash1.equals(hash2));
        return false;
    }
	
	public static int factorial(int n) {
		int result = 1;
		if(n==1) {
			return 1;
		} else {
			result = n*factorial(n-1);
		}
		return result;
	}
	public static void bfs(int[][] arr, int start, int n) {
		int i=start,j;
		int visited[] = new int[n];
		
		System.out.print(i);
		visited[i] = 1;
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		
		while(!queue.isEmpty()) {
			i=queue.poll();
			for(j=0; j<n; j++) {
				if(arr[i][j] == 1 && visited[j] == 0) {
					System.out.print(j);
					visited[j] = 1;
					queue.add(j);
				}
			}
		}
	}
	
	public static void dfs(int[][] arr) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) return image;
		fill(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public static void fill(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
		image[sr][sc] = newColor;
		fill(image, sr + 1, sc, color, newColor);
		fill(image, sr - 1, sc, color, newColor);
		fill(image, sr, sc + 1, color, newColor);
		fill(image, sr, sc - 1, color, newColor);
	}
	    
	public static void floodFill1(int[][] image, int sr, int sc, int color) {
		Deque<String> queue = new LinkedList<>();
		Map<String, Integer> hash = new HashMap<>();
		hash.put(String.valueOf(sr+","+sc), null);
		queue.addFirst(String.valueOf(sr+","+sc));

		while(!queue.isEmpty()) {
			String[] returnValue = queue.removeFirst().split(",");
			int srTemp = Integer.valueOf(returnValue[0]);
			int scTemp = Integer.valueOf(returnValue[1]);
			if(srTemp < 0 || srTemp > 2 || scTemp < 0 || scTemp > 2) {
				continue;
			}
			if(image[srTemp][scTemp] == 1) {
				image[srTemp][scTemp] = 2;
			}
			if(!hash.containsKey(String.valueOf(srTemp+","+(scTemp-1)))) {
				queue.addLast(String.valueOf(srTemp+","+(scTemp-1)));
				hash.put(String.valueOf(srTemp+","+(scTemp-1)), null);
			}
			if(!hash.containsKey(String.valueOf(srTemp+","+(scTemp+1)))) {
				queue.addLast(String.valueOf(srTemp+","+(scTemp+1)));
				hash.put(String.valueOf(srTemp+","+(scTemp+1)), null);
			}

			if(!hash.containsKey(String.valueOf((srTemp-1)+","+scTemp))) {
				queue.addLast(String.valueOf((srTemp-1)+","+scTemp));
				hash.put(String.valueOf((srTemp-1)+","+scTemp), null);
			}
			if(!hash.containsKey(String.valueOf((srTemp+1)+","+scTemp))) {
				queue.addLast(String.valueOf((srTemp+1)+","+scTemp));
				hash.put(String.valueOf((srTemp+1)+","+scTemp), null);
			}

		}
	}
	
	public static int[] shuffleUsingNewArray(int[] nums, int n) {
        int res[] = new int[n*2]; // new int[nums.length];
        int x=0, y=n;
        for(int i=0; i < res.length; i = i+2) {
        	res[i] = nums[x++];
        	res[i+1] = nums[y++];
        }
        return res;
    }
	
	public static int[] shuffleUsingShift(int[] nums, int n) {
		int y=n, x=1, temp, t;
		while(x<y) {
			temp=nums[x];
			nums[x++] = nums[y];
			t=y;
			while(x<t) {
				nums[t] = nums[t-1];
				t--;
			}
			nums[x++] = temp;
			y++;
		}
		return nums;
	}
}
