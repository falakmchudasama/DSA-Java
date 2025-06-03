import java.util.ArrayList;

public class MinHBasics {
    public static class MinHeap1 {
        private ArrayList<Integer> array = new ArrayList<>();

        // Insertion
        public void push(int data){
            if(array.isEmpty()){
                array.add(data);
                return;
            }
            array.add(data);
            int x = array.size()-1;

            heapifyUp(x);
        }

        // Deletion
        public void pop() {
            if (array.isEmpty()) return;
            
            int lastIndex = array.size() - 1;
            array.set(0, array.get(lastIndex));
            array.remove(lastIndex);
        
            heapifyDown(0);
        }

        // HeapifyUp
        private void heapifyUp(int x){
            // Element sits on its parent's position
            while (x > 0) {
                int parent = (x-1)/2;

                if(array.get(x) >= array.get(parent)){
                    break;
                }

                int temp = array.get(x); // temp = x
                array.set(x, array.get(parent)); // parent at child's position
                array.set(parent, temp);    
                x = parent;
            }
        }
        
        // HeapifyDown
        private void heapifyDown(int index) {
            // Element sits on the position of child
            int smallest = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
        
            if (leftChild < array.size() && array.get(leftChild) < array.get(smallest)) {
                smallest = leftChild;
            }
        
            if (rightChild < array.size() && array.get(rightChild) < array.get(smallest)) {
                smallest = rightChild;
            }
        
            if (smallest != index) {
                int temp = array.get(index);
                array.set(index, array.get(smallest));
                array.set(smallest, temp);
        
                heapifyDown(smallest);
            }
        }

        // peek
        public int peek(){
            return array.get(0);
        }

        // getSize
        public int getSize(){
            return array.size();
        }

        // Print heap
        public void print(){
            for(int i = 0; i < array.size(); i++){
                System.out.print(array.get(i) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MinHeap1 heap = new MinHeap1();
        heap.push(15);
        heap.push(20);
        heap.push(11);
        heap.push(10);
        heap.push(5);
        heap.push(7);

        heap.pop();
        heap.print();
    }
}