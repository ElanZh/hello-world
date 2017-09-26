package coreJ;

import jdk.nashorn.internal.parser.TokenStream;

import java.io.BufferedInputStream;

public class Expression {
    public TokenStream ts;

    public static void main(String args[]) {
        Expression e = new Expression();
        System.out.println(e.evalue());
    }

    public Expression() {
        ts = new ExpressionTokenStream(new BufferedInputStream(System.in));
    }

    public int evalue() {
        int t = term();
        Token op = null;

        try {
            op = ts.getToken();
            while (op.tokenType == PLUS || op.tokenType == MINUS) {
                ts.consumeToken();
                int t2 = term();
                if (op.tokenType == PLUS) {
                    t += t2;
                } else {
                    t -= t2;
                }

                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int term() {
        int t = factor();

        Token op = null;
        try {
            op = ts.getToken();

            while (op.tokenType == MULT || op.tokenType == DIV) {
                ts.consumeToken();
                int t2 = factor();
                if (op.tokenType == MULT) {
                    t *= t2;
                } else {
                    t /= t2;
                }
                op = ts.getToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int factor() {
        Token t = null;
        try {
            t = ts.getToken();

            if (t.tokenType == INT) {
                ts.consumeToken();
                return (((Integer) t.value).intValue());
            } else if (t.tokenType == LPAR) {
                ts.consumeToken();
                int v = evalue();
                match(ts.getToken(), RPAR);
                return v;
            }
            else if (t.tokenType == MINUS) {
                ts.consumeToken();
                return 0 - factor();
            }
            else {
                throw new IOException("Illegal Expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // should not reach here
        return 0;
    }

    private void match(Token t, Token.TokenType tt) {
        assert t.tokenType == tt;
        ts.consumeToken();
    }
}
