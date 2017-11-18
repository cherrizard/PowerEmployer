package um.facehack.poweremployer;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SendNotificationStudentReceiver extends BroadcastReceiver {

    private final String TAG = "SendNotificationStudentReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Long studentId = intent.getLongExtra("studentId", -1L);
        Long companyId = CurrentUser.getInstance().getUser().getId();

        NetworkRequest.getInstance().accept(studentId, companyId);

        int notificationCode = intent.getIntExtra("notificationCode",-1);
        NotificationManager notiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notiManager.cancel(notificationCode);
    }
}
