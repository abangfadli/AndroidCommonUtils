package com.abangfadli.commonutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * Created by ahmadfadli on 5/4/16.
 */
public class IntentUtil {

    private static final String INTENT_DATA_DIALER_PREFIX = "tel:";

    public static void telephone(Context context, String phone) {
        phone = sanitizePhoneNumber(phone);

        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(INTENT_DATA_DIALER_PREFIX + phone));
        context.startActivity(dialIntent);
    }

    /** this will remove all char except (0-9 and +) then return the sanitized version
     */
    private static String sanitizePhoneNumber(String number){
        String r = number;
        r = r.replaceAll("[^0-9+]", "");
        return r;
    }

    public static void url(Context context, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static void email(Context context, String emailAddress) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", emailAddress, null));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        context.startActivity(Intent.createChooser(emailIntent, "Email"));

    }

    public static boolean canResolveIntent(Context context, Intent intent) {
        List<ResolveInfo> resolveInfo = context.getPackageManager().queryIntentActivities(intent, 0);
        return resolveInfo != null && !resolveInfo.isEmpty();
    }
}
