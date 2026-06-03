package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.covode.number.Covode;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DraweeViewTouch extends it.sephiroth.android.library.imagezoom.a {
    private DraweeHolder I;

    static {
        Covode.recordClassIndex(656151);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I.onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I.onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.I.onAttach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.I.onDetach();
    }

    private void Q(Context context) {
        if (this.I == null) {
            this.I = DraweeHolder.create(new GenericDraweeHierarchyBuilder(getResources()).build(), context);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.I.getTopLevelDrawable() && super.verifyDrawable(drawable)) {
            return true;
        }
        return false;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        this.I.setController(Fresco.newDraweeControllerBuilder().setOldController(this.I.getController()).setImageRequest(imageRequest).setControllerListener(new a(Fresco.getImagePipeline().fetchDecodedImage(imageRequest, (Object) null))).build());
    }

    class a extends BaseControllerListener<ImageInfo> {
        final /* synthetic */ DataSource a;

        a(DataSource dataSource) {
            this.a = dataSource;
        }

        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            CloseableReference closeableReference;
            Throwable th;
            Bitmap underlyingBitmap;
            super.onFinalImageSet(str, imageInfo, animatable);
            try {
                closeableReference = (CloseableReference) this.a.getResult();
                if (closeableReference != null) {
                    try {
                        CloseableStaticBitmap closeableStaticBitmap = (CloseableImage) closeableReference.get();
                        if ((closeableStaticBitmap instanceof CloseableStaticBitmap) && (underlyingBitmap = closeableStaticBitmap.getUnderlyingBitmap()) != null) {
                            DraweeViewTouch.this.setImageBitmap(underlyingBitmap);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        this.a.close();
                        CloseableReference.closeSafely(closeableReference);
                        throw th;
                    }
                }
                this.a.close();
                CloseableReference.closeSafely(closeableReference);
            } catch (Throwable th3) {
                closeableReference = null;
                th = th3;
            }
        }
    }

    public DraweeViewTouch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Q(context);
    }
}
