/**
 * @author Maddy
 * Ver 1.0 Oct 17, 2017 10:27:04 PM
 * Given an array of integers and an integer k, design an algorithm to find all pairs of integers
 * within the array which sum to k.
 * Ex:
 * I/P: [1,1,1,1], 2
 * O/P: 6
 */

package crackTheCode.Ch_16_Moderate;

import java.util.Arrays;

public class PairsWithSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 1, 1 };
		int k = 2;
		System.out.println(countPairs(a, k));

	}

	/**
	 * @param a
	 * @param k
	 * @return count
	 */
	private static int countPairs(int[] a, int k) {
		Arrays.sort(a);
        int low =0,high= a.length-1;
        int count=0;
        while(low<high){
            int sum = a[low] + a[high];
            if(sum == k){
                int t1=0, t2=0;
                while(low < high && a[low+1] == a[low]){
                    low++;
                    t1++;
                }
                while(high > low && a[high-1] == a[high]){
                   t2++;
                   high--;
                }
                if(low == high && (a[low] + a[high] == k) && (a[low ] == a[high])){
                    t1++;
                    count += t1*(t1-1)/2;                    
                }
                else{
                    t1++; t2++;
                    low++; high--;
                    count += t1*t2;
                }
            } else if( sum > k){
                high--;
            } else {
                low++;
            }
        }
        
        return count;
	}

}
