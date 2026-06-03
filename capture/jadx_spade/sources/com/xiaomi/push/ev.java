package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ev {
    private XmlPullParser a;

    static {
        Covode.recordClassIndex(655507);
    }

    ev() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    fn a(byte[] bArr, ez ezVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return fv.a(this.a);
            }
            if (name.equals("iq")) {
                return fv.a(this.a, ezVar);
            }
            if (name.equals("presence")) {
                return fv.m444a(this.a);
            }
            if (!this.a.getName().equals("stream")) {
                if (!this.a.getName().equals("error")) {
                    if (this.a.getName().equals("warning")) {
                        this.a.next();
                        this.a.getName().equals("multi-login");
                        return null;
                    }
                    this.a.getName().equals("bind");
                    return null;
                }
                throw new fh(fv.m445a(this.a));
            }
            return null;
        }
        return null;
    }
}
