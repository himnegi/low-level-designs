package test;

public class File implements FileSystemComponent {
	private String fileName;

	File(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void show() {
		System.out.println("file name is " + this.fileName);
	}

}
