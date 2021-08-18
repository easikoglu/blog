package com.easikoglu.algos;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class LinkedListSum {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int sum = 0;
    int carry = 0;
    ListNode result, dummy = new ListNode(0);
    result = dummy;
    while (l1 != null || l2 != null || carry != 0) {
      sum += carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      result.next = new ListNode(sum % 10);
      carry = sum / 10;
      result = result.next;
    }
    return dummy.next;
  }
}
