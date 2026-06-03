package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcProductData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_info")
    public UgcBookInfo bookInfo;

    @SerializedName("discount_labels")
    public List<UgcDiscountLabel> discountLabels;

    @SerializedName("discount_tag")
    public String discountTag;

    @SerializedName("expland_schema")
    public String explandSchema;
    public Map<String, String> extra;

    @SerializedName("min_price")
    public long minPrice;

    @SerializedName("min_price_str")
    public String minPriceStr;

    @SerializedName("product_id")
    public String productID;

    @SerializedName("product_icon")
    public String productIcon;

    @SerializedName("product_name")
    public String productName;

    @SerializedName("product_schema")
    public String productSchema;

    @SerializedName("regular_price")
    public long regularPrice;

    @SerializedName("regular_price_str")
    public String regularPriceStr;

    @SerializedName("rit_tags")
    public List<String> ritTags;

    @SerializedName("sales_str")
    public String salesStr;

    @SerializedName("style_type")
    public ProductCardStyleType styleType;

    static {
        Covode.recordClassIndex(613516);
        fieldTypeClassRef = FieldType.class;
    }
}
