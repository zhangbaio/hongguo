package com.dragon.read.component.shortvideo.api.model;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesTransition implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private int targetViewId = -1;
    private int animViewId = -1;

    public static final class a {
        static {
            Covode.recordClassIndex(598797);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598796);
        Companion = new a(null);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public final int getAnimViewId() {
        return this.animViewId;
    }

    public final int getTargetViewId() {
        return this.targetViewId;
    }

    public final void setAnimViewId(int i) {
        this.animViewId = i;
    }

    public final void setTargetViewId(int i) {
        this.targetViewId = i;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        Map map;
        Map map2;
        if (transitionValues != null && (map2 = transitionValues.values) != null) {
            map2.put("series_transition: width", 100);
        }
        if (transitionValues != null && (map = transitionValues.values) != null) {
            map.put("series_transition: height", 100);
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        Map map;
        Map map2;
        if (transitionValues != null && (map2 = transitionValues.values) != null) {
            map2.put("series_transition: width", 10);
        }
        if (transitionValues != null && (map = transitionValues.values) != null) {
            map.put("series_transition: height", 10);
        }
    }
}
