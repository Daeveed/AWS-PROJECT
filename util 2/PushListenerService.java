package com.minpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import com.amazonaws.mobileconnectors.pinpoint.targeting.notification.NotificationClient;
import com.amazonaws.mobile.AWSMobileClient;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * A service that listens to GCM notifications.
 */
public class PushListenerService extends GcmListenerService {

    private static final String LOG_TAG = PushListenerService.class.getSimpleName();

    // Intent action used in local broadcast
    public static final String ACTION_SNS_NOTIFICATION = "sns-notification";
    // Intent keys
    public static final String INTENT_SNS_NOTIFICATION_FROM = "from";
    public static final String INTENT_SNS_NOTIFICATION_DATA = "data";

    /**
     * Helper method to extract SNS message from bundle.
     *
     * @param data bundle
     * @return message string from SNS push notification
     */
    public static String getMessage(Bundle data) {
        // If a push notification is sent as plain text, then the message appears in "default".
        // Otherwise it's in the "message" for JSON format.
        return data.containsKey("default") ? data.getString("default") : data.getString(
            "message", "");
    }

    private void broadcast(final String from, final Bundle data) {
        Intent intent = new Intent(ACTION_SNS_NOTIFICATION);
        intent.putExtra(INTENT_SNS_NOTIFICATION_FROM, from);
        intent.putExtra(INTENT_SNS_NOTIFICATION_DATA, data);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs. For Set of keys use
     * data.keySet().
     */
    @Override
    public void onMessageReceived(final String from, final Bundle data) {
        AWSMobileClient.initializeMobileClientIfNecessary(this.getApplicationContext());
        final NotificationClient notificationClient = AWSMobileClient.defaultMobileClient()
            .getPinpointManager().getNotificationClient();

        NotificationClient.CampaignPushResult pushResult =
            notificationClient.handleGCMCampaignPush(from, data, this.getClass());

        if (!NotificationClient.CampaignPushResult.NOT_HANDLED.equals(pushResult)) {
            // The push message was due to a Dartboard campaign.
            // If the app was in the background, a local notification was added in the notification center.
            // If the app was in the foreground, an event was recorded indicating the app was in the foreground,
            // for the demo, we will broadcast the notification to let the main activity display it in a dialog.
            if (NotificationClient.CampaignPushResult.APP_IN_FOREGROUND.equals(pushResult)) {
                // Create a message that will display the raw data of the campaign push in a dialog.
                data.putString("message", String.format("Received Campaign Push:\n%s", data.toString()));
                broadcast(from, data);
            }
            return;
        }

    }
}
