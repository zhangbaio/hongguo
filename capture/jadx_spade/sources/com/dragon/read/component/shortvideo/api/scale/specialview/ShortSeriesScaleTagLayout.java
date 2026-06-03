package com.dragon.read.component.shortvideo.api.scale.specialview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.scale.ShortSeriesScaleTextView;
import com.dragon.read.widget.tag.TagLayout;
import java.util.Queue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesScaleTagLayout extends TagLayout {
    static {
        Covode.recordClassIndex(598846);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleTagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public TextView createTagTextView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ShortSeriesScaleTextView(context, null, 0, 6, null);
    }

    public TextView createTagTextView(Context context, Queue<TextView> queue) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (queue != null && !queue.isEmpty()) {
            TextView poll = queue.poll();
            Intrinsics.checkNotNullExpressionValue(poll, "poll(...)");
            return poll;
        }
        return new ShortSeriesScaleTextView(context, null, 0, 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleTagLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        disableScale();
    }

    public /* synthetic */ ShortSeriesScaleTagLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
