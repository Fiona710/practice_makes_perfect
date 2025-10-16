# 递归和迭代的区别

## 1. 基本概念

### 递归（Recursion）
递归是一种函数调用自身的编程技术。递归函数通过将问题分解为更小的子问题来解决，直到达到基础情况（base case）。

### 迭代（Iteration）
迭代是通过循环结构（如for、while）重复执行一段代码，直到满足特定条件为止。

## 2. 主要区别

| 特性 | 递归 | 迭代 |
|------|------|------|
| **实现方式** | 函数调用自身 | 使用循环结构（for/while） |
| **终止条件** | 基础条件（base case） | 循环条件不满足 |
| **代码可读性** | 对某些问题更直观（如树遍历） | 对简单重复逻辑更清晰 |
| **空间复杂度** | O(n)，需要调用栈空间 | O(1)，通常只需常量空间 |
| **性能** | 相对较慢（函数调用开销） | 相对较快（无函数调用开销） |
| **栈溢出风险** | 深度过大时可能栈溢出 | 不存在栈溢出问题 |
| **状态保存** | 通过调用栈自动保存 | 需要显式使用变量保存 |

## 3. 优缺点对比

### 递归的优点
- 代码简洁优雅，逻辑清晰
- 适合解决树形结构、分治算法等问题
- 自然地表达问题的递归性质（如斐波那契数列、阶乘）
- 减少代码复杂度，易于理解和维护

### 递归的缺点
- 每次函数调用都需要额外的内存空间（调用栈）
- 可能导致栈溢出（Stack Overflow）
- 性能开销较大（函数调用、参数传递、返回值处理）
- 可能存在重复计算（需要使用记忆化优化）

### 迭代的优点
- 执行效率高，没有函数调用开销
- 空间复杂度低，通常只需常量空间
- 不会出现栈溢出问题
- 便于性能优化

### 迭代的缺点
- 对于复杂问题，代码可能更冗长
- 需要显式管理状态变量
- 某些递归问题改写为迭代较困难（如深度优先搜索）

## 4. 使用场景

### 适合使用递归的场景
1. **树和图的遍历**：二叉树遍历、图的DFS
2. **分治算法**：归并排序、快速排序
3. **回溯算法**：N皇后问题、组合问题
4. **数学问题**：阶乘、斐波那契数列、汉诺塔
5. **动态规划**：某些DP问题的自顶向下实现

### 适合使用迭代的场景
1. **简单循环**：数组遍历、求和
2. **性能要求高**：大数据量处理
3. **空间受限**：嵌入式系统、深度很大的递归
4. **尾递归优化**：将尾递归改写为迭代

## 5. 代码示例

### 示例1：计算阶乘

#### 递归实现
```java
public int factorialRecursive(int n) {
    // 基础条件
    if (n <= 1) {
        return 1;
    }
    // 递归调用
    return n * factorialRecursive(n - 1);
}
```

#### 迭代实现
```java
public int factorialIterative(int n) {
    int result = 1;
    // 循环迭代
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

### 示例2：斐波那契数列

#### 递归实现（朴素）
```java
public int fibonacciRecursive(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}
// 时间复杂度：O(2^n)，存在大量重复计算
```

#### 递归实现（带记忆化）
```java
public int fibonacciMemo(int n, Map<Integer, Integer> memo) {
    if (n <= 1) {
        return n;
    }
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    int result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
    memo.put(n, result);
    return result;
}
// 时间复杂度：O(n)
```

#### 迭代实现
```java
public int fibonacciIterative(int n) {
    if (n <= 1) {
        return n;
    }
    int prev = 0, curr = 1;
    for (int i = 2; i <= n; i++) {
        int temp = curr;
        curr = prev + curr;
        prev = temp;
    }
    return curr;
}
// 时间复杂度：O(n)，空间复杂度：O(1)
```

### 示例3：链表反转

#### 递归实现
```java
public ListNode reverseListRecursive(ListNode head) {
    // 基础条件：空节点或只有一个节点
    if (head == null || head.next == null) {
        return head;
    }
    // 递归反转后面的节点
    ListNode newHead = reverseListRecursive(head.next);
    // 反转当前节点
    head.next.next = head;
    head.next = null;
    return newHead;
}
```

#### 迭代实现
```java
public ListNode reverseListIterative(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
```

## 6. 递归与迭代的转换

### 递归转迭代的方法
1. **使用栈模拟递归**：显式使用栈保存状态
2. **尾递归优化**：将尾递归改写为循环
3. **动态规划**：自底向上计算

### 示例：二叉树中序遍历

#### 递归版本
```java
public void inorderRecursive(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }
    inorderRecursive(root.left, result);
    result.add(root.val);
    inorderRecursive(root.right, result);
}
```

#### 迭代版本（使用栈）
```java
public List<Integer> inorderIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    
    while (curr != null || !stack.isEmpty()) {
        // 一直向左走，将节点压栈
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        // 弹出栈顶节点并访问
        curr = stack.pop();
        result.add(curr.val);
        // 转向右子树
        curr = curr.right;
    }
    return result;
}
```

## 7. 选择建议

### 优先选择递归的情况
- 问题本身具有递归性质（树、图、分治）
- 代码简洁性优先于性能
- 递归深度可控（不会太深）
- 需要快速实现和验证算法

### 优先选择迭代的情况
- 性能要求高，需要优化执行效率
- 递归深度可能很大，有栈溢出风险
- 空间复杂度要求严格
- 简单的循环逻辑

### 综合考虑
在实际开发中，应根据具体问题的特点、性能要求、代码可维护性等因素综合考虑：
- 先用递归实现以理解问题本质
- 如果性能不满足要求，再优化为迭代
- 或者使用记忆化、动态规划等技术优化递归
