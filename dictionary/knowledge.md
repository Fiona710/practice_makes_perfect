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

---

# 排序算法

## 1. 排序算法概述

排序算法是计算机科学中最基础也是最重要的算法之一。排序是将一组数据按照特定顺序（升序或降序）重新排列的过程。

### 排序算法分类

#### 按稳定性分类
- **稳定排序**：相等元素的相对位置在排序后保持不变（冒泡、插入、归并、基数）
- **不稳定排序**：相等元素的相对位置可能改变（选择、快速、希尔、堆）

#### 按时间复杂度分类
- **O(n²)**：冒泡排序、选择排序、插入排序
- **O(n log n)**：归并排序、快速排序、堆排序
- **O(n)**：计数排序、桶排序、基数排序（特定条件下）

#### 按空间复杂度分类
- **原地排序（O(1)）**：冒泡、选择、插入、希尔、堆、快速
- **非原地排序（O(n)）**：归并、计数、桶、基数

## 2. 常见排序算法对比

| 算法 | 平均时间 | 最好时间 | 最坏时间 | 空间复杂度 | 稳定性 | 适用场景 |
|------|---------|---------|---------|-----------|--------|---------|
| **冒泡排序** | O(n²) | O(n) | O(n²) | O(1) | 稳定 | 小规模数据 |
| **选择排序** | O(n²) | O(n²) | O(n²) | O(1) | 不稳定 | 小规模数据 |
| **插入排序** | O(n²) | O(n) | O(n²) | O(1) | 稳定 | 小规模或基本有序 |
| **希尔排序** | O(n^1.3) | O(n) | O(n²) | O(1) | 不稳定 | 中等规模数据 |
| **归并排序** | O(n log n) | O(n log n) | O(n log n) | O(n) | 稳定 | 大规模数据、链表 |
| **快速排序** | O(n log n) | O(n log n) | O(n²) | O(log n) | 不稳定 | 大规模数据（常用）|
| **堆排序** | O(n log n) | O(n log n) | O(n log n) | O(1) | 不稳定 | 大规模数据 |
| **计数排序** | O(n+k) | O(n+k) | O(n+k) | O(k) | 稳定 | 整数且范围有限 |
| **桶排序** | O(n+k) | O(n+k) | O(n²) | O(n+k) | 稳定 | 均匀分布的数据 |
| **基数排序** | O(d(n+k)) | O(d(n+k)) | O(d(n+k)) | O(n+k) | 稳定 | 整数、字符串 |

## 3. 详细算法实现

### 3.1 冒泡排序（Bubble Sort）

#### 算法思想
重复遍历数组，比较相邻元素，如果顺序错误就交换，直到没有需要交换的元素。

#### 代码实现
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false; // 优化：检测是否发生交换
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                // 交换相邻元素
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        // 如果没有发生交换，说明已经有序
        if (!swapped) break;
    }
}
```

#### 特点
- 简单易懂，代码实现容易
- 适合小规模数据或基本有序的数据
- 稳定排序

### 3.2 选择排序（Selection Sort）

#### 算法思想
每次从未排序部分找到最小（或最大）元素，放到已排序部分的末尾。

#### 代码实现
```java
public void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        // 找到未排序部分的最小元素
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        // 交换到已排序部分的末尾
        if (minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
```

#### 特点
- 交换次数最少，最多n-1次
- 不稳定排序
- 性能不受数据初始状态影响

### 3.3 插入排序（Insertion Sort）

#### 算法思想
将数组分为已排序和未排序两部分，每次从未排序部分取一个元素，插入到已排序部分的正确位置。

#### 代码实现
```java
public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        // 将大于key的元素向后移动
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

#### 特点
- 对基本有序的数据效率很高
- 稳定排序
- 适合小规模数据或在线排序（边输入边排序）

### 3.4 希尔排序（Shell Sort）

#### 算法思想
插入排序的改进版，通过设置增量序列，先对距离较远的元素进行排序，逐步减小增量。

#### 代码实现
```java
public void shellSort(int[] arr) {
    int n = arr.length;
    // 初始增量为数组长度的一半，每次减半
    for (int gap = n / 2; gap > 0; gap /= 2) {
        // 对每个子序列进行插入排序
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}
```

#### 特点
- 比简单的O(n²)算法快
- 不稳定排序
- 性能依赖于增量序列的选择

### 3.5 归并排序（Merge Sort）

#### 算法思想
采用分治策略，将数组分成两半，分别排序后再合并。

#### 代码实现
```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        // 递归排序左右两半
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // 合并
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    // 创建临时数组
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    
    // 合并两个有序数组
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }
    
    // 复制剩余元素
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    
    // 复制回原数组
    for (i = 0; i < k; i++) {
        arr[left + i] = temp[i];
    }
}
```

#### 特点
- 时间复杂度稳定在O(n log n)
- 稳定排序
- 需要额外O(n)空间
- 适合对链表排序

### 3.6 快速排序（Quick Sort）

#### 算法思想
选择一个基准元素，将数组分为小于和大于基准的两部分，递归地对两部分进行排序。

#### 代码实现
```java
public void quickSort(int[] arr, int left, int right) {
    if (left < right) {
        // 获取分区位置
        int pivotIndex = partition(arr, left, right);
        // 递归排序左右两部分
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }
}

public int partition(int[] param, int left, int right){
   int pivot = param[left];

   int i = left;
   int j = right;

   while(i < j){
      while(i < j && param[j] > pivot){
         j--;
      }

      while(i < j && param[i] <= pivot){
         i++;
      }

      swap(param,i,j);
   }
   swap(param,i,left);
   return i;
}

public void swap(int[] param, int left, int right){
   int tmp = param[left];
   param[left] = param[right];
   param[right] = tmp;
}
```

#### 优化版本（三路快排）
```java
public void quickSort3Way(int[] arr, int left, int right) {
    if (left >= right) return;
    
    int pivot = arr[left];
    int lt = left;      // arr[left+1...lt] < pivot
    int gt = right;     // arr[gt...right] > pivot
    int i = left + 1;   // arr[lt+1...i-1] == pivot
    
    while (i <= gt) {
        if (arr[i] < pivot) {
            swap(arr, i++, ++lt);
        } else if (arr[i] > pivot) {
            swap(arr, i, gt--);
        } else {
            i++;
        }
    }
    swap(arr, left, lt);
    
    quickSort3Way(arr, left, lt - 1);
    quickSort3Way(arr, gt + 1, right);
}
```

#### 特点
- 平均性能最好，实际应用最广
- 不稳定排序
- 最坏情况O(n²)，可通过随机化基准优化
- 原地排序，空间复杂度O(log n)（递归栈）

### 3.7 堆排序（Heap Sort）

#### 算法思想
利用堆这种数据结构，将数组构建成最大堆，然后依次取出堆顶元素。

#### 代码实现
```java
public void heapSort(int[] arr) {
    int n = arr.length;
    
    // 构建最大堆（从最后一个非叶子节点开始）
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
    
    // 依次取出堆顶元素
    for (int i = n - 1; i > 0; i--) {
        // 将堆顶（最大值）与末尾交换
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        
        // 重新调整堆
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    // 找到最大值
    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }
    
    // 如果最大值不是根节点，交换并递归调整
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
```

#### 特点
- 时间复杂度稳定在O(n log n)
- 原地排序，空间复杂度O(1)
- 不稳定排序
- 适合处理海量数据（Top K问题）

### 3.8 计数排序（Counting Sort）

#### 算法思想
统计每个元素出现的次数，然后按顺序输出。适用于整数且范围不大的情况。

#### 代码实现
```java
public void countingSort(int[] arr) {
    if (arr.length == 0) return;
    
    // 找到最大值和最小值
    int max = arr[0], min = arr[0];
    for (int num : arr) {
        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    
    // 创建计数数组
    int range = max - min + 1;
    int[] count = new int[range];
    
    // 统计每个元素出现的次数
    for (int num : arr) {
        count[num - min]++;
    }
    
    // 重建数组
    int index = 0;
    for (int i = 0; i < range; i++) {
        while (count[i]-- > 0) {
            arr[index++] = i + min;
        }
    }
}
```

#### 特点
- 时间复杂度O(n+k)，k为数据范围
- 稳定排序
- 适合整数且范围有限的数据
- 需要额外O(k)空间

### 3.9 桶排序（Bucket Sort）

#### 算法思想
将数据分配到有限数量的桶中，每个桶内部排序，最后合并所有桶。

#### 代码实现
```java
public void bucketSort(int[] arr) {
    if (arr.length == 0) return;
    
    // 找到最大值和最小值
    int max = arr[0], min = arr[0];
    for (int num : arr) {
        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    
    // 桶的数量
    int bucketCount = (max - min) / arr.length + 1;
    List<List<Integer>> buckets = new ArrayList<>(bucketCount);
    for (int i = 0; i < bucketCount; i++) {
        buckets.add(new ArrayList<>());
    }
    
    // 将元素分配到桶中
    for (int num : arr) {
        int bucketIndex = (num - min) / arr.length;
        buckets.get(bucketIndex).add(num);
    }
    
    // 对每个桶内部排序并合并
    int index = 0;
    for (List<Integer> bucket : buckets) {
        Collections.sort(bucket); // 可以使用其他排序算法
        for (int num : bucket) {
            arr[index++] = num;
        }
    }
}
```

#### 特点
- 平均时间复杂度O(n+k)
- 稳定排序
- 适合均匀分布的数据
- 需要额外空间

### 3.10 基数排序（Radix Sort）

#### 算法思想
按照数字的每一位进行排序，从最低位开始到最高位。

#### 代码实现
```java
public void radixSort(int[] arr) {
    if (arr.length == 0) return;
    
    // 找到最大值，确定位数
    int max = arr[0];
    for (int num : arr) {
        max = Math.max(max, num);
    }
    
    // 从个位开始，对每一位进行计数排序
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSortByDigit(arr, exp);
    }
}

private void countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];
    
    // 统计每个数字出现的次数
    for (int i = 0; i < n; i++) {
        int digit = (arr[i] / exp) % 10;
        count[digit]++;
    }
    
    // 计算累积计数
    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }
    
    // 从后向前构建输出数组（保证稳定性）
    for (int i = n - 1; i >= 0; i--) {
        int digit = (arr[i] / exp) % 10;
        output[count[digit] - 1] = arr[i];
        count[digit]--;
    }
    
    // 复制回原数组
    System.arraycopy(output, 0, arr, 0, n);
}
```

#### 特点
- 时间复杂度O(d(n+k))，d为位数，k为基数
- 稳定排序
- 适合整数、字符串等有固定位数的数据
- 需要额外空间

## 4. 排序算法选择指南

### 根据数据规模选择
- **小规模（n < 50）**：插入排序
- **中等规模（50 < n < 10000）**：快速排序、希尔排序
- **大规模（n > 10000）**：快速排序、归并排序、堆排序

### 根据数据特征选择
- **基本有序**：插入排序、冒泡排序
- **随机分布**：快速排序
- **有大量重复元素**：三路快速排序
- **整数且范围有限**：计数排序、桶排序、基数排序
- **需要稳定性**：归并排序、插入排序

### 根据空间限制选择
- **空间充足**：归并排序
- **空间受限**：堆排序、快速排序、原地排序算法

### 实际应用场景
- **Java的Arrays.sort()**：对于基本类型使用双轴快速排序（Dual-Pivot QuickSort），对于对象使用TimSort（归并+插入的混合）
- **数据库排序**：外部归并排序
- **操作系统任务调度**：优先队列（堆）
- **Top K问题**：堆排序、快速选择算法

## 5. 排序算法面试重点

### 常见面试题
1. 实现快速排序的三种分区方法
2. 如何优化快速排序避免最坏情况
3. 归并排序和快速排序的区别
4. 什么时候使用堆排序
5. 如何在O(n)时间内排序
6. 稳定排序和不稳定排序的应用场景

### 优化技巧
1. **快速排序优化**：
   - 三数取中选择基准
   - 小数组使用插入排序
   - 三路快排处理重复元素

2. **归并排序优化**：
   - 小数组使用插入排序
   - 判断是否已有序，避免不必要的合并

3. **通用优化**：
   - 尾递归优化
   - 减少不必要的交换
   - 利用CPU缓存局部性
