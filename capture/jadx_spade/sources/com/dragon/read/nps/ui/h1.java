package com.dragon.read.nps.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.nps.INpsViewProxy;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.rpc.model.UserResearchData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h1 extends ConstraintLayout implements INpsViewProxy {
    public static final int l;
    private INpsViewProxy.IOnSelectChanged g;
    private int h;
    private boolean i;
    private boolean j;
    private final NpsEmojiView[] k;

    static {
        Covode.recordClassIndex(612587);
        l = 8;
    }

    private final void V1() {
        S1();
    }

    public final int getCurrentIndex() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S1() {
        NpsEmojiView[] npsEmojiViewArr = this.k;
        int i = 0;
        npsEmojiViewArr[0] = 0;
        npsEmojiViewArr[1] = findViewById(2131825597);
        this.k[2] = findViewById(2131826300);
        this.k[3] = findViewById(2131831700);
        NpsEmojiView[] npsEmojiViewArr2 = this.k;
        npsEmojiViewArr2[4] = null;
        int length = npsEmojiViewArr2.length;
        final int i2 = 0;
        while (i < length) {
            final NpsEmojiView npsEmojiView = npsEmojiViewArr2[i];
            int i3 = i2 + 1;
            if (npsEmojiView != null) {
                npsEmojiView.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        h1.T1(h1.this, i2, npsEmojiView, view);
                    }
                });
            }
            i++;
            i2 = i3;
        }
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setClickSelectUIChangeEnable(boolean z) {
        this.i = z;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setTouchEnable(boolean z) {
        this.j = z;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setOnSelectChangedListener(INpsViewProxy.IOnSelectChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = listener;
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void updateData(UserResearchData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        setRemarks(data.scoreRemarks);
    }

    private final void W1(int i) {
        NpsEmojiView[] npsEmojiViewArr = this.k;
        int length = npsEmojiViewArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            NpsEmojiView npsEmojiView = npsEmojiViewArr[i2];
            int i4 = i3 + 1;
            if (i3 != i && npsEmojiView != null) {
                npsEmojiView.d();
            }
            i2++;
            i3 = i4;
        }
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void setCurrentIndex(int i) {
        if (i >= 0 && i <= 4 && !this.i) {
            W1(i);
            NpsEmojiView npsEmojiView = this.k[i];
            if (npsEmojiView != null) {
                npsEmojiView.c(true);
            }
            this.h = i;
        }
    }

    @Override // com.dragon.read.nps.INpsViewProxy
    public void updateTheme(int i) {
        for (NpsEmojiView npsEmojiView : this.k) {
            if (npsEmojiView != null) {
                npsEmojiView.e(i);
            }
        }
    }

    private final void setRemarks(Map<String, String> map) {
        if (map == null) {
            return;
        }
        NpsEmojiView[] npsEmojiViewArr = this.k;
        NpsPopMemoryCache.ResultKey resultKey = NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied;
        NpsEmojiView npsEmojiView = npsEmojiViewArr[resultKey.getNumber() - 1];
        if (npsEmojiView != null) {
            npsEmojiView.setText(map.get(String.valueOf(resultKey.getNumber())));
        }
        NpsEmojiView[] npsEmojiViewArr2 = this.k;
        NpsPopMemoryCache.ResultKey resultKey2 = NpsPopMemoryCache.ResultKey.enum_dissatisfied;
        NpsEmojiView npsEmojiView2 = npsEmojiViewArr2[resultKey2.getNumber() - 1];
        if (npsEmojiView2 != null) {
            npsEmojiView2.setText(map.get(String.valueOf(resultKey2.getNumber())));
        }
        NpsEmojiView[] npsEmojiViewArr3 = this.k;
        NpsPopMemoryCache.ResultKey resultKey3 = NpsPopMemoryCache.ResultKey.enum_average;
        NpsEmojiView npsEmojiView3 = npsEmojiViewArr3[resultKey3.getNumber() - 1];
        if (npsEmojiView3 != null) {
            npsEmojiView3.setText(map.get(String.valueOf(resultKey3.getNumber())));
        }
        NpsEmojiView[] npsEmojiViewArr4 = this.k;
        NpsPopMemoryCache.ResultKey resultKey4 = NpsPopMemoryCache.ResultKey.enum_satisfied;
        NpsEmojiView npsEmojiView4 = npsEmojiViewArr4[resultKey4.getNumber() - 1];
        if (npsEmojiView4 != null) {
            npsEmojiView4.setText(map.get(String.valueOf(resultKey4.getNumber())));
        }
        NpsEmojiView[] npsEmojiViewArr5 = this.k;
        NpsPopMemoryCache.ResultKey resultKey5 = NpsPopMemoryCache.ResultKey.enum_extremely_satisfied;
        NpsEmojiView npsEmojiView5 = npsEmojiViewArr5[resultKey5.getNumber() - 1];
        if (npsEmojiView5 != null) {
            npsEmojiView5.setText(map.get(String.valueOf(resultKey5.getNumber())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = true;
        this.j = true;
        this.k = new NpsEmojiView[5];
        ViewGroup.inflate(context, 2131039604, this);
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(h1 h1Var, int i, NpsEmojiView npsEmojiView, View view) {
        if (!h1Var.j) {
            return;
        }
        if (h1Var.i) {
            h1Var.W1(i);
            npsEmojiView.c(true);
            h1Var.h = i;
        }
        INpsViewProxy.IOnSelectChanged iOnSelectChanged = h1Var.g;
        if (iOnSelectChanged != null) {
            iOnSelectChanged.onChanged(i + 1);
        }
    }
}
