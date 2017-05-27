package csci152.impl;

import csci152.adt.Stack;

public class ArrayStack<T> implements Stack<T>{
	
	private T[] values;
	private int size;
	
	public ArrayStack() {
		values = (T[]) new Object[10];
		size = 0;
	}
	
	@Override
	public void push(T value) {
		if (values.length <= size) {
			T[] temp = (T[]) new Object[values.length * 2];
			for (int i = 0; i < size; i++) {
				temp[i] = values[i];
			}
			values = temp;
		}
		values[size] = value;
		size++;		
	}
	
	public int showLength() {
		return values.length;
	}

	@Override
	public T pop() throws Exception {
		if (size > 0) {
			T result = values[size - 1];
			size--;
			return result;
		}  throw new Exception("Cannot pop from empty stack");
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
	}
	
	public String toString() {
		String accum = "bottom[";
		int i;
		for (i = 0; i < size - 1; i++) {
			accum += values[i] + ",";
		}
		accum += values[i];
		accum += "]top";
		return accum;
	}


	
}
