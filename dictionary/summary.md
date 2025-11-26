# 链表类
1.手撕反转链表方法一定要熟练熟练熟练！好多难度大点的题目，内部都基于反转链表
2.链表类在处理的时候，要注意头节点和尾巴节点为null的情况的考虑，可以在头节点增加一个空节点
3.链表遍历的时候，尤其是单向链表，要使用中间临时变量来记录下一个节点的信息

# DFS
DFS（深度优先搜索）：主要用于解决图、树遍历的场景，通过递归的方式，从一个节点出发，遍历其相邻节点，直到遍历完整个图或树。
DFS通常使用栈来辅助实现，也可以使用递归的方式实现。DFS的遍历顺序是先遍历当前节点的相邻节点，再遍历这些相邻节点的相邻节点，直到遍历完整个图或树。
DFS的实现通常需要使用一个visited数组来记录已经访问过的节点，避免重复访问。DFS的时间复杂度通常为O(V+E)，其中V为节点数，E为边数。

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