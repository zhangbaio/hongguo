package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final p a;
    private static final com.dragon.read.kmp.i b;
    private static final com.dragon.read.kmp.i c;
    private static final com.dragon.read.kmp.i d;
    private static final com.dragon.read.kmp.i e;
    private static final com.dragon.read.kmp.i f;
    private static final com.dragon.read.kmp.i g;
    public static final int h;

    private p() {
    }

    public static final com.dragon.read.kmp.i f() {
        return b;
    }

    public static final com.dragon.read.kmp.i g() {
        return f;
    }

    public static final com.dragon.read.kmp.i h() {
        return g;
    }

    public static final com.dragon.read.kmp.i i() {
        return e;
    }

    public static final com.dragon.read.kmp.i j() {
        return d;
    }

    public static final com.dragon.read.kmp.i k() {
        return c;
    }

    static {
        Covode.recordClassIndex(608662);
        a = new p();
        b = new com.dragon.read.kmp.i(m("BookMark"));
        c = new com.dragon.read.kmp.i(m("Underline"));
        d = new com.dragon.read.kmp.i(m("Note"));
        e = new com.dragon.read.kmp.i("NoteCenter");
        f = new com.dragon.read.kmp.i(d("Font"));
        g = new com.dragon.read.kmp.i("Menu");
        int i = com.dragon.read.kmp.i.b;
        h = i | i | i | i | i | i;
    }

    public static final String a(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Assistant");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String b(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Bookend");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String c(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Chapter");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String d(String... suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        String str = "Reader";
        for (String str2 : suffix) {
            str = str + '-' + str2;
        }
        return str;
    }

    public static final String e(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Database");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String l(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Menu");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String m(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Note");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String n(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Progress");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String o(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Property");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String p(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("Strategy");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public static final String q(String... tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add("View");
        spreadBuilder.addSpread(tag);
        return d((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }
}
