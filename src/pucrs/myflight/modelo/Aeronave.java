package pucrs.myflight.modelo;

public class Aeronave implements Contavel, Comparable<Aeronave>{
	private static int totalAeronaves = 0;
	private String codigo;
	private String descricao;
	private int capacidade;
	
	public Aeronave(String codigo, String descricao, int capacidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;

		totalAeronaves++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getCapacidade() {
		return capacidade;
	}


	@Override
	public String toString() {
		return "{" +
			" codigo='" + getCodigo() + "'" +
			", descricao='" + getDescricao() + "'" +
			", capacidade='" + getCapacidade() + "'" +
			"}";
	}

	@Override
	public int Contar() {
		return totalAeronaves;
	}

	@Override
	public int compareTo(Aeronave outra) {
		return descricao.compareTo(outra.descricao);
	}

}
