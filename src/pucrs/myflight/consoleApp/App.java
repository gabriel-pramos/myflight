package pucrs.myflight.consoleApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.VooEscalas;
import pucrs.myflight.modelo.VooDireto;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.Gerenciador;

public class App {

	public static void main(String[] args) {
		System.out.println("\nMyFlight project...");


		GerenciadorCias cias = new GerenciadorCias();
		GerenciadorAeronaves aeronaves = new GerenciadorAeronaves();
		GerenciadorAeroportos aeroportos = new GerenciadorAeroportos();
		GerenciadorRotas rotas = new GerenciadorRotas();
		GerenciadorVoos voos = new GerenciadorVoos();

		cias.adicionar(new CiaAerea("JJ", "LATAM Linhas Aéreas"));
		cias.adicionar(new CiaAerea("G3", "Gol Linhas Aéreas SA"));
		cias.adicionar(new CiaAerea("TP", "TAP Portugal"));
		cias.adicionar(new CiaAerea("AD", "Azul Linhas Aéreas"));

		aeronaves.adicionar(new Aeronave("733", "Boeing 737-300", 140));
		aeronaves.adicionar(new Aeronave("73G", "Boeing 737-700", 126));
		aeronaves.adicionar(new Aeronave("380", "Airbus Industrie A380", 644));
		aeronaves.adicionar(new Aeronave("764", "Boeing 767-400", 304));

		aeroportos.adicionar(new Aeroporto("POA", "Salgado Filho Intl Apt", new Geo(-29.9939, -51.1711)));
		aeroportos.adicionar(new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", new Geo(-23.4356, -46.4731)));
		aeroportos.adicionar(new Aeroporto("LIS", "Lisbon", new Geo(38.7742, -9.1342)));
		aeroportos.adicionar(new Aeroporto("MIA", "Miami International Apt", new Geo(25.7933, -80.2906)));

		Rota r1 = new Rota(cias.buscarCodigo("G3"), aeroportos.buscarPorCodigo("GRU"), aeroportos.buscarPorCodigo("POA"), aeronaves.buscarPorCodigo("738"));
		Rota r2 = new Rota(cias.buscarCodigo("G3"), aeroportos.buscarPorCodigo("POA"), aeroportos.buscarPorCodigo("GRU"), aeronaves.buscarPorCodigo("738"));
		Rota r3 = new Rota(cias.buscarCodigo("TP"), aeroportos.buscarPorCodigo("MIA"), aeroportos.buscarPorCodigo("LIS"), aeronaves.buscarPorCodigo("738"));
		Rota r4 = new Rota(cias.buscarCodigo("JJ"), aeroportos.buscarPorCodigo("GRU"), aeroportos.buscarPorCodigo("LIS"), aeronaves.buscarPorCodigo("738"));
		
		rotas.adicionar(r1);
		rotas.adicionar(r2);
		rotas.adicionar(r3);
		rotas.adicionar(r4);

		voos.adicionar(new VooDireto(r1, LocalDateTime.of(2016, 8, 10, 8, 0)));
		voos.adicionar(new VooDireto(r2, LocalDateTime.of(2016, 8, 10, 15, 0)));
		voos.adicionar(new VooDireto(r3, LocalDateTime.of(2016, 8, 15, 12, 0)));

		System.out.println(voos.listarTodos());

		System.out.print("\n\n\n\n\n");


		// Utilizando Gerenciador universal

		Gerenciador g = new Gerenciador();

		g.adicionar(new CiaAerea("JJ", "LATAM Linhas Aéreas"));
		g.adicionar(new CiaAerea("G3", "Gol Linhas Aéreas SA"));
		g.adicionar(new CiaAerea("TP", "TAP Portugal"));
		g.adicionar(new CiaAerea("AD", "Azul Linhas Aéreas"));

		g.adicionar(new Aeronave("733", "Boeing 737-300", 140));
		g.adicionar(new Aeronave("73G", "Boeing 737-700", 126));
		g.adicionar(new Aeronave("380", "Airbus Industrie A380", 644));
		g.adicionar(new Aeronave("764", "Boeing 767-400", 304));

		g.adicionar(new Aeroporto("POA", "Salgado Filho Intl Apt", new Geo(-29.9939, -51.1711)));
		g.adicionar(new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", new Geo(-23.4356, -46.4731)));
		g.adicionar(new Aeroporto("LIS", "Lisbon", new Geo(38.7742, -9.1342)));
		g.adicionar(new Aeroporto("MIA", "Miami International Apt", new Geo(25.7933, -80.2906)));

		g.adicionar(r1);
		g.adicionar(r2);
		g.adicionar(r3);
		g.adicionar(r4);

		g.adicionar(new VooDireto(r1, LocalDateTime.of(2016, 8, 10, 8, 0)));
		g.adicionar(new VooDireto(r2, LocalDateTime.of(2016, 8, 10, 15, 0)));
		g.adicionar(new VooDireto(r3, LocalDateTime.of(2016, 8, 15, 12, 0)));
		g.adicionar(new VooDireto(r4, LocalDateTime.of(2016, 8, 16, 15, 30)));

		System.out.println(g.getVoos());

		System.out.print("\n\n\n\n\n");



		// Distancia entre pontos

		Aeroporto POA = g.getAeroportos().buscarPorCodigo("POA");
		Aeroporto GRU = g.getAeroportos().buscarPorCodigo("GRU");

		System.out.println("Distancia POA - GRU: " + Geo.distancia(POA.getLocal(), GRU.getLocal()));
		System.out.println("Distancia GRU - POA: " + GRU.getLocal().distancia(POA.getLocal()));
		System.out.println("Distancia GRU - GRU: " + GRU.getLocal().distancia(GRU.getLocal()));

		System.out.print("\n\n\n\n\n");


		// Imprimir contadores

		System.out.println("Contador de Cias: "+ CiaAerea.Contar());

		// Interface Contavel

		Aeronave aeronave01 = g.getAeronaves().buscarPorCodigo("73G");
		System.out.println("Contador de Aeronaves: "+ aeronave01.Contar());

		System.out.print("\n\n\n\n\n");


		// Interface Comparable

		System.out.println("Aeronaves Antes:");
		System.out.println(g.getAeronaves().toString());
		System.out.print("\n");

		g.getAeronaves().ordenaDescricao();

		System.out.println("Aeronaves Depois:");
		System.out.println(g.getAeronaves().toString());
		System.out.print("\n\n");

		//-

		System.out.println("Rotas Antes:");
		System.out.println(g.getRotas().toString());
		System.out.print("\n");

		g.getRotas().ordenaNomeCia();

		System.out.println("Rotas Depois:");
		System.out.println(g.getRotas().toString());
		System.out.print("\n\n");

		//-

		System.out.println("Aeroportos Antes:");
		System.out.println(g.getAeroportos().toString());
		System.out.print("\n");

		g.getAeroportos().ordenaNome();

		System.out.println("Aeroportos Depois:");
		System.out.println(g.getAeroportos().toString());
		System.out.print("\n\n");



		/* Antes de usar Polimorfismo

		// Voo, VooEscalas, VooVariasEscalas

		Voo v1 = new Voo(r1, LocalDateTime.of(2022, 5, 1, 4, 30), Duration.ofMinutes(90));
		System.out.println("v1: " + v1);
		System.out.print("\n");

		Voo v2 = new VooEscalas(r1, r2, LocalDateTime.of(2022, 5, 1, 4, 30), Duration.ofMinutes(90));
		System.out.println("v2: " + v2);
		System.out.print("\n");

		// Essa implementacao nao ficou boa, como VooVariasEscalas herda de Voo, precisamos informar a rota, o que nao faz sentido nesse caso.
		Voo v3 = new VooVariasEscalas(r1, LocalDateTime.of(2022, 5, 1, 4, 30), Duration.ofMinutes(90), new ArrayList<Rota>(Arrays. asList(r1,r2,r3,r4)));
		System.out.println("v3: " + v3);
		System.out.print("\n");

		*/

		Voo v1 = new VooDireto(r1, LocalDateTime.of(2022, 5, 1, 4, 30));
		System.out.println("v1: " + v1);
		System.out.print("\n");

		Voo v2 = new VooEscalas(new ArrayList<Rota>(Arrays. asList(r1,r2,r3,r4)), LocalDateTime.of(2022, 5, 1, 4, 30));
		System.out.println("v2: " + v2);
		System.out.print("\n");





	}
}
