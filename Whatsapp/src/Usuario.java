
public class Usuario {

	private String iduser;
	private Repositorio<Chat> grups;
	private Repositorio<Mensagem> mensagens;
	int quantidadedemensagens = 0;
	
	public Usuario(String iduser) {
		this.iduser = iduser;
		grups = new Repositorio<Chat>("grupos");
		mensagens = new Repositorio<Mensagem>("mensagens");
	}

	public Repositorio<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Repositorio<Chat> getGrups() {
		return grups;
	}

	public void setGrups(Repositorio<Chat> grups) {
		this.grups = grups;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	
	public String toString() {
		return iduser;
	}

	public Chat retornaChat(Chat c) {
		for(Chat chat : this.grups.getAll()) 
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		throw new RuntimeException("fail: voce nao esta nesse grupo");
	}
	
	public void mostrarMensagens(Chat c) {
		if(this.retornaChat(c) != null) {
			System.out.println(c.mostrarSms(this.getIduser()));
		}	
	}
		
	public String contagem(Chat c) {
		String saida="";
		for(Mensagem m : c.getSms().getAll()) {
			if(!m.getUser().equals(this.iduser)) {
				if(!m.isLido()) {
				   quantidadedemensagens++;
				   m.setLido(true);
				}
			}
		}
		saida += quantidadedemensagens ;
		quantidadedemensagens = 0;
		return saida;
	}
	public String mostrarGroups() {
		String saida ="[ ";
		for(Chat c : grups.getAll())
			saida+= c.toString() + " ";
		return saida + "]";
	}
}
