package com.dragon.read.local.db.pojo;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookModel implements Serializable {
    public String bookId;
    public String bookName;
    public BookType bookType;
    public Map<String, Object> extraMap;
    public int genreType;
    public boolean isLocalBook;
    public boolean isPubPay;

    static {
        Covode.recordClassIndex(611917);
    }

    public int hashCode() {
        return ((this.bookType.getValue() + 31) * 31) + this.bookId.hashCode();
    }

    public String toString() {
        return "BookModel{bookId='" + this.bookId + "', bookType=" + this.bookType + ", isLocalBook=" + this.isLocalBook + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookModel)) {
            return false;
        }
        BookModel bookModel = (BookModel) obj;
        if (this.bookId.equals(bookModel.bookId) && this.bookType == bookModel.bookType) {
            return true;
        }
        return false;
    }

    public Object getExtra(String str) {
        if (this.extraMap != null && !TextUtils.isEmpty(str)) {
            return this.extraMap.get(str);
        }
        return null;
    }

    public void addExtra(String str, Object obj) {
        if (this.extraMap == null) {
            this.extraMap = new HashMap();
        }
        if (!TextUtils.isEmpty(str)) {
            this.extraMap.put(str, obj);
        }
    }

    public BookModel(String str, BookType bookType) {
        this.bookId = str;
        this.bookType = bookType;
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("book id is null");
            if (AppUtils.isOfficialBuild()) {
                this.bookId = "";
                LogWrapper.error("BookModel", "error = %s", new Object[]{Log.getStackTraceString(illegalArgumentException)});
                return;
            }
            throw illegalArgumentException;
        }
    }
}
