package generic;

// �Զ�������͵ķ���
public class Demo2 <T>
{
	public void hello(T t) {
		
	}
	
	// ע��static��Ҫ�Լ��������ͣ���static�ؼ��ʺ���
	public static <T> void a(T t) {

	}
	
	// ��дһ�����ͷ����� ʵ��ָ��λ���ϵ�����Ԫ�ؽ���
	public void swap(T[] arr, int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	// ��дһ�����ͷ����� ����һ�����飬���ߵ������е�����Ԫ��
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
