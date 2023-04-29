package lexer;

// Token 是所有词法单元的基类
public class Token {
    // tag 字段表示这个 token 的类型或类别
    public int tag;

    // 构造方法初始化 tag 字段的值
    public Token(int t) {
        tag = t;
    }

    // toString() 方法返回该 token 对象的字符串表示形式
    // 在此实现中，它将 tag 的 ASCII 码值转换成字符并返回
    public String toString() {
        return "" + (char) tag;
    }
}

//这个类作为所有词法单元的基类，定义了 tag 字段表示词法单元的类型或类别。其他值得注意的点包括：

// Token 类构造函数接收一个参数 t，用于初始化 tag 字段。
// toString() 方法返回该 token 对象的字符串表示形式，即将 tag 的 ASCII 码值转换成字符并返回。
// 总之，Token 类是所有词法单元的基类，用于表示源代码中所有的词法单元，并提供了一些基本的方法来处理这些单元。