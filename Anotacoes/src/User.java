

public class User implements Comparable<User>{

	private String username;
	private String password;
	public Repositorio<Nota> notas;
	
	public Repositorio<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Repositorio<Nota> notas) {
		this.notas = notas;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		notas = new Repositorio<Nota>(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public String toString() {
		return username + ":" + password;
	}

	
	public int compareTo(User other) {
		return this.username.compareTo(other.username);
	}



}



