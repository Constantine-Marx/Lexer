package lexer;

import java.io.IOException;
import java.util.Hashtable;

public class Lexer {

    //行号
    public static int line = 1;

    //下一个读入的字符
    char peek = ' ';

    //保留字表
    Hashtable words = new Hashtable();
    //hashtable structure: <key, value> = <word.lexeme, word>

    //向保留字表中添加新的保留字
    void reserve(Word w) {
        words.put(w.lexeme, w);
    }
    //words.put is a method of Hashtable class which is used to add a new key-value pair in a hashtable.
    //The key is the lexeme of the word, and the value is the word itself.


    //构造函数，初始化保留字表
    public Lexer() {
        reserve(new Word("if", Tag.IF));
        //将NewArray
        // Print ReadInteger ReadLine添加进保留字中
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(new Word("continue", Tag.CONTINUE));
        reserve(new Word("return", Tag.RETURN));
        reserve(new Word("new", Tag.NEW));
        reserve(new Word("class", Tag.CLASS));
        reserve(new Word("void", Tag.VOID));
        reserve(new Word("int", Tag.INT));
        reserve(new Word("static", Tag.STATIC));
        reserve(new Word("double", Tag.DOUBLE));
        reserve(new Word("bool", Tag.BOOL));
        reserve(new Word("string", Tag.STRING));
        reserve(new Word("null", Tag.NULL));
        reserve(new Word("this", Tag.THIS));
        reserve(new Word("for", Tag.FOR));
        reserve(new Word("extends", Tag.EXTENDS));
        reserve(new Word("NewArray", Tag.NEWARRAY));
        reserve(new Word("Print", Tag.PRINT));
        reserve(new Word("ReadInteger", Tag.READINTEGER));
        reserve(new Word("ReadLine", Tag.READLINE));

        reserve(Word.False);
        reserve(Word.True);


    }

    //从输入中读取下一个字符
    public void readch() throws IOException {
        peek = (char) System.in.read();
    }

    //判断是否和指定的字符匹配，并从输入中读取下一个字符
    boolean readch(char c) throws IOException {
        readch();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    //获取下一个Token
    public Token scan() throws IOException {
        //跳过空白字符
        //空白字符包括空格、制表符、换行符
        for (; ; readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line += 1;
            } else {
                break;
            }
        }

        //处理操作符类Token
        switch (peek) {
            case '&':
                if (readch('&'))
                    return Word.and;
                else
                    return new Token('&');
            case '|':
                if (readch('|'))
                    return Word.or;
                else
                    return new Token('|');
            case '=':
                if (readch('='))
                    return Word.eq;
                else
                    return new Token('=');
            case '!':
                if (readch('='))
                    return Word.ne;
                else
                    return new Token('!');
            case '<':
                if (readch('='))
                    return Word.le;
                else
                    return new Token('<');
            case '>':
                if (readch('='))
                    return Word.ge;
                else
                    return new Token('>');
        }


        //处理数字类Token
        if (Character.isDigit(peek)) {
            int v = 0;
            //定义存放16进制的字符串
            StringBuilder hex = new StringBuilder("0x");
            //判断是否为16进制
            if (peek == '0') {
                readch();
                if (peek == 'x') {
                    readch();
                    if (Character.isDigit(peek) || (peek >= 'a' && peek <= 'f') || (peek >= 'A' && peek <= 'F')) {
                        do {
                            hex.append(peek);
                            readch();
                        } while (Character.isDigit(peek) || (peek >= 'a' && peek <= 'f') || (peek >= 'A' && peek <= 'F'));
                        //将hex转换为10进制
                        return new Hex(hex.toString());
                    }
                }
            }

            do {
                v = 10 * v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));//这段代码的作用是从输入流中读取连续的数字字符，并将它们转换为整数类型的值。
            // 这个过程使用 do-while 循环来实现，直到遇到非数字字符为止。这个过程中，代码使用了很多基本的语言特性，包括变量赋值、函数调用和条件语句等。

            if (peek != '.')
                return new Num(v);//不是浮点数，就进NUM中

            float x = v;
            float d = 10;

            for (; ; ) {
                readch();
                if (!Character.isDigit(peek)) {
                    //判断是否为科学计数形式的浮点数
                    if (peek == 'e' || peek == 'E') {
                        readch();
                        char flag = '+';
                        if (peek == '+' || peek == '-') {
                            flag = peek;
                            readch();
                        }
                        if (Character.isDigit(peek)) {
                            int power = 0;
                            do {
                                power = 10 * power + Character.digit(peek, 10);
                                readch();
                            } while (Character.isDigit(peek));
                            if (flag == '+') {
                                x = x * (float) Math.pow(10, power);
                            } else {
                                x = x / (float) Math.pow(10, power);
                            }
                            return new Real(x);
                        }
                    }else {
                        break;
                    }
                } else {
                    x = x + Character.digit(peek, 10) / d;
                    d = d * 10;
                }
            }
            return new Real(x);
        }

        //处理标识符类Token
        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek) || peek == '_');

            String s = b.toString();
            //实现带下划线的标识符的识别
            if (s.contains("_")) {
                return new Word(s, Tag.ID);
            }

            Word w = (Word) words.get(s);
            if (w != null)
                return w;
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        //识别是否为注释
        if (peek == '/') {
            readch();
            if (peek == '/') {
                do {
                    readch();
                } while (peek != '\n');
                return scan();
            } else if (peek == '*') {
                readch();
                while (true) {
                    if (peek == '*') {
                        readch();
                        if (peek == '/') {
                            readch();
                            return scan();
                        }
                    } else {
                        readch();
                    }
                }
            } else {
                return new Token('/');
            }
        }


        //处理其他字符类Token
        Token tok = new Token(peek);
        peek = ' ';
        return tok;

    }

    //输出保留字表的大小
    public void out() {
        System.out.println(words.size());
    }

    //获取下一个读入的字符
    public char getPeek() {
        return peek;
    }

    //设置下一个读入的字符
    public void setPeek(char peek) {
        this.peek = peek;
    }

}


