package com.example.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanDecode {

    private Map<String, String> map = new HashMap<>();

    private void mapping(Node node, String code) {
        if (node == null) return ;
        if (node.left == null && node.right == null) {
            this.map.put(code, node.data);
            return;
        }

        mapping(node.left, "0");
        mapping(node.right, "1");
    }

    public void decode(String s, Node node) {

        mapping(node.left, "0");
        mapping(node.right, "1");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }
        String code;
        while (!list.isEmpty()) {
            code = list.remove(0);
            if (map.containsKey(code)) {
                System.out.print(map.get(code));
                code = "";
            }
        }
    }
}

class Node {
    public  int frequency; // the frequency of this tree
    public  String data;
    public  Node left, right;
}
