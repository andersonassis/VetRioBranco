package br.com.andersonassis.vetriobranco.modelos;

/**
 * Created by AndersonLuis on 04/03/2018.
 */

public class ArtilheirosBojo {
    private String nomeJogador;
    private String equipe;
    private String golsMarcados;
    private String imagem;

    public ArtilheirosBojo(String nomeJogador, String equipe, String golsMarcados, String imagem) {
        this.nomeJogador = nomeJogador;
        this.equipe = equipe;
        this.golsMarcados = golsMarcados;
        this.imagem = imagem;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(String golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
