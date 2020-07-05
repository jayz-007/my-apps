package tictactoe.model;

public class Player {
	private String playerName;
	private String PlayerMark;

	public Player(String name, String playerMark) {
		this.playerName = name;
		this.PlayerMark = playerMark;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerCode() {
		return PlayerMark;
	}

}
