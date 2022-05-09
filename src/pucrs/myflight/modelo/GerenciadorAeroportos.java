package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        aeroportos = new ArrayList<Aeroporto>();
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod) {
        for (Aeroporto aero: aeroportos) {
            if ( aero.getCodigo().equals(cod) ) {
                return aero;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "{" +
            " aeroportos='" + aeroportos + "'" +
            "}";
    }


    public void ordenaNome() {
        Collections.sort(aeroportos);
    }
}
