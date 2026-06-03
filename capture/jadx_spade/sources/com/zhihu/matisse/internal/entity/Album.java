package com.zhihu.matisse.internal.entity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Album implements Parcelable {
    public static final String ALBUM_ID_ALL;
    public static final Parcelable.Creator<Album> CREATOR;
    private long mCount;
    private final Uri mCoverUri;
    private final String mDisplayName;
    private final String mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.mCount;
    }

    public Uri getCoverUri() {
        return this.mCoverUri;
    }

    public String getId() {
        return this.mId;
    }

    public void addCaptureCount() {
        this.mCount++;
    }

    public Uri getCompatUri() {
        return getCoverUri();
    }

    public boolean isAll() {
        return ALBUM_ID_ALL.equals(this.mId);
    }

    public boolean isEmpty() {
        if (this.mCount == 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(656117);
        CREATOR = new a();
        ALBUM_ID_ALL = String.valueOf(-1);
    }

    static class a implements Parcelable.Creator<Album> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Album[] newArray(int i) {
            return new Album[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Album createFromParcel(Parcel parcel) {
            return new Album(parcel, null);
        }
    }

    public String getDisplayName(Context context) {
        if (isAll()) {
            return context.getString(2131104494);
        }
        return this.mDisplayName;
    }

    private Album(Parcel parcel) {
        this.mId = parcel.readString();
        this.mCoverUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mDisplayName = parcel.readString();
        this.mCount = parcel.readLong();
    }

    public static Album valueOf(Cursor cursor) {
        return new Album(cursor.getString(cursor.getColumnIndex("bucket_id")), Uri.parse(cursor.getString(cursor.getColumnIndex("uri"))), cursor.getString(cursor.getColumnIndex("bucket_display_name")), cursor.getLong(cursor.getColumnIndex("count")));
    }

    /* synthetic */ Album(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mCoverUri, 0);
        parcel.writeString(this.mDisplayName);
        parcel.writeLong(this.mCount);
    }

    public Album(String str, Uri uri, String str2, long j) {
        this.mId = str;
        this.mCoverUri = uri;
        this.mDisplayName = str2;
        this.mCount = j;
    }
}
