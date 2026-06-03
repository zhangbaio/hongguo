package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EcomWidgetData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("detail_url")
    public String detailUrl;

    @SerializedName("main_product_name")
    public String mainProductName;

    @SerializedName("main_product_url")
    public String mainProductUrl;

    @SerializedName("order_status")
    public int orderStatus;

    @SerializedName("order_status_desc")
    public String orderStatusDesc;

    @SerializedName("order_status_detail")
    public String orderStatusDetail;
    public int price;
    public String title;

    @SerializedName("widget_default_detail")
    public String widgetDefaultDetail;

    static {
        Covode.recordClassIndex(612079);
        fieldTypeClassRef = FieldType.class;
    }
}
