package com.finance.calculator.dto;

import lombok.Data;

@Data
public class ExchangeRateDto {

    //조회 결과
    private int result;
    //통화 코드
    private String cur_unit;
    //국가,통화명
    private String cur_nm;
    //송금 받을 때
    private String ttb;
    //송금 보낼 때
    private String tts;
    //매매 기준율
    private String deal_bas_r;
    //장부가격
    private String bkpr;
    //년환가료율
    private String yy_efee_r;
    //10일환가료율
    private String ten_dd_efee_r;
    //서울외국환중개 매매기준율
    private String kftc_deal_bas_r;
    //서울외국환중개 장부가격
    private String kftc_bkpr;
}
