package util;

import java.util.Scanner;

/**
 * Scanner工具类
 * 提供从控制台读取输入并转换为数据结构的方法
 * 
 * @author practice_makes_perfect
 */
public class ScannerUtils {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * 从控制台读取输入，转换为单向链表
     * 输入格式：以逗号分隔的整数字符串，例如：1,2,3,4,5
     * 
     * @return 链表头节点，如果输入为空则返回null
     */
    public static ListNode scanListNode() {
        System.out.println("请输入链表节点（用逗号分隔，例如：1,2,3,4,5）：");
        String input = scanner.nextLine().trim();
        
        if (input == null || input.isEmpty()) {
            System.out.println("输入为空，返回空链表");
            return null;
        }
        
        return parseListNode(input);
    }
    
    /**
     * 从控制台读取输入，转换为单向链表（带提示信息）
     * 
     * @param prompt 提示信息
     * @return 链表头节点，如果输入为空则返回null
     */
    public static ListNode scanListNode(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        
        if (input == null || input.isEmpty()) {
            System.out.println("输入为空，返回空链表");
            return null;
        }
        
        return parseListNode(input);
    }
    
    /**
     * 解析逗号分隔的字符串，转换为链表
     * 
     * @param input 逗号分隔的字符串
     * @return 链表头节点
     */
    public static ListNode parseListNode(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        
        // 去除空格并分割字符串
        String[] parts = input.trim().split(",");
        
        if (parts.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        try {
            for (String part : parts) {
                String trimmed = part.trim();
                if (!trimmed.isEmpty()) {
                    int val = Integer.parseInt(trimmed);
                    curr.next = new ListNode(val);
                    curr = curr.next;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("输入格式错误，请输入有效的整数！错误信息：" + e.getMessage());
            return null;
        }
        
        return dummy.next;
    }
    
    /**
     * 打印链表（辅助方法）
     * 
     * @param head 链表头节点
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        
        System.out.println(sb.toString());
    }
    
    /**
     * 从控制台读取整数
     * 
     * @param prompt 提示信息
     * @return 整数值
     */
    public static int scanInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("输入无效，请输入一个整数：");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // 消费换行符
        return result;
    }
    
    /**
     * 从控制台读取字符串
     * 
     * @param prompt 提示信息
     * @return 字符串
     */
    public static String scanString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    /**
     * 从控制台读取整数数组
     * 输入格式：以逗号分隔的整数字符串，例如：1,2,3,4,5
     * 
     * @return 整数数组
     */
    public static int[] scanIntArray() {
        System.out.println("请输入整数数组（用逗号分隔，例如：1,2,3,4,5）：");
        String input = scanner.nextLine().trim();
        
        if (input == null || input.isEmpty()) {
            return new int[0];
        }
        
        return parseIntArray(input);
    }
    
    /**
     * 从控制台读取整数数组（带提示信息）
     * 
     * @param prompt 提示信息
     * @return 整数数组
     */
    public static int[] scanIntArray(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        
        if (input == null || input.isEmpty()) {
            return new int[0];
        }
        
        return parseIntArray(input);
    }
    
    /**
     * 解析逗号分隔的字符串，转换为整数数组
     * 
     * @param input 逗号分隔的字符串
     * @return 整数数组
     */
    public static int[] parseIntArray(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new int[0];
        }
        
        String[] parts = input.trim().split(",");
        int[] result = new int[parts.length];
        
        try {
            for (int i = 0; i < parts.length; i++) {
                result[i] = Integer.parseInt(parts[i].trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("输入格式错误，请输入有效的整数！错误信息：" + e.getMessage());
            return new int[0];
        }
        
        return result;
    }
    
    /**
     * 关闭Scanner
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
    
    /**
     * 测试方法
     */
    public static void main(String[] args) {
        System.out.println("=== Scanner工具类测试 ===\n");
        
        // 测试1：扫描链表节点
        System.out.println("测试1：从控制台读取链表");
        ListNode list1 = scanListNode();
        System.out.print("创建的链表：");
        printListNode(list1);
        
        // 测试2：使用自定义提示信息
        System.out.println("\n测试2：使用自定义提示信息读取链表");
        ListNode list2 = scanListNode("请输入第二个链表的节点值：");
        System.out.print("创建的链表：");
        printListNode(list2);
        
        // 测试3：直接解析字符串
        System.out.println("\n测试3：直接解析字符串为链表");
        String testInput = "10,20,30,40,50";
        System.out.println("输入字符串：" + testInput);
        ListNode list3 = parseListNode(testInput);
        System.out.print("解析的链表：");
        printListNode(list3);
        
        // 测试4：读取整数数组
        System.out.println("\n测试4：从控制台读取整数数组");
        int[] arr = scanIntArray();
        System.out.print("创建的数组：[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // 测试5：读取单个整数
        System.out.println("\n测试5：读取单个整数");
        int num = scanInt("请输入一个整数：");
        System.out.println("输入的整数是：" + num);
        
        // 测试6：异常输入处理
        System.out.println("\n测试6：测试异常输入处理");
        String invalidInput = "1,2,abc,4,5";
        System.out.println("输入字符串（包含非法字符）：" + invalidInput);
        ListNode list4 = parseListNode(invalidInput);
        System.out.print("解析结果：");
        printListNode(list4);
        
        // 关闭scanner
        closeScanner();
        
        System.out.println("\n=== 测试完成 ===");
    }
}

