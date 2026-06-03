package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class LocationInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String city;

    @SerializedName("city_code")
    public String cityCode;

    @SerializedName("city_id")
    public long cityId;
    public String country;

    @SerializedName("country_id")
    public long countryId;
    public String province;

    @SerializedName("province_code")
    public String provinceCode;

    @SerializedName("province_id")
    public long provinceId;

    static {
        Covode.recordClassIndex(612140);
        fieldTypeClassRef = FieldType.class;
    }
}
