package br.com.andersonassis.vetriobranco.modelos;

public class CartoesModel {

    private String equipe;
    private String atleta;
    private String amarelo;
    private String vermelho;
    private String suspenso;



    public CartoesModel(String equipe, String atleta, String amarelo, String vermelho, String suspenso) {
        this.equipe = equipe;
        this.atleta = atleta;
        this.amarelo = amarelo;
        this.vermelho = vermelho;
        this.suspenso = suspenso;

    }


    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getAmarelo() {
        return amarelo;
    }

    public void setAmarelo(String amarelo) {
        this.amarelo = amarelo;
    }

    public String getVermelho() {
        return vermelho;
    }

    public void setVermelho(String vermelho) {
        this.vermelho = vermelho;
    }

    public String getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }


}
