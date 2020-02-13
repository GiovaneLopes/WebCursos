package utils;

import java.util.ArrayList;

public class Instrutores {
    private int id;
    private int valor_hora;
    private int valor_receber;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String experiencia;
    private ArrayList<Turmas> turmas;
    
    public Instrutores() { }

    public Instrutores(int id, int valor_hora, String nome, String email, String login, String senha, String experiencia) {
        this.id = id;
        this.valor_hora = valor_hora;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.experiencia = experiencia;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor_hora() {
		return valor_hora;
	}

	public void setValor_hora(int valor_hora) {
		this.valor_hora = valor_hora;
	}

	public int getValor_receber() {
		return valor_receber;
	}

	public void setValor_receber(int valor_receber) {
		this.valor_receber = valor_receber;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public ArrayList<Turmas> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turmas> turmas) {
		this.turmas = turmas;
	}
}
