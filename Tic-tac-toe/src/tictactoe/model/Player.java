package tictactoe.model;

public class Player {
	private String playerName;
	private String PlayerCode;

	public Player(String name, String playercode) {
		this.playerName = name;
		this.PlayerCode = playercode;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerCode() {
		return PlayerCode;
	}

}
