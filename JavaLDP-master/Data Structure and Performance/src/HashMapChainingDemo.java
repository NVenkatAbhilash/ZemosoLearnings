import java.util.*;

class HashMapChaining {
    private List<String> valuesList[];
    private List<Integer> keyList[];
    private int size;

    HashMapChaining(int size) {
        valuesList = new List[size];
        keyList = new List[size];
        this.size = size;
    }

    private int hashCode(int key) {
        return (key) % size;
    }

    void put(int key, String data) {
        int index = search(key);
        int hashKey = hashCode(key);
        if(index!=-1){
            valuesList[hashKey].set(index,data);
        }
        if (valuesList[hashKey] == null) {
            valuesList[hashKey] = new LinkedList<>();
            keyList[hashKey] = new LinkedList<>();
        }
        valuesList[hashKey].add(data);
        keyList[hashKey].add(key);
    }

    private int search(int key) {
        int hashKey = hashCode(key);
        if(keyList[hashKey]==null)
            return -1;
        return keyList[hashKey].indexOf(key);
    }

    String get(int key) {
        int hashKey = hashCode(key);
        int index = search(key);
        if (index == -1)
            return "Not found";
        return valuesList[hashKey].get(index);
    }

    void set(int key,String value){
        if(search(key)!=-1)
            put(key,value);
        else
            System.out.println("Key doesn't exist");
    }

    void delete(int key) {
        int index = search(key);
        if (index == -1){
            System.out.println("key doesn't exist");
            return;
        }
        int hashKey = hashCode(key);
        keyList[hashKey].remove(index);
        valuesList[hashKey].remove(index);
    }
}

public class HashMapChainingDemo {
    public static void main(String args[]){
        HashMapChaining hash = new HashMapChaining(10);
        hash.put(111,"Sriram");
        hash.put(391,"Abhi");
        hash.put(451,"Rams");
        hash.set(451,"Ramesh");
        System.out.println(hash.get(391));
        System.out.println(hash.get(44));
        hash.delete(111);
        hash.delete(12);
        System.out.println(hash.get(111));
        System.out.println(hash.get(451));
    }
}
