package com.xiaomi.push.service;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.fk;
import com.xiaomi.push.ft;
import com.xiaomi.push.fu;
import com.xiaomi.push.fw;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i implements ft {
    static {
        Covode.recordClassIndex(655717);
    }

    public void a() {
        fu.a().a("all", "xm:chat", this);
    }

    public fk b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }

    public static fk a(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = fw.b(xmlPullParser.getAttributeValue(i));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next != 3) {
                if (next == 4) {
                    str = xmlPullParser.getText().trim();
                } else if (next == 2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    fk a = a(xmlPullParser);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                return new fk(name, namespace, strArr, strArr2, str, arrayList);
            }
        }
    }
}
