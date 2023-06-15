package gft.services;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import gft.entities.Address;
import gft.util.Util;


public class ServiceAddress {
	
	private static String webService = "http://viacep.com.br/ws/";
	private static int codigoSucesso = 200;

    public static Address searchAddressFor(String cep) throws Exception {
        String urlParaChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Address address = gson.fromJson(jsonEmString, Address.class);

            return address;
        } catch (RuntimeException e) {
            throw new Exception("ERRO: " + e.getMessage());
        }
    }

}
