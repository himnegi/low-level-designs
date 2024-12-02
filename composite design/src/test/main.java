package test;

public class main {
	public static void main(String[] args) {
		File f1 = new File("study");
		Directory d1 = new Directory("root");
		Directory d2 = new Directory("source");
		d1.add(f1);
		d1.add(d2);
		d1.show();
	}
}
