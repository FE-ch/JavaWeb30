package generic;

// 自定义带泛型的方法
public class Demo2 <T>
{
	public void hello(T t) {
		
	}
	
	// 注意static需要自己申明泛型，在static关键词后面
	public static <T> void a(T t) {

	}
	
	// 编写一个泛型方法， 实现指定位置上的数组元素交换
	public void swap(T[] arr, int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	// 编写一个泛型方法， 接收一个数组，并颠倒数组中的所有元素
	public static <E> E[] reverse(E[] arr) {
		int startPos = 0;
		int endPos = arr.length - 1;
		
		while (startPos < endPos) {
			E temp = arr[startPos];
			arr[startPos] = arr[endPos];
			arr[endPos] = temp;
			
			startPos++;
			endPos--;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {1, 3, 5, 2, 4};
		Integer[] newArr = reverse(arr);
		for (int i : newArr) {
			System.out.printf("%d ", i);
		}
	}
}
