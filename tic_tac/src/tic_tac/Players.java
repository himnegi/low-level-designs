package tic_tac;

public class Players {

	private String name;

	private String peiceType;

	public Players(String name, String peiceType) {

		this.name = name;
		this.peiceType = peiceType;
		System.out.println("player initialized with name " + name + "and peice " + peiceType);
	}

	public String getName() {
		return this.name;
	}

	public String getPeiceType() {
		return this.peiceType;
	}
}
