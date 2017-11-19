package um.facehack.poweremployer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;
import java.util.Map;

public class AppFirebaseMessagingService extends FirebaseMessagingService {

    static int code = 1;

    private final String TAG = "AppFirebaseMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "Message Received");
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.power_employer)
                        .setContentTitle(remoteMessage.getNotification().getTitle())
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getNotification().getBody()))
                        .setContentText(remoteMessage.getNotification().getBody());

        if (CurrentUser.getInstance().getUser() instanceof Company) {
            Map<String, String> data = remoteMessage.getData();

            String id = data.get("id");
            String name = data.get("name");
            int age = Integer.parseInt(data.get("age"));
            Boolean gender = Boolean.getBoolean(data.get("gender"));
            String skills = data.get("skills");

            mBuilder.setOngoing(true);
            Intent noIntent = new Intent(getApplicationContext(), DismissNotificationReceiver.class);
            noIntent.putExtra("notificationCode", code);
            PendingIntent noPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, noIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Intent yesIntent = new Intent(getApplicationContext(), SendNotificationStudentReceiver.class);
            yesIntent.putExtra("name", name);
            yesIntent.putExtra("notificationCode", code);
            PendingIntent yesPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, yesIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.addAction(R.mipmap.ic_launcher_round, getString(android.R.string.yes), yesPendingIntent);
            mBuilder.addAction(R.mipmap.ic_launcher_round, getString(android.R.string.no), noPendingIntent);

            Log.d(TAG, name);

        } else {
            Map<String, String> data = remoteMessage.getData();
            String name = data.get("name");
            String address = data.get("address");
            String email = data.get("email");

            StudentCompanyModel scmodel = new StudentCompanyModel();
            scmodel.setCompanyAddress(address);
            scmodel.setCompanyEmail(email);
            scmodel.setCompanyName(name);

            AppDatabase.getAppDatabase(getApplicationContext()).SCDAO().insertAll(scmodel);

            Log.d(TAG, data.toString());
        }

        NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notiManager.notify(code, mBuilder.build());
        ++code;
    }
}
