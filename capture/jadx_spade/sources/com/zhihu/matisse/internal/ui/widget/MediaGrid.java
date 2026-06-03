package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zhihu.matisse.internal.entity.Item;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaGrid extends SquareFrameLayout implements View.OnClickListener {
    private SimpleDraweeView a;
    private CheckView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private Item f;
    public b g;
    private a h;

    public interface a {
        void Q(ImageView imageView, Item item, RecyclerView.ViewHolder viewHolder);

        void r3(CheckView checkView, Item item, RecyclerView.ViewHolder viewHolder);
    }

    static {
        Covode.recordClassIndex(656153);
    }

    public Item getMedia() {
        return this.f;
    }

    private void c() {
        this.b.setCountable(this.g.c);
    }

    private void d() {
        int i;
        ImageView imageView = this.c;
        if (this.f.isGif()) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    private void f() {
        if (this.f.isVideo()) {
            this.e.setVisibility(0);
            this.e.setText(DateUtils.formatElapsedTime(this.f.duration / 1000));
        } else {
            this.e.setVisibility(8);
        }
    }

    private void e() {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(this.f.getCompatUri());
        int i = this.g.a;
        ImageRequest build = newBuilderWithSource.setResizeOptions(new ResizeOptions(i, i)).build();
        if (this.f.isGif()) {
            this.a.setController(Fresco.newDraweeControllerBuilder().setOldController(this.a.getController()).setImageRequest(build).setAutoPlayAnimations(true).build());
        } else {
            this.a.setImageRequest(build);
        }
    }

    public void setOnMediaGridClickListener(a aVar) {
        this.h = aVar;
    }

    public void setCheckEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    public void setChecked(boolean z) {
        this.b.setChecked(z);
    }

    public void setCheckedNum(int i) {
        this.b.setCheckedNum(i);
    }

    public void a(Item item) {
        this.f = item;
        d();
        c();
        e();
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickAgent.onClick(view);
        a aVar = this.h;
        if (aVar != null) {
            SimpleDraweeView simpleDraweeView = this.a;
            if (view == simpleDraweeView) {
                aVar.Q(simpleDraweeView, this.f, this.g.d);
                return;
            }
            CheckView checkView = this.b;
            if (view == checkView || view == this.d) {
                aVar.r3(checkView, this.f, this.g.d);
            }
        }
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(2131039898, (ViewGroup) this, true);
        this.a = findViewById(2131829762);
        this.b = (CheckView) findViewById(2131823240);
        this.d = (ImageView) findViewById(2131823242);
        this.c = (ImageView) findViewById(2131826820);
        this.e = (TextView) findViewById(2131835694);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public MediaGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public static class b {
        int a;
        Drawable b;
        boolean c;
        RecyclerView.ViewHolder d;

        static {
            Covode.recordClassIndex(656155);
        }

        public b(int i, Drawable drawable, boolean z, RecyclerView.ViewHolder viewHolder) {
            this.a = i;
            this.b = drawable;
            this.c = z;
            this.d = viewHolder;
        }
    }
}
