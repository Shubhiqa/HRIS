package source;

public class Addition {
	
	public int i, j;

	public Addition(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int add() {
		return i+j;
	}
	
	public static void print() {
		System.out.print("Hello");
	}
}
