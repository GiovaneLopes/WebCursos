package utils;

import java.util.ArrayList;

public class Alunos {

    private int id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String senha;
    private String login;
    private String endereco;
    private String cidade;
    private String bairro;
    private String cep;
    private String comentario;
    private char aprovado;
    private ArrayList<Matriculas> matriculas;


    public Alunos() {
        this.aprovado = 'N';
    }

    public Alunos(int id, String nome, String cpf, String celular, String email, String login, String endereco, String cidade, String bairro, String cep, String comentario, char aprovado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.login = login;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.comentario = comentario;
        this.aprovado = aprovado;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public char getAprovado() {
		return aprovado;
	}

	public void setAprovado(char aprovado) {
		this.aprovado = aprovado;
	}

	public ArrayList<Matriculas> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}

}
