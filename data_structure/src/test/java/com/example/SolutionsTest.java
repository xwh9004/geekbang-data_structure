package com.example;

import com.example.leetcode.ListNode;
import com.example.leetcode.Solutions;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:27 on 2020/1/10
 * @version V0.1
 * @classNmae SolutionsTest
 */
public class SolutionsTest {

    public Solutions solutions;

    @Before
    public void before() {
        solutions = new Solutions();
    }

    @Test
    public void twoSum() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = solutions.twoSum(nums, target);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }
    @Test
    public void addTwoNumber(){
        ListNode nodeL1_0 = new ListNode(2);
        ListNode nodeL1_1 = new ListNode(4);
        ListNode nodeL1_2 = new ListNode(3);
        nodeL1_0.next = nodeL1_1;
        nodeL1_1.next = nodeL1_2;
        ListNode nodeL2_0 = new ListNode(5);
        ListNode nodeL2_1 = new ListNode(6);
        ListNode nodeL2_2 = new ListNode(4);
        nodeL2_0.next = nodeL2_1;
        nodeL2_1.next = nodeL2_2;
        solutions.addTwoNumbers(nodeL1_0, nodeL2_0);
    }

    @Test
    public void lengthOfLongestSubstring(){
        int res = solutions.lengthOfLongestSubstring("dvdf");
//        int res = solutions.lengthOfLongestSubstring("pwweke");
//        int res = solutions.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }

    @Test
    public void removeDuplicates(){
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
//        int[] nums ={1};
        int res = solutions.removeDuplicates(nums);
        System.out.println(res);
    }
}
