package com.finance.calculator.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Value("${exchangeRate_key}")
    private String apiKey;

    @Override
    public BigDecimal getExchangeRate(String country) {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        JSONParser parser = new JSONParser();

        String authKey = apiKey;
        String searchDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String dataType = "AP01";   //Request -> String:AP01(환율)
        BigDecimal exchangeRate = null;
        HttpURLConnection connection = null;

        try {
            // Request URL
            URL url = new URL("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + authKey + "&searchdate=" + searchDate + "&data=" + dataType);
            connection = (HttpURLConnection) url.openConnection();

            // Request 초기 세팅
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            // API 호출
            // 실패했을 경우 Connection Close
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else { // 성공했을 경우 환율 정보 추출
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    JSONArray exchangeRateInfoList = (JSONArray) parser.parse(line);

                    // 선택한 금액에 대해 KRW와 비교하여 환율 정보 조회
                    for (Object o : exchangeRateInfoList) {
                        JSONObject exchangeRateInfo = (JSONObject) o;
                        if (exchangeRateInfo.get("cur_unit").equals(country)) {

                            // 쉼표가 포함되어 String 형태로 들어오는 데이터를 Double로 파싱하기 위한 부분
                            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
                            exchangeRate = BigDecimal.valueOf(format.parse(exchangeRateInfo.get("deal_bas_r").toString()).doubleValue());
                        }
                    }
                }
                reader.close();
            }
            System.out.println(responseContent.toString());

        } catch (IOException | ParseException | java.text.ParseException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }

        if (exchangeRate == null) {
            exchangeRate = BigDecimal.valueOf(1);
        }

        return exchangeRate;
    }
}
