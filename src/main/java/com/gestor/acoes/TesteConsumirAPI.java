package com.gestor.acoes;


import com.google.gson.Gson;
import io.agroal.api.exceptionsorter.SybaseExceptionSorter;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteConsumirAPI {

    public static void main(String[] args) {
/*        Client client = ClientBuilder.newClient();
        String resposta = client.target("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=RECR11.SA&interval=5min&apikey=k6meno6Ehr3VJTzBX0hfTao2h3fS8VjdaG1oOEZA").request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        JSONObject userObject = new JSONObject(resposta);
        JSONObject timesSeriesDaily = (JSONObject) userObject.get("Time Series (Daily)");

        JSONObject metaData = (JSONObject) userObject.get("Meta Data");
        String nome = metaData.getString("2. Symbol");


        LocalDate data = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        JSONObject a = (JSONObject) timesSeriesDaily.get(data.format(formatter));

        RespostaAcaoDTO respostaDTO = new RespostaAcaoDTO();
        respostaDTO.setValorAbertura(a.getBigDecimal("1. open"));
        respostaDTO.setData(data);
        respostaDTO.setNome(nome);

        System.out.println("RESPOSTA: " + respostaDTO);*/

        String senha = "123";
        try {
            MessageDigest algorithm = null;
            algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            System.out.println(messageDigest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

//[B@2ac1fdc4


    }


}
