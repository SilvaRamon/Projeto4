package com.example.ramon.tabapp;

/**
 * Created by Pichau on 07/02/2017.
 */

public class Denuncia {
    private String tipoDeOcorrencia;
    private String endereço;
    private String detalhesDaOcorrencia;

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
}
