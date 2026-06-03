package com.dragon.read.openanim;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.covode.number.Covode;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p extends o {
    public static final int c;

    static {
        Covode.recordClassIndex(612636);
        c = 8;
    }

    @Override // com.dragon.read.openanim.o
    public void a() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        RoundedBitmapDrawable roundedBitmapDrawable = this.a;
        Intrinsics.checkNotNull(roundedBitmapDrawable, "null cannot be cast to non-null type com.facebook.drawee.drawable.RoundedBitmapDrawable");
        Drawable current = roundedBitmapDrawable.getCurrent();
        if (current instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) current;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(RoundedBitmapDrawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }
}
