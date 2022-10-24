package com.dsa.tree.util;

import java.util.Arrays;

public class MaxHeap {

	private int[] heap;
	private int size; // size of max heap

	public MaxHeap(int capacity) {
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

	public void insert(int x) {
		if(size == heap.length-1) {
			resize();
		}
		heap[++size] = x;
		int i=size;

		while(i>1 && heap[i/2] < heap[i]) {
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
			if(heap[j+1] > heap[j]) {
				j=j+1;
			}
			if(heap[i] < heap[j]) {
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
	public void printMaxHeap() {
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

	public void createHeapify() {
		// Need to rewrite
		this.heap = new int[]{0,5,10,30,20,35,40,15};
		this.size = heap.length-1;
		int n = size;
		for(int i=n; i>0; i--) {
			int j=i*2;
			if(j>size) {
				continue;
			}
			if(heap[i] > heap[j] && heap[i] > heap[j+1]) {
				continue;
			} else {
				if(heap[j+1] > heap[j]) {
					j=j+1;
				}
				com.dsa.array.util.ArraysUtil.swap(heap, i, j);
			}
			System.out.println(heap[i]);
		}
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(10);		

		maxHeap.createHeap();
		maxHeap.printMaxHeap(); // 40 25 35 10 5 20 30

		maxHeap.delete();
		maxHeap.printMaxHeap(); // 35 25 30 10 5 20
		maxHeap.delete();
		maxHeap.printMaxHeap(); // 30 25 20 10 5
		maxHeap.delete();
		maxHeap.printMaxHeap(); // 25 10 20 5
		maxHeap.delete();
		maxHeap.printMaxHeap(); // 20 10 5
		maxHeap.delete();
		maxHeap.printMaxHeap(); // 10 5
		maxHeap.delete();
		maxHeap.printMaxHeap(); // 5

		/*maxHeap.insert(10);
		maxHeap.insert(20);
		maxHeap.insert(30);
		maxHeap.insert(25);
		maxHeap.insert(5);
		maxHeap.insert(40);
		maxHeap.insert(35);
		maxHeap.printMaxHeap(); // 40 25 35 10 5 20 30*/

		System.out.println("Display Array ");
		com.dsa.array.util.ArraysUtil.display(maxHeap.heap);
	}
}
