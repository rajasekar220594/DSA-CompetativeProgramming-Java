

public class Test {
	public static void main(String[] args) {
		int arr[] = {1,1,2,2};
		shuffleUsingShift(arr, 2);
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
