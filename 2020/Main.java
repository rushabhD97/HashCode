/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        {   try{
            br = new BufferedReader(new
                     FileReader(new File("D:\\Competitive Programming\\HashCode\\c_medium.in"))); 
            }catch(Exception e){
                System.out.println(e);
            }
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static int max=0;
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader sc=new FastReader();
		int m=sc.nextInt();
        int n=sc.nextInt();
		
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		c(arr,n,1,arr[0],m);
		c(arr,n,1,0,m);
		System.out.println(max);

	}
	static void c(int[] arr,int n,int currIndex,int currSum,int target){
	    if(currSum>target)
	        return;
	    if(currIndex==n){
	        max=Math.max(max,currSum);
	        return;
	    }
	        
	    c(arr,n,currIndex+1,currSum+arr[currIndex],target);
	    c(arr,n,currIndex+1,currSum,target);
	    
	    
	}
	
	
}
