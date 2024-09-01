package com.practice.demo.coding.test;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        System.out.println(checkValidParanthesis("{(}()"));
    }

    public static int checkValidParanthesis(String s) {
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '}' : if (chars.pop() != '{') return i; break;
                case ')' : if (chars.pop() != '(') return i; break;
                case ']' : if (chars.pop() != '[') return i; break;
                default : chars.push(ch);
            }
        }

        return -1;
    }
}
