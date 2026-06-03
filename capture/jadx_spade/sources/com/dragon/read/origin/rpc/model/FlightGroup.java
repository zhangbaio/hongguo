package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FlightGroup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("alias_name")
    public String aliasName;

    @SerializedName("alias_thumb_uri")
    public String aliasThumbURI;

    @SerializedName("alias_thumb_url")
    public List<ImageFormatInfo> aliasThumbURL;

    @SerializedName("audit_reject_reason")
    public String auditRejectReason;

    @SerializedName("version_id")
    public String versionID;

    static {
        Covode.recordClassIndex(612930);
        fieldTypeClassRef = FieldType.class;
    }
}
