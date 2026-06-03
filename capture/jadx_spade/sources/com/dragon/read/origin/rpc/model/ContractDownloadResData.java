package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ContractDownloadResData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ai_download_url")
    public String aIDownloadURL;

    @SerializedName("all_download_info")
    public List<ContractDownloadInfo> allDownloadInfo;

    @SerializedName("download_uri")
    public String downloadURI;

    @SerializedName("download_url")
    public String downloadURL;

    static {
        Covode.recordClassIndex(612843);
        fieldTypeClassRef = FieldType.class;
    }
}
