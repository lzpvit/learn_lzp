<!-- GFM-TOC -->
* [�㷨˼��](#�㷨˼��)
    * [���ֲ���](#���ֲ���)
    * [̰��˼��](#̰��˼��)
    * [˫ָ��](#˫ָ��)
    * [����](#����)
        * [����ѡ��](#����ѡ��)
        * [������](#������)
        * [Ͱ����](#Ͱ����)
    * [����](#����)
        * [BFS](#bfs)
        * [DFS](#dfs)
        * [Backtracking](#backtracking)
    * [����](#����)
    * [�ݹ�](#�ݹ�)
    * [��̬�滮](#��̬�滮)
        * [�ָ�����](#�ָ�����)
        * [����·��](#����·��)
        * [쳲���������](#쳲���������)
        * [�����������](#�����������)
        * [�������ϵ��](#�������ϵ��)
        * [0-1 ����](#0-1-����)
        * [��������](#��������)
        * [�ַ����༭](#�ַ����༭)
        * [��������](#��������)
    * [��ѧ](#��ѧ)
        * [����](#����)
        * [���Լ��](#���Լ��)
        * [����ת��](#����ת��)
        * [�׳�](#�׳�)
        * [�ַ����ӷ�����](#�ַ����ӷ�����)
        * [��������](#��������)
        * [����ͶƱ����](#����ͶƱ����)
        * [����](#����)
* [���ݽṹ���](#���ݽṹ���)
    * [ջ�Ͷ���](#ջ�Ͷ���)
    * [��ϣ��](#��ϣ��)
    * [�ַ���](#�ַ���)
    * [���������](#���������)
        * [�������](#�������)
    * [����](#����)
    * [��](#��)
        * [�ݹ�](#�ݹ�)
        * [��α���](#��α���)
        * [ǰ�к������](#ǰ�к������)
        * [BST](#bst)
        * [Trie](#trie)
    * [ͼ](#ͼ)
    * [λ����](#λ����)
* [�ο�����](#�ο�����)
<!-- GFM-TOC -->

# �㷨˼��

## ���ֲ���

���ֲ���˼��򵥣�������ʵ��ʱ��һЩ��Ҫע���ϸ�ڣ�

1. �ڼ��� mid ʱ����ʹ�� mid = (l + h) / 2 ���ַ�ʽ����Ϊ l + h ���ܻᵼ�¼ӷ������Ӧ��ʹ�� mid = l + (h - l) / 2 ��

2. �� h �ĸ�ֵ��ѭ�������йأ���ѭ������Ϊ l <= h ʱ��h = mid - 1����ѭ������Ϊ l < h ʱ��h = mid��
�������£���ѭ������Ϊ l <= h ʱ����� h = mid�������ѭ���޷��˳������������ l = 1��h = 1����ʱ mid Ҳ���� 1�������ʱ����ִ�� h = mid ����ô�ͻ�����ѭ������ѭ������Ϊ l < h ����� h = mid - 1��������������ҵ���������������� 1,2,3 ��Ҫ���� 1 ���ʼ l = 0��h = 2��mid = 1���ж� key < arr[mid] ִ�� h = mid - 1 = 0����ʱѭ���˳���ֱ�ӰѲ��ҵ��������ˡ�

3. l �ĸ�ֵһ�㶼Ϊ l = mid + 1��

```java
public int search(int key, int[] arr) {
    int l = 0, h = arr.length - 1;
    while (l <= h) {
        int mid = l + (h - l) / 2;
        if (key == arr[mid]) return mid;
        if (key < arr[mid]) h = mid - 1;
        else l = mid + 1;
    }
    return -1;
}
```

**�󿪷�**

[Leetcode : 69. Sqrt(x) (Easy)](https://leetcode.com/problems/sqrtx/description/)

һ���� x �Ŀ��� sqrt һ���� 0 \~ x ֮�䣬�������� sqrt == x / sqrt ���������ö��ֲ����� 0 \~ x ֮����� sqrt��

```java
public int mySqrt(int x) {
    if(x <= 1) return x;
    int l = 1, h = x;
    while(l <= h){
        int mid = l + (h - l) / 2;
        int sqrt = x / mid;
        if(sqrt == mid) return mid;
        else if(sqrt < mid) h = mid - 1;
        else l = mid + 1;
    }
    return h;
}
```

**��Ӳ��**

[Leetcode : 441. Arranging Coins (Easy)](https://leetcode.com/problems/arranging-coins/description/)

```html
n = 8

The coins can form the following rows:
��
�� ��
�� �� ��
�� ��

Because the 4th row is incomplete, we return 3.
```

��Ŀ�������� i �а� i ����ͳ���ܹ����е�������

���� h ������ l����Ϊ�ڵ�Ӳ�����һ�в������ȥ��

```java
public int arrangeCoins(int n) {
    int l = 0, h = n;
    while(l <= h){
        int m = l + (h - l) / 2;
        long x = m * (m + 1L) / 2;
        if(x == n) return m;
        else if(x < n) l = m + 1;
        else h = m - 1;
    }
    return h;
}
```

���Բ��ö��ֲ��ң���ֱ�۵Ľⷨ���£�

```java
public int arrangeCoins(int n) {
    int level = 1;
    while (n > 0) {
        n -= level;
        level++;
    }
    return n == 0 ? level - 1 : level - 2;
}
```

**��������� Single Element**

[Leetcode : 540. Single Element in a Sorted Array (Medium)](https://leetcode.com/problems/single-element-in-a-sorted-array/description/)

��Ŀ������һ����������ֻ��һ�������������Σ��ҳ��������

```java
public int singleNonDuplicate(int[] nums) {
    int l = 0, h = nums.length - 1;
    while(l < h) {
        int m = l + (h - l) / 2;
        if(m % 2 == 1) m--; // ��֤ l/h/m ����ż��λ��ʹ�ò��������Сһֱ���� ����
        if(nums[m] == nums[m + 1]) l = m + 2;
        else h = m;
    }
    return nums[l];
}
```

## ̰��˼��

̰��˼�뱣֤ÿ�β������Ǿֲ����ŵģ��������õ��Ľ����ȫ�����ŵġ�

**�������**

[Leetcode : 455. Assign Cookies (Easy)](https://leetcode.com/problems/assign-cookies/description/)

��Ŀ������ÿ�����Ӷ���һ������ȣ�ÿ�����ɶ���һ����С��ֻ�б��ɵĴ�С����һ�����ӵ�����ȣ��ú��ӲŻ������㡣��������Ի������ĺ���������

��Ϊ��С�ĺ��������׵õ����㣬�����������С���ӡ���һ�����ӵı���Ӧ������С��������ú��ӣ���������ɾ�������������ȱȽϴ�ĺ��ӡ�

֤����������ĳ��ѡ���У�̰�Ĳ���ѡ����� i �����ӷ���� m �����ɣ����ҵ� i �������������С���� m ������Ϊ��������� i �����ӵ���С���ɣ�����̰�Ĳ������տ������� k �����ӡ��������Ų��������ѡ���и� i �����ӷ���� n �����ɣ�����������ɴ��ڵ� m �����ɣ���ô���Ų���������Ҫ������� k �����ӡ����Ƿ���ʹ�õ� m ������ȥ����� n ��������ȫ��Ӱ������Ľ�������̰�Ĳ��Ծ������Ų��ԣ����̰�Ĳ��������ŵġ�

```java
public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0;
    while(i < g.length && j < s.length){
        if(g[i] <= s[j]) i++;
        j++;
    }
    return i;
}
```

**Ͷ���ڴ�����**

[Leetcode : 452. Minimum Number of Arrows to Burst Balloons (Medium)](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/)

```
Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2
```

��Ŀ������������һ��ˮƽ�����ϰڷţ������ص������ڴ�ֱ���������ᣬʹ��·���ϵ����򶼻���ƣ������С��Ͷ���ڴ�����

```java
public int findMinArrowShots(int[][] points) {
    if(points.length == 0) return 0;
    Arrays.sort(points,(a,b) -> (a[1] - b[1]));
    int curPos = points[0][1];
    int ret = 1;
    for (int i = 1; i < points.length; i++) {
        if(points[i][0] <= curPos) {
            continue;
        }
        curPos = points[i][1];
        ret++;
    }
    return ret;
 }
```

**��Ʊ���������**

[Leetcode : 122. Best Time to Buy and Sell Stock II (Easy)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

�������Ʊ��Ȼ����۹�Ʊ���Ӷ���ò�۴��������档

����һ������ [a, b, c, d]������� a <= b <= c <= d ����ô�������Ϊ d - a = (d - c) + (c - b) + (b - a) �������ʵ�һ�� prices[i] ��  prices[i] - prices[i-1] ����ô�Ͱ� prices[i] - prices[i-1] �ӵ������У��Ӷ��ھֲ����ŵ������Ҳ��֤ȫ�����š�

```java
public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i = 1; i < prices.length; i++){
        if(prices[i] > prices[i-1]) profit += (prices[i] - prices[i-1]);
    }
    return profit;
}
```

**��ֲ����**

[Leetcode : 605. Can Place Flowers (Easy)](https://leetcode.com/problems/can-place-flowers/description/)

```html
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
```

��Ŀ����������֮��������Ҫһ����λ�ļ����

```java
public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int cnt = 0;
    for(int i = 0; i < flowerbed.length; i++){
        if(flowerbed[i] == 1) continue;
        int pre = i == 0 ? 0 : flowerbed[i - 1];
        int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
        if(pre == 0 && next == 0) {
            cnt++;
            flowerbed[i] = 1;
        }
    }
    return cnt >= n;
}
```

**�޸�һ������Ϊ�ǵݼ�����**

[Leetcode : 665. Non-decreasing Array (Easy)](https://leetcode.com/problems/non-decreasing-array/description/)

��Ŀ�������ж�һ�������ܲ���ֻ�޸�һ�����ͳ�Ϊ�ǵݼ����顣

�� nums[i] < nums[i - 1] ������£������ȿ����� nums[i - 1] = nums[i]����Ϊ����޸� nums[i] = nums[i - 1] �Ļ�����ô nums[i] �����������ô���п��ܱ� nums[i + 1] ������Ҫ����ʹ nums[i] ��С��

������ nums[i] < nums[i - 2] ������£�ֻ�޸� nums[i - 1] �����������Ϊ�ǵݼ���ֻ��ͨ���޸� nums[i] = nums[i - 1] ���С�

```java
public boolean checkPossibility(int[] nums) {
    int cnt = 0;
    for(int i = 1; i < nums.length; i++){
        if(nums[i] < nums[i - 1]){
            cnt++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i]) nums[i] = nums[i-1];
            else nums[i - 1] = nums[i];
        }
    }
    return cnt <= 1;
}
```

**�ж��Ƿ�Ϊ�Ӵ�**

[Leetcode : 392. Is Subsequence (Medium)](https://leetcode.com/problems/is-subsequence/description/)

```html
s = "abc", t = "ahbgdc"
Return true.
```

```java
public boolean isSubsequence(String s, String t) {
    for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
        pos = t.indexOf(s.charAt(i), pos);
        if(pos == -1) return false;
    }
    return true;
}
```

**�ָ��ַ���ʹͬ���ַ�������һ��**

[Leetcode : 763. Partition Labels (Medium)](https://leetcode.com/problems/partition-labels/description/)

```java
public List<Integer> partitionLabels(String S) {
    List<Integer> ret = new ArrayList<>();
    int[] lastIdxs = new int[26];
    for(int i = 0; i < S.length(); i++) lastIdxs[S.charAt(i) - 'a'] = i;
    int startIdx = 0;
    while(startIdx < S.length()) {
        int endIdx = startIdx;
        for(int i = startIdx; i < S.length() && i <= endIdx; i++) {
            int lastIdx = lastIdxs[S.charAt(i) - 'a'];
            if(lastIdx == i) continue;
            if(lastIdx > endIdx) endIdx = lastIdx;
        }
        ret.add(endIdx - startIdx + 1);
        startIdx = endIdx + 1;
    }
    return ret;
}
```

**������ߺ�����������**

```html
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

һ��ѧ������������ (h, k) ������h ��ʾ��ߣ�k ��ʾ����ǰ����� k ��ѧ������߱����߻��ߺ���һ���ߡ�

��������߽���k ֵ����Ȼ���ź����˳�������еĵ� k ��λ���С�

```java
public int[][] reconstructQueue(int[][] people) {
    if(people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
    
    Arrays.sort(people, new Comparator<int[]>() {
       public int compare(int[] a, int[] b) {
           if(a[0] == b[0]) return a[1] - b[1];
           return b[0] - a[0];
       } 
    });
    
    int n = people.length;
    List<int[]> tmp = new ArrayList<>();
    for(int i = 0; i < n; i++) {
        tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
    }
    
    int[][] ret = new int[n][2];
    for(int i = 0; i < n; i++) {
        ret[i][0] = tmp.get(i)[0];
        ret[i][1] = tmp.get(i)[1];
    }
    return ret;
}
```


## ˫ָ��

˫ָ����Ҫ���ڱ������飬����ָ��ָ��ͬ��Ԫ�أ��Ӷ�Эͬ�������

**��һ���Ѿ�����������в��ҳ���������ʹ���ǵĺ�Ϊ 0**

[Leetcode ��167. Two Sum II - Input array is sorted (Easy)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

ʹ��˫ָ�룬һ��ָ��ָ��Ԫ�ؽ�С��ֵ��һ��ָ��ָ��Ԫ�ؽϴ��ֵ��ָ���СԪ�ص�ָ���ͷ��β������ָ��ϴ�Ԫ�ص�ָ���β��ͷ������

�������ָ��ָ��Ԫ�صĺ� sum == target����ô�õ�Ҫ��Ľ������� sum > target���ƶ��ϴ��Ԫ�أ�ʹ sum ��СһЩ����� sum < target���ƶ���С��Ԫ�أ�ʹ sum ���һЩ��

```java
public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    while (i < j) {
        int sum = numbers[i] + numbers[j];
        if (sum == target) return new int[]{i + 1, j + 1};
        else if (sum < target) i++;
        else j--;
    }
    return null;
}
```

���������չ������Ԫ�غ�Ϊ 0 �����⣺[����Ա��������ָ�� P351](#)

**�������ۼӺ�Ϊ����ֵ��������鳤��**

[����Ա��������ָ�� P354/P355/P358](#)

**���к��ж��ź���ľ����в���Ԫ��**

[����Ա��������ָ�� P347](#)

**��ת�ַ����е�Ԫ���ַ�**

[Leetcode : 345. Reverse Vowels of a String (Easy)](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)

ʹ��˫ָ�룬ָ�����ת������Ԫ���ַ���һ��ָ���ͷ��β������һ��ָ���β��ͷ������

```java
private HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

public String reverseVowels(String s) {
    if(s.length() == 0) return s;
    int i = 0, j = s.length() - 1;
    char[] result = new char[s.length()];
    while(i <= j){
        char ci = s.charAt(i);
        char cj = s.charAt(j);
        if(!vowels.contains(ci)){
            result[i] = ci;
            i++;
        } else if(!vowels.contains(cj)){
            result[j] = cj;
            j--;
        } else{
            result[i] = cj;
            result[j] = ci;
            i++;
            j--;
        }
    }
    return new String(result);
}
```

**����ƽ����**

[Leetcode : 633. Sum of Square Numbers (Easy)](https://leetcode.com/problems/sum-of-square-numbers/description/)

�ж�һ�����Ƿ�Ϊ��������ƽ���ͣ����� 5 = 1<sup>2</sup> + 2<sup>2</sup>��

```java
public boolean judgeSquareSum(int c) {
    int left = 0, right = (int) Math.sqrt(c);
    while(left <= right){
        int powSum = left * left + right * right;
        if(powSum == c) return true;
        else if(powSum > c) right--;
        else left++;
    }
    return false;
}
```

**�ַ�������������ɾ��һ���ַ���**

[Leetcode : 680. Valid Palindrome II (Easy)](https://leetcode.com/problems/valid-palindrome-ii/description/)

```java
public boolean validPalindrome(String s) {
    int i = 0, j = s.length() -1;
    while(i < j){
        if(s.charAt(i) != s.charAt(j)){
            return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
        }
        i++;
        j--;
    }
    return true;
}

private boolean isPalindrome(String s, int l, int r){
    while(l < r){
        if(s.charAt(l) != s.charAt(r))
            return false;
        l++;
        r--;
    }
    return true;
}
```

**�鲢������������**

[Leetcode : 88. Merge Sorted Array (Easy)](https://leetcode.com/problems/merge-sorted-array/description/)

�ѹ鲢����浽��һ�������ϡ�

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1; // ��Ҫ��β��ʼ������������ nums1 �Ϲ鲢�õ���ֵ�Ḳ�ǻ�δ���й鲢�Ƚϵ�ֵ
    int idx = m + n - 1;
    while(i >= 0 || j >= 0){
        if(i < 0) nums1[idx] = nums2[j--];
        else if(j < 0) nums1[idx] = nums1[i--];
        else if(nums1[i] > nums2[j]) nums1[idx] = nums1[i--];
        else nums1[idx] = nums2[j--];
        idx--;
    }
}
```

**�ж������Ƿ���ڻ�**

[Leetcode : 141. Linked List Cycle (Easy)](https://leetcode.com/problems/linked-list-cycle/description/)

ʹ��˫ָ�룬һ��ָ��ÿ���ƶ�һ���ڵ㣬һ��ָ��ÿ���ƶ������ڵ㣬������ڻ�����ô������ָ��һ����������

```java
public boolean hasCycle(ListNode head) {
    if(head == null) return false;
    ListNode l1 = head, l2 = head.next;
    while(l1 != null && l2 != null){
        if(l1 == l2) return true;
        l1 = l1.next;
        if(l2.next == null) break;
        l2 = l2.next.next;
    }
    return false;
}
```

**�������**

[Leetcode : 524. Longest Word in Dictionary through Deleting (Medium)](https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/)

```
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
```

```java
public String findLongestWord(String s, List<String> d) {
    String ret = "";
    for (String str : d) {
        for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
            if (s.charAt(i) == str.charAt(j)) j++;
            if (j == str.length()) {
                if (ret.length() < str.length()
                        || (ret.length() == str.length() && ret.compareTo(str) > 0)) {
                    ret = str;
                }
            }
        }
    }
    return ret;
}
```

## ����

### ����ѡ��

һ��������� **Kth Element** ���⣬������ O(n) ʱ�临�Ӷȣ�O(1) �ռ临�Ӷ������⹤����

���������һ��������ѡ��һ����Ҫ�ȴ������飬����������ʱ�临�Ӷ�Ϊ O(n<sup>2</sup>)��

### ������

������������� **TopK Elements** ���⣬ͨ��ά��һ����СΪ K �Ķѣ����е�Ԫ�ؾ��� TopK Elements����Ȼ��Ҳ����������� Kth Element ���⣬��Ϊ�����ѵ��Ǹ�Ԫ�ؾ��� Kth Element������ѡ��Ҳ������� TopK Elements ���⣬��Ϊ�ҵ� Kth Element ֮���ٱ���һ�����飬����С�ڵ���  Kth Element ��Ԫ�ض��� TopK Elements�����Կ���������ѡ��Ͷ����򶼿������ Kth Element �� TopK Elements ���⣬ֻ���п�����Ҫ�����⡣

**Kth Element**

[Leetocde : 215. Kth Largest Element in an Array (Medium)](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)

����ο���[Solution explained](https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained)

- ʱ�临�Ӷ� O(nlgn)���ռ临�Ӷ� O(1) �ⷨ������
- ʱ�临�Ӷ� O(nlgk)���ռ临�Ӷ� O(k) �ⷨ��������
- ʱ�临�Ӷ� O(n)���ռ临�Ӷ� O(1) �ⷨ��QuickSelect

**ToK Elements**

[����Ա��������ָ�� P336](#)

### Ͱ����


**�ҳ�����Ƶ������ k ����**

[Leetcode : 347. Top K Frequent Elements (Medium)](https://leetcode.com/problems/top-k-frequent-elements/description/)

Ͱ����

```java
public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> ret = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<Integer>[] bucket = new List[nums.length + 1];
    for(int key : map.keySet()) {
        int frequency = map.get(key);
        if(bucket[frequency] == null) {
            bucket[frequency] = new ArrayList<>();
        }
        bucket[frequency].add(key);
    }
    
    for(int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
        if(bucket[i] != null) {
            ret.addAll(bucket[i]);
        }
    }
    return ret;
}
```

## ����

������������͹�����������㷺����������ͼ�У��������ǵ�Ӧ��ԶԶ��ֹ��ˡ�

### BFS

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/4ff355cf-9a7f-4468-af43-e5b02038facc.jpg)

����������������������е���һ��һ��ؽ��б������ӽڵ� 0 ������������ 6��2��1 �� 5 ���ĸ��½ڵ㡣

������ 6 ��ʼ�������õ��ڵ� 4 ���� 2 ��ʼ������û����һ���ڵ㣻�� 1 ��ʼ������û����һ���ڵ㣻�� 5 ��ʼ�������õ� 3 �� 4 �ڵ㡣��һ���ܹ��õ������½ڵ㣺4 �� 3 ��

�������½ڵ�������������ı���������

���Կ�����ÿһ�ֱ����Ľڵ㶼����ڵ�·��������ͬ���� d<sub>i</sub> ��ʾ�� i ���ڵ�����ڵ��·�����ȣ��Ƶ���һ�����ۣ������ȱ����Ľڵ� i �������Ľڵ� j���� d<sub>i</sub><=d<sub>j</sub>������������ۣ�����������·�� **���Ž�** ���⣺��һ�α�����Ŀ�Ľڵ㣬����������·��Ϊ���·�����������������֮���ٱ�����Ŀ�Ľڵ㣬��������·���Ͳ������·����

�ڳ���ʵ�� BFS ʱ��Ҫ�����������⣺

- ���У������洢ÿһ�ֱ����Ľڵ�
- ��ǣ����ڱ������ýڵ㣬Ӧ�ý�����ǣ���ֹ�ظ�������


**�����������д�ԭ�㵽�ض�������·������**

```html
[[1,1,0,1],
[1,0,1,0],
[1,1,1,1],
[1,0,1,1]]
```

```java
public int minPathLength(int[][] grids, int tr, int tc) {
    int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m = grids.length, n = grids[0].length;
    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(0, 0, 1));
    while (!queue.isEmpty()) {
        Position pos = queue.poll();
        for (int i = 0; i < 4; i++) {
            Position nextPos = new Position(pos.r + next[i][0], pos.c + next[i][1], pos.length + 1);
            if (nextPos.r < 0 || nextPos.r >= m || nextPos.c < 0 || nextPos.c >= n) continue;
            if (grids[nextPos.r][nextPos.c] != 1) continue;
            grids[nextPos.r][nextPos.c] = 0;
            if (nextPos.r == tr && nextPos.c == tc) return nextPos.length;
            queue.add(nextPos);
        }
    }
    return -1;
}

private class Position {
    int r, c, length;
    public Position(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }
}
```


### DFS

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/f7f7e3e5-7dd4-4173-9999-576b9e2ac0a2.png)

�����������һ��һ�������ÿһ��������������½ڵ㣬Ҫ�ö����ȴ洢�����Ա���һ�������ʱ���ٱ�������������������ڱ�����һ���½ڵ�ʱ������½ڵ���б������ӽڵ� 0 ������ʼ�������õ����½ڵ� 6 ʱ��������½ڵ� 6 ���б������õ��½ڵ� 4����˷��������ַ�ʽ�����½ڵ㣬ֱ��û���½ڵ��ˣ���ʱ���ء����ص����ڵ� 0 ������ǣ������Ը��ڵ� 0 ���б������õ��½ڵ� 2��Ȼ��������ϲ��衣

��һ���ڵ������ʹ�� DFS ��һ��ͼ���б���ʱ���ܹ��������Ľڵ㶼�Ǵӳ�ʼ�ڵ�ɴ�ģ�DFS ������������� **�ɴ���** ���⡣

�ڳ���ʵ�� DFS ʱ��Ҫ�����������⣺

- ջ����ջ�����浱ǰ�ڵ���Ϣ���������½ڵ㷵��ʱ�ܹ�����������ǰ�ڵ㡣Ҳ����ʹ�õݹ�ջ��
- ��ǣ��� BFS һ��ͬ����Ҫ���Ѿ��������ýڵ���б�ǡ�


**����������ͨ���**

[Leetcode : 695. Max Area of Island (Easy)](https://leetcode.com/problems/max-area-of-island/description/)

```html
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
```

```java
public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int max = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1) max = Math.max(max, dfs(grid, i, j));
        }
    }
    return max;
}

private int dfs(int[][] grid, int i, int j){
    int m = grid.length, n = grid[0].length;
    if(i < 0 || i >= m || j < 0 || j >= n) return 0;
    if(grid[i][j] == 0) return 0;
    grid[i][j] = 0;
    return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
}
```

**ͼ����ͨ����**

[Leetcode : 547. Friend Circles (Medium)](https://leetcode.com/problems/friend-circles/description/)

```html
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
```

```java
public int findCircleNum(int[][] M) {
    int n = M.length;
    int ret = 0;
    boolean[] hasFind = new boolean[n];
    for(int i = 0; i < n; i++) {
        if(!hasFind[i]) {
            dfs(M, i, hasFind);
            ret++;
        }

    }
    return ret;
}

private void dfs(int[][] M, int i, boolean[] hasFind) {
    hasFind[i] = true;
    int n = M.length;
    for(int k = 0; k < n; k++) {
        if(M[i][k] == 1 && !hasFind[k]) {
            dfs(M, k, hasFind);
        }
    }
}
```

**�����е���ͨ��������**

[Leetcode : 200. Number of Islands (Medium)](https://leetcode.com/problems/number-of-islands/description/)

```html
11110
11010
11000
00000
Answer: 1
```

```java
private int m, n;
private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    m = grid.length;
    n = grid[0].length;
    int ret = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                dfs(grid, i, j);
                ret++;
            }
        }
    }
    return ret;
}

private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
    grid[i][j] = '0';
    for (int k = 0; k < direction.length; k++) {
        dfs(grid, i + direction[k][0], j + direction[k][1]);
    }
}
```

**��������������дӸ���Ҷ�ӵ�·��**

[Leetcode : 257. Binary Tree Paths (Easy)](https://leetcode.com/problems/binary-tree-paths/description/)

```html
  1
/  \
2    3
\
  5
```
```html
["1->2->5", "1->3"]
```

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new ArrayList();
    if(root == null) return ret;
    dfs(root, "", ret);
    return ret;
}

private void dfs(TreeNode root, String prefix, List<String> ret){
    if(root == null) return;
    if(root.left == null && root.right == null){
        ret.add(prefix + root.val);
        return;
    }
    prefix += (root.val + "->");
    dfs(root.left, prefix, ret);
    dfs(root.right, prefix, ret);
}
```

**���������**

[Leetcode : 130. Surrounded Regions (Medium)](https://leetcode.com/problems/surrounded-regions/description/)

```html
For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
```

��Ŀ������ʹ�ñ� 'X' �� 'O' ת��Ϊ 'X'��

����ѡ�����������࣬ʣ�µľ�������ˡ�

```java
private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
private int m, n;

public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    m = board.length;
    n = board[0].length;
    for (int i = 0; i < m; i++) {
        dfs(board, i, 0);
        dfs(board, i, n - 1);
    }
    for (int i = 0; i < n; i++) {
        dfs(board, 0, i);
        dfs(board, m - 1, i);
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'T') board[i][j] = 'O';
            else if (board[i][j] == 'O') board[i][j] = 'X';
        }
    }
}

private void dfs(char[][] board, int r, int c) {
    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') return;
    board[r][c] = 'T';
    for (int i = 0; i < direction.length; i++) {
        dfs(board, r + direction[i][0], c + direction[i][1]);
    }
}
```

**�����������ܵ��������**

[Leetcode : 417. Pacific Atlantic Water Flow (Medium)](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

```html
Given the following 5x5 matrix:

  Pacific \~   \~   \~   \~   \~ 
       \~  1   2   2   3  (5) *
       \~  3   2   3  (4) (4) *
       \~  2   4  (5)  3   1  *
       \~ (6) (7)  1   4   5  *
       \~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
```

��Ŀ��������ߺ��ϱ���̫ƽ���ұߺ��±��Ǵ������ڲ������ִ����Σ����θߵĵط���ˮ�ܹ������͵ĵط������ˮ�ܹ�����̫ƽ��ʹ���������еط���

```java
private int m, n;
private int[][] matrix;
private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> ret = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return ret;
    this.m = matrix.length;
    this.n = matrix[0].length;
    this.matrix = matrix;
    boolean[][] canReachP = new boolean[m][n];
    boolean[][] canReachA = new boolean[m][n];
    for (int i = 0; i < m; i++) {
        dfs(i, 0, canReachP);
        dfs(i, n - 1, canReachA);
    }
    for (int i = 0; i < n; i++) {
        dfs(0, i, canReachP);
        dfs(m - 1, i, canReachA);
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (canReachP[i][j] && canReachA[i][j]) {
                ret.add(new int[]{i, j});
            }
        }
    }
    return ret;
}

private void dfs(int r, int c, boolean[][] canReach) {
    if(canReach[r][c]) return;
    canReach[r][c] = true;
    for (int i = 0; i < direction.length; i++) {
        int nextR = direction[i][0] + r;
        int nextC = direction[i][1] + c;
        if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                || matrix[r][c] > matrix[nextR][nextC]) continue;
        dfs(nextR, nextC, canReach);
    }
}
```

**N �ʺ�**

[Leetcode : 51. N-Queens (Hard)](https://leetcode.com/problems/n-queens/description/)

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/1f080e53-4758-406c-bb5f-dbedf89b63ce.jpg)

��Ŀ�������� n\*n �ľ����аڷ� n ���ʺ󣬲���ÿ���ʺ�����ͬһ�У�ͬһ�У�ͬһ�Խ����ϣ�Ҫ������е� n �ʺ�⡣

һ��һ�еذڷţ���ȷ��һ���е��Ǹ��ʺ�Ӧ�ð�����һ��ʱ����Ҫ���������������ȷ��ĳһ���Ƿ�Ϸ����������������ֱ�Ϊ���б�����顢45 �ȶԽ��߱������� 135 �ȶԽ��߱�����顣

45 �ȶԽ��߱�������ά��Ϊ 2\*n - 1��ͨ����ͼ������ȷ (r,c) ��λ�����ڵ������±�Ϊ r + c��

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/85583359-1b45-45f2-9811-4f7bb9a64db7.jpg)

135 �ȶԽ��߱�������ά��Ҳ�� 2\*n - 1��(r,c) ��λ�����ڵ������±�Ϊ n - 1 - (r - c)��

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/9e80f75a-b12b-4344-80c8-1f9ccc2d5246.jpg)

```java
private List<List<String>> ret;
private char[][] nQueens;
private boolean[] colUsed;
private boolean[] diagonals45Used;
private boolean[] diagonals135Used;
private int n;

public List<List<String>> solveNQueens(int n) {
    ret = new ArrayList<>();
    nQueens = new char[n][n];
    Arrays.fill(nQueens, '.');
    colUsed = new boolean[n];
    diagonals45Used = new boolean[2 * n - 1];
    diagonals135Used = new boolean[2 * n - 1];
    this.n = n;
    backstracking(0);
    return ret;
}

private void backstracking(int row) {
    if (row == n) {
        List<String> list = new ArrayList<>();
        for (char[] chars : nQueens) {
            list.add(new String(chars));
        }
        ret.add(list);
        return;
    }

    for (int col = 0; col < n; col++) {
        int diagonals45Idx = row + col;
        int diagonals135Idx = n - 1 - (row - col);
        if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
            continue;
        }
        nQueens[row][col] = 'Q';
        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
        backstracking(row + 1);
        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
        nQueens[row][col] = '.';
    }
}
```

### Backtracking

������ DFS ��һ�֣����������ڱ���ͼ�Ľڵ��ϣ������������ **�������** ���⣬������ { 'a','b','c' } �����ַ�������������������ַ����еõ����ַ�����

�ڳ���ʵ��ʱ��������Ҫע���Ԫ�ؽ��б�ǵ����⡣ʹ�õݹ�ʵ�ֵĻ��ݣ��ڷ���һ����Ԫ�ؽ����µĵݹ���ã���ʱ��Ҫ����Ԫ�ر��Ϊ�Ѿ����ʣ����������ڼ����ݹ����ʱ�����ظ����ʸ�Ԫ�أ������ڵݹ鷵��ʱ����Ҫ����Ԫ�ر��Ϊδ���ʣ���Ϊֻ��Ҫ��֤��һ���ݹ����в�ͬʱ����һ��Ԫ�أ����ڲ�ͬ�ĵݹ����ǿ��Է����Ѿ����ʹ����ǲ��ڵ�ǰ�ݹ����е�Ԫ�ء�

**���ּ������**

[Leetcode : 17. Letter Combinations of a Phone Number (Medium)](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/a3f34241-bb80-4879-8ec9-dff2d81b514e.jpg)

```html
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

```java
private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

public List<String> letterCombinations(String digits) {
    List<String> ret = new ArrayList<>();
    if (digits != null && digits.length() != 0) {
        combination("", digits, 0, ret);
    }
    return ret;
}

private void combination(String prefix, String digits, int offset, List<String> ret) {
    if (offset == digits.length()) {
        ret.add(prefix);
        return;
    }
    String letters = KEYS[digits.charAt(offset) - '0'];
    for (char c : letters.toCharArray()) {
        combination(prefix + c, digits, offset + 1, ret);
    }
}
```

**�ھ�����Ѱ���ַ���**

[Leetcode : 79. Word Search (Medium)](https://leetcode.com/problems/word-search/description/)

```html
For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
```

```java
private static int[][] shift = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
private static boolean[][] visited;
private int m;
private int n;

public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) return true;
    if (board == null || board.length == 0 || board[0].length == 0) return false;
    m = board.length;
    n = board[0].length;
    visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (dfs(board, word, 0, i, j)) return true;
        }
    }
    return false;
}

private boolean dfs(char[][] board, String word, int start, int r, int c) {
    if (start == word.length()) {
        return true;
    }
    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(start) ||  visited[r][c] ) {
        return false;
    }
    visited[r][c] = true;
    for (int i = 0; i < shift.length; i++) {
        int nextR = r + shift[i][0];
        int nextC = c + shift[i][1];
        if (dfs(board, word, start + 1, nextR, nextC)) return true;
    }
    visited[r][c] = false;
    return false;
}
```

**IP ��ַ����**

[Leetcode : 93. Restore IP Addresses(Medium)](https://leetcode.com/problems/restore-ip-addresses/description/)

```html
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"].
```

```java
private List<String> ret;

public List<String> restoreIpAddresses(String s) {
    ret = new ArrayList<>();
    doRestore(0, "", s);
    return ret;
}

private void doRestore(int k, String path, String s) {
    if (k == 4 || s.length() == 0) {
        if (k == 4 && s.length() == 0) {
            ret.add(path);
        }
        return;
    }
    for (int i = 0; i < s.length() && i <= 2; i++) {
        if (i != 0 && s.charAt(0) == '0') break;
        String part = s.substring(0, i + 1);
        if (Integer.valueOf(part) <= 255) {
            doRestore(k + 1, path.length() != 0 ? path + "." + part : part, s.substring(i + 1));
        }
    }
}
```

**����**

[Leetcode : 46. Permutations (Medium)](https://leetcode.com/problems/permutations/description/)

��Ŀ�������ҳ�һ�������������С�

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> permuteList = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    backtracking(permuteList, visited, nums, ret);
    return ret;
}

private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret){
    if(permuteList.size() == nums.length){
        ret.add(new ArrayList(permuteList));
        return;
    }

    for(int i = 0; i < visited.length; i++){
        if(visited[i]) continue;
        visited[i] = true;
        permuteList.add(nums[i]);
        backtracking(permuteList, visited, nums, ret);
        permuteList.remove(permuteList.size() - 1);
        visited[i] = false;
    }
}
```

**�����ظ�������**

[Leetcode : 47. Permutations II (Medium)](https://leetcode.com/problems/permutations-ii/description/)

```html
[1,1,2] have the following unique permutations:
[[1,1,2], [1,2,1], [2,1,1]]
```

��ʵ���ϣ��� Permutations ��ͬ����Ҫ������Ȼ�������һ��Ԫ��ʱ���ж����Ԫ���Ƿ����ǰһ��Ԫ�أ�������ڣ�����ǰһ��Ԫ�ػ�δ���ʣ���ô���������Ԫ�ء�

```java
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> permuteList = new ArrayList<>();
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    backtracking(permuteList, visited, nums, ret);
    return ret;
}

private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
    if (permuteList.size() == nums.length) {
        ret.add(new ArrayList(permuteList));
        return;
    }

    for (int i = 0; i < visited.length; i++) {
        if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
        if (visited[i]) continue;
        visited[i] = true;
        permuteList.add(nums[i]);
        backtracking(permuteList, visited, nums, ret);
        permuteList.remove(permuteList.size() - 1);
        visited[i] = false;
    }
}
```

**���**

[Leetcode : 77. Combinations (Medium)](https://leetcode.com/problems/combinations/description/)

��Ŀ�������ҳ��� 1 \~ n ��ȡ�� k ��Ԫ�ص����п��ܵ���ϡ�

```java
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> combineList = new ArrayList<>();
    backtracking(1, n, k, combineList, ret);
    return ret;
}

private void backtracking(int start, int n, int k, List<Integer> combineList, List<List<Integer>> ret){
    if(k == 0){
        ret.add(new ArrayList(combineList)); // ����Ҫ���¹���һ�� List
        return;
    }
    
    for(int i = start; i <= n - k + 1; i++){ // ��֦

        combineList.add(i);                        // �� i ���Ϊ�ѷ���
        backtracking(i + 1, n, k - 1, combineList, ret);
        combineList.remove(combineList.size() - 1); // �� i ���Ϊδ����
    }
}
```

**������**

[Leetcode : 39. Combination Sum (Medium)](https://leetcode.com/problems/combination-sum/description/)

```html
given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[[7],[2, 2, 3]]
```


```java
 private List<List<Integer>> ret;

 public List<List<Integer>> combinationSum(int[] candidates, int target) {
     ret = new ArrayList<>();
     doCombination(candidates, target, 0, new ArrayList<>());
     return ret;
 }

 private void doCombination(int[] candidates, int target, int start, List<Integer> list) {
     if (target == 0) {
         ret.add(new ArrayList<>(list));
         return;
     }
     for (int i = start; i < candidates.length; i++) {
         if (candidates[i] <= target) {
             list.add(candidates[i]);
             doCombination(candidates, target - candidates[i], i, list);
             list.remove(list.size() - 1);
         }
     }
 }
```

**�����ظ���������**

[Leetcode : 40. Combination Sum II (Medium)](https://leetcode.com/problems/combination-sum-ii/description/)

```html
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

```java
private List<List<Integer>> ret;

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    ret = new ArrayList<>();
    Arrays.sort(candidates);
    doCombination(candidates, target, 0, new ArrayList<>(), new boolean[candidates.length]);
    return ret;
}

private void doCombination(int[] candidates, int target, int start, List<Integer> list, boolean[] visited) {
    if (target == 0) {
        ret.add(new ArrayList<>(list));
        return;
    }
    for (int i = start; i < candidates.length; i++) {
        if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) continue;
        if (candidates[i] <= target) {
            list.add(candidates[i]);
            visited[i] = true;
            doCombination(candidates, target - candidates[i], i + 1, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
```


**�Ӽ�**

[Leetcode : 78. Subsets (Medium)](https://leetcode.com/problems/subsets/description/)

��Ŀ�������ҳ����ϵ������Ӽ����Ӽ������ظ���[1, 2] �� [2, 1] �����Ӽ����ظ�

```java
private List<List<Integer>> ret;
private List<Integer> subsetList;

public List<List<Integer>> subsets(int[] nums) {
    ret = new ArrayList<>();
    subsetList = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
        backtracking(0, i, nums);
    }
    return ret;
}

private void backtracking(int startIdx, int size, int[] nums) {
    if (subsetList.size() == size) {
        ret.add(new ArrayList(subsetList));
        return;
    }

    for (int i = startIdx; i < nums.length; i++) {
        subsetList.add(nums[i]);
        backtracking(i + 1, size, nums); // startIdx ��Ϊ��һ��Ԫ�أ�ʹ subset �е�Ԫ�ض���������
        subsetList.remove(subsetList.size() - 1);
    }
}
```

**�����ظ����Ӽ�**

[Leetcode : 90. Subsets II (Medium)](https://leetcode.com/problems/subsets-ii/description/)

```html
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

```java
private List<List<Integer>> ret;
private List<Integer> subsetList;
private boolean[] visited;

public List<List<Integer>> subsetsWithDup(int[] nums) {
    ret = new ArrayList<>();
    subsetList = new ArrayList<>();
    visited = new boolean[nums.length];
    Arrays.sort(nums);
    for (int i = 0; i <= nums.length; i++) {
        backtracking(0, i, nums);
    }
    return ret;
}

private void backtracking(int startIdx, int size, int[] nums) {
    if (subsetList.size() == size) {
        ret.add(new ArrayList(subsetList));
        return;
    }

    for (int i = startIdx; i < nums.length; i++) {
        if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
        subsetList.add(nums[i]);
        visited[i] = true;
        backtracking(i + 1, size, nums);
        visited[i] = false;
        subsetList.remove(subsetList.size() - 1);
    }
}
```

**�ָ��ַ���ʹ��ÿ���ֶ��ǻ�����**

[Leetcode : 131. Palindrome Partitioning (Medium)](https://leetcode.com/problems/palindrome-partitioning/description/)

```java
private List<List<String>> ret;

public List<List<String>> partition(String s) {
    ret = new ArrayList<>();
    doPartion(new ArrayList<>(), s);
    return ret;
}

private void doPartion(List<String> list, String s) {
    if (s.length() == 0) {
        ret.add(new ArrayList<>(list));
        return;
    }
    for (int i = 0; i < s.length(); i++) {
        if (isPalindrome(s, 0, i)) {
            list.add(s.substring(0, i + 1));
            doPartion(list, s.substring(i + 1));
            list.remove(list.size() - 1);
        }
    }
}

private boolean isPalindrome(String s, int begin, int end) {
    while (begin < end) {
        if (s.charAt(begin++) != s.charAt(end--)) return false;
    }
    return true;
}
```

**����**

[Leetcode : 37. Sudoku Solver (Hard)](https://leetcode.com/problems/sudoku-solver/description/)

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/1ca52246-c443-48ae-b1f8-1cafc09ec75c.png)

```java
private boolean[][] rowsUsed = new boolean[9][10];
private boolean[][] colsUsed = new boolean[9][10];
private boolean[][] cubesUsed = new boolean[9][10];
private char[][] board;

public void solveSudoku(char[][] board) {
    this.board = board;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') continue;
            int num = board[i][j] - '0';
            rowsUsed[i][num] = true;
            colsUsed[j][num] = true;
            cubesUsed[cubeNum(i, j)][num] = true;
        }
    }
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            backtracking(i, j);
        }
    }
}

private boolean backtracking(int row, int col) {
    while (row < 9 && board[row][col] != '.') {
        row = col == 8 ? row + 1 : row;
        col = col == 8 ? 0 : col + 1;
    }
    if (row == 9) {
        return true;
    }
    for (int num = 1; num <= 9; num++) {
        if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) continue;
        rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
        board[row][col] = (char) (num + '0');
        if (backtracking(row, col)) return true;
        board[row][col] = '.';
        rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
    }
    return false;
}

private int cubeNum(int i, int j) {
    int r = i / 3;
    int c = j / 3;
    return r * 3 + c;
}
```

## ����

**�����ʽ������**

[Leetcode : 241. Different Ways to Add Parentheses (Medium)](https://leetcode.com/problems/different-ways-to-add-parentheses/description/)

```html
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output : [0, 2]
```

```java
public List<Integer> diffWaysToCompute(String input) {
    int n = input.length();
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        char c = input.charAt(i);
        if (c == '+' || c == '-' || c == '*') {
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (int l : left) {
                for (int r : right) {
                    switch (c) {
                        case '+': ret.add(l + r); break;
                        case '-': ret.add(l - r); break;
                        case '*': ret.add(l * r); break;
                    }
                }
            }
        }
    }
    if (ret.size() == 0) ret.add(Integer.valueOf(input));
    return ret;
}
```

## �ݹ�

��ԭʼ����ֽ�ɽ�С����������⡣

## ��̬�滮

��ԭ������ɶ�������⣬������������ʱ�򱣴�������Ľ⣬ʹ��������ֻ���һ�Ρ�

### �ָ�����

**�ָ����������˻�**

[Leetcode : 343. Integer Break (Medim)](https://leetcode.com/problems/integer-break/description/)

��Ŀ������For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

```java
public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
        for(int j = 1; j <= i - 1; j++) {
            dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
        }
    }
    return dp[n];
}
```

**��ƽ�������ָ�����**

[Leetcode : 279. Perfect Squares(Medium)](https://leetcode.com/problems/perfect-squares/description/)

��Ŀ������For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

```java
public int numSquares(int n) {
    List<Integer> squares = new ArrayList<>(); // �洢С�� n ��ƽ����
    int diff = 3;
    while(square <= n) {
        squares.add(square);
        square += diff;
        diff += 2;
    }
    int[] dp = new int[n + 1];
    for(int i = 1; i <= n; i++) {
        int max = Integer.MAX_VALUE;
        for(int s : squares) {
            if(s > i) break;
            max = Math.min(max, dp[i - s] + 1);
        }
        dp[i] = max;
    }
    return dp[n];
}
```

**�ָ�����������ĸ�ַ���**

[Leetcode : 91. Decode Ways (Medium)](https://leetcode.com/problems/decode-ways/description/)

��Ŀ������Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

```java
public int numDecodings(String s) {
    if(s == null || s.length() == 0) return 0;
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for(int i = 2; i <= n; i++) {
        int one = Integer.valueOf(s.substring(i - 1, i));
        if(one != 0) dp[i] += dp[i - 1];
        if(s.charAt(i - 2) == '0') continue;
        int two = Integer.valueOf(s.substring(i - 2, i));
        if(two <= 26) dp[i] += dp[i - 2];
    }
    return dp[n];
}
```

### ����·��

**�������·����**

[Leetcode : 62. Unique Paths (Medium)](https://leetcode.com/problems/unique-paths/description/)

��Ŀ������ͳ�ƴӾ������Ͻǵ����½ǵ�·��������ÿ��ֻ������������ƶ���

```java
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if(i == 0) dp[j] = 1;
            else if(j != 0) dp[j] = dp[j] + dp[j - 1];
        }
    }
    return dp[n - 1];
}
```

**�������С·����**

[Leetcode : 64. Minimum Path Sum (Medium)](https://leetcode.com/problems/minimum-path-sum/description/)

��Ŀ��������Ӿ�������Ͻǵ����½ǵ���С·���ͣ�ÿ��ֻ������������ƶ���

```java
public int minPathSum(int[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) return 0;
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(j == 0) dp[0] = dp[0] + grid[i][0];
            else if(i == 0) dp[j] = dp[j - 1] + grid[0][j];
            else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
    }
    return dp[n - 1];
}
```

### 쳲���������

����Ա��������ָ�ϵ� 4 �µķ�������쳲������� N ������ת��Ϊ����˷����㣬�Ӷ���ʱ�临�Ӷ���СΪ O(lgN)��

**��¥��**

[Leetcode : 70. Climbing Stairs (Easy)](https://leetcode.com/problems/climbing-stairs/description/)

��Ŀ�������� N ��¥�ݣ�ÿ�ο�����һ�׻������ף����ж�������¥�ݵķ�����

����һ������ dp �洢��¥�ݵķ�������Ϊ�˷������ۣ������±�� 1 ��ʼ����dp[i] ��ʾ�ߵ��� i ��¥�ݵķ�����Ŀ���� i ��¥�ݿ��Դӵ� i-1 �� i-2 ��¥������һ������ߵ��� i ��¥�ݵķ�����Ϊ�ߵ��� i-1 �͵� i-2 ��¥�ݵķ�����֮�͡�

<center>dp[i] = dp[i-1] + dp[i-2]</center>

dp[N] ��Ϊ����

���ǵ� dp[i] ֻ�� dp[i - 1] �� dp[i - 2] �йأ���˿���ֻ�������������洢 dp[i - 1] �� dp[i - 2] ���ɣ�ʹ��ԭ���� O(n) �ռ临�Ӷ��Ż�Ϊ O(1) ���Ӷȡ�

```java
public int climbStairs(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;
    // ǰһ��¥�ݡ���һ��¥��
    int pre1 = 2, pre2 = 1;
    for(int i = 2; i < n; i++){
        int cur = pre1 + pre2;
        pre2 = pre1;
        pre1 = cur;
    }
    return pre1;
}
```

**ĸţ����**

[����Ա��������ָ��-P181](#)

��Ŀ����������ũ���г����ĸţÿ�궼���� 1 ͷСĸţ��������Զ����������һ���� 1 ֻСĸţ���ӵڶ��꿪ʼ��ĸţ��ʼ��Сĸţ��ÿֻСĸţ 3 ��֮������ֿ�����Сĸţ���������� N���� N ���ţ��������

�� i ������ţ������Ϊ��

<center>dp[i] = dp[i-1] + dp[i-3]</center>

**ǿ������**

[Leetcode : 198. House Robber (Easy)](https://leetcode.com/problems/house-robber/description/)

��Ŀ����������һ��ס�������ǲ������ڽ���ס�����������������

���� dp ���������洢���������������� dp[i] ��ʾ������ i ��ס��ʱ����������������ڲ��������ڽ�ס���������������˵� i ��ס����ôֻ������ i - 2 �� i - 3 ��ס��������

![](http://latex.codecogs.com/gif.latex?\\\\dp[i]=max(dp[i-2],dp[i-3])+nums[i])

O(n) �ռ临�Ӷ�ʵ�ַ�����

```java
public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    if(n == 1) return nums[0];
    if(n == 2) return Math.max(nums[0], nums[1]);
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = nums[1];
    dp[2] = nums[0] + nums[2];
    for(int i = 3; i < n; i++){
        dp[i] = Math.max(dp[i -2], dp[i - 3]) + nums[i];
    }
    return Math.max(dp[n - 1], dp[n - 2]);
}
```

O(1) �ռ临�Ӷ�ʵ�ַ�����

```java
public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;
    if(n == 1) return nums[0];
    if(n == 2) return Math.max(nums[0], nums[1]);
    int pre3 = nums[0], pre2 = nums[1], pre1 = nums[2] + nums[0];
    for(int i = 3; i < n; i++){
        int cur = Math.max(pre2, pre3) + nums[i];
        pre3 = pre2;
        pre2 = pre1;
        pre1 = cur;
    }
    return Math.max(pre1, pre2);
}
```

**ǿ���ڻ��ν�������**

[Leetcode : 213. House Robber II (Medium)](https://leetcode.com/problems/house-robber-ii/description/)

```java
public int rob(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int n = nums.length;
    if(n == 1) return nums[0];
    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
}

private int rob(int[] nums, int s, int e) {
    int n = nums.length;
    if(e - s == 0) return nums[s];
    if(e - s == 1) return Math.max(nums[s], nums[s + 1]);
    int[] dp = new int[n];
    dp[s] = nums[s];
    dp[s + 1] = nums[s + 1];
    dp[s + 2] = nums[s] + nums[s + 2];
    for (int i = s + 3; i <= e; i++) {
        dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
    }
    return Math.max(dp[e], dp[e - 1]);
}
```


**�ż�����**

��Ŀ�������� N �� �� �� �ŷ⣬���Ǳ����ң������װ�ŵķ�ʽ������

����һ������ dp �洢����ʽ������dp[i] ��ʾǰ i ���ź��ŷ�Ĵ���ʽ����������� i ����װ���� j ���ŷ����棬���� j ����װ���� k ���ŷ����档���� i �� k �Ƿ���ȣ������������

�� i==k������ i �� k ���ź����ǵ��ź��ŷ�����ȷ��λ�ã��������� i-2 ������ dp[i-2] �ִ���װ�ŵķ�ʽ������ j �� i-1 ��ȡֵ����˹��� (i-1)\*dp[i-2] �ִ���װ�ŷ�ʽ��

�� i != k������ i �� j ���ź󣬵� i ���ź��ŷ�����ȷ��λ�ã����� i-1 ������ dp[i-1] �ִ���װ�ŷ�ʽ������ j �� i-1 ��ȡֵ����˹��� (n-1)\*dp[i-1] �ִ���װ�ŷ�ʽ��

��������������װ��������ʽ����Ϊ��

<center> dp[i] = (i-1) \* dp[i-2] + (i-1) \* dp[i-1] </center>

dp[N] ��Ϊ����

����¥������һ����dp[i] ֻ�� dp[i-1] �� dp[i-2] �йأ����Ҳ����ֻ�������������洢 dp[i-1] �� dp[i-2]��

### �����������

��֪һ������ {S<sub>1</sub>, S<sub>2</sub>,...,S<sub>n</sub>} ��ȡ������������µ����� {S<sub>i1</sub>, S<sub>i2</sub>,..., S<sub>im</sub>}������ i1��i2 ... im ���ֵ��������������и�������Ȼ����ԭ�����е��Ⱥ�˳�򣬳�������Ϊԭ���е�һ��**������**��

������������У����±� ix > iy ʱ��S<sub>ix</sub> > S<sub>iy</sub>����������Ϊԭ���е�һ��**����������**��

����һ������ dp �洢����������еĳ��ȣ�dp[n] ��ʾ�� S<sub>n</sub> ��β�����е�����������г��ȡ�����һ������������ {S<sub>i1</sub>, S<sub>i2</sub>,...,S<sub>im</sub>}����� im < n ���� S<sub>im</sub> < S<sub>n</sub> ����ʱ {S<sub>i1</sub>, S<sub>i2</sub>,..., S<sub>im</sub>, S<sub>n</sub>} Ϊһ�����������У����������еĳ������� 1���������������ĵ����������У���������Ǹ����������о���Ҫ�ҵģ��ڳ�����ĵ����������ϼ��� S<sub>n</sub> �͹������� S<sub>n</sub> Ϊ��β������������С���� dp[n] = max{ dp[i]+1 | S<sub>i</sub> < S<sub>n</sub> && i < n} ��

��Ϊ���� dp[n] ʱ�����޷��ҵ�һ�����������ĵ��������У���ʱ {S<sub>n</sub>} �͹����˵��������У������Ҫ��ǰ�����ⷽ�����޸ģ��� dp[n] ��СΪ 1������

![](http://latex.codecogs.com/gif.latex?\\\\dp[n]=max\{1,dp[i]+1|S_i<S_n\&\&i<n\})

����һ������Ϊ N �����У�������в���һ������ S<sub>N</sub> Ϊ��β����� dp[N] �������е�����������еĳ��ȣ���Ҫ���� dp �����ҳ����ֵ������Ҫ�Ľ������ max{ dp[i] | 1 <= i <= N} ��Ϊ����

**�����������**

[Leetcode : 300. Longest Increasing Subsequence (Medium)](https://leetcode.com/problems/longest-increasing-subsequence/description/)

```java
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    for(int i = 0; i < n; i++){
        int max = 1;
        for(int j = 0; j < i; j++){
            if(nums[i] > nums[j]) max = Math.max(max, dp[j] + 1);
        }
        dp[i] = max;
    }
    int ret = 0;
    for(int i = 0; i < n; i++){
        ret = Math.max(ret, dp[i]);
    }
    return ret;
}
```

���Ͻⷨ��ʱ�临�Ӷ�Ϊ O(n<sup>2</sup>) ������ʹ�ö��ֲ���ʹ��ʱ�临�ӶȽ���Ϊ O(nlog<sub>n</sub>)������һ�� tails ���飬���� tails[i] �洢����Ϊ i + 1 ������������е����һ��Ԫ�أ������������ [4,5,6,3]����

```html
len = 1  :      [4], [5], [6], [3]  => tails[0] = 3
len = 2  :      [4, 5], [5, 6]      => tails[1] = 5
len = 3  :      [4, 5, 6]            => tails[2] = 6
```

����һ��Ԫ�� x����������� tails �������е�ֵ����ô������ӵ� tails ���棻��� tails[i-1] < x <= tails[i]����ô���� tails[i] = x ��

���Կ��� tails ���鱣����������ڲ��� S<sub>i</sub> λ�� tails �����λ��ʱ�Ϳ���ʹ�ö��ֲ��ҡ�

```java
public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] tails = new int[n];
    int size = 0;
    for(int i = 0; i < n; i++){
        int idx = binarySearch(tails, 0, size, nums[i]);
        tails[idx] = nums[i];
        if(idx == size) size++;
    }
    return size;
}

private int binarySearch(int[] nums, int sIdx, int eIdx, int key){
    while(sIdx < eIdx){
        int mIdx = sIdx + (eIdx - sIdx) / 2;
        if(nums[mIdx] == key) return mIdx;
        else if(nums[mIdx] > key) eIdx = mIdx;
        else sIdx = mIdx + 1;
    }
    return sIdx;
}
```

**��ڶ�������**

[Leetcode : 376. Wiggle Subsequence (Medium)](https://leetcode.com/problems/wiggle-subsequence/description/)

Ҫ��ʹ�� O(n) ʱ�临�Ӷ���⡣

ʹ������״̬ up �� down��

```java
public int wiggleMaxLength(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    int up = 1, down = 1;
    for (int i = 1; i < len; i++) {
        if (nums[i] > nums[i - 1]) up = down + 1;
        else if (nums[i] < nums[i - 1]) down = up + 1;
    }
    return Math.max(up, down);
}
```

### �������ϵ��

�������������� S1 �� S2���ҳ�������Ĺ��������С�

����һ����ά���� dp �����洢����������еĳ��ȣ����� dp[i][j] ��ʾ S1 ��ǰ i ���ַ��� S2 ��ǰ j ���ַ�����������еĳ��ȡ����� S1<sub>i</sub> �� S2<sub>j</sub> ֵ�Ƿ���ȣ���Ϊ���������

�� �� S1<sub>i</sub>==S2<sub>j</sub> ʱ����ô������ S1 ��ǰ i-1 ���ַ��� S2 ��ǰ j-1 ���ַ�����������еĻ������ټ��� S1<sub>i</sub> ���ֵ������������г��ȼ� 1 ���� dp[i][j] = dp[i-1][j-1] + 1��

�� �� S1<sub>i</sub> != S2<sub>j</sub> ʱ����ʱ�����������Ϊ S1 ��ǰ i-1 ���ַ��� S2 ��ǰ j ���ַ�����������У��� S1 ��ǰ i ���ַ��� S2 ��ǰ j-1 ���ַ�����������У����ǵ�����ߣ��� dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }��

���ϣ��������ϵ�е�״̬ת�Ʒ���Ϊ��

![](http://latex.codecogs.com/gif.latex?\\\\
dp[i][j]=\left\{
\begin{array}{rcl}
dp[i-1][j-1]&&{S1_i==S2_j}\\
max(dp[i-1][j],dp[i][j-1])&&{S1_i<>S2_j}
\end{array}\right.
)

���ڳ���Ϊ N ������ S<sub>1</sub> �� ����Ϊ M ������ S<sub>2</sub>��dp[N][M] �������� S<sub>1</sub> ������ S<sub>2</sub> ������������г��ȡ�

���������������ȣ�����������������²�ͬ�㣺

�� ��Ե����������У������ǵ�����������С�
�� ��������������У�dp[i] ��ʾ�� S<sub>i</sub> Ϊ��β������������г��ȣ������б������ S<sub>i</sub> ����������������У�dp[i][j] ��ʾ S1 ��ǰ i ���ַ��� S2 ��ǰ j ���ַ�������������г��ȣ���һ������ S1<sub>i</sub> �� S2<sub>j</sub> ��
�� ���� 2 ���������ս�ʱ��������������� dp[N][M] �������ս⣬��������������� dp[N] �������ս⣬��Ϊ�� S<sub>N</sub> Ϊ��β������������в�һ����������������������У���Ҫ����һ�� dp �����ҵ�����ߡ�

```java
public int lengthOfLCS(int[] nums1, int[] nums2) {
    int n1 = nums1.length, n2 = nums2.length;
    int[][] dp = new int[n1 + 1][n2 + 1];
    for (int i = 1; i <= n1; i++) {
        for (int j = 1; j <= n2; j++) {
            if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[n1][n2];
}
```

### 0-1 ����

��һ������Ϊ N �ı�����Ҫ���������װ����Ʒ�ļ�ֵ�����Щ��Ʒ���������ԣ���� w �ͼ�ֵ v��

����һ����ά���� dp �洢����ֵ������ dp[i][j] ��ʾ��������� j ������£�ǰ i ����Ʒ�ܴﵽ������ֵ����� i ����Ʒ���Ϊ w����ֵΪ v�����ݵ� i ����Ʒ�Ƿ���ӵ������У����Է�����������ۣ�

�� �� i ����Ʒû��ӵ������������������ j ��ǰ i ����Ʒ������ֵ��������������� j ��ǰ i-1 ����Ʒ������ֵ��dp[i][j] = dp[i-1][j]��
�� �� i ����Ʒ��ӵ������У�dp[i][j] = dp[i-1][j-w] + v��

�� i ����Ʒ�����Ҳ���Բ���ӣ�ȡ�����������������ֵ����

���ϣ�0-1 ������״̬ת�Ʒ���Ϊ��

![](http://latex.codecogs.com/gif.latex?\\\\dp[i][j]=max(dp[i-1][j],dp[i-1][j-w]+v))

```java
public int knapsack(int W, int N, int[] weights, int[] values) {
    int[][] dp = new int[N][W];
    for (int i = W - 1; i >= 0; i--) {
        dp[0][i] = i > weights[0] ? values[0] : 0;
    }
    for (int i = 1; i < N; i++) {
        for (int j = W - 1; j >= weights[i]; j--) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
        }
        for (int j = weights[i - 1] - 1; j >= 0; j--) {
            dp[i][j] = dp[i - 1][j];
        }
    }
    return dp[N - 1][W - 1];
}
```

**�ռ��Ż�**

�ڳ���ʵ��ʱ���Զ� 0-1 �������Ż����۲�״̬ת�Ʒ��̿���֪����ǰ i ����Ʒ��״̬����ǰ i-1 ����Ʒ��״̬�йأ���˿��Խ� dp ����Ϊһά���飬���� dp[j] �ȿ��Ա�ʾ dp[i-1][j] Ҳ���Ա�ʾ dp[i][j]����ʱ��

![](http://latex.codecogs.com/gif.latex?\\\\dp[j]=max(dp[j],dp[j-w]+v))

��Ϊ dp[j-w] ��ʾ dp[i-1][j-w]����˲������� dp[i][j-w] ��ֹ�� dp[i-1][j-w] ���ǡ�Ҳ����˵Ҫ�ȼ��� dp[i][j] �ټ��� dp[i][j-w]���ڳ���ʵ��ʱ��Ҫ��������ѭ����⡣


**�޷�ʹ��̰���㷨�Ľ���**

0-1 ���������޷�ʹ��̰���㷨����⣬Ҳ����˵���ܰ���������Լ۱���ߵ���Ʒ���ﵽ���ţ�������Ϊ���ַ�ʽ������ɱ����ռ���˷ѣ��Ӷ��޷��ﵽ���š������������Ʒ��һ������Ϊ 5 �ı���������������Ʒ 0 �������Ʒ 1����ôֻ�ܴ�ŵļ�ֵΪ 16���˷��˴�СΪ 2 �Ŀռ䡣���ŵķ�ʽ�Ǵ����Ʒ 1 ����Ʒ 2����ֵΪ 22.

| id | w | v | v/w |
| --- | --- | --- | --- |
| 0 | 1 | 6 | 6 |
| 1 | 2 | 10 | 5 |
| 2 | 3 | 12 | 4 |

**����**

��ȫ��������Ʒ�������޸�������ת��Ϊ 0-1 ��������ÿ����Ʒ������ͼ�ֵ��Ϊ 1/2/4... �����������Ƕ�����һ������Ʒ��Ȼ��һ����Ʒֻ�����һ�Ρ�

���ر�������Ʒ���������ƣ�ͬ������ת��Ϊ 0-1 ������

��ά���ñ�������Ʒ���������������������ͬʱ�������������ơ�

��������Ʒ֮���໥Լ������������

**��������Ϊ����ȵ�������**

[Leetcode : 416. Partition Equal Subset Sum (Medium)](https://leetcode.com/problems/partition-equal-subset-sum/description/)

���Կ���һ��������СΪ sum/2 �� 0-1 �������⣬����Ҳ�в�ͬ�ĵط�������û�м�ֵ���ԣ����ұ������뱻������

����ʵ��ʹ���˿ռ��Ż���

```java
public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    if (sum % 2 != 0) {
        return false;
    }
    int W = sum / 2;
    boolean[] dp = new boolean[W + 1];
    int n = nums.length;
    for(int i = 0; i <= W; i++) {
        if(nums[0] == i) dp[i] = true;
    }
    for(int i = 1; i < n; i++) {
        for(int j = W; j >= nums[i]; j--) {
            dp[j] = dp[j] || dp[j - nums[i]];
        }
    }

    return dp[W];
}
```

**�ַ����������б�ָ�**

[Leetcode : 139. Word Break (Medium)](https://leetcode.com/problems/word-break/description/)

```html
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
```

```java
public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
        for (String word : wordDict) {
            if (word.length() <= i
                    && word.equals(s.substring(i - word.length(), i))) {
                dp[i] = dp[i] || dp[i - word.length()];
            }
        }
    }
    return dp[n];
}
```

**�ı�һ������������ʹ�����ǵĺ�Ϊһ������**

[Leetcode : 494. Target Sum (Medium)](https://leetcode.com/problems/target-sum/description/)

```html
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
```

���������ת��Ϊ subset sum ���⣬�Ӷ�ʹ�� 0-1 �����ķ�������⡣���Խ����������������֣�P �� N������ P ʹ�����ţ�N ʹ�ø��ţ��������Ƶ���

```html
                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
```

���ֻҪ�ҵ�һ���Ӽ��������Ƕ�ȡ���ţ����Һ͵��� (target + sum(nums))/2����֤�����ڽ⡣

```java
public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    if (sum < S || (sum + S) % 2 == 1) {
        return 0;
    }
    return subsetSum(nums, (sum + S) >>> 1);
}

private int subsetSum(int[] nums, int targetSum) {
    Arrays.sort(nums);
    int[] dp = new int[targetSum + 1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        for (int j = targetSum; j >= num; j--) {
            dp[j] = dp[j] + dp[j - num];
        }
    }
    return dp[targetSum];
}
```

**01�ַ����������ַ���**

[Leetcode : 474. Ones and Zeroes (Medium)](https://leetcode.com/problems/ones-and-zeroes/description/)

```html
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are ��10,��0001��,��1��,��0��
```

����һ����ά���õ� 0-1 �������⣬������������С��0 �������� 1 ��������

```java
public int findMaxForm(String[] strs, int m, int n) {
    if (strs == null || strs.length == 0) return 0;
    int l = strs.length;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < l; i++) {
        String s = strs[i];
        int ones = 0, zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
            else if (c == '1') ones++;
        }
        for (int j = m; j >= zeros; j--) {
            for (int k = n; k >= ones; k--) {
                if (zeros <= j && ones <= k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
    }
    return dp[m][n];
}
```

**����Ǯ**

[Leetcode : 322. Coin Change (Medium)](https://leetcode.com/problems/coin-change/description/)

��Ŀ��������һЩ����Ӳ�ң�Ҫ������ЩӲ������ɸ�������Ǯ��������ʹ��Ӳ���������١�Ӳ�ҿ����ظ�ʹ�á�

����һ����ȫ�������⣬��ȫ��������� 0-1����������ʵ����Ψһ�Ĳ�ͬ�ǣ��ڶ���ѭ���Ǵ� 0 ��ʼ�ģ������Ǵ�β����ʼ��

```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```

**����ܺ�**

[Leetcode : 377. Combination Sum IV (Medium)](https://leetcode.com/problems/combination-sum-iv/description/)

```html
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
```

```java
public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] <= i) {
                dp[i] += dp[i - nums[j]];
            }
        }
    }
    return dp[target];
}
```

**ֻ�ܽ������εĹ�Ʊ����**

[Leetcode : 123. Best Time to Buy and Sell Stock III (Hard)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/)

```java
public int maxProfit(int[] prices) {
    int firstBuy = Integer.MIN_VALUE, firstSell = 0;
    int secondBuy = Integer.MIN_VALUE, secondSell = 0;
    for (int curPrice : prices) {
        if (firstBuy < -curPrice) firstBuy = -curPrice;
        if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice;
        if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice;
        if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice;
    }
    return secondSell;
}
```

**ֻ�ܽ��� k �εĹ�Ʊ����**

[Leetcode : 188. Best Time to Buy and Sell Stock IV (Hard)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/)

```html
dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] } = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
```

```java
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (k >= n/2) {
        int maxPro = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1])
                maxPro += prices[i] - prices[i-1];
        }
        return maxPro;
    }
    int[][] dp = new int[k + 1][n];
    for (int i = 1; i <= k; i++) {
        int localMax = dp[i - 1][0] - prices[0];
        for (int j = 1; j < n; j++) {
            dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
            localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
        }
    }
    return dp[k][n - 1];
}
```

### ��������

**���������**

[Leetcode : 303. Range Sum Query - Immutable (Easy)](https://leetcode.com/problems/range-sum-query-immutable/description/)

������ i \~ j �ĺͣ�����ת��Ϊ sum[j] - sum[i-1]������ sum[i] Ϊ 0 \~ j �ĺ͡�

```java
class NumArray {
    
    int[] nums;
    
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? nums[j] : nums[j] - nums[i - 1];
    }
}
```

**���������ĺ�**

[Leetcode : 53. Maximum Subarray (Easy)](https://leetcode.com/problems/maximum-subarray/description/)

�� sum[i] Ϊ�� num[i] Ϊ��β�����������ĺͣ������� sum[i-1] �õ� sum[i] ��ֵ����� sum[i-1] С�� 0����ô�� num[i] Ϊ��β�������鲻�ܰ���ǰ������ݣ���Ϊ����ǰ��Ĳ��֣���ô��һ����� num[i] ��С��

```java
public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] sum = new int[n];
    sum[0] = nums[0];
    int max = sum[0];
    for(int i = 1; i < n; i++){
        sum[i] = (sum[i-1] > 0 ? sum[i-1] : 0) + nums[i];
        max = Math.max(max, sum[i]);
    }
    return max;
}
```

**�����еȲ����������ĸ���**

[Leetcode : 413. Arithmetic Slices (Medium)](https://leetcode.com/problems/arithmetic-slices/description/)

```html
A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
```

���� (1,2,3,4)������������ɵ���������ķ�ʽ�������� (1,2,3,4,5)������ɵ���������ķ�ʽ���� (1,2,3,4) �������⻹����һ�֣��� (1,2,3,4,5)����� dp[i] = dp[i - 1] + 1��

```java
public int numberOfArithmeticSlices(int[] A) {
    int n = A.length;
    int[] dp = new int[n];
    for(int i = 2; i < n; i++) {
        if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            dp[i] = dp[i - 1] + 1;
        }
    }
    int ret = 0;
    for(int cnt : dp) {
        ret += cnt;
    }
    return ret;
}
```

### �ַ����༭

**ɾ�������ַ������ַ�ʹ�������**

[Leetcode : 583. Delete Operation for Two Strings (Medium)](https://leetcode.com/problems/delete-operation-for-two-strings/description/)

����ת��Ϊ�������ַ�������������������⡣

```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            if (i == 0 || j == 0) continue;
            dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1
                    : Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
    }
    return m + n - 2 * dp[m][n];
}
```


**�޸�һ���ַ�����Ϊ��һ���ַ���** // TODO

[Leetcode : 72. Edit Distance (Hard)](https://leetcode.com/problems/edit-distance/description/)

**�޸�һ���ַ���ʹ����Ϊ�����ַ���**// TODO

[����Ա��������ָ��-�ַ���](#)

### ��������

**��Ҫ��ȴ�ڵĹ�Ʊ����**

[Leetcode : 309. Best Time to Buy and Sell Stock with Cooldown(Medium)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/)

��Ŀ����������֮����Ҫ��һ�����ȴʱ�䡣

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/ac9b31ec-cef1-4880-a875-fc4571ca10e1.png)

```html
s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
```


```java
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int n = prices.length;
    int[] s0 = new int[n];
    int[] s1 = new int[n];
    int[] s2 = new int[n];
    s0[0] = 0;
    s1[0] = -prices[0];
    s2[0] = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
        s0[i] = Math.max(s0[i - 1], s2[i - 1]);
        s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
        s2[i] = Math.max(s2[i - 1], s1[i - 1] + prices[i]);
    }
    return Math.max(s0[n - 1], s2[n - 1]);
}
```


**ͳ�ƴ� 0 \~ n ÿ�����Ķ����Ʊ�ʾ�� 1 �ĸ���**

[Leetcode : 338. Counting Bits (Medium)](https://leetcode.com/problems/counting-bits/description/)

�������� 6(110)�������Կ��������� 2(10) ǰ�����һ�� 1 ����� dp[i] = dp[i&(i-1)] + 1;

```java
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[i&(i-1)] + 1;
        }
        return ret;
    }
```

**һ���������ܹ����ɵ����**

[Leetcode : 646. Maximum Length of Pair Chain (Medium)](https://leetcode.com/problems/maximum-length-of-pair-chain/description/)

���� (a, b) �� (c, d) ����� b < c�������ǿ��Թ���һ������

```java
public int findLongestChain(int[][] pairs) {
    if(pairs == null || pairs.length == 0) {
        return 0;
    }
    Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
    int n = pairs.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < i; j++) {
            if(pairs[i][0] > pairs[j][1]){
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    
    int ret = 0;
    for(int num : dp) {
        ret = Math.max(ret, num);
    }
    return ret;
}
```

**������۳���Ʊ��������**

[Leetcode : 121. Best Time to Buy and Sell Stock (Easy)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

ֻ����һ�ν��ס�

ֻҪ��¼ǰ�����С�۸񣬽������С�۸���Ϊ����۸�Ȼ�󽫵�ǰ�ļ۸���Ϊ�۳��۸񣬲鿴����۸��Ƿ��ǵ�ǰ�����۸�

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    if(n == 0) return 0;
    int soFarMin = prices[0];
    int max = 0;
    for(int i = 1; i < n; i++){
        if(soFarMin > prices[i]) soFarMin = prices[i];
        else max = Math.max(max, prices[i] - soFarMin);
    }
    return max;
}
```

**����ճ���ַ�**

[Leetcode : 650. 2 Keys Keyboard (Medium)](https://leetcode.com/problems/2-keys-keyboard/description/)

```java
public int minSteps(int n) {
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
        dp[i] = i;
        for (int j = i - 1; j >= 0; j--) {
            if (i % j == 0) {
                dp[i] = dp[j] + dp[i / j];
                break;
            }
        }
    }
    return dp[n];
}
```

```java
public int minSteps(int n) {
    if (n == 1) return 0;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return i + minSteps(n / i);
    }
    return n;
}
```

## ��ѧ

### ����

**�����ֽ�**

ÿһ���������Էֽ�������ĳ˻������� 84 = 2<sup>2</sup> \* 3<sup>1</sup> \* 5<sup>0</sup> \* 7<sup>1</sup> \* 11<sup>0</sup> \* 13<sup>0</sup> \* 17<sup>0</sup> \* ��

**����**

�� x = 2<sup>m0</sup> \* 3<sup>m1</sup> \* 5<sup>m2</sup> \* 7<sup>m3</sup> \* 11<sup>m4</sup> \* ��
�� y = 2<sup>n0</sup> \* 3<sup>n1</sup> \* 5<sup>n2</sup> \* 7<sup>n3</sup> \* 11<sup>n4</sup> \* ��

��� x ���� y��y mod x == 0������������� i��mi <= ni��

x �� y �� **���Լ��** Ϊ��gcd(x,y) =  2<sup>min(m0,n0)</sup> \* 3<sup>min(m1,n1)</sup> \* 5<sup>min(m2,n2)</sup> \* ...

x �� y �� **��С������** Ϊ��lcm(x,y) =  2<sup>max(m0,n0)</sup> \* 3<sup>max(m1,n1)</sup> \* 5<sup>max(m2,n2)</sup> \* ...

**������������**

[Leetcode : 204. Count Primes (Easy)](https://leetcode.com/problems/count-primes/description/)

������˹����ɸ����ÿ���ҵ�һ������ʱ�����ܱ��������������ų�����

```java
public int countPrimes(int n) {
    boolean[] notPrimes = new boolean[n + 1];
    int cnt = 0;
    for(int i = 2; i < n; i++){
        if(notPrimes[i]) continue;
        cnt++;
        // �� i * i ��ʼ����Ϊ��� k < i����ô k * i ��֮ǰ���Ѿ���ȥ������
        for(long j = (long) i * i; j < n; j += i){
            notPrimes[(int) j] = true;
        }
    }
    return cnt;
}
```

### ���Լ��

```java
int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```

��󹫱���Ϊ�����ĳ˻��������Լ����

```java
int lcm(int a, int b){
    return a * b / gcd(a, b);
}
```

�������Լ�����⣬��Ϊ��Ҫ���� a % b ������������ǱȽϺ�ʱ�ģ�����ʹ�� [ ���֮����2.7]() �ķ��������ü�������λ�������滻����

���� a �� b �����Լ�� f(a, b)���У�

1\. ��� a �� b ��Ϊż����f(a, b) = 2\*f(a/2, b/2);
2\. ��� a ��ż�� b ��������f(a, b) = f(a/2, b);
3\. ��� b ��ż�� a ��������f(a, b) = f(a, b/2);
4\. ��� a �� b ��Ϊ������f(a, b) = f(a, a-b);

�� 2 �ͳ� 2 ������ת��Ϊ��λ������

### ����ת��

Java �� static String toString(int num, int radix) ���Խ�һ������װ��Ϊ redix ���Ʊ�ʾ���ַ�����

**7 ����**

[Leetcode : 504. Base 7 (Easy)](https://leetcode.com/problems/base-7/description/)

```java
public String convertToBase7(int num) {
    if (num < 0) {
        return '-' + convertToBase7(-num);
    }
    if (num < 7) {
        return num + "";
    }
    return convertToBase7(num / 7) + num % 7;
}
```

**16 ����**

[Leetcode : 405. Convert a Number to Hexadecimal (Easy)](https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/)

```java
public String toHex(int num) {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    if(num == 0) return "0";
    String ret = "";
    while(num != 0){
        ret = map[(num & 0b1111)] + ret;
        num >>>= 4;
    }
    return ret;
}
```

### �׳�

**ͳ�ƽ׳�β���ж��ٸ� 0**

[Leetcode : 172. Factorial Trailing Zeroes (Easy)](https://leetcode.com/problems/factorial-trailing-zeroes/description/)

β���� 0 �� 2 * 5 ������2 ���������Զ��� 5 �����������ֻҪͳ���ж��ٸ� 5 ���ɡ�

����һ���� N���������� 5 �ĸ���Ϊ��N/5 + N/5<sup>2</sup> + N/5<sup>3</sup> + ...������ N/5 ��ʾ������ N ������ 5 �ı�������һ�� 5��N/5<sup>2</sup> ��ʾ������ N ������ 5<sup>2</sup> �ı����ٹ���һ�� 5 ...��

```java
public int trailingZeroes(int n) {
    return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
}
```

���ͳ�Ƶ��� N! �Ķ����Ʊ�ʾ�����λ 1 ��λ�ã�ֻҪͳ���ж��ٸ� 2 ���ɣ�����Ŀ���� [ ���֮����2.2](#) ��������ж��ٸ� 5 һ����2 �ĸ���Ϊ N/2 + N/2<sup>2</sup> + N/2<sup>3</sup> + ...

### �ַ����ӷ�����

**�����Ƽӷ�**

[Leetcode : 67. Add Binary (Easy)](https://leetcode.com/problems/add-binary/description/)

```java
public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
    String str = "";
    while(i >= 0 || j >= 0){
        if(i >= 0 && a.charAt(i--) == '1') carry++;
        if(j >= 0 && b.charAt(j--) == '1') carry++;
        str = (carry % 2) + str;
        carry /= 2;
    }
    if(carry == 1) str = "1" + str;
    return str;
}
```

**�ַ����ӷ�**

[Leetcode : 415. Add Strings (Easy)](https://leetcode.com/problems/add-strings/description/)

��Ŀ�������ַ�����ֵΪ�Ǹ�����

```java
public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
        int x = i < 0 ? 0 : num1.charAt(i) - '0';
        int y = j < 0 ? 0 : num2.charAt(j) - '0';
        sb.append((x + y + carry) % 10);
        carry = (x + y + carry) / 10;
    }
    return sb.reverse().toString();
}
```

### ��������

**�ı�����Ԫ��ʹ���е�����Ԫ�ض����**

[Leetcode : 462. Minimum Moves to Equal Array Elements II (Medium)](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/)

��Ŀ������ÿ�ο��Զ�һ������Ԫ�ؼ�һ���߼�һ������С�ĸı������

���Ǹ����͵��������⣬�ƶ�������С�ķ�ʽ������Ԫ�ض��ƶ�����λ�����������£�

�� m Ϊ��λ����a �� b �� m ���ߵ�����Ԫ�أ��� b > a��Ҫʹ a �� b ��ȣ������ܹ��ƶ��Ĵ���Ϊ b - a�����ֵ���� (b - m) + (m - a)��Ҳ���ǰ����������ƶ�����λ�����ƶ�������

�����鳤��Ϊ N��������ҵ� N/2 �� a �� b ����ϣ�ʹ���Ƕ��ƶ��� m ��λ�á�

**�ⷨ 1**

������ʱ�临�Ӷȣ�O(NlgN)

```java
public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int ret = 0;
    int l = 0, h = nums.length - 1;
    while(l <= h) {
        ret += nums[h] - nums[l];
        l++;
        h--;
    }
    return ret;
}
```

**�ⷨ 2**

ʹ�ÿ��������ҵ���λ����ʱ�临�Ӷ� O(N)

```java
public int minMoves2(int[] nums) {
    int ret = 0;
    int n = nums.length;
    int median = quickSelect(nums, 0, n - 1, n / 2 + 1);
    for(int num : nums) ret += Math.abs(num - median);
    return ret;
}

private int quickSelect(int[] nums, int start, int end, int k) {
    int l = start, r = end, privot = nums[(l + r) / 2];
    while(l <= r) {
        while(nums[l] < privot) l++;
        while(nums[r] > privot) r--;
        if(l >= r) break;
        swap(nums, l, r);
        l++; r--;
    }
    int left = l - start + 1;
    if(left > k) return quickSelect(nums, start, l - 1, k);
    if(left == k && l == r) return nums[l];
    int right = r - start + 1;
    return quickSelect(nums, r + 1, end, k - right);
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
}
```

### ����ͶƱ����

**�����г��ִ������� n / 2 ��Ԫ��**

[Leetcode : 169. Majority Element (Easy)](https://leetcode.com/problems/majority-element/description/)

�ȶ������������м��Ǹ������ִ���һ������ n / 2

```java
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
}
```

�������� Boyer-Moore Majority Vote Algorithm �����������⣬ʹ��ʱ�临�Ӷ�Ϊ O(n)��������ô�����㷨��ʹ�� cnt ��ͳ��һ��Ԫ�س��ֵĴ���������������Ԫ�غ�ͳ��Ԫ�ز����ʱ���� cnt--�����ǰ������� i ��Ԫ�أ��� cnt == 0 ��˵��ǰ i ��Ԫ��û�� majority�������� majority�����ǳ��ֵĴ������� i / 2 ����Ϊ������� i / 2 �Ļ� cnt ��һ������Ϊ 0 ����ʱʣ�µ� n - i ��Ԫ���У�majority ����Ŀ���� (n - i) / 2����˼������Ҿ����ҳ� majority��

```java
public int majorityElement(int[] nums) {
    int cnt = 0, majority = 0;
    for(int i = 0; i < nums.length; i++){
        if(cnt == 0) {
            majority = nums[i];
            cnt++;
        }
        else if(majority == nums[i]) cnt++;
        else cnt--;
    }
    return majority;
}
```

**�����г��ִ������� n / k ��Ԫ��**

[����Ա��������ָ�� P343](#)

ѡ k - 1 ����ѡ

### ����

**ƽ����**

[Leetcode : 367. Valid Perfect Square (Easy)](https://leetcode.com/problems/valid-perfect-square/description/)

ƽ�����У�1,4,9,16,..
�����3,5,7,...

���Ϊ�Ȳ����У�ʹ��������Կ��Եõ��� 1 ��ʼ��ƽ�����С�

```java
public boolean isPerfectSquare(int num) {
    int subNum = 1;
    while (num > 0) {
        num -= subNum;
        subNum += 2;
    }
    return num == 0;
}
```

**3 �� n �η�**

[Leetcode : 326. Power of Three (Easy)](https://leetcode.com/problems/power-of-three/description/)

```java
public boolean isPowerOfThree(int n) {
    return n > 0 && (1162261467 % n == 0);
}
```

**�ҳ������еĳ˻�����������**

[Leetcode : 628. Maximum Product of Three Numbers (Easy)](https://leetcode.com/problems/maximum-product-of-three-numbers/description/)

```java
public int maximumProduct(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int n : nums) {
        if (n > max1) {
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if (n > max2) {
            max3 = max2;
            max2 = n;
        } else if (n > max3) {
            max3 = n;
        }

        if (n < min1) {
            min2 = min1;
            min1 = n;
        } else if (n < min2) {
            min2 = n;
        }
    }
    return Math.max(max1*max2*max3, max1*min1*min2);
}
```

**�˻�����**

[Leetcode : 238. Product of Array Except Self (Medium)](https://leetcode.com/problems/product-of-array-except-self/description/)

��Ŀ����������һ�����飬����һ�������飬�������ÿ��Ԫ��Ϊԭʼ�����г��˸�λ���ϵ�Ԫ��֮������Ԫ�صĳ˻���

��ĿҪ��ʱ�临�Ӷ�Ϊ O(n)�����Ҳ���ʹ�ó�����

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ret = new int[n];
    ret[0] = 1;
    for(int i = 1; i < n; i++) {
        ret[i] = ret[i - 1] * nums[i - 1];
    }
    int right = 1;
    for(int i = n - 1; i >= 0; i--) {
        ret[i] *= right;
        right *= nums[i];
    }
    return ret;
}
```

# ���ݽṹ���

## ջ�Ͷ���

**��ջʵ�ֶ���**

һ��ջʵ�֣�

```java
class  MyQueue {
    private Stack<Integer> st = new Stack();

    public void push(int x) {
        Stack<Integer> temp = new Stack();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(x);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}
```

����ջʵ�֣�

```java
class  MyQueue {
    private Stack<Integer> in = new Stack();
    private Stack<Integer> out = new Stack();
  
    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }
    
    private void in2out(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
```

**�ö���ʵ��ջ**

[Leetcode : 225. Implement Stack using Queues (Easy)](https://leetcode.com/problems/implement-stack-using-queues/description/)

```java
class MyStack {
    
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i++){ // ��ת
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
```

**��Сֵջ**

[Leetcode : 155. Min Stack (Easy)](https://leetcode.com/problems/min-stack/description/)

������ջʵ�֣�һ���洢���ݣ�һ���洢��Сֵ��

```java
class MinStack {
    
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        dataStack.add(x);
        if(x < min) {
            min = x;
        }
        minStack.add(min);
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
        if(!minStack.isEmpty()) {
            min = minStack.peek();
        } else{
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```

����ʵ����Сֵ�������⣬�����Ƚ�����ʹ��ջ��ʵ�֣�Ȼ��ͽ�����ת��Ϊ��Сֵջ�������������� ���֮����3.7��

**��ջʵ������ƥ��**

[Leetcode : 20. Valid Parentheses (Easy)](https://leetcode.com/problems/valid-parentheses/description/)

```html
"()[]{}"

Output : true
```

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(c == '(' || c == '{' || c == '[') stack.push(c);
        else{
            if(stack.isEmpty()) return false;
            char cStack = stack.pop();
            if(c == ')' && cStack != '(' ||
              c == ']' && cStack != '[' ||
              c == '}' && cStack != '{' ) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

**�����бȵ�ǰԪ�ش����һ������Ԫ�صľ���**

```html
Input: [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]
```

[Leetcode : 739. Daily Temperatures (Medium)](https://leetcode.com/problems/daily-temperatures/description/)

ʹ��ջ���洢��δ�����Ԫ�ء����Ա�֤��ջ������Ԫ�ص���������������һ��������ĳ��Ԫ�ش��Ԫ�ؽ���ջ�У������Ǹ�Ԫ���Ѿ��ҵ��������Ԫ�أ���˻��ջ��

```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ret = new int[n];
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < n; i++) {
        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int idx = stack.pop();
            ret[idx] = i - idx;
        }
        stack.add(i);
    }
    return ret;
}
```

**��������һ���ȵ�ǰ�������**

[Leetcode : 496. Next Greater Element I (Easy)](https://leetcode.com/problems/next-greater-element-i/description/)

```html
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
```

�ڱ�������ʱ�� Stack �������е����������������ǰ����������ջ��Ԫ�����Ĵ�˵��ջ��Ԫ�ص���һ��������������ǵ�ǰԪ�ء�

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for(int num : nums2){
        while(!stack.isEmpty() && num > stack.peek()){
            map.put(stack.pop(), num);
        }
        stack.add(num);
    }
    int[] ret = new int[nums1.length];
    for(int i = 0; i < nums1.length; i++){
        if(map.containsKey(nums1[i])) ret[i] = map.get(nums1[i]);
        else ret[i] = -1;
    }
    return ret;
}
```

**ѭ����������һ���ȵ�ǰԪ�ش����**

[Leetcode : 503. Next Greater Element II (Medium)](https://leetcode.com/problems/next-greater-element-ii/description/)

```java
public int[] nextGreaterElements(int[] nums) {
    int n = nums.length, next[] = new int[n];
    Arrays.fill(next, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n * 2; i++) {
        int num = nums[i % n];
        while (!stack.isEmpty() && nums[stack.peek()] < num)
            next[stack.pop()] = num;
        if (i < n) stack.push(i);
    }
    return next;
}
```


## ��ϣ��

���� Hash Table ���Կ��ٲ���һ��Ԫ���Ƿ���ڵ����⣬������Ҫһ���Ŀռ����洢�������ȿ���ʱ�临�Ӷȵ�����£��������� Hash Table ���ֿռ任ȡʱ���������

Java �е� **HashSet** ���ڴ洢һ�����ϣ����� O(1) ��ʱ�临�ӶȲ���Ԫ���Ƿ��ڼ����С�

���Ԫ��������ҷ�Χ������ô������һ�������������洢һ��Ԫ���Ƿ���ڣ��������ֻ��Сд�ַ���Ԫ�أ��Ϳ�����һ������Ϊ 26 �Ĳ����������洢һ���ַ����ϣ�ʹ�ÿռ临�ӶȽ���Ϊ O(1)��

Java �е� **HashMap** ��Ҫ����ӳ���ϵ���Ӷ�������Ԫ����ϵ������

�ڶ�һ�����ݽ���ѹ����������ת��ʱ������ HashMap ���԰�ԭʼ���ݺ�ת�����������ϵ������������һ���� url ��ϵͳ�У�[Leetcdoe : 535. Encode and Decode TinyURL (Medium)](https://leetcode.com/problems/encode-and-decode-tinyurl/description/)�������� HashMap �Ϳ��Դ洢������ url ��ԭʼ url ��ӳ�䣬ʹ�ò���������ʾ�򻯵� url��Ҳ���Ը��ݼ򻯵� url �õ�ԭʼ url �Ӷ���λ����ȷ����Դ��

HashMap Ҳ����������Ԫ�ؽ��м���ͳ�ƣ���ʱ��ΪԪ�أ�ֵΪ�������� HashSet ���ƣ����Ԫ������ҷ�Χ���󣬿�������������������ͳ�ơ�


**�����е���������Ϊ����ֵ**

[Leetcode : 1. Two Sum (Easy)](https://leetcode.com/problems/two-sum/description/)

�����ȶ������������Ȼ��ʹ��˫ָ�뷽�����߶��ֲ��ҷ�������������ʱ�临�Ӷ�Ϊ O(nlg<sub>n</sub>)���ռ临�Ӷ�Ϊ O(1)��

�� HashMap �洢����Ԫ�غ�������ӳ�䣬�ڷ��ʵ� nums[i] ʱ���ж� HashMap ���Ƿ���� target - nums[i] ���������˵�� target - nums[i] ���ڵ������� i ����Ҫ�ҵ����������÷�����ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(n)��ʹ�ÿռ�����ȡʱ�䡣

```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
        else map.put(nums[i], i);
    }
    return null;
}
```

**���г����**

��г���������������С��ֻ������Ϊ 1

[Leetcode : 594. Longest Harmonious Subsequence (Easy)](https://leetcode.com/problems/longest-harmonious-subsequence/description/)

```java
public int findLHS(int[] nums) {
    Map<Long, Integer> map = new HashMap<>();
    for (long num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int result = 0;
    for (long key : map.keySet()) {
        if (map.containsKey(key + 1)) {
            result = Math.max(result, map.get(key + 1) + map.get(key));
        }
    }
    return result;
}
```

## �ַ���

**�����ַ����İ������ַ��Ƿ���ȫ��ͬ**

[Leetcode : 242. Valid Anagram (Easy)](https://leetcode.com/problems/valid-anagram/description/)

�ַ���ֻ����Сд�ַ����ܹ��� 26 ��Сд�ַ��������� Hash Table ��ӳ���ַ�����ִ�������Ϊ��ֵ��Χ��С����˿���������������ӳ�䡣

ʹ�ó���Ϊ 26 ������������ַ������ֵ��ַ�����ͳ�ƣ��Ƚ������ַ������ֵ��ַ������Ƿ���ͬ��

```java
public boolean isAnagram(String s, String t) {
    int[] cnts = new int[26];
    for(int i  = 0; i < s.length(); i++) cnts[s.charAt(i) - 'a'] ++;
    for(int i  = 0; i < t.length(); i++) cnts[t.charAt(i) - 'a'] --;
    for(int i  = 0; i < 26; i++) if(cnts[i] != 0) return false;
    return true;
}
```

**�ַ���ͬ��**

[Leetcode : 205. Isomorphic Strings (Easy)](https://leetcode.com/problems/isomorphic-strings/description/)

���� "egg" �� "add" ������ͬ���ַ�����

��¼һ���ַ��ϴγ��ֵ�λ�ã���������ַ�����ĳ���ַ��ϴγ��ֵ�λ��һ������ô������ͬ����

```java
public boolean isIsomorphic(String s, String t) {
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    for(int i = 0; i < s.length(); i++){
        if(m1[s.charAt(i)] != m2[t.charAt(i)]) {
            return false;
        }
        m1[s.charAt(i)] = i + 1;
        m2[t.charAt(i)] = i + 1;
    }
    return true;
}
```

**����һ���ַ����Ͽ�����ɵĻ����ַ�������󳤶�**

[Leetcode : 409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/description/)

ʹ�ó���Ϊ 128 ������������ͳ��ÿ���ַ����ֵĸ�����ÿ���ַ���ż���������������ɻ����ַ�������Ϊ�����ַ������м���Ǹ��ַ����Ե������֣���������е������ַ��Ͱ����ŵ����м䡣

```java
public int longestPalindrome(String s) {
    int[] cnts = new int[128]; // ascii ���ܹ� 128 ��
    for(char c : s.toCharArray()) cnts[c]++;
    int ret = 0;
    for(int cnt : cnts)  ret += (cnt / 2) * 2;
    if(ret < s.length()) ret ++; // ��������� s ��һ���е���δʹ�õ��ַ����ڣ����԰�����ַ��ŵ����ĵ����м�
    return ret;
}
```

**�ж�һ�������Ƿ��ǻ�����**

[Leetcode : 9. Palindrome Number (Easy)](https://leetcode.com/problems/palindrome-number/description/)

Ҫ����ʹ�ö���ռ䣬Ҳ�Ͳ��ܽ�����ת��Ϊ�ַ��������жϡ�

�������ֳ����������֣��ұ��ǲ�����Ҫת�ã�Ȼ���ж����������Ƿ���ȡ�

```java
public boolean isPalindrome(int x) {
    if(x == 0) return true;
    if(x < 0) return false;
    if(x % 10 == 0) return false;
    int right = 0;
    while(x > right){
        right = right * 10 + x % 10;
        x /= 10;
    }
    return x == right || x == right / 10;
}
```

**�������ַ���**

[Leetcode : 647. Palindromic Substrings (Medium)](https://leetcode.com/problems/palindromic-substrings/description/)

��������Ǵ��ַ�����ĳһλ��ʼ��������ȥ��չ���ַ�����

```java
private int cnt = 0;
public int countSubstrings(String s) {
    for(int i = 0; i < s.length(); i++) {
        extendSubstrings(s, i, i);    // ��������
        extendSubstrings(s, i, i + 1); // ż������
    }
    return cnt;
}

private void extendSubstrings(String s, int start, int end) {
    while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        start--;
        end++;
        cnt++;
    }
}
```

**ͳ�ƶ������ַ��������� 1 �� ���� 0 ������ͬ�����ַ�������**

```html
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
```

[Leetcode : 696. Count Binary Substrings (Easy)](https://leetcode.com/problems/count-binary-substrings/description/)

```java
public int countBinarySubstrings(String s) {
    int preLen = 0, curLen = 1, ret = 0;
    for(int i = 1; i < s.length(); i++){
        if(s.charAt(i) == s.charAt(i-1)) curLen++;
        else{
            preLen = curLen;
            curLen = 1;
        }

        if(preLen >= curLen) ret++;
    }
    return ret;
}
```

**�ַ���ѭ����λ����**

[ ���֮����3.1](#)

���������ַ��� s1 �� s2 ��Ҫ���ж� s2 �Ƿ��ܹ��� s1 ��ѭ����λ�õ����ַ���������

```html
s1 = AABCD, s2 = CDAA
Return : true
```

s1 ����ѭ����λ�Ľ���� s1s1 �����ַ��������ֻҪ�ж� s2 �Ƿ��� s1s1 �����ַ������ɡ�

**�ַ���ѭ����λ**

[ ���֮����2.17](#)

���ַ�������ѭ���ƶ� k λ��

���� abcd123 �����ƶ� 3 λ �õ� 123abcd

�� abcd123 �е� abcd �� 123 �������򣬵õ� dcba321��Ȼ��������ַ����������򣬵õ�123abcd��

**�ַ����е��ʵķ�ת**

[����Ա��������ָ��](#)

���罫 "I am a student" ��ת�� "student a am I"

��ÿ����������Ȼ�������ַ�������

## ���������

**������ת** // TODO

[����Ա���Խ�� P114](#)

**֮���ʹ�ӡ** //TODO

[����Ա��������ָ�� P335](#)

**�������е� 0 �Ƶ�ĩβ**

[Leetcode : 283. Move Zeroes (Easy)](https://leetcode.com/problems/move-zeroes/description/)

```java
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0) nums[idx++] = nums[i];
        }
        while(idx < n){
            nums[idx++] = 0;
        }
    }
```

**һ������Ԫ���� [1, n] ֮�䣬����һ�������滻Ϊ��һ�������ҳ���ʧ�������ظ�����**

[Leetcode : 645. Set Mismatch (Easy)](https://leetcode.com/problems/set-mismatch/description/)

��ֱ�ӵķ������ȶ���������������ַ���ʱ�临�Ӷ�Ϊ O(nlog<sub>n</sub>)����������� O(n) ��ʱ�临�Ӷȡ�O(1) �ռ临�Ӷ�����⡣

��Ҫ˼������ͨ����������Ԫ�أ�ʹ�������ϵ�Ԫ������ȷ��λ���ϡ�

�������飬����� i λ�ϵ�Ԫ�ز��� i + 1 ����ô�ͽ����� i λ �� nums[i] - 1 λ�ϵ�Ԫ�أ�ʹ�� num[i] - 1 ��Ԫ��Ϊ nums[i] ��Ҳ���Ǹ�λ��Ԫ������ȷ�ġ�����������Ҫѭ�����У���Ϊһ�ν���û�취ʹ�õ� i λ�ϵ�Ԫ������ȷ�ġ�����Ҫ����������Ԫ�ؿ��ܾ����ظ�Ԫ�أ���ôѭ���Ϳ�����Զ������ȥ����ֹѭ���ķ����Ǽ��� nums[i] != nums[nums[i] - 1 ������

������Ŀ��

- [Leetcode :448. Find All Numbers Disappeared in an Array (Easy)](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)��Ѱ�����ж�ʧ��Ԫ��
- [Leetcode : 442. Find All Duplicates in an Array (Medium)](https://leetcode.com/problems/find-all-duplicates-in-an-array/description/)��Ѱ�������ظ���Ԫ�ء�

```java
public int[] findErrorNums(int[] nums) {
    for(int i = 0; i < nums.length; i++){
        while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
    }
    
    for(int i = 0; i < nums.length; i++){
        if(i + 1 != nums[i]) return new int[]{nums[i], i + 1};
    }
    
    return null;
}

private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```

**�ҳ��������ظ�����������ֵ�� [0, n-1] ֮��**

[Leetcode : 287. Find the Duplicate Number (Medium)](https://leetcode.com/problems/find-the-duplicate-number/description/)

���ֲ��ҽⷨ��

```java
public int findDuplicate(int[] nums) {
     int l = 1, h = nums.length - 1;
     while (l <= h) {
         int mid = l + (h - l) / 2;
         int cnt = 0;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] <= mid) cnt++;
         }
         if (cnt > mid) h = mid - 1;
         else l = mid + 1;
     }
     return l;
}
```

˫ָ��ⷨ���������л��������ҳ�������ڣ�

```java
public int findDuplicate(int[] nums) {
      int slow = nums[0], fast = nums[nums[0]];
      while (slow != fast) {
          slow = nums[slow];
          fast = nums[nums[fast]];
      }

      fast = 0;
      while (slow != fast) {
          slow = nums[slow];
          fast = nums[fast];
      }
      return slow;
}
```

### �������

�������ָ�����к��зֱ�����ľ���

һ���������������ʹ�ö��ֲ��ҷ�����

```html
[
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
]
```

**����������**

[Leetocde : 240. Search a 2D Matrix II (Medium)](https://leetcode.com/problems/search-a-2d-matrix-ii/description/)

```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    int m = matrix.length, n = matrix[0].length;
    int row = 0, col = n - 1;
    while (row < m && col >= 0) {
        if (target == matrix[row][col]) return true;
        else if (target < matrix[row][col]) col--;
        else row++;
    }
    return false;
}
```

**�������� Kth Element**

[Leetcode : 378. Kth Smallest Element in a Sorted Matrix ((Medium))](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/)

```html
matrix = [
  [ 1,  5,  9],
  [10, 11, 13],
  [12, 13, 15]
],
k = 8,

return 13.
```

����ο���[Share my thoughts and Clean Java Code](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173)

���ֲ��ҽⷨ��

```java
public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
    while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n && matrix[i][j] <= mid; j++) {
                cnt++;
            }
        }
        if(cnt < k) lo = mid + 1;
        else hi = mid - 1;
    }
    return lo;
}
```

�ѽⷨ��

```java
public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
    for(int i = 0; i < k - 1; i++) { // С���ѣ�ȥ�� k - 1 ���Ѷ�Ԫ�أ���ʱ�Ѷ�Ԫ�ؾ��ǵ� k ����
        Tuple t = pq.poll();
        if(t.x == m - 1) continue;
        pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
    }
    return pq.poll().val;
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x; this.y = y; this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
```

## ����

**�ж���������Ľ���**

[Leetcode : 160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/description/)

```html
A:          a1 �� a2
                  �K
                    c1 �� c2 �� c3
                  �J
B:    b1 �� b2 �� b3
```

Ҫ��ʱ�临�Ӷ�Ϊ O(n) �ռ临�Ӷ�Ϊ O(1)

�� A �ĳ���Ϊ a + c��B �ĳ���Ϊ b + c������ c Ϊβ���������ֳ��ȣ���֪ a + c + b = b + c + a��

������ A �����ָ����ʵ�����β��ʱ������������ B ��ͷ����ʼ�������� B��ͬ���أ������� B �����ָ����ʵ�����β��ʱ������������ A ��ͷ����ʼ�������� A���������ܿ��Ʒ��� A �� B ���������ָ����ͬʱ���ʵ����㡣

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    ListNode l1 = headA, l2 = headB;
    while(l1 != l2){
        l1 = (l1 == null) ? headB : l1.next;
        l2 = (l2 == null) ? headA : l2.next;
    }
    return l1;
}
```

���ֻ���ж��Ƿ���ڽ��㣬��ô������һ�����⣬�� ���֮����3.6 �����⡣�����ֽⷨ���ѵ�һ������Ľ�β���ӵ��ڶ�������Ŀ�ͷ�����ڶ��������Ƿ���ڻ�������ֱ�ӱȽϵ�һ���������һ���ڵ�͵ڶ����������һ���ڵ��Ƿ���ͬ��



**����ת**

[Leetcode : 206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)

ͷ�巨�ܹ������򹹽�����

```java
public ListNode reverseList(ListNode head) {
    ListNode newHead = null; // ��Ϊ null ����Ϊ������Ľ�β
    while(head != null){
        ListNode nextNode = head.next;
        head.next = newHead;
        newHead = head;
        head = nextNode;
    }
    return newHead;
}
```

**�鲢�������������**

[Leetcode : 21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)

�������һ���������õݹ鷽ʽ�����壺�����ǿսڵ㣬������һ��ֵ��һ��ָ����һ�������ָ�룬��˺ܶ�������������õݹ�������

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode newHead = null;
    if(l1.val < l2.val){
        newHead = l1;
        newHead.next = mergeTwoLists(l1.next, l2);
    } else{
        newHead = l2;
        newHead.next = mergeTwoLists(l1, l2.next);
    }
    return newHead;
}
```

**������������ɾ���ظ��ڵ�**

[Leetcode : 83. Remove Duplicates from Sorted List (Easy)](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)

```java
public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    head.next = deleteDuplicates(head.next);
    return head.next != null && head.val == head.next.val ? head.next : head;
}
```

**��������**

[Leetcode : 234. Palindrome Linked List (Easy)](https://leetcode.com/problems/palindrome-linked-list/description/)

�г����룬�Ѻ��η�ת��Ȼ��Ƚ������Ƿ���ȡ�

```java
public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    ListNode slow = head, fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    if(fast != null){  // ż���ڵ㣬�� slow ָ����һ���ڵ�
        slow = slow.next;
    }

    cut(head, slow); // �г���������
    ListNode l1 = head, l2 = slow;
    l2 = reverse(l2);
    return isEqual(l1, l2);
}

private void cut(ListNode head, ListNode cutNode){
    while( head.next != cutNode ) head = head.next;
    head.next = null;
}

private ListNode reverse(ListNode head){
    ListNode newHead = null;
    while(head != null){
        ListNode nextNode = head.next;
        head.next = newHead;
        newHead = head;
        head = nextNode;
    }
    return newHead;
}

private boolean isEqual(ListNode l1, ListNode l2){
    while(l1 != null && l2 != null){
        if(l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return true;
}
```

**��������ɾ���ڵ�**

[���֮����3.4]()

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/2c968ec5-0967-49ce-ac06-f8f5c9ab33bc.jpg)

```java
B.val = C.val;
B.next = C.next;
```

**����Ԫ�ذ���ż�ۼ�**

[Leetcode : 328. Odd Even Linked List (Medium)](https://leetcode.com/problems/odd-even-linked-list/description/)

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null) {
        return head;
    }
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
        odd.next = odd.next.next;
        odd = odd.next;
        even.next = even.next.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}
```

## ��

### �ݹ�

һ����Ҫô�ǿ�����Ҫô������ָ�룬ÿ��ָ��ָ��һ����������һ�ֵݹ�ṹ���ܶ������������ʹ�õݹ�������

**���ĸ߶�**

[Leetcode : 104. Maximum Depth of Binary Tree (Easy)](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)

```java
public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
```

**��ת��**

[Leetcode : 226. Invert Binary Tree (Easy)](https://leetcode.com/problems/invert-binary-tree/description/)

```java
public TreeNode invertTree(TreeNode root) {
    if(root == null) return null;
    TreeNode left = root.left; // ����Ĳ�����ı� left ָ�룬����ȱ�������
    root.left = invertTree(root.right);
    root.right = invertTree(left);
    return root;
}
```

**�鲢������**

[Leetcode : 617. Merge Two Binary Trees (Easy)](https://leetcode.com/problems/merge-two-binary-trees/description/)

```java
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if(t1 == null && t2 == null) return null;
    if(t1 == null) return t2;
    if(t2 == null) return t1;
    TreeNode root = new TreeNode(t1.val + t2.val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
}
```

**�ж�·�����Ƿ����һ����**

[Leetcdoe : 112. Path Sum (Easy)](https://leetcode.com/problems/path-sum/description/)

��Ŀ������·���Ͷ���Ϊ�� root �� leaf �����нڵ�ĺ�

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) return false;
    if(root.left == null && root.right == null && root.val == sum) return true;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}
```

**ͳ��·���͵���һ������·������**

[Leetcode : 437. Path Sum III (Easy)](https://leetcode.com/problems/path-sum-iii/description/)

��Ŀ������·����һ���� root ��ͷ���� leaf ��β�����Ǳ�������

pathSumStartWithRoot() ����ͳ����ĳ���ڵ㿪ͷ��·��������

```java
public int pathSum(TreeNode root, int sum) {
    if(root == null) return 0;
    int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    return ret;
}

private int pathSumStartWithRoot(TreeNode root, int sum){
    if(root == null) return 0;
    int ret = 0;
    if(root.val == sum) ret++;
    ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
    return ret;
}
```

**���ĶԳ�**

[Leetcode : 101. Symmetric Tree (Easy)](https://leetcode.com/problems/symmetric-tree/description/)

```java
public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(TreeNode t1, TreeNode t2){
    if(t1 == null && t2 == null) return true;
    if(t1 == null || t2 == null) return false;
    if(t1.val != t2.val) return false;
    return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
}
```

**ƽ����**

[Leetcode : 110. Balanced Binary Tree (Easy)](https://leetcode.com/problems/balanced-binary-tree/description/)

��Ŀ���������������߶Ȳ��Ƿ�С�ڵ��� 1

```java
private boolean result = true;

public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return result;
}

public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    if (Math.abs(l - r) > 1) result = false;
    return 1 + Math.max(l, r);
}
```

**��С·��**

[Leetcode : 111. Minimum Depth of Binary Tree (Easy)](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)

��Ŀ���������ĸ��ڵ㵽Ҷ�ӽڵ����С����

```java
public int minDepth(TreeNode root) {
    if(root == null) return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    if(left == 0 || right == 0) return left + right + 1;
    return Math.min(left, right) + 1;
}
```

**ͳ����Ҷ�ӽڵ�ĺ�**

[Leetcode : 404. Sum of Left Leaves (Easy)](https://leetcode.com/problems/sum-of-left-leaves/description/)

```java
public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    if(isLeaf(root.left)) return root.left.val +  sumOfLeftLeaves(root.right);
    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
}

private boolean isLeaf(TreeNode node){
    if(node == null) return false;
    return node.left == null && node.right == null;
}
```

**�޼�һ����**

[Leetcode : 669. Trim a Binary Search Tree (Easy)](https://leetcode.com/problems/trim-a-binary-search-tree/description/)

��Ŀ������ֻ����ֵ�� L \~ R ֮��Ľڵ�

```java
public TreeNode trimBST(TreeNode root, int L, int R) {
    if(root == null) return null;
    if(root.val > R) return trimBST(root.left, L, R);
    if(root.val < L) return trimBST(root.right, L, R);
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
}
```

**����**

[Leetcode : 572. Subtree of Another Tree (Easy)](https://leetcode.com/problems/subtree-of-another-tree/description/)

```java
public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s == null && t == null) return true;
    if(s == null || t == null) return false;
    if(s.val == t.val && isSame(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
}

private boolean isSame(TreeNode s, TreeNode t){
    if(s == null && t == null) return true;
    if(s == null || t == null) return false;
    if(s.val != t.val) return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
}
```

**�����������й�����������**

[Leetcode : 108. Convert Sorted Array to Binary Search Tree (Easy)](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)

�����������BST�������ڵ���ڵ������������нڵ㣬С�ڵ������������нڵ㡣

```java
public TreeNode sortedArrayToBST(int[] nums) {
    return toBST(nums, 0, nums.length - 1);
}

private TreeNode toBST(int[] nums, int sIdx, int eIdx){
    if(sIdx > eIdx) return null;
    int mIdx = (sIdx + eIdx) / 2;
    TreeNode root = new TreeNode(nums[mIdx]);
    root.left =  toBST(nums, sIdx, mIdx - 1);
    root.right = toBST(nums, mIdx + 1, eIdx);
    return root;
}
```

**���ڵ���·��**

```html
          1
        / \
        2  3
      / \
      4  5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
```

```java
private int max = 0;

public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return max;
}

private int depth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int leftDepth = depth(root.left);
    int rightDepth = depth(root.right);
    max = Math.max(max, leftDepth + rightDepth);
    return Math.max(leftDepth, rightDepth) + 1;
}
```

**�ҳ��������еڶ�С�Ľڵ�**

[Leetcode : 671. Second Minimum Node In a Binary Tree (Easy)](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/)

```html
Input:
    2
  / \
  2  5
    / \
    5  7

Output: 5
```

һ���ڵ�Ҫô���� 0 ���� 2 ���ӽڵ㣬������ӽڵ㣬��ô���ڵ�����С�Ľڵ㡣

```java
public int findSecondMinimumValue(TreeNode root) {
    if(root == null) return -1;
    if(root.left == null && root.right == null) return -1;
    int leftVal = root.left.val;
    int rightVal = root.right.val;
    if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
    if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
    if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
    if(leftVal != -1) return leftVal;
    return rightVal;
}
```

**Ѱ�������ڵ�������������**

[Leetcode : 235. Lowest Common Ancestor of a Binary Search Tree (Easy)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    return root;
}
```

**�����������**

[Leetcode : 236. Lowest Common Ancestor of a Binary Tree (Medium) ](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
```

**�����ͬ�ڵ�ֵ��·������**

[Leetcode : 687. Longest Univalue Path (Easy)](https://pomotodo.com/app/)

```html
              1
            / \
            4  5
          / \  \
          4  4  5

Output : 2
```

```java
private int path = 0;
public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return path;
}

private int dfs(TreeNode root){
    if(root == null) return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
    int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
    path = Math.max(path, leftPath + rightPath);
    return Math.max(leftPath, rightPath);
}
```

**�������**

[Leetcode : 337. House Robber III (Medium)](https://leetcode.com/problems/house-robber-iii/description/)

```java
public int rob(TreeNode root) {
    if (root == null) return 0;
    int val1 = root.val;
    if (root.left != null) {
        val1 += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
        val1 += rob(root.right.left) + rob(root.right.right);
    }
    int val2 = rob(root.left) + rob(root.right);
    return Math.max(val1, val2);
}
```

### ��α���

ʹ�� BFS������Ҫʹ�������������ֱ�洢��ǰ��Ľڵ����һ��Ľڵ㣬 ��Ϊ�ڿ�ʼ����һ��Ľڵ�ʱ����ǰ�����еĽڵ������ǵ�ǰ��Ľڵ�����ֻҪ���Ʊ�����ô��ڵ��������ܱ�֤��α����Ķ��ǵ�ǰ��Ľڵ㡣

**����һ����ÿ��ڵ��ƽ����**

[637. Average of Levels in Binary Tree (Easy)](https://leetcode.com/problems/average-of-levels-in-binary-tree/description/)

```java
public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ret = new ArrayList<>();
    if(root == null) return ret;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int cnt = queue.size();
        double sum = 0;
        for(int i = 0; i < cnt; i++){
            TreeNode node = queue.poll();
            sum += node.val;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        ret.add(sum / cnt);
    }
    return ret;
}
```

**�õ����½ǵĽڵ�**

[Leetcode : 513. Find Bottom Left Tree Value (Easy)](https://leetcode.com/problems/find-bottom-left-tree-value/description/)

```java
public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        root = queue.poll();
        if(root.right != null) queue.add(root.right);
        if(root.left != null) queue.add(root.left);
    }
    return root.val;
}
```

### ǰ�к������

```html
   1
  / \
  2  3
 / \  \
4  5  6
```

��α���˳��[1 2 3 4 5 6]
ǰ�����˳��[1 2 4 5 3 6]
�������˳��[4 2 5 1 3 6]
�������˳��[4 5 2 6 3 1]

��α���ʹ�� BFS ʵ�֣����õľ��� BFS һ��һ����������ԣ���ǰ�����򡢺������������ DFS ʵ�֡�

ǰ�����򡢺����ֻ���ڶԽڵ���ʵ�˳����һ�㲻ͬ����������ͬ��

�� ǰ��

```java
void dfs(TreeNode root){
    visit(root);
    dfs(root.left);
    dfs(root.right);
}
```

�� ����

```java
void dfs(TreeNode root){
    dfs(root.left);
    visit(root);
    dfs(root.right);
}
```

�� ����

```java
void dfs(TreeNode root){
    dfs(root.left);
    dfs(root.right);
    visit(root);
}
```

**�ǵݹ�ʵ�ֶ�������ǰ�����**

[Leetcode : 144. Binary Tree Preorder Traversal (Medium)](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) return ret;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        ret.add(node.val);
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left); // ������������������������������Ϊ������������ջ��
    }
    return ret;
}
```

**�ǵݹ�ʵ�ֶ������ĺ�������**

[Leetcode : ### 145. Binary Tree Postorder Traversal (Medium)](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

ǰ�����Ϊ root -> left -> right���������Ϊ left -> right -> root�������޸�ǰ�������Ϊ root -> right -> left����ô���˳��ͺͺ�����������෴��

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) return ret;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        ret.add(node.val);
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
    }
    Collections.reverse(ret);
    return ret;
}
```

**�ǵݹ�ʵ�ֶ��������������**

[Leetcode : 94. Binary Tree Inorder Traversal (Medium)](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while(cur != null || !stack.isEmpty()) {
        while(cur != null) { // ģ��ݹ�ջ�Ĳ�������
            stack.add(cur);
            cur = cur.left;
        }
        TreeNode node = stack.pop();
        ret.add(node.val);
        cur = node.right;
    }
    return ret;
}
```

**ʹ�����������ǰ����������ؽ�������** //TODO

### BST

��Ҫ���� BST �������������ص㡣

**�� BST ��Ѱ�������ڵ㣬ʹ���ǵĺ�Ϊһ������ֵ��**

[653. Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/)

ʹ����������õ���������֮��������˫ָ���������в��ҡ�

Ӧ��ע�⵽����һ�ⲻ���÷ֱ���������������������������˼�룬��Ϊ��������Ľڵ���ֱܷ������������С�

```java
public boolean findTarget(TreeNode root, int k) {
    List<Integer> nums = new ArrayList<>();
    inOrder(root, nums);
    int i = 0, j = nums.size() - 1;
    while(i < j){
        int sum = nums.get(i) + nums.get(j);
        if(sum == k) return true;
        if(sum < k) i++;
        else j--;
    }
    return false;
}

private void inOrder(TreeNode root, List<Integer> nums){
    if(root == null) return;
    inOrder(root.left, nums);
    nums.add(root.val);
    inOrder(root.right, nums);
}
```

**�� BST �в�����С�������ڵ�֮��ľ���ֵ**

[Leetcode : 530. Minimum Absolute Difference in BST (Easy)](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

���� BST ���������Ϊ��������ʣ���������������ٽ��������ڵ�֮��ľ���ֵ��ȡ��Сֵ��

```java
private int minDiff = Integer.MAX_VALUE;
private int preVal = -1;

public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return minDiff;
}

private void inorder(TreeNode node){
    if(node == null) return;
    inorder(node.left);
    if(preVal != -1) minDiff = Math.min(minDiff, Math.abs(node.val - preVal));
    preVal = node.val;
    inorder(node.right);
}
```

**�� BST ÿ���ڵ��ֵ�����ϱ�����Ľڵ��ֵ**

[Leetcode : Convert BST to Greater Tree (Easy)](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)

�ȱ�����������

```java
private int sum = 0;

public TreeNode convertBST(TreeNode root) {
    traver(root);
    return root;
}

private void traver(TreeNode root) {
    if (root == null) {
        return;
    }
    if (root.right != null) {
        traver(root.right);
    }
    sum += root.val;
    root.val = sum;
    if (root.left != null) {
        traver(root.left);
    }
}
```

**Ѱ�� BST �г��ִ������Ľڵ�**

```java
private int cnt = 1;
private int maxCnt = 1;
private TreeNode preNode = null;
private List<Integer> list;

public int[] findMode(TreeNode root) {
    list = new ArrayList<>();
    inorder(root);
    int[] ret = new int[list.size()];
    int idx = 0;
    for(int num : list){
        ret[idx++] = num;
    }
    return ret;
}

private void inorder(TreeNode node){
    if(node == null) return;
    inorder(node.left);
    if(preNode != null){
        if(preNode.val == node.val) cnt++;
        else cnt = 1;
    }
    if(cnt > maxCnt){
        maxCnt = cnt;
        list.clear();
        list.add(node.val);
    } else if(cnt == maxCnt){
        list.add(node.val);
    }
    preNode = node;
    inorder(node.right);
}
```

**Ѱ�� BST �ĵ� k ��Ԫ��**

[Leetcode : 230. Kth Smallest Element in a BST (Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

�ݹ�ⷨ��

```java
public int kthSmallest(TreeNode root, int k) {
    int leftCnt = count(root.left);
    if(leftCnt == k - 1) return root.val;
    if(leftCnt > k - 1) return kthSmallest(root.left, k);
    return kthSmallest(root.right, k - leftCnt - 1);
}

private int count(TreeNode node) {
    if(node == null) return 0;
    return 1 + count(node.left) + count(node.right);
}
```

��������ⷨ��

```java
private int cnt = 0;
private int val;

public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return val;
}

private void inorder(TreeNode node, int k) {
    if(node == null) return;
    inorder(node.left, k);
    cnt++;
    if(cnt == k) {
        val = node.val;
        return;
    }
    inorder(node.right, k);
}
```


### Trie

![](https://github.com/CyC2018/InterviewNotes/blob/master/pics/5c638d59-d4ae-4ba4-ad44-80bdc30f38dd.jpg)

Trie���ֳ�ǰ׺�����ֵ����������ж��ַ����Ƿ���ڻ����Ƿ����ĳ���ַ���ǰ׺��

**ʵ��һ�� Trie**

[Leetcode : 208. Implement Trie (Prefix Tree) (Medium)](https://leetcode.com/problems/implement-trie-prefix-tree/description/)

```java
class Trie {
    
    private class Node{
        Node[] childs = new Node[26];
        boolean isLeaf;
    }
    
    private Node root = new Node();
    
    /** Initialize your data structure here. */
    public Trie() {
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int idx = word.charAt(0) - 'a';
        insert(word, root);
    }
    
    private void insert(String word, Node node){
        int idx = word.charAt(0) - 'a';
        if(node.childs[idx] == null){
            node.childs[idx] = new Node();
        }
        if(word.length() == 1) node.childs[idx].isLeaf = true;
        else insert(word.substring(1), node.childs[idx]);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root); 
    }
    
    private boolean search(String word, Node node){
        if(node == null) return false;
        int idx = word.charAt(0) - 'a';
        if(node.childs[idx] == null) return false;
        if(word.length() == 1) return node.childs[idx].isLeaf;
        return search(word.substring(1), node.childs[idx]);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }
    
    private boolean startWith(String prefix, Node node){
        if(node == null) return false;
        if(prefix.length() == 0) return true;
        int idx = prefix.charAt(0) - 'a';
        return startWith(prefix.substring(1), node.childs[idx]);
    }
}
```

**ʵ��һ�� Trie��������ǰ׺��**

[Leetcode : 677. Map Sum Pairs (Medium)](https://leetcode.com/problems/map-sum-pairs/description/)

```java
class MapSum {
    private class Trie {
        int val;
        Map<Character, Trie> childs;
        boolean isWord;
        
        Trie() {
            childs = new HashMap<>();
        }
    }
    
    private Trie root;

    public MapSum() {
        root = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = root;
        for(char c : key.toCharArray()) {
            if(!cur.childs.containsKey(c)) {
                Trie next = new Trie();
                cur.childs.put(c, next);
            }
            cur = cur.childs.get(c);
        }
        cur.val = val;
        cur.isWord = true;
    }
    
    public int sum(String prefix) {
        Trie cur = root;
        for(char c : prefix.toCharArray()) {
            if(!cur.childs.containsKey(c)) return 0;
            cur = cur.childs.get(c);
        }
        return dfs(cur);
    }
    
    private int dfs(Trie cur) {
        int sum = 0;
        if(cur.isWord) {
            sum += cur.val;
        }
        for(Trie next : cur.childs.values()) {
            sum += dfs(next);
        }
        return sum;
    }
}
```

## ͼ

## λ����

**1. ����ԭ��**

0s ��ʾ һ�� 0 ��1s ��ʾһ�� 1��

```
x ^ 0s = x      x & 0s = 0      x | 0s = x
x ^ 1s = \~x     x & 1s = x      x | 1s = 1s
x ^ x = 0       x & x = x       x | x = x
```

�� ���� x ^ 1s = \~x ���ص㣬���Խ�λ����ʾ��ת������ x ^ x = 0 ���ص㣬���Խ����������ظ���������ȥ����ֻ������һ������
�� ���� x & 0s = 0 �� x & 1s = x ���ص㣬����ʵ�����������һ���� num �� mask ��00111100 ����λ�������ֻ���� num ���� mask �� 1 �������Ӧ��λ��
�� ���� x | 0s = x �� x | 1s = 1s ���ص㣬����ʵ�����ò�����һ���� num �� mask��00111100 ����λ��������� num ���� mask �� 1 �������Ӧ��λ������Ϊ 1 ��

\>\> n Ϊ�������ƣ��൱�ڳ��� 2<sup>n</sup>��
\>\>\> n Ϊ�޷������ƣ���߻Ჹ�� 0��
&lt;&lt; n Ϊ�������ƣ��൱�ڳ��� 2<sup>n</sup>��

n&(n-1) ��λ������ȥ�� n ��λ����ʾ����͵���һλ��������ڶ����Ʊ�ʾ 10110**100**����ȥ 1 �õ� 10110**011**��������������õ� 10110**000**��

n-n&(\~n+1) ��������ȥ�� n ��λ����ʾ����ߵ���һλ��

n&(-n) ������õ� n ��λ����ʾ����͵���һλ��-n �õ� n �ķ���� 1�����ڶ����Ʊ�ʾ 10110**100**��-n �õ� 01001**100**������õ� 00000**100**

**2. mask ����**

Ҫ��ȡ 111111111���� 0 ȡ�����ɣ�\~0��

Ҫ�õ�ֻ�е� i λΪ 1 �� mask���� 1 �����ƶ� i λ���ɣ�1&lt;&lt;i ������ 1&lt;&lt;5 �õ�ֻ�е� 5 λΪ 1 �� mask ��00010000��

Ҫ�õ� 1 �� i λΪ 1 �� mask��1&lt;&lt;(i+1)-1 ���ɣ����罫 1&lt;&lt;(4+1)-1 = 00010000-1 = 00001111��

Ҫ�õ� 1 �� i λΪ 0 �� mask��ֻ�轫 1 �� i λΪ 1 �� mask ȡ������ \~(1&lt;&lt;(i+1)-1)��

**3. λ��������**

�� ��ȡ�� i λ

num & 00010000 != 0

```java
(num & (1 << i)) != 0;
```

�� ���� i λ����Ϊ 1

num | 00010000

```java
num | (1 << i);
```

�� ���� i λ���Ϊ 0

num & 11101111

```java
num & (\~(1 << i))
```

�� �����λ���� i λ���Ϊ 0

num & 00001111

```java
num & ((1 << i) - 1);
```

�� ���� 0 λ���� i λ���Ϊ 0

num & 11110000

```java
num & (\~((1 << (i+1)) - 1));
```

�� ���� i λ����Ϊ 0 ���� 1

�Ƚ��� i λ���㣬Ȼ�� v ���� i λ��ִ�С�λ�����㡣

```java
(num & (1 << i)) | (v << i);
```

**4. Java �е�λ����**

```html
static int Integer.bitCount()            // ͳ�� 1 ������
static int Integer.highestOneBit()       // ������λ
static String toBinaryString(int i)      // ת��λ�����Ʊ�ʾ���ַ���
```

**ͳ���������Ķ����Ʊ�ʾ�ж���λ��ͬ**

[Leetcode : 461. Hamming Distance (Easy)](https://leetcode.com/problems/hamming-distance/)

����������������������ͬ����һλ���Ϊ 1 ��ͳ���ж��ٸ� 1 ���ɡ�

```java
public int hammingDistance(int x, int y) {
    int z = x ^ y;
    int cnt = 0;
    while(z != 0){
        if((z & 1) == 1) cnt++;
        z = z >> 1;
    }
    return cnt;
}
```

����ʹ�� Integer.bitcount() ��ͳ�� 1 ���ĸ�����

```java
public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
}
```

**��תһ�����ı���λ**

[Leetcode : 190. Reverse Bits (Easy)](https://leetcode.com/problems/reverse-bits/description/)

```java
public int reverseBits(int n) {
    int ret = 0;
    for(int i = 0; i < 32; i++){
        ret <<= 1;
        ret |= (n & 1);
        n >>>= 1;
    }
    return ret;
}
```

**���ö������������������**

[����Ա��������ָ�� ��P317](#)

```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

�� c = a ^ b����ô b ^ c = b ^ b ^ a = a��a ^ c = a ^ a ^ b = b��

**�ж�һ�����ǲ��� 4 �� n �η�**

[Leetcode : 342. Power of Four (Easy)](https://leetcode.com/problems/power-of-four/)

���������Ʊ�ʾ����ֻ��һ������λΪ 1 ������Ķ�Ϊ 0 ������ 16 �� 10000������ÿ�ΰ� 1 �����ƶ� 2 λ�����ܹ�����������֣�Ȼ��ȽϹ������������Ҫ�жϵ����Ƿ���ͬ��

```java
public boolean isPowerOfFour(int num) {
    int i = 1;
    while(i > 0){
        if(i == num) return true;
        i = i << 2;
    }
    return false;
}
```

Ҳ������ Java �� Integer.toString() ����������ת��Ϊ 4 ������ʽ���ַ�����Ȼ���ж��ַ����Ƿ��� 1 ��ͷ��

```java
public boolean isPowerOfFour(int num) {
    return Integer.toString(num, 4).matches("10*");
}
```

**�ж�һ�����ǲ��� 2 �� n �η�**

[Leetcode : 231. Power of Two (Easy)](https://leetcode.com/problems/power-of-two/description/)

ͬ�������� Power of Four �ķ��������� 2 �� n �η������⣬���Ķ����Ʊ�ʾֻ��һ�� 1 ���ڡ�

```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && Integer.bitCount(n) == 1;
}
```

���� 1000 & 0111 == 0 �������ʣ��õ����½ⷨ��

```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

**������Ψһһ�����ظ���Ԫ��**

[Leetcode : 136. Single Number (Easy)](https://leetcode.com/problems/single-number/description/)

������ͬ�������Ľ��Ϊ 0�������������������������Ľ�����ǵ������ֵ��Ǹ�����

���Ƶ��У�[Leetcode : 389. Find the Difference (Easy)](https://leetcode.com/problems/find-the-difference/description/)�������ַ�������һ���ַ�����ͬ��ʹ�������������� O(1) �Ŀռ临�Ӷ�����⣬������Ҫʹ�� HashSet��

```java
public int singleNumber(int[] nums) {
    int ret = 0;
    for(int n : nums) ret = ret ^ n;
    return ret;
}
```

**�����в��ظ�������Ԫ��**

[Leetcode : 260. Single Number III (Medium)](https://leetcode.com/problems/single-number-iii/description/)

��������ȵ�Ԫ����λ����ʾ�ϱض�����һλ���ڲ�ͬ��

�����������Ԫ�����õ��Ľ��Ϊ�������ظ�������Ԫ�����Ľ����

diff &= -diff �õ��� diff ���Ҳ಻Ϊ 0 ��λ��Ҳ���ǲ������ظ�������Ԫ����λ����ʾ�����Ҳ಻ͬ����һλ��������һλ�Ϳ��Խ�����Ԫ�����ֿ�����


```java
public int[] singleNumber(int[] nums) {
    int diff = 0;
    for(int num : nums) diff ^= num;
    // �õ�����һλ
    diff &= -diff;
    int[] ret = new int[2];
    for(int num : nums) {
        if((num & diff) == 0) ret[0] ^= num;
        else ret[1] ^= num;
    }
    return ret;
}
```

**�ж�һ������λ����ʾ�Ƿ񲻻���������� 0 �� 1**

[Leetcode : 693. Binary Number with Alternating Bits (Easy)](https://leetcode.com/problems/binary-number-with-alternating-bits/description/)

���� 10101 ����λ����ʾ���������������ƶ� 1 λ�õ� 1010 ����������ÿ��λ����ͬ��������õ��Ľ��Ϊ 11111��

```java
public boolean hasAlternatingBits(int n) {
    int a = (n ^ (n >> 1));
    return (a & (a + 1)) == 0;
}
```

**��һ�����Ĳ���**

[Leetcode : 476. Number Complement (Easy)](https://leetcode.com/problems/number-complement/description/)

�����Ƕ����Ʊ�ʾ�е��� 0 ����

���� 00000101��Ҫ������Խ����� 00000111 ��������������ô�����ת��Ϊ������ 00000111��

```java
public int findComplement(int num) {
    if(num == 0) return 1;
    int mask = 1 << 30;
    while((num & mask) == 0) mask >>= 1;
    mask = (mask << 1) - 1;
    return num ^ mask;
}
```

�������� Java �� Integer.highestOneBit() ��������ú����� 1 ������

```java
public int findComplement(int num) {
    if(num == 0) return 1;
    int mask = Integer.highestOneBit(num);
    mask = (mask << 1) - 1;
    return num ^ mask;
}
```

���� 10000000 ��������Ҫ��չ�� 11111111�������������·�����

```html
mask |= mask >> 1    11000000
mask |= mask >> 2    11110000
mask |= mask >> 4    11111111
```

```java
public int findComplement(int num) {
    int mask = num;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return (mask ^ num);
}
```

**ʵ�������ļӷ�**

[Leetcode : 371. Sum of Two Integers (Easy)](https://leetcode.com/problems/sum-of-two-integers/description/)

a ^ b ��ʾû�п��ǽ�λ������������ĺͣ�(a & b) << 1 ���ǽ�λ���ݹ����ֹ��ԭ���� (a & b) << 1 ���ұ߻��һ�� 0����ô�����ݹ飬��λ���ұߵ� 0 ���������࣬����λ���Ϊ 0���ݹ���ֹ��

```java
public int getSum(int a, int b) {
    return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
}
```

**ʵ�������˷�**

[����Ա��������ָ�� P319](#)

**�ַ����������˻�**

[Leetcode : 318. Maximum Product of Word Lengths (Medium)](https://leetcode.com/problems/maximum-product-of-word-lengths/description/)

��Ŀ�������ַ���������ַ���ֻ����Сд�ַ�������ַ��������������ַ������ȵ����˻���Ҫ���������ַ������ܺ�����ͬ�ַ���

����˼·��������Ҫ�������ж������ַ����Ƿ���ͬ�ַ��������ַ���ֻ����Сд�ַ����ܹ� 26 λ����˿�����һ�� 32 λ���������洢ÿ���ַ��Ƿ���ֹ���

```java
public int maxProduct(String[] words) {
    int n = words.length;
    if (n == 0) return 0;
    int[] val = new int[n];
    for (int i = 0; i < n; i++) {
        for (char c : words[i].toCharArray()) {
            val[i] |= 1 << (c - 'a');
        }
    }
    int ret = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if ((val[i] & val[j]) == 0) {
                ret = Math.max(ret, words[i].length() * words[j].length());
            }
        }
    }
    return ret;
}
```

# �ο�����

- [Leetcode](https://leetcode.com/problemset/algorithms/?status=Todo)
- ��ָ Offer
- ����Ա���Խ��
- ���֮��
- ����Ա��������ָ��
- ���ݽṹ���㷨����
- �㷨
- ������̳��������л���ָ��

