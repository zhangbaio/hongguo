package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cn {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f204a;

    /* renamed from: a, reason: collision with other field name */
    private String f205a;
    private int b;

    /* renamed from: b, reason: collision with other field name */
    private long f206b;

    /* renamed from: b, reason: collision with other field name */
    private String f207b;
    private int c;

    /* renamed from: c, reason: collision with other field name */
    private long f208c;
    private int d;

    /* renamed from: d, reason: collision with other field name */
    private long f209d;
    private int e;
    private int f;
    private int g;

    static {
        Covode.recordClassIndex(655419);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m247a() {
        return this.f204a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m249b() {
        return this.f206b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m251c() {
        return this.f208c;
    }

    /* renamed from: d, reason: collision with other method in class */
    public long m252d() {
        return this.f209d;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m248a() {
        return this.f205a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m250b() {
        return this.f207b;
    }

    public String toString() {
        return "DisconnectStatsModel{count=" + this.a + ", host='" + this.f205a + "', netState=" + this.b + ", reason=" + this.c + ", pingInterval=" + this.f204a + ", netType=" + this.d + ", wifiDigest='" + this.f207b + "', connectedNetType=" + this.e + ", duration=" + this.f206b + ", disconnectionTime=" + this.f208c + ", reconnectionTime=" + this.f209d + ", xmsfVc=" + this.f + ", androidVc=" + this.g + '}';
    }

    public void e(int i) {
        this.e = i;
    }

    public void f(int i) {
        this.f = i;
    }

    public void g(int i) {
        this.g = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(long j) {
        this.f208c = j;
    }

    public void d(long j) {
        this.f209d = j;
    }

    public void a(long j) {
        this.f204a = j;
    }

    public void b(long j) {
        this.f206b = j;
    }

    public void a(String str) {
        this.f205a = str;
    }

    public void b(String str) {
        this.f207b = str;
    }
}
