package org.breeze.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * <p>思路1：
 * <ol>
 * <li>采用双栈法实现表达式求值，一个栈用来存储数字，一个栈用来存储运算符。
 * <li>对输入的字符串进行扫描，将其中的数字、运算符和括号等分解成标记。
 * <li>对标记序列进行遍历，依次处理每个标记：
 * <ul>
 * <li>如果是数字，则将其压入数字栈中。
 * <li>如果是左括号，则将其压入运算符栈中。
 * <li>如果是右括号，则从运算符栈中弹出运算符，并从数字栈中弹出两个数字，进行计算，并将结果压入数字栈中，直到遇到与之匹配的左括号。
 * <li>如果是运算符，则按照运算符的优先级进行处理，具体地：
 * <ul><li>如果当前运算符的优先级小于等于栈顶运算符的优先级，则从运算符栈中弹出运算符，并从数字栈中弹出两个数字，进行计算，并将结果压入数字栈中，直到当前运算符的优先级大于栈顶运算符的优先级或者运算符栈为空，然后将当前运算符压入运算符栈中。</ul>
 * </ul>
 * <li>遍历完标记序列后，如果运算符栈不为空，则按照顺序弹出运算符，并从数字栈中弹出两个数字，进行计算，并将结果压入数字栈中，直到运算符栈为空。
 * <li>最终数字栈中存储的即为表达式的结果。
 * <p>
 * </ol>
 *
 * <p>思路2：</p>
 * <ol>
 * <li>词法分析：对输入的字符串进行扫描，将其中的数字、运算符和括号等分解成标记。例如，输入字符串 "2*(3+4)" 可以被分解成以下标记序列：数字 2、乘号、左括号、数字 3、加号、数字 4、右括号。
 * <li>语法分析：将标记序列转化成语法树的形式。其中，数字节点表示数字，运算符节点表示运算符号，括号节点表示括号。例如，上述标记序列可以转化成以下语法树：
 * <p>
 * <p>&nbsp;&nbsp;&nbsp;*
 * <p>&nbsp;&nbsp;/&nbsp;\
 * <p>2&nbsp;&nbsp;&nbsp;+
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;\
 * <p>&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;4
 * </li>
 * <li>计算表达式：对语法树进行遍历，递归计算每个子表达式的值。具体地，可以按照以下步骤进行：
 * <ol>
 * <li>遍历语法树，找到最深层的括号节点。
 * <li>递归计算该括号节点中的子表达式的值。
 * <li>将该括号节点替换为子表达式的值。
 * <li>重复步骤 1 到步骤 3，直到语法树中没有括号节点。
 * <li>按照运算符的优先级，递归计算每个运算符节点的子表达式的值。
 * <li>返回整个表达式的值。
 * </ol>
 *
 *
 * @author andy
 * @version 1.0.0
 */
public class Calculator {

    // 数字栈
    public static Stack<BigDecimal> number = new Stack<>();

    // 操作符栈
    public static Stack<Character> operate = new Stack<>();

    // 支持的操作符
    public static Map<String, Integer> supportOpt = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
    }};

    public static Set<Character> supportNum = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!StringUtils.isEmpty(str)) {
            traversalStr(str);
            cal();
            System.out.println("结果：" + number.peek());
            str = scanner.nextLine();
        }
    }

    private static void analyzeStr() {

    }

    private static void traversalStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            // 如果是数字：
            if (supportNum.contains(c)) {
                number.push(BigDecimal.valueOf(Character.getNumericValue(c)));
            }
            // 如果是左括号
            if ('(' == c) {
                operate.push(c);
            }

            // 如果是右括号：弹出栈顶运算符，并弹出两个数字进行计算，结果加入数字栈，知道碰到左括号
            if (')' == c) {
                while (operate.peek() == '(') {
                    calCurrent();
                }
            }

            // 如果是运算符
            if (supportOpt.containsKey(String.valueOf(c))) {
                // 判断当前运算符与运算符栈顶运算符的优先级，
                while (!operate.isEmpty() &&
                        supportOpt.get(String.valueOf(c)).compareTo(supportOpt.get(String.valueOf(operate.peek()))) <= 0) {
                    // 如果小于或者等于：弹出栈顶运算符，并弹出两个数字进行计算，结果加入数字栈
                    calCurrent();
                }
                // 如果大或者栈顶运算符为空；加入运算符栈
                operate.push(c);
            }
        }
    }

    /**
     * 弹出栈顶运算符，并弹出两个数字进行计算，结果加入数字栈
     */
    private static void calCurrent() {
        Character topOpt = operate.pop();
        BigDecimal num1 = number.pop();
        BigDecimal num2 = number.pop();
        BigDecimal result = new BigDecimal(0);
        switch (topOpt) {
            case '+':
                result = num2.add(num1);
                break;
            case '-':
                result = num2.subtract(num1);
                break;
            case '*':
                result = num2.multiply(num1);
                break;
            case '/':
                result = num2.divide(num1, 4, RoundingMode.HALF_UP);
                break;
        }
        number.push(result);
    }

    private static void cal() {
        while (!operate.isEmpty()) {
            calCurrent();
        }
    }

}
