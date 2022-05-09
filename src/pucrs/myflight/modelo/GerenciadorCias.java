package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<CiaAerea>();
	}

    public void adicionar(CiaAerea c) {
        empresas.add(c);
    }

    public ArrayList<CiaAerea> listarTodos() {
        return empresas;
    }

    public CiaAerea buscarCodigo(String cod) {
        for (CiaAerea e: empresas) {
            if ( e.getCodigo().equals(cod) ) {
                return e;
            }
        }

        return null;
    }

    public CiaAerea buscarNome(String nome) {
        for (CiaAerea e: empresas) {
            if ( e.getNome().equals(nome) ) {
                return e;
            }
        }

        return null;
    }
}
