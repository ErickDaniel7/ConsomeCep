package br.unipar.programacaoweb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    private String cep; // CEP é a chave primária
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String siafi;
    private String unidade; // Unidade, se aplicável, como campo adicional
    private LocalDateTime dataConsulta; // Usando LocalDateTime para melhor manipulação de datas

    // Formatação da data para exibição
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Método para formatar a data da consulta em string
    public String getDataConsultaFormatada() {
        return dataConsulta != null ? dataConsulta.format(FORMATTER) : "Data não disponível";
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("CEP: ").append(cep).append("\n")
                .append("Logradouro: ").append(logradouro).append("\n")
                .append("Complemento: ").append(complemento).append("\n")
                .append("Bairro: ").append(bairro).append("\n")
                .append("Localidade: ").append(localidade).append("\n")
                .append("UF: ").append(uf).append("\n")
                .append("IBGE: ").append(ibge).append("\n")
                .append("SIAFI: ").append(siafi).append("\n")
                .append("Unidade: ").append(unidade).append("\n")
                .append("Data da Consulta: ").append(getDataConsultaFormatada())
                .toString();
    }
}
