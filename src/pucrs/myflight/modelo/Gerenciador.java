package pucrs.myflight.modelo;

public class Gerenciador {
    private GerenciadorCias cias;
    private GerenciadorAeronaves aeronaves;
    private GerenciadorAeroportos aeroportos;
    private GerenciadorRotas rotas;
    private GerenciadorVoos voos;

    public Gerenciador() {
        cias = new GerenciadorCias();
        aeronaves = new GerenciadorAeronaves();
        aeroportos = new GerenciadorAeroportos();
        rotas = new GerenciadorRotas();
        voos = new GerenciadorVoos();
    }

    public GerenciadorCias getCias() {
        return cias;
    }

    public GerenciadorAeronaves getAeronaves() {
        return this.aeronaves;
    }

    public GerenciadorAeroportos getAeroportos() {
        return this.aeroportos;
    }

    public GerenciadorRotas getRotas() {
        return this.rotas;
    }

    public GerenciadorVoos getVoos() {
        return this.voos;
    }

    public void adicionar(CiaAerea c) {
        this.cias.adicionar(c);
    }

    public void adicionar(Aeronave aviao) {
        this.aeronaves.adicionar(aviao);
    }

    public void adicionar(Aeroporto aero) {
        this.aeroportos.adicionar(aero);
    }

    public void adicionar(Rota r) {
        this.rotas.adicionar(r);
    }

    public void adicionar(Voo v) {
        this.voos.adicionar(v);
    }
}
