package com.example.ramon.tabapp;

/**
 * Created by Pichau on 07/02/2017.
 */

public class Denuncia {
    private String tipoDeOcorrencia;
    private String endereço;
    private String detalhesDaOcorrencia;
    private String imagemURL;
    private double latitude;
    private double longitude;

    public Denuncia() {
    }

    public String getTipoDeOcorrencia() {
        return tipoDeOcorrencia;
    }

    public void setTipoDeOcorrencia(String tipoDeOcorrencia) {
        this.tipoDeOcorrencia = tipoDeOcorrencia;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getDetalhesDaOcorrencia() {
        return detalhesDaOcorrencia;
    }

    public void setDetalhesDaOcorrencia(String detalhesDaOcorrencia) {
        this.detalhesDaOcorrencia = detalhesDaOcorrencia;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
