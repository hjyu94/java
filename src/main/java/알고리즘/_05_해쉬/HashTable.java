package 알고리즘._05_해쉬;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

public class HashTable {
    @AllArgsConstructor @Getter @Setter
    class Node {
        String key;
        String value;
    }

    LinkedList<Node>[] data;

    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) { // key -> hashcode
        int hashcode = 0;
        for(char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }

    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];
        if(list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if(node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? "Not found" : node.getValue();
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung", "data sung");
        h.put("jin", "data jin");
        h.put("hee", "data hee");
        h.put("min", "data min");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
    }
}
