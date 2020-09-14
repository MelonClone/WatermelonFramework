package org.watermelon.framework.global.model.application;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Initializer {
    static Map<String, Initializable> initializableList = new HashMap<>();

    public static void addInitiator(Initializable initiator) {
        if (!initializableList.containsKey(initiator.getTag())) {
            initializableList.put(initiator.getTag(), initiator);
        }
    }

    public static void init(Context appContext) {
        for (String tag : initializableList.keySet()) {
            try {
                Objects.requireNonNull(initializableList.get(tag)).init(appContext);
            } catch (NullPointerException e) {
            }
        }
    }

    public static boolean isInit(String tag) {
        try {
            return Objects.requireNonNull(initializableList.get(tag)).isInit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean isInit(Initializable initiator) {
        try {
            return Objects.requireNonNull(initializableList.get(initiator.getTag())).isInit();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static Initializable getInitiator(String tag) {
        return initializableList.get(tag);
    }
}
