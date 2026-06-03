package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MultipleNameExperimentBook implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("alias_modify_time")
    public String aliasModifyTime;

    @SerializedName("alias_name")
    public String aliasName;

    @SerializedName("alias_thumb_uri")
    public String aliasThumbURI;

    @SerializedName("alias_thumb_url")
    public List<ImageFormatInfo> aliasThumbURL;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("book_name")
    public String bookName;

    @SerializedName("experiment_info_status")
    public short experimentInfoStatus;

    @SerializedName("has_on_flight")
    public boolean hasOnFlight;

    @SerializedName("on_flight_type")
    public short onFlightType;

    @SerializedName("thumb_uri")
    public String thumbURI;

    @SerializedName("thumb_url")
    public List<ImageFormatInfo> thumbURL;

    static {
        Covode.recordClassIndex(613243);
        fieldTypeClassRef = FieldType.class;
    }
}
