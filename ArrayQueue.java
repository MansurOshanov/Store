package csci152.impl;

import csci152.adt.Queue;
	

public class ArrayQueue <T> implements Queue<T> {

	private T[] values;
	private int size;
	private int front;
	private int back;
	
	public ArrayQueue(){
		values = (T[]) new Object[5];
		size = 0;
		front = 0;
		back = 0;
	}
	
	@Override
	public void enqueue(T value) {
		if (size == values.length) {
			T[] newArr = (T[])new Object[values.length * 2];
			for (int i = 0, k = front; i < size; i++, k = (k + 1) % values.length) {
				newArr[i] = values[k];
			}
			values = newArr;
			front = 0;
			back = size;
		} 
		values[back] = value;
		back = (back + 1) % values.length;
		size++;
	}

	@Override
	public T dequeue() throws Exception {
		if (size == 0) {
			throw new Exception("Queue is empty");
		}
		T result = values[front];
		values[front] = null;
		front = (front + 1) % values.length;
		size--;
		return result;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		front = 0;
		back = 0;
	}
	
	
	public String toString() {
		String accum = "front\n----\n";
		for (int i = 0, k = front; i < size; i++, k = (k + 1) % values.length) {
			accum += values[k];
		}
		accum += "\n-----\nback";
		return accum;
	}
}
