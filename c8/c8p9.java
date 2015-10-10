import java.util.ArrayList;

class Cell<K, V> {
    K key;
    V value;
    public Cell(K key, V value) { this.key = key; this.value = value; }
}

class HashTable<K, V> {
    private int PRIME = 43;
    private ArrayList<ArrayList<Cell<K, V>>> hash_table;
    public HashTable(){
        hash_table = new ArrayList<ArrayList<Cell<K, V>>>();
        for (int i = 0; i < PRIME; ++i) {
            hash_table.add(new ArrayList<Cell<K, V>>());
        }
    }

    private int hash(K key) { 
        return key.toString().length() % PRIME;
    }

    public void put(K key, V value) {
	Cell<K,V> c = new Cell<K,V>(key, value);
	int k = hash(key);
	ArrayList<Cell<K, V>> list = hash_table.get(k);
	list.add(c);
    }

    public V get(K key) {
        int k = hash(key);
        ArrayList<Cell<K, V>> list = hash_table.get(k);
        if (list.size() == 1) return list.get(0).value;
        V ret = null;
        for (Cell<K, V> c : list) {
            System.out.println("collided");
            if (key == c.key) { ret = c.value; break; }
        }
        return ret;
    } 
}

public class c8p9{
    public static void main(String[] args){
        HashTable<String, Integer> map = new HashTable<String, Integer>();
        map.put("teste", 10);
        map.put("outro", 32);
        System.out.println(map.get("outro"));
    }
}
