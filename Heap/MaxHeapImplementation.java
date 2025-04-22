package Heap;

import java.util.Arrays;
class MaxHeapImplementation{
    static class MaxHeap{
        int[] heap;
        int size;
        int capacity;
    
        MaxHeap(int capacity){
            this.capacity = capacity;
            this.size = 0;
            heap = new int[capacity];
        }
    
        int parent(int index){
            return (index-1)/2;
        }
    
        int leftChild(int index){
            return 2*index+1;
        }
    
        int rightChild(int index){
            return 2*index + 1;
        }
    
        void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    
        public void insert(int value){
            if(size==capacity){
                System.out.println("Heap is full");
                return;
            }
    
            heap[size] = value;
            int current = size;
            size++;
    
            while (current>0 && heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    
        public int extractMax() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapify(0);
            return max;
        }
    
        public void printHeap() {
            System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
        }
    
        void heapify(int index) {
            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);
            
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                heapify(largest);
            }
        }   
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.printHeap();
        System.out.println("Extracted Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
