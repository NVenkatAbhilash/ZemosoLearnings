class HashMapLinear {
    int valuesArray[], size, keyArray[];

    HashMapLinear(int size) {
        keyArray = new int[size];
        valuesArray = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            keyArray[i] = -1;
        }
    }

    private int hashCode(int key) {
        return (key * 7 + 3) % size;
    }

    void insert(int key, int data) {
        int hashKey = hashCode(key);
        for (int i = 0; i < size; i++) {
            hashKey = (hashKey + i) % size;
            if (keyArray[hashKey] < 0) {
                keyArray[hashKey] = key;
                valuesArray[hashKey] = data;
                return;
            }
        }
        System.out.println("hash table is full");
    }

    int search(int key) {
        int hashKey = hashCode(key);
        for (int i = 0; i < size; i++) {
            hashKey = (hashKey + i) % size;
            if (keyArray[hashKey] == key) {
                return hashKey;
            }
            if (keyArray[hashKey] == -1) {
                break;
            }
        }
        System.out.println("Key does not exist");
        return -1;
    }

    int get(int key) {
        int hashKey = search(key);
        if (hashKey == -1)
            return -1;
        return valuesArray[hashKey];
    }

    void delete(int key) {
        int hashKey = search(key);
        if (hashKey == -1)
            return;
        keyArray[hashKey] = -2;
    }
}

public class HashMapLinearProbingDemo {
    public static void  main(String args[]){
        HashMapLinear hash = new HashMapLinear(10);
        hash.insert(1,100);
        hash.insert(5,500);
        hash.insert(16,799);
        System.out.println(hash.get(16));
        System.out.println(hash.get(9));
        hash.delete(5);
        hash.delete(17);
        System.out.println(hash.get(5));
    }
}
