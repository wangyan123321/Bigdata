package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * ����һ�Ŷ�������ǰ����������������ԭ���еĶ�����
 * 
 * @author wy
 *
 */
public class RebuildTree {

	/**
	 * �����ڵ���
	 * 
	 * @author wy
	 *
	 * @param <T>
	 */
	static class Node<T> {
		public T value;
		public Node left;
		public Node right;
	}

	/**
	 * �ؽ�������
	 * 
	 * @param be ǰ������
	 * @param ce ��������
	 * @return
	 */
	public static Node rebuildNode(ArrayList<Integer> be, ArrayList<Integer> ce) {
		Node<Integer> root = new Node<Integer>();

		return null;
	}

	
	/**
	 * ��ȡ��ǰ�ڵ��������ʱ������λ�� index
	 *
	 * 
	 * @return
	 */
	public static Integer getLeftCenIndex(Integer cur , ArrayList<Integer> ce) {
		int index = 0;
		
		while(ce.get(index) != cur) {
			index ++;
		}
		
		return index;
	}
	
	/**
	 * ��ȡ��ǰ�ڵ����ǰ�����е�����λ��
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static int getLeftBeIndex(ArrayList<Integer> be, ArrayList<Integer> ce, int index) {

		// �Ƚ��������ж�
		if (be == null || be.isEmpty() || ce == null || ce.isEmpty()) {
			return -1;
		}
		
		//��ǰ�ڵ����û��������������-1
		if (index == 0) {
			return -1;
		}

		// ��ȡ��������ǰ������
		Integer cur = be.get(0);
		ArrayList<Integer> newBe = new ArrayList<>();

		// ͨ�����������ȡ���е�ǰ�ڵ������������Ľڵ�
		Set<Integer> set = new TreeSet();
		for (int i = 0; i < index; i++) {
			set.addAll(be.subList(0, index+1));
		}
		

		// ͨ�����������ȡ���е�ǰ�ڵ������������Ľڵ㹹�����µ�����
		int leftIndex = 0;
		for (Integer value : be) {
			if (set.contains(value)) {
				leftIndex++;
			} else {
				break;
			}
		}

		return leftIndex-1;
	}

	/**
	 * ���¹�������������
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static ArrayList<Integer> rebuildLeftCe(ArrayList<Integer> be, ArrayList<Integer> ce) {

		// �Ƚ��������ж�
		if (be == null || be.isEmpty() || ce == null || ce.isEmpty()) {
			return null;
		}

		// ��ȡ����������������
		Integer cur = be.get(0);
		ArrayList<Integer> newCe = new ArrayList<>();

		// ͨ�����������ȡ���е�ǰ�ڵ������������Ľڵ�
		for (Integer value : ce) {
			if (value != cur) {
				newCe.add(value);
			} else {
				break;
			}
		}

		return newCe;
	}

	/**
	 * ���¹�����ǰ������
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static ArrayList<Integer> rebuildRightBe(ArrayList<Integer> be, ArrayList<Integer> ce) {

		return null;
	}

	/**
	 * ���¹�������������
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static ArrayList<Integer> rebuildRightCe(ArrayList<Integer> be, ArrayList<Integer> ce) {

		return null;
	}

	public static void main(String[] args) {

	}
}
