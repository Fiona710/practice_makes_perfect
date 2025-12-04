# 链表类
1.手撕反转链表方法一定要熟练熟练熟练！好多难度大点的题目，内部都基于反转链表  
2.链表类在处理的时候，要注意头节点和尾巴节点为null的情况的考虑，可以在头节点增加一个空节点  
3.链表遍历的时候，尤其是单向链表，要使用中间临时变量来记录下一个节点的信息

## 题目列表

25 k个一组翻转链表  
24 反转链表

# DFS
DFS（深度优先搜索）：主要用于解决图、树遍历的场景，通过递归的方式，从一个节点出发，遍历其相邻节点，直到遍历完整个图或树。
DFS通常使用栈来辅助实现，也可以使用递归的方式实现。DFS的遍历顺序是先遍历当前节点的相邻节点，再遍历这些相邻节点的相邻节点，直到遍历完整个图或树。
DFS的实现通常需要使用一个visited数组来记录已经访问过的节点，避免重复访问。DFS的时间复杂度通常为O(V+E)，其中V为节点数，E为边数。

## 题目列表
200岛屿数量  
463岛屿的周长


## dfs实现代码

### 基于邻接矩阵的DFS实现
```java
import java.util.*;

public class DFSMatrix {
    private int[][] graph; // 邻接矩阵
    private boolean[] visited; // 访问标记数组
    private int vertexCount; // 顶点数量

    public DFSMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graph = new int[vertexCount][vertexCount];
        this.visited = new boolean[vertexCount];
    }

    // 添加边
    public void addEdge(int from, int to) {
        graph[from][to] = 1;
        graph[to][from] = 1; // 无向图
    }

    // 递归DFS实现
    public void dfsRecursive(int startVertex) {
        Arrays.fill(visited, false);
        System.out.print("DFS遍历结果（递归）: ");
        dfsRecursiveHelper(startVertex);
        System.out.println();
    }

    private void dfsRecursiveHelper(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertexCount; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                dfsRecursiveHelper(i);
            }
        }
    }

    // 迭代DFS实现（使用栈）
    public void dfsIterative(int startVertex) {
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("DFS遍历结果（迭代）: ");
        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            // 注意：邻接点要逆序入栈以保证与递归顺序一致
            for (int i = vertexCount - 1; i >= 0; i--) {
                if (graph[current][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

```

### 基于邻接表的DFS实现
```java
import java.util.*;

public class DFSList {
    private List<List<Integer>> graph; // 邻接表
    private boolean[] visited;
    private int vertexCount;

    public DFSList(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graph = new ArrayList<>();
        this.visited = new boolean[vertexCount];
        
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // 添加边
    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from); // 无向图
    }

    // 递归DFS
    public void dfsRecursive(int startVertex) {
        Arrays.fill(visited, false);
        System.out.print("DFS遍历结果（递归）: ");
        dfsRecursiveHelper(startVertex);
        System.out.println();
    }

    private void dfsRecursiveHelper(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRecursiveHelper(neighbor);
            }
        }
    }

    // 迭代DFS
    public void dfsIterative(int startVertex) {
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("DFS遍历结果（迭代）: ");
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                
                // 逆序入栈以保证与递归顺序一致
                List<Integer> neighbors = graph.get(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }
}
```

### 针对树的DFS实现
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeDFS {
    // 前序遍历：根->左->右
    public void preorder(TreeNode root) {
        if (root == null) return;
        
        System.out.print(root.val + " "); // 访问根节点
        preorder(root.left);              // 遍历左子树
        preorder(root.right);             // 遍历右子树
    }
    
    // 中序遍历：左->根->右
    public void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);               // 遍历左子树
        System.out.print(root.val + " "); // 访问根节点
        inorder(root.right);              // 遍历右子树
    }
    
    // 后序遍历：左->右->根
    public void postorder(TreeNode root) {
        if (root == null) return;
        
        postorder(root.left);             // 遍历左子树
        postorder(root.right);            // 遍历右子树
        System.out.print(root.val + " "); // 访问根节点
    }
}

```

# BFS


# 回溯法
一种 “试错 + 回退” 的算法思想（“走不通就回头”）  
实现回溯算法必须明确以下 5 个要素，缺一不可：

| 要素         | 作用                                                                 | 示例（全排列问题）|
|--------------|----------------------------------------------------------------------|---------------------------------------------|
| 解空间       | 所有可能的解的集合（明确要遍历的范围）| 1、2、3 的所有排列组合（[1,2,3]、[1,3,2] 等） |
| 路径         | 记录当前已做出的选择（逐步构建解）| path = [1,2]（已选 1、2，待选 3）|
| 选择列表     | 当前步骤可选择的选项（岔路口的所有方向）| 已选 [1,2] 时，选择列表仅剩 [3]                |
| 约束条件     | 过滤无效选择（避免走死路）| 已选的数不能重复选（排除 path 中已有元素）|
| 终止条件     | 判定是否找到一个完整解（到达出口）| path.size() == 数组长度（排列完成）|

回溯算法有固定的代码模板，无论什么问题，只需替换 “选择列表、约束条件、终止条件” 即可：  

```java
// 全局/成员变量：存储最终所有解
结果集 = []
function 回溯(路径, 选择列表):
    if 满足终止条件:
        结果集.add(路径的副本) // 注意：需复制路径，避免后续修改覆盖
        return
    for 选择 in 选择列表:
        // 1. 做选择（剪枝：过滤无效选择）
        if 选择不满足约束条件:
            continue
        路径.add(选择)
        // 2. 递归探索下一层
        回溯(路径, 新的选择列表)
        // 3. 回退（撤销选择）
        路径.remove(选择)
```
回溯算法本质是暴力搜索，效率较低，剪枝是提升性能的关键 —— 在 “做选择” 前过滤掉无效选择，避免不必要的递归：  
示例（组合总和问题）：若目标和为 7，当前路径和已为 8，直接跳过后续选择；  
示例（N 皇后问题）：若当前位置与已放皇后冲突（同行 / 同列 / 同斜线），直接跳过该位置；  
核心原则：越早剪枝，效率越高（避免递归到深层才发现无解）  

## 回溯和递归混淆
回溯法和递归的核心区别在于：递归是一种 “编程技巧 / 执行方式”，而回溯法是一种 “算法思想 / 问题解决策略” —— 递归是回溯法的常用实现手段，但回溯法≠递归，递归也可用于其他场景（如分治、树遍历）  

## 题目
全排序II
