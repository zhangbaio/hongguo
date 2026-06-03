package com.dragon.read.kmp.reader.services;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.kmp.reader.font.manager.KmpFontDownloaderImpl;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v implements g {
    public static final v a;

    static {
        Covode.recordClassIndex(608553);
        a = new v();
    }

    private v() {
    }

    @Override // com.dragon.read.kmp.reader.services.f
    public com.dragon.read.kmp.reader.font.manager.h Z7() {
        return com.dragon.read.kmp.reader.font.manager.j.a;
    }

    @Override // com.dragon.read.kmp.reader.services.f
    public com.dragon.read.kmp.reader.font.manager.i n4() {
        return KmpFontDownloaderImpl.a;
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public boolean f7() {
        return o45.e.l();
    }

    @Override // com.dragon.read.kmp.reader.services.f
    public List<String> t7() {
        return o45.e.a.p();
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public Typeface e0(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return F0(new PolarisFileWrapper(path));
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public boolean e8(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return o45.e.s((NsReaderActivity) context);
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    public static Typeface F0(File file) {
        String path;
        if (TypeFaceOptimizer.getSwitch() && (path = file.getPath()) != null) {
            if (TypeFaceLancet.cache.contains(path)) {
                return (Typeface) TypeFaceLancet.cache.get(path);
            }
            Typeface createFromFile = Typeface.createFromFile(file);
            if (createFromFile != null) {
                TypeFaceLancet.cache.put(path, createFromFile);
                return createFromFile;
            }
        }
        return Typeface.createFromFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public void G6(String fileName, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(action, "action");
        com.dragon.read.reader.newfont.c.a.c(fileName, action);
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public boolean k3(String fontName, String file) {
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        Intrinsics.checkNotNullParameter(file, "file");
        return com.dragon.read.reader.newfont.c.a.f(fontName, new PolarisFileWrapper(file));
    }

    @Override // com.dragon.read.kmp.reader.services.g
    public void g2(Context platformContext, boolean z, final Function1<? super Boolean, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(platformContext, "platformContext");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        o45.e.A(platformContext, z, new Function1() { // from class: com.dragon.read.kmp.reader.services.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s1;
                s1 = v.s1(Function1.this, ((Boolean) obj).booleanValue());
                return s1;
            }
        });
    }
}
