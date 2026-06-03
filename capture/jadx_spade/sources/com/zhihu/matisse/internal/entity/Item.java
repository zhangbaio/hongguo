package com.zhihu.matisse.internal.entity;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.MimeType;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Item implements Parcelable {
    public static final Parcelable.Creator<Item> CREATOR;
    public final long duration;
    public final long id;
    public final String mimeType;
    public final long size;
    public final Uri uri;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri getContentUri() {
        return this.uri;
    }

    public Uri getCompatUri() {
        return getContentUri();
    }

    static {
        Covode.recordClassIndex(656121);
        CREATOR = new a();
    }

    public boolean isCapture() {
        if (this.id == -1) {
            return true;
        }
        return false;
    }

    public boolean isGif() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        return str.equals(MimeType.GIF.toString());
    }

    public int hashCode() {
        int hashCode = Long.valueOf(this.id).hashCode() + 31;
        String str = this.mimeType;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        return (((((hashCode * 31) + this.uri.hashCode()) * 31) + Long.valueOf(this.size).hashCode()) * 31) + Long.valueOf(this.duration).hashCode();
    }

    public boolean isImage() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        if (!str.equals(MimeType.JPEG.toString()) && !this.mimeType.equals(MimeType.PNG.toString()) && !this.mimeType.equals(MimeType.GIF.toString()) && !this.mimeType.equals(MimeType.BMP.toString()) && !this.mimeType.equals(MimeType.WEBP.toString())) {
            return false;
        }
        return true;
    }

    public boolean isVideo() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        if (!str.equals(MimeType.MPEG.toString()) && !this.mimeType.equals(MimeType.MP4.toString()) && !this.mimeType.equals(MimeType.QUICKTIME.toString()) && !this.mimeType.equals(MimeType.THREEGPP.toString()) && !this.mimeType.equals(MimeType.THREEGPP2.toString()) && !this.mimeType.equals(MimeType.MKV.toString()) && !this.mimeType.equals(MimeType.WEBM.toString()) && !this.mimeType.equals(MimeType.TS.toString()) && !this.mimeType.equals(MimeType.AVI.toString())) {
            return false;
        }
        return true;
    }

    static class a implements Parcelable.Creator<Item> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Item[] newArray(int i) {
            return new Item[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Item createFromParcel(Parcel parcel) {
            return new Item(parcel, null);
        }
    }

    public static Item valueOf(Cursor cursor) {
        return new Item(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("mime_type")), cursor.getLong(cursor.getColumnIndex("_size")), cursor.getLong(cursor.getColumnIndex("duration")));
    }

    private Item(Parcel parcel) {
        this.id = parcel.readLong();
        this.mimeType = parcel.readString();
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.size = parcel.readLong();
        this.duration = parcel.readLong();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        if (this.id != item.id) {
            return false;
        }
        String str = this.mimeType;
        if ((str == null || !str.equals(item.mimeType)) && (this.mimeType != null || item.mimeType != null)) {
            return false;
        }
        Uri uri = this.uri;
        if (((uri == null || !uri.equals(item.uri)) && (this.uri != null || item.uri != null)) || this.size != item.size || this.duration != item.duration) {
            return false;
        }
        return true;
    }

    /* synthetic */ Item(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.mimeType);
        parcel.writeParcelable(this.uri, 0);
        parcel.writeLong(this.size);
        parcel.writeLong(this.duration);
    }

    private Item(long j, String str, long j2, long j3) {
        Uri contentUri;
        this.id = j;
        this.mimeType = str;
        if (isImage()) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (isVideo()) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = MediaStore.Files.getContentUri("external");
        }
        this.uri = ContentUris.withAppendedId(contentUri, j);
        this.size = j2;
        this.duration = j3;
    }
}
