package main;

import java.io.IOException;

import lexer.Lexer;
import lexer.Token;

public class Main {
    public static void main(String[] args) throws IOException {
        //创建一个Lexer对象
        Lexer lexer = new Lexer();
        //初始化一个计数器cnt，一行输出5个就换行
        int cnt = 0;

        //循环获取token并处理，直到行末
        do {
            //获取下一个token
            Token token = lexer.scan();

            //根据不同的类型打印对应的信息
            switch (token.tag) {
                case 13:
                    break;
                case 264: // ID
                    //输出左对齐
                    System.out.printf("%-15s", "(ID , " + token + ")");
                    break;
                case 270: // NUM
                    System.out.printf("%-15s", "(NUM , " + token + ")");
                    break;
                //批量一次输出case256-case 293：
                case 256:
                case 257:
                case 258:
                case 259:
                case 260:
                case 261:
                case 262:
                case 263:
                case 265:
                case 266:
                case 267:
                case 268:
                case 269:
                case 271:
                case 272:
                case 273:
                case 274:
                case 275:
                case 277:
                case 278:
                case 279:
                case 280:
                case 281:
                case 282:
                case 283:

                case 285:
                case 286:
                case 287:
                case 288:
                case 289:
                case 290:
                case 291:
                case 292:
                case 293:
                case 294:
                    //输出左对齐
                    System.out.printf("%-15s", "(KEY , " + token + ")");
                    break;
                case 276:
                    System.out.printf("%-15s", "(HEX , " + token + ")");
                    break;
                case 284:
                    System.out.printf("%-15s", "(STRING , " + token + ")");
                    break;
                default:
                    //输出左对齐，key为SYS
                    System.out.printf("%-15s", "(SYM , " + (char) token.tag + ")");
                    break;
            }
            //计数器加一
            cnt++;
            //如果计数器到5，换行
            if (cnt == 5) {
                System.out.println();
                cnt = 0;
            }

        } while (lexer.getPeek() != '\n'); //循环条件：未到行末
    }
}


//class Main {
//    static void main(){
//        class Fibonacci f = new Fibonacci();//new a Fibonacci
//        Print(f.get(ReadInteger()));
//    }
//}
///**
// * Fibonacci
// */  /*123*/  /*1234*/
//class Fibonacci {



