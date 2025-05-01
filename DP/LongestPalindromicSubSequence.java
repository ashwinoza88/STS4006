package DP;

import java.util.Scanner;

public class LongestPalindromicSubSequence {
    public static int lcs(String s1,StringBuilder s2,int i,int j)
    {
        if(i<0 || j<0)
        {
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return 1+lcs(s1,s2,i-1,j-1);
        }
        return Math.max(lcs(s1,s2,i,j-1),lcs(s1,s2,i-1,j));
    }
    
    public static int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder(s);
        s2 = s2.reverse();
        int i = s.length()-1;
        int j = s.length()-1;
        return lcs(s,s2,i,j);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestPalindromeSubseq(str));
    }
}
