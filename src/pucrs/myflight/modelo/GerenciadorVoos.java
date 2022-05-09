package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        voos = new ArrayList<Voo>();
    }

    public void adicionar(Voo v) {
        voos.add(v);
    }

    public ArrayList<Voo> listarTodos() {
        return voos;
    }

    public ArrayList<Voo> buscarData(LocalDateTime data) {
        ArrayList<Voo> voos_data = new ArrayList<Voo>();

        for (Voo v: voos) {
            if ( v.getDatahora().compareTo(data) == 0 ) {
                voos_data.add(v);
            }
        }

        return voos_data;
    }

    @Override
    public String toString() {
        return "{" +
            " voos='" + listarTodos() + "'" +
            "}";
    }

}
