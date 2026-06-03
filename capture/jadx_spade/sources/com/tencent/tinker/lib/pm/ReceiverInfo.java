package com.tencent.tinker.lib.pm;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.Muter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ReceiverInfo implements Parcelable {
    public static final Parcelable.Creator<ReceiverInfo> CREATOR;
    public boolean exported;
    public List<IntentFilter> intentFilters;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Covode.recordClassIndex(653779);
        CREATOR = new Parcelable.Creator<ReceiverInfo>() { // from class: com.tencent.tinker.lib.pm.ReceiverInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ReceiverInfo[] newArray(int i) {
                return new ReceiverInfo[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ReceiverInfo createFromParcel(Parcel parcel) {
                return new ReceiverInfo(parcel);
            }
        };
    }

    public ReceiverInfo(Parcel parcel) {
        this.name = "";
        this.intentFilters = new ArrayList();
        this.exported = false;
        this.name = parcel.readString();
        Context appContext = Muter.getAppContext();
        if (appContext != null) {
            parcel.readList(this.intentFilters, appContext.getClassLoader());
        } else {
            parcel.readList(this.intentFilters, IntentFilter.class.getClassLoader());
        }
        this.exported = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeList(this.intentFilters);
        parcel.writeInt(this.exported ? 1 : 0);
    }

    public ReceiverInfo(String str, List<IntentFilter> list, boolean z) {
        this.name = "";
        this.intentFilters = new ArrayList();
        this.exported = false;
        if (!TextUtils.isEmpty(str)) {
            this.name = str;
        }
        if (list != null && list.size() > 0) {
            this.intentFilters = list;
        }
        this.exported = z;
    }
}
