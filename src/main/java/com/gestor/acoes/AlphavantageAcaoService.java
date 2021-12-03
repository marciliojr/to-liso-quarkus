package com.gestor.acoes;

import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequestScoped
public class AlphavantageAcaoService {


    public RespostaAcaoDTO obterRespostaAcao(String codigoAcao) {

        Client client = ClientBuilder.newClient();
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + codigoAcao + ".SA&interval=5min&apikey=k6meno6Ehr3VJTzBX0hfTao2h3fS8VjdaG1oOEZA";
        String resposta = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        JSONObject userObject = new JSONObject(resposta);
        JSONObject timesSeriesDaily = (JSONObject) userObject.get("Time Series (Daily)");

        JSONObject metaData = (JSONObject) userObject.get("Meta Data");
        String nome = metaData.getString("2. Symbol");

        LocalDate data = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JSONObject valorAcaoDoDia = (JSONObject) timesSeriesDaily.get(data.minusDays(1).format(formatter));

        RespostaAcaoDTO respostaDTO = new RespostaAcaoDTO();
        respostaDTO.setValorAbertura(valorAcaoDoDia.getBigDecimal("1. open"));
        respostaDTO.setData(data);
        respostaDTO.setNome(nome);


        return respostaDTO;
    }


}
