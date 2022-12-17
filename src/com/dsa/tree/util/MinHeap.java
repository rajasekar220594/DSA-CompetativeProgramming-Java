package com.dsa.tree.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {

	private int[] heap;
	private int size; // size of max heap

	public MinHeap(int capacity) {
		heap = new int[capacity+ 1]; // index 0 is kept as empty
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void resize() {
		heap = Arrays.copyOf(heap, heap.length*2);
	}
	
    // Returning the position of  the parent for the node currently at pos
    public int parent(int pos) { return pos / 2; }
 
    // Returning the position of the left child for the node currently at pos
    public int leftChild(int pos) { return (2 * pos); }
    
    // Returning the position of the right child for the node currently at pos
    public int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Returning true if the passed node is a leaf node
    public boolean isLeaf(int pos)
    {
        if (pos > (size / 2)) {
            return true;
        }
        return false;
    }
 
    // To swap two nodes of the heap
    public void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // To heapify the node at pos
    public void minHeapify(int pos)
   {     
	   if(!isLeaf(pos)){
		   int swapPos= pos;
		   // swap with the minimum of the two children
		   // to check if right child exists. Otherwise default value will be '0'
		   // and that will be swapped with parent node.
		   if(rightChild(pos)<=size)
			   swapPos = heap[leftChild(pos)]<heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
		   else
			   swapPos= heap[leftChild(pos)];

		   if(heap[pos]>heap[leftChild(pos)] || heap[pos]> heap[rightChild(pos)]){
			   swap(pos,swapPos);
			   minHeapify(swapPos);
		   }

	   }      
   }
	public void insert(int x) {
		if(size == heap.length-1) {
			resize();
		}
		heap[++size] = x;
		int i=size;

		while(i>1 && heap[i/2] > heap[i]) {
			int temp = heap[i];
			heap[i] = heap[i/2];
			heap[i/2] = temp;
			i=i/2;
		}
	}

	/*public void insert(int x) {
		if(size == heap.length - 1) {
			resize();
		}
		heap[++size] = x;
		swim(size);
	}

	private void swim(int k) {
		while(k > 1 && heap[k/2] < heap[k]) {
			int temp = heap[k];
			heap[k] = heap[k/2];
			heap[k/2] = temp;
			k = k/2; // bcoz we need to continue shifting up till  new value inserted is at correct position
		}
	}*/

	public void delete() {
		int x,i=1,j=2*i;
		x=heap[1];
		heap[1] = heap[size];

		while(j<=size-1) {
			if(heap[j+1] < heap[j]) {
				j=j+1;
			}
			if(heap[i] > heap[j]) {
				com.dsa.array.util.ArraysUtil.swap(heap, i, j);
				i=j;
				j=2*j;
			} else {
				break;
			}
		}
		heap[size] = x;
		size--;
	}
	public void printMinHeap() {
		System.out.print("Min Heap : ");
		for(int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println("");
	}
	public void createHeap() {
		this.heap = new int[]{0,10,20,30,25,5,40,35};
		this.size = 1;
		for(int i=2; i<=7; i++) {
			insert(heap[i]);
		}
	}

	public void getMax() {
		int n = (size+1)/2;
		int max = heap[n];
		for (int i=n+1; i<=size; i++) {
			if(heap[i] > max) {
				max = heap[i];
			}
		}
		System.out.println("Max >> "+max);
	}
	
	public void deleteElement(int value) {
		int i=1;
		for(; i<=size; i++) {
			if(heap[i] == value) break;
		}
		
		if(i<size) {
			heap[i] = heap[size];
			size--;
			minHeapify(i);
		}
	}
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(10);		
		minHeap.insert(60);
		minHeap.insert(10);
		minHeap.insert(20);
		minHeap.insert(30);
		minHeap.insert(25);
		minHeap.insert(5);
		minHeap.insert(40);
		minHeap.insert(35);
		minHeap.insert(50);
		minHeap.getMax();
		
		minHeap.printMinHeap(); // 5 10 30 25 20 40 35
		minHeap.deleteElement(10);
		
		minHeap.delete();
		minHeap.printMinHeap(); // 10 20 30 25 35 40
		minHeap.delete();
		minHeap.printMinHeap(); // 20 25 30 40 35
		minHeap.delete();
		minHeap.printMinHeap(); // 25 35 30 40
		minHeap.delete();
		minHeap.printMinHeap(); // 30 35 40
		minHeap.delete();
		minHeap.printMinHeap(); // 35 40
		minHeap.delete();
		minHeap.printMinHeap(); // 40

		System.out.println("Display Array ");
		com.dsa.array.util.ArraysUtil.display(minHeap.heap);
	}

}
