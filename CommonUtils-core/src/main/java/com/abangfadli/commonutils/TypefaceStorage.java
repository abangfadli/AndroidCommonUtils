package com.abangfadli.commonutils;

/**
 * Created by ahmadfadli on 8/15/16.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

/**
 * Created by ahmadfadli on 6/26/16.
 * Storage for saving instantated TypeFace to avoid leak memory
 */
public class TypefaceStorage {
    private static final String TAG = "TypefaceStorage";

    private static final Hashtable<String, Typeface> mCache = new Hashtable<>();

    public static Typeface get(Context c, String assetPath) {
        synchronized (mCache) {
            if (!mCache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), assetPath);
                    mCache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Error getting typeface '" + assetPath + "' - " + e.getMessage());
                    return null;
                }
            }
            return mCache.get(assetPath);
        }
    }
}