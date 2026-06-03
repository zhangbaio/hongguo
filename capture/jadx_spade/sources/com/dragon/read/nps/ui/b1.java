package com.dragon.read.nps.ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.scale.AppScaleUtils;
import com.dragon.read.rpc.model.OptionInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int i;
    private final a d;
    public OptionInfo e;
    public boolean f;
    public boolean g;
    public float h;

    public interface a {
        void a(boolean z, String str);

        void b(String str);

        boolean c(String str);

        int getTheme();
    }

    static {
        Covode.recordClassIndex(612583);
        i = 8;
    }

    public a F3() {
        return this.d;
    }

    public final float G3() {
        if (this.g) {
            return AppScaleUtils.calcScaleSize(this.h);
        }
        return this.h;
    }

    public int getItemCount() {
        String str;
        List list;
        List list2;
        OptionInfo optionInfo = this.e;
        if (optionInfo != null) {
            str = optionInfo.optionNameWithInput;
        } else {
            str = null;
        }
        int i2 = 0;
        if (str != null && !h.a.d() && !NpsPopMemoryCache.a.c()) {
            OptionInfo optionInfo2 = this.e;
            if (optionInfo2 != null && (list2 = optionInfo2.optionsName) != null) {
                i2 = list2.size();
            }
            return i2 + 1;
        }
        OptionInfo optionInfo3 = this.e;
        if (optionInfo3 == null || (list = optionInfo3.optionsName) == null) {
            return 0;
        }
        return list.size();
    }

    public static final class b extends RecyclerView.ViewHolder {
        public static final int e;
        public final g d;

        static {
            Covode.recordClassIndex(612585);
            e = 8;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(g item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            this.d = item;
        }

        public final void w2(String text, boolean z, float f, boolean z2, a aVar) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.d.setText(text);
            this.d.setEditable(z2);
            this.d.setListener(aVar);
            this.d.setSelect(z);
            this.d.setTextSize(f);
        }
    }

    public b1(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
        this.h = 14.0f;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.f) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return new b(new d(context, null));
        }
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        return new b(new e(context2, null));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i2) {
        String str;
        List list;
        String str2;
        List list2;
        String str3;
        String str4;
        String str5;
        String str6;
        List list3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        OptionInfo optionInfo = this.e;
        boolean z = false;
        if (optionInfo != null && (list3 = optionInfo.optionsName) != null && i2 == list3.size()) {
            z = true;
        }
        String str7 = "";
        if (z) {
            b bVar = (b) holder;
            OptionInfo optionInfo2 = this.e;
            if (optionInfo2 == null || (str6 = optionInfo2.optionNameWithInput) == null) {
                str4 = "";
            } else {
                str4 = str6;
            }
            a F3 = F3();
            OptionInfo optionInfo3 = this.e;
            if (optionInfo3 != null && (str5 = optionInfo3.optionNameWithInput) != null) {
                str7 = str5;
            }
            bVar.w2(str4, F3.c(str7), G3(), true, F3());
            return;
        }
        b bVar2 = (b) holder;
        OptionInfo optionInfo4 = this.e;
        if (optionInfo4 == null || (list2 = optionInfo4.optionsName) == null || (str3 = (String) list2.get(i2)) == null) {
            str = "";
        } else {
            str = str3;
        }
        a F32 = F3();
        OptionInfo optionInfo5 = this.e;
        if (optionInfo5 != null && (list = optionInfo5.optionsName) != null && (str2 = (String) list.get(i2)) != null) {
            str7 = str2;
        }
        bVar2.w2(str, F32.c(str7), G3(), false, F3());
    }
}
