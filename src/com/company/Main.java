package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter Size of String");
        int n = sc.nextInt();
        System.out.println("Enter First Sample String");
        sc.nextLine();
        String s1 = sc.nextLine().toUpperCase();
        char[] c1 = s1.toCharArray();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push((int)c1[i]);
        }
        System.out.println("Enter Second Second String");
        String s2 = sc.nextLine().toUpperCase();
        char[] c2 = s2.toCharArray();
        for(int i=0;i<n;i++){
            st.push((int)c2[i]);
            st.add(i,st.get(i+n)-st.get(i));
            st.remove(i+1);
        }
        System.out.println("Enter Question String");
        String test = sc.nextLine().toUpperCase();
        char[] tes = test.toCharArray();
        for(int i=0;i<n;i++){
            st.remove(n);
            st.push((int)tes[i]);
            if(st.get(n+n-1)+st.get(i)<65){
               int remain = 65-(st.get(n+n-1)+st.get(i));
               if(remain<0){
                   remain = -remain;
               }
               st.add(i,91-remain);
            }
            else if(st.get(n+n-1)+st.get(i)>90){
                int remain = (st.get(n+n-1)+st.get(i)) - 90;
                if(remain<0){
                    remain = -remain;
                }
                st.add(i,64+remain);
            }
            else {
                st.add(i, st.get(n + n - 1) + st.get(i));
            }
            st.remove(i+1);
        }
        char[] res = new char[n];
        for(int i=0;i<n;i++) {
            int temp = st.get(i);
            res[i] = (char)temp;
        }
        System.out.println(res);
    }
}
