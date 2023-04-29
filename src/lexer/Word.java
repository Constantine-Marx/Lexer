package lexer;

// Word 是 Token 的子类，表示源代码中的保留字或标识符
public class Word extends Token {
    // lexeme 表示单词的字符串形式
    public String lexeme = "";

    // 构造方法用于初始化单词的字符串形式和标记（tag）
    public Word(String s, int tag) {
        super(tag);
        lexeme = s;
    }

    // 该方法返回单词的字符串形式
    public String toString() {
        return lexeme;
    }

    // 下面的语句声明了一些常量，表示特定的单词
    // 这些常量都是 Word 类型，并且使用 Tag 常量来指定它们的标记
    public static final Word and = new Word("&&", Tag.AND),
                             or = new Word("||", Tag.OR),
                             eq = new Word("==", Tag.EQ),
                             ne = new Word("!=", Tag.NE),
                             le = new Word("<=", Tag.LE),
                             ge = new Word(">=", Tag.GE),
                             minus = new Word("minus", Tag.MINUS),
                             True = new Word("true", Tag.TRUE),
                             False = new Word("false", Tag.FALSE),
                             temp = new Word("t", Tag.TEMP);
}

// Word 类表示源代码中的保留字或标识符。注意到这个类拥有一个名为 lexeme 的公共字符串字段，表示代码中的单词或标识符。其他值得注意的点包括：

// Word 类构造函数接收两个参数，一个是字符串形式的单词或标识符，另一个是此单词的标记（tag）。
// toString() 方法返回单词的字符串形式。
// 在类定义中，使用 final 关键字声明了一些常量。这些常量都是 Word 类型，并用于表示特定的单词和操作符。这些常量的初始化可以看作是对单例模式的一种应用。
// 总而言之，Word 类旨在提供一种方式来表示源代码中的单词和标识符，并且还提供了一些预定义的常量，以便可以轻松地处理它们。