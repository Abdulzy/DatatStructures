/** 
 * So far, the infixExpressionEvaluator can convert an infix math expression to postfix.
 * It only works with infix expressions padded with spaces everywhere except the beginning and end.
 */

/**
 * @author Austin
 */

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class InfixExpressionEvaluator {
    
    public static void checkBalance(String infixExpr) {
        Stack parens = new Stack<>();
        StringTokenizer st = new StringTokenizer(infixExpr);
        String c;
        while(st.hasMoreTokens()) {
            c = st.nextToken();
            switch(c) {
                case "(":
                    parens.push(c);
                case ")":
                    try {
                        parens.pop();
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(e);
                    }
                default: //do nothing
            }
        }
        if(!parens.empty())
            throw new IllegalArgumentException("bad parens");
    }
    
    /** Returns a postfix algebraic expression from an infix one.
     *  @param infixExpr
     *  @return String
     */
    public static String infixToPostfix(String infixExpr) {
        String postfixExpr = "";
        Object poppedToken;
        Stack operators = new Stack<>();
        StringTokenizer st = new StringTokenizer(infixExpr);
        String c;
        while(st.hasMoreTokens()) {
            c = st.nextToken();
            switch (c) {
                case "(":
                case "+":
                case "-":
                case "^":
                case "*":
                case "/":
                case "%":
                    operators.push(c);
                    break;
                case ")":
                    /** This loop pops all tokens until it reaches a left hand parenthesis. */
                    while(!operators.peek().equals("(")) {
                        poppedToken = operators.pop();
                        postfixExpr += " " + poppedToken;
                    }
                    /** After the loop, we need to remove the left parenthesis from the stack
                        if applicable. */
                    if(operators.peek().equals("("))
                        operators.pop();
                    break;
                default:
                    postfixExpr += " " + c;
                    break;
            }
        }
        if(!operators.isEmpty()) {
            /** This loop is needed when the infix expression does not start with parenthesis. */
            while( !operators.isEmpty() ) {
                postfixExpr += " " + operators.pop();
            }
        }
        return postfixExpr;
    }
    
    /** 
     * This method calls the infixToPostfix method, then does math on the postfix expression.
     * @return sum The final total of the evaluation.
     * @param infixExpr a String describing an infix math expression.
     */
    public static double evaluateInfixExpr(String infixExpr) {
        double sum = 0;
        String postfixExpr = infixToPostfix(infixExpr);
        StringTokenizer st = new StringTokenizer(postfixExpr);
        Stack operands;
        operands = new Stack<>();
        Object x, y;
        String s;
        while(st.hasMoreTokens()) {
            s = st.nextToken();
            switch(s) {
                case "^":
                case "*":
                case "/":
                case "%":
                case "+":
                case "-":
                    x = operands.pop();
                    y = operands.pop();
                    sum = subEvaluation(x, y, s);
                    operands.push(sum);
                    //System.out.println("Stack looks like: " + operands);
                    break;
                default:
                    operands.push(s);
                    //System.out.println("Stack looks like: " + operands);
            }
        }
        return Double.parseDouble(operands.pop().toString());
    }
    
    /** This method is an intermediate evaluation of to numbers using an operator.
     *  @return A double, the result of the evaluation.
     *  @param x an Object that is parsed to a String, then to a double
     *  @param y another Object that is parsed to a String, then to a double.
     *  @param poppedOperator The string describing the operator
     */
    public static double subEvaluation(Object x, Object y, String poppedOperator) {
        double a = Double.parseDouble(x.toString());
        double b = Double.parseDouble(y.toString());
        //System.out.println(a + " " + poppedOperator + " " + b);
        switch(poppedOperator) {
            case "^":
                return Math.pow(b, a);
            case "*":
                return b * a;
            case "/":
                return b / a;
            case "%":
                return b % a;
            case "+":
                return b + a;
            case "-":
                return b - a;
            default:
                return 0.0;
        }
    }
}
