import java.util.*;
public class InfixToPostfix {


    /** Returns a postfix expression from an infix one. Doesn't work if it isn't equally parenthesized.
     *  @param infix
     *  @return String
     */
    public static String infix2Postfix(String infix) {
        Stack<String> operators = new Stack<String>();
        StringTokenizer st = new StringTokenizer(infix);
        String result = "";
        boolean bracket = checkBrackets(infix);
        if(bracket) {
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.equals("(")) {
                    operators.push(token);
                } else if (token.equals("+")
                        || token.equals("-")
                        || token.equals("^")
                        || token.equals("*")
                        || token.equals("/")
                        || token.equals("%")) {
                    operators.push(token);
                } else if (token.equals(")")) {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        result += " " + operators.pop();
                    }
                    if (operators.peek().equals("("))
                    /** To remove the left parenthesis. */
                        operators.pop();
                } else // must be a number
                {
                    result = result + " " + token;
                }
                if (!operators.isEmpty()) {
                    /** This loop functions when the expression has no parenthesis. */
                    while (!operators.isEmpty()) {
                        result += " " + operators.pop();
                    }
                }

            }
            return result;
        }
        else
            return "This function has an uneven amount of brackets";

    }

    /** Returns a boolean false if the amount of brackets are uneven and true if they are even.
     *  @param infix
     *  @return String
     */

    public static boolean checkBrackets(String infix) {
        Stack<String> bracket = new Stack<String>();
        StringTokenizer st = new StringTokenizer(infix);
        while(st.hasMoreTokens() ) {
            String c = st.nextToken();
            switch(c) {
                case "(":
                    bracket.push(c);
                case ")":
                    try {
                        bracket.pop();
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(e);
                    }
                default:
            }
        }
        if(!bracket.empty()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args)
    {
        String[] expressions = {
                "( 2 + ( 5 * 5 ) )",
                "( ( 2 + 5 ) * 5 )",
                "( ( ( 3 + 5 ) * 4 ) - 9 )",
                "( ( ( 1 + 3 ) ^ 4 ) * ( 2 ^ 3 ) )",
                "( ( ( 32 * 41 ) / 16 ) + ( 12 * 10 ) )"
        };

        for (int i = 0; i < expressions.length; i++)
        {
            String result = infix2Postfix( expressions[i] );
            System.out.println( expressions[i] + " ==> " + result );
        }
    }//main()

}


