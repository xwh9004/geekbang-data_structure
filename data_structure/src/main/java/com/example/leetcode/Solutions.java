package com.example.leetcode;

import java.util.*;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:25 on 2020/1/10
 * @version V0.1
 * @classNmae Solutions
 */
public class Solutions {


    /**
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;

        //构造Map 容器

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && !index.equals(i)) {
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        return res;

    }

    /**
     * 初稿，不做参数校验
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resNode = new ListNode(l1.val);
        ListNode headNode = resNode;
        ListNode index_1 = l1;
        ListNode index_2 = l2;
        int advance = 0;
        while ((index_1 != null || index_2 != null)) {
            int val = advance + index_1.val + index_2.val;
            advance = val / 10;
            int mod = val % 10;
            resNode.val = mod;
            resNode.next = new ListNode(advance);
            index_1 = index_1.next;
            index_2 = index_2.next;
            resNode = resNode.next;

        }
        ListNode restStartNode = null;
        if (index_1 != null) {
            restStartNode = index_1;
        }
        if (index_2 != null) {
            restStartNode = index_2;
        }

        if (restStartNode != null) {
            while (restStartNode != null) {
                int val = advance + restStartNode.val;
                advance = val / 10;
                int mod = val % 10;
                resNode.val = mod;
                resNode.next = new ListNode(advance);
                restStartNode = restStartNode.next;
                resNode = resNode.next;
            }
        }
        ListNode preview = headNode;
        ListNode current = headNode;
        while (current.next != null) {
            preview = current;
            current = current.next;
        }
        if (current.val == 0) {
            preview.next = null;
        }
        return headNode;

    }


    public int lengthOfLongestSubstring(String s) {

        char[] chars= s.toCharArray();
        Queue<Character> queue = new ArrayDeque<>();
        int max = 0;
        for (int i=0;i<chars.length;i++){

            if(queue.contains(chars[i])){
                max =max>queue.size()?max:queue.size();
                while (!queue.remove().equals(chars[i]));
            }
            queue.add(chars[i]);

        }
        max =max>queue.size()?max:queue.size();
        return max;


    }
    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    /**
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int i=0;
        for (int j=0;j<len;j++){
           if(nums[i]!=nums[j]){
               nums[++i] = nums[j];
           }
        }
        return i+1;

    }


}
