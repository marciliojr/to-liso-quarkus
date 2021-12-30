package com.gestor.acoes;

import com.gestor.config.ConfiguracoesService;
import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestScoped
public class AlphavantageAcaoService {

    @Inject
    private AcaoRepository repository;

    @Inject
    private ConfiguracoesService serviceConfiguracoes;

    public RespostaAcaoDTO obterRespostaAcao(String codigoAcao) {

        Map<String, String> mapaConfiguracao = serviceConfiguracoes.getMapaConfiguracao();
        String key_acoes = mapaConfiguracao.get("key_acoes");

        Client client = ClientBuilder.newClient();
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + codigoAcao + ".SA&interval=5min&apikey="+key_acoes;
        String resposta = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        JSONObject userObject = new JSONObject(resposta);
        JSONObject timesSeriesDaily = (JSONObject) userObject.get("Time Series (Daily)");

        JSONObject metaData = (JSONObject) userObject.get("Meta Data");
        String nome = metaData.getString("2. Symbol");
        String dataUltimaAtualizacao = metaData.getString("3. Last Refreshed");

        LocalDate localDateUltimaAtualizacao = LocalDate.parse(dataUltimaAtualizacao);

        LocalDate data = LocalDate.now();

        if(data.isAfter(localDateUltimaAtualizacao)){
            data = localDateUltimaAtualizacao;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JSONObject valorAcaoDoDia = (JSONObject) timesSeriesDaily.get(data.format(formatter));

        RespostaAcaoDTO respostaDTO = new RespostaAcaoDTO();
        respostaDTO.setValorAbertura(valorAcaoDoDia.getBigDecimal("1. open"));
        respostaDTO.setData(data);
        respostaDTO.setNome(nome);
        respostaDTO.setValorFechamento(valorAcaoDoDia.getBigDecimal("4. close"));


        return respostaDTO;
    }

    @Transactional
    public void createMockAcoes(){

        List<String> lista = new ArrayList<String>();
        lista.add("NEOE3");
        lista.add("ITUB3");
        lista.add("VRTA11");
        lista.add("BTLG11");
        lista.add("RECR11");

        for (String acao: lista) {
            RespostaAcaoDTO dto = obterRespostaAcao(acao);
            repository.salvarMock(dto);
        }

    }


}
