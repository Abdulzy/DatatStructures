import java.util.*;

public class InfixToPostfix {


    /** Returns a postfix expression from an infix one. Doesn't work if it isn't equally parenthesized.
     *  @param infix
     *  @return String
     */
    public static String infix2Postfix(String infix) {
        Stack<String> operators = new Stack<String>();
        Stack<String> brackets = new Stack<String>();
        StringTokenizer st = new StringTokenizer(infix);
        StringTokenizer ps = new StringTokenizer(infix);
        String result = " " ;
        String token;
        while(ps.hasMoreTokens()) {
            String c = ps.nextToken();
            if(c.equals("(")) {
                brackets.push(c);
            }
            else if(c.equals(")")) {
                brackets.pop();
            }
        }
        if(brackets.empty()){
            while (st.hasMoreTokens()) {
                token = st.nextToken();
                switch (token) {
                    case "(":
                    case "+":
                    case "-":
                    case "^":
                    case "*":
                    case "/":
                    case "%":
                        operators.push(token);
                        break;
                    case ")":
                        while(!operators.peek().equals("(")) {
                            result += " " + operators.pop();
                        }
                        if (operators.peek().equals("("))
                        /** To remove the left parenthesis. */
                            operators.pop();
                        break;
                    default:// must be a number
                        result += " " + token;
                        break;
                }
            }
            if (!operators.isEmpty()) {
                /** This loop functions when the expression has no parenthesis. */
                while (!operators.isEmpty()) {
                    result += " " + operators.pop();
                }
            }
            return result;
        }
        else if(!brackets.empty()) {
        }
        return "Amount of brackets are uneven";
    }




    public static void main(String[] args)
    {
        String[] expressions = {
                "( 2 + ( 5 * 5 )  ",
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


