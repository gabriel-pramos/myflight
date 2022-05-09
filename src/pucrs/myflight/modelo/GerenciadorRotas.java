package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas() {
        rotas = new ArrayList<Rota>();
    }

    public void adicionar(Rota r) {
        rotas.add(r);
    }

    public ArrayList<Rota> listarTodos() {
        return rotas;
    }

    public ArrayList<Rota> buscarData(Aeroporto orig) {
        ArrayList<Rota> rotas_data = new ArrayList<Rota>();

        for (Rota r: rotas) {
            if ( r.getOrigem() == orig ) {
                rotas_data.add(r);
            }
        }

        return rotas_data;
    }


    @Override
    public String toString() {
        return "{" +
            " rotas='" + rotas + "'" +
            "}";
    }


    public void ordenaNomeCia() {
        Collections.sort(rotas);
    }

}
