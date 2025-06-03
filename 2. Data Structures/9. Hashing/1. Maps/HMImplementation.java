import java.util.ArrayList;
import java.util.LinkedList;
public class HMImplementation {
    static class HashMap1<K,V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int N;
        private int n;
        private double lambda = 0;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")
        public HashMap1() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int getHash(K key){
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % N;
        }

        private int getLLI(K key, int bucketI){
            LinkedList<Node> ll = bucket[bucketI];
            int index = 0;
            for(int i = 0; i < ll.size(); i++){
                if(ll.get(i).key == key){
                    return index;
                }
                index++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBucket[] = bucket;
            N = 2*N;
            bucket = new LinkedList[N];

            for(int i = 0; i < N; i++){
                bucket[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.remove(i);
                    push(node.key, node.value);
                }
            }
        }

        // 1. push
        public void push(K key, V value){
            int bucketIndex = getHash(key);
            int LLIndex = getLLI(key, bucketIndex);
            if(LLIndex != -1){
                Node node = bucket[bucketIndex].get(LLIndex);
                node.value = value;
            }
            else{
                bucket[bucketIndex].add( new Node(key, value) );
                n++;
            }
            lambda = (double)n/N;
            if(lambda > 2.0){
                reHash();
            }
        }

        // 2. containsKey
        public boolean containsKey(K key){
            int bucketIndex = getHash(key);
            int LLIndex = getLLI(key, bucketIndex);

            if(LLIndex == -1){
                return false;
            }
            return true;
        }

        // 3. pop
        public V pop(K key){
            int bucketIndex = getHash(key);
            LinkedList<Node> ll = bucket[bucketIndex];

            for(int i = 0; i < ll.size(); i++){
                if(ll.get(i).key == key){
                    V value = ll.remove(i).value;
                    n--;
                    return value;
                }
            }
            return null;
        }

        // 4. getKey
        public V getKey(K key){
            int bucketIndex = getHash(key);
            int LLIndex = getLLI(key, bucketIndex);
            if(LLIndex == -1){
                return null;
            }
            return bucket[bucketIndex].get(LLIndex).value;
        }

        // 5. getSize
        public int getSize(){
            return n;
        }

        // 6. keySet
        public ArrayList<K> getKeySet(){
            ArrayList<K> set = new ArrayList<>();
            for(int i = 0; i < bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for(int j = 0; j < ll.size(); j++){
                    set.add( ll.get(j).key );
                }
            }
            return set;
        }

        // 7. isEmpty
        public boolean isEmpty(){
            return n == 0;
        }

        // 8. printMap
        public void printMap(){
            for(int i = 0; i < bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for(int j = 0; j < ll.size(); j++){
                    System.out.println(ll.get(j).key + " : " + ll.get(j).value);
                }
            }
        }
    }
    public static void main(String[] args) {
        HashMap1<String, Integer> map = new HashMap1<>();
        map.push("Bharat", 140);
        map.push("USA", 50);
        map.push("Russia", 10);
        map.push("Israel", 2);
        map.push("España", 3);
        map.push("China", 140);

        ArrayList<String> array = map.getKeySet();
        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
        System.out.println( map.getKey("Bharat") );
    }
}