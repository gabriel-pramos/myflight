package pucrs.myflight.modelo;

public class CiaAerea{
	private static int totalCiasAereas = 0;
	private String codigo;
	private String nome;
	
	public CiaAerea(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;

		totalCiasAereas++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	

	@Override
	public String toString() {
		return "{" +
			" codigo='" + getCodigo() + "'" +
			", nome='" + getNome() + "'" +
			"}";
	}

	public static int Contar() {
		return totalCiasAereas;
	}
	
}
