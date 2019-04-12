package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * 根据一颗二叉树的前序遍历和中序遍历还原已有的二叉树
 * 
 * @author wy
 *
 */
public class RebuildTree {

	/**
	 * 声明节点类
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
	 * 重建二叉树
	 * 
	 * @param be 前序数组
	 * @param ce 中序数组
	 * @return
	 */
	public static Node rebuildNode(ArrayList<Integer> be, ArrayList<Integer> ce) {
		Node<Integer> root = new Node<Integer>();

		return null;
	}

	
	/**
	 * 获取当前节点中序遍历时的索引位置 index
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
	 * 获取当前节点的左前序序列的索引位置
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static int getLeftBeIndex(ArrayList<Integer> be, ArrayList<Integer> ce, int index) {

		// 先进行条件判断
		if (be == null || be.isEmpty() || ce == null || ce.isEmpty()) {
			return -1;
		}
		
		//当前节点如果没有左子树，返回-1
		if (index == 0) {
			return -1;
		}

		// 获取左子树的前序序列
		Integer cur = be.get(0);
		ArrayList<Integer> newBe = new ArrayList<>();

		// 通过中序数组获取所有当前节点所有左子树的节点
		Set<Integer> set = new TreeSet();
		for (int i = 0; i < index; i++) {
			set.addAll(be.subList(0, index+1));
		}
		

		// 通过先序数组获取所有当前节点所有左子树的节点构建的新的数组
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
	 * 从新构建左中序数组
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static ArrayList<Integer> rebuildLeftCe(ArrayList<Integer> be, ArrayList<Integer> ce) {

		// 先进行条件判断
		if (be == null || be.isEmpty() || ce == null || ce.isEmpty()) {
			return null;
		}

		// 获取左子树的中序序列
		Integer cur = be.get(0);
		ArrayList<Integer> newCe = new ArrayList<>();

		// 通过中序数组获取所有当前节点所有左子树的节点
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
	 * 重新构建右前序数组
	 * 
	 * @param be
	 * @param ce
	 * @return
	 */
	public static ArrayList<Integer> rebuildRightBe(ArrayList<Integer> be, ArrayList<Integer> ce) {

		return null;
	}

	/**
	 * 从新构建右中序数组
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
