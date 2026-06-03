package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageInnerIncomeData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount1;

    @SerializedName("amount1_total")
    public long amount1Total;

    @SerializedName("amount1_type")
    public String amount1Type;

    @SerializedName("amount1_url")
    public String amount1Url;
    public int amount2;

    @SerializedName("amount2_total")
    public long amount2Total;

    @SerializedName("amount2_type")
    public String amount2Type;

    @SerializedName("amount2_url")
    public String amount2Url;

    @SerializedName("exchange_data")
    public PageInnerExchangeData exchangeData;

    @SerializedName("hexiao_info")
    public IncomeDataHexiaoInfo hexiaoInfo;

    @SerializedName("income_area_info")
    public IncomeAreaInfo incomeAreaInfo;

    @SerializedName("show_type")
    public String showType;

    @SerializedName("wallet_bar_info")
    public WalletBarInfo walletBarInfo;

    static {
        Covode.recordClassIndex(612177);
        fieldTypeClassRef = FieldType.class;
    }
}
