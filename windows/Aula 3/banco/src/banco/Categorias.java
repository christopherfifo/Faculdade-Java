package banco;

public class Categorias {
	private int idCategoria;
	private String descricao;

	public Categorias() {
	}

	public Categorias(int idCategoria, String descricao) {
		this.idCategoria = idCategoria;
		this.descricao = descricao;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
