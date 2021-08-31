package problems;

import net.sf.cglib.asm.$ModuleVisitor;

import java.util.List;

/**
 *
 * @version 1.0
 * @Date 2021/6/11 10:18 上午
 * @since 1.0
 */
public class Problem2 {

    private static final ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
    private static final ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
    private static final ListNode l3 = new ListNode(2,new ListNode(4,new ListNode(3)));
    private static final ListNode l4 = new ListNode(5,new ListNode(6,new ListNode(4)));
    private static final ListNode l5 = new ListNode(0);
    private static final ListNode l6 = new ListNode(7,new ListNode(3,new ListNode(9,new ListNode(8))));

    private static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers3(ListNode l1,ListNode l2){
        ListNode result = new ListNode();
        ListNode curr = result;
        int carry = 0;

        //同时遍历两个链表，结束标志：两个链表均为空
        while( l1 != null || l2 != null){
            // 加数、进位统一处理
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum /10;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return result.next;
    }

    // 官方答案
    public static ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        int carry = 0;
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            cur.next = new ListNode((x+y+carry) % 10);
            cur = cur.next;
            carry = (x+y+carry) / 10;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        ListNode currentL1 = l1;
        int len1 = length(l1);
        int len2 = length(l2);
        int maxLen = len1 >= len2 ? len1 : len2;
        while(maxLen -- > 0){
            if(l1 != null && l2 != null){
                l1.val += l2.val;
                if(l1.val >= 10){
                    l1.val = l1.val %10;
                    if(l1.next != null){
                        l1.next.val ++;
                    }else{
                        l1.next = new ListNode(1,null);
                    }
                }
                currentL1 = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        currentL1.next = (l2 != null) ? l2 : l1;
        while (currentL1 != null){
            if(currentL1.val >= 10){
                currentL1.val = currentL1.val %10;
                if(currentL1.next != null){
                    currentL1.next.val ++;
                }else{
                    currentL1.next = new ListNode(1,null);
                    break;
                }
            }
            currentL1 = currentL1.next;
        }
        return result;
    }

    private static int length(ListNode ln){
        int length = 0;
        if(ln == null){
            return length;
        }
        while(ln!= null){
            ln = ln.next;
            length ++;
        }
        return length;
    }

    private static void printNode(ListNode node){
        while (node != null){
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("l1.length = " + length(l1));
        System.out.println("l2.length = " + length(l2));
        printNode(l1);
        printNode(l2);
        ListNode result1 = addTwoNumbers2(l2,l1);
        ListNode result2 = addTwoNumbers2(l3,l4);
        ListNode result3 = addTwoNumbers2(l5,l6);
        printNode(result1);
        printNode(result2);
        printNode(result3);
    }
}
