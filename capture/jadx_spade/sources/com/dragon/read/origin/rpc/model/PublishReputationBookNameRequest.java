package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublishReputationBookNameRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    public String bookID;

    @SerializedName("reputation_book_name")
    public String reputationBookName;

    @SerializedName("reputation_thumb_uri")
    public String reputationThumbURI;

    static {
        Covode.recordClassIndex(613343);
        fieldTypeClassRef = FieldType.class;
    }
}
