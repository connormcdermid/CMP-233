package org.mcdermid;

import java.util.Scanner;

public class Balancer {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("Please enter an algebraic expression.");
        String in = user.nextLine();
        boolean balanceBit = true;

        // break string into char array
        char[] expr = in.toCharArray();

        Stack<Token> tokenStack = new Stack<>();

        for (int i = 0; i < expr.length; i++) {
            switch(expr[i]) {
                case '(':
                    tokenStack.push(Token.PARENTHESES);
                    break;
                case '[':
                    tokenStack.push(Token.BRACKETS);
                    break;
                case '{':
                    tokenStack.push(Token.BRACES);
                    break;
                case '<':
                    tokenStack.push(Token.GUILLEMETS);
                    break;
                case ')':
                    try {
                        if (tokenStack.peek() == Token.PARENTHESES) {
                            tokenStack.pop();
                        } else {
                            System.out.printf("This expression is unbalanced at %d, you waste of space.%n", i);
                            balanceBit = false;
                        }
                    } catch (ListException e) {
                        System.out.printf("This expression is unbalanced at %d, you waste of space.%n", i);
                        balanceBit = false;
                    }
                    break;
                case ']':
                    try {
                        if (tokenStack.peek() == Token.BRACKETS) {
                            tokenStack.pop();
                        } else {
                            System.out.printf("This expression is unbalanced at %d, you meaty hulk%n", i);
                            balanceBit = false;
                        }
                    } catch (ListException e) {
                        System.out.printf("This expression is unbalanced at %d, you meaty hulk%n", i);
                        balanceBit = false;
                    }
                    break;
                case '}' :
                    try {
                        if (tokenStack.peek() == Token.BRACES) {
                            tokenStack.pop();
                        } else {
                            System.out.printf("This expression is unbalanced at %d, you meaty hulk%n", i);
                            balanceBit = false;
                        }
                    } catch (ListException e) {
                        System.out.printf("This expression is unbalanced at %d, you small grassy knoll%n", i);
                        balanceBit = false;
                    }
                    break;
                case '>':
                    try {
                        if (tokenStack.peek() == Token.GUILLEMETS) {
                            tokenStack.pop();
                        } else {
                            System.out.printf("This expression is unbalanced at %d, you meaty hulk%n", i);
                            balanceBit = false;
                        }
                    } catch (ListException e) {
                        System.out.printf("This expression is unbalanced at %d, you truncated decimal%n", i);
                        balanceBit = false;
                    }
            }
        }
        if (tokenStack.getHead() != null) {
            balanceBit = false;
            System.out.printf("This expression is imbalanced at %d %n", expr.length);
        }
        if (balanceBit) {
            System.out.println("This expression is balanced!");
        }
    }
}
