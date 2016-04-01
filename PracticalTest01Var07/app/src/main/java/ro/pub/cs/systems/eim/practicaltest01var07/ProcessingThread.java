package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private Context context;
    private String name;
    private String group;

    public ProcessingThread(Context context, String name, String group) {
        this.context = context;
        this.name = name;
        this.group = group;
    }

    @Override
    public void run() {
//        Log.d(Constants.TAG, "Thread.run() was invoked, PID:" + android.os.Process.myPid() + " TID:" + android.os.Process.myTid());
//        Random randomGenerator = new Random();
//        while (true) {
//            int randomInt = randomGenerator.nextInt(3);
//            switch (randomInt) {
//                case 0:
                    sendMessage(1);
//                    break;
//                case 1:
//                    sendMessage(Constants.MESSAGE_STRING2);
//                    break;
//                case 2:
//                    sendMessage(Constants.MESSAGE_STRING3);
//                    break;
//            }
            sleep();
//        }
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        Date date = new Date();
//        switch(messageType) {
//            case Constants.MESSAGE_STRING1:
//                intent.setAction(Constants.ACTION_STRING1);
//                intent.putExtra(Constants.DATA, "1) "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                Log.d(Constants.TAG,"Sending Action"+Constants.MESSAGE_STRING1+" : "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                break;
//            case Constants.MESSAGE_STRING2:
//                intent.setAction(Constants.ACTION_STRING2);
//                intent.putExtra(Constants.DATA, "2) "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                Log.d(Constants.TAG,"Sending Action"+Constants.MESSAGE_STRING2+" : "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                break;
//            case Constants.MESSAGE_STRING3:
//                intent.setAction(Constants.ACTION_STRING3);
//                intent.putExtra(Constants.DATA, "3) "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                Log.d(Constants.TAG,"Sending Action"+Constants.MESSAGE_STRING3+" : "+date.toString()+" ;count1="+this.aritm+";count2="+this.geom);
//                break;
//        }
        context.sendBroadcast(intent);
    }

}
