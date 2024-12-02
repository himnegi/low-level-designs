package test;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
	private String dirName;

	List<FileSystemComponent> fileSystemComponent = new ArrayList<>();

	Directory(String dirName) {
		this.dirName = dirName;

	}

	public void  add(FileSystemComponent obj) {
	
		fileSystemComponent.add(obj);
	}

	@Override
	public void show() {
		System.out.println("direc name is " + this.dirName);
		for (FileSystemComponent o : fileSystemComponent) {
			o.show();
		}
	}

}
