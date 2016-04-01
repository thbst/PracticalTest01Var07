package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;





public class PracticalTest01Var07MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Button navButton = null;
    private EditText nameText = null;
    private EditText groupText = null;
    private CheckBox nameCheck = null;
    private CheckBox groupCheck = null;
    final private static int ID = 99;
    private final String TAG = "EIM";
    private final String MY_ACTION = "ro.pub.cs.systems.eim.practicaltest01var07.intent.action.PracticalTest01Activity";



    private class HandleClick implements Button.OnClickListener {
        @Override
        public void onClick(View view) {

            navButton = (Button) findViewById(R.id.nav_button);
            String name = nameText.getText().toString();
            String group = groupText.getText().toString();

            switch (view.getId()) {
                case R.id.nav_button:
                    Log.d(TAG, "nav_button");
//                    final String THE_ACTION="ro.pub.cs.systems.eim.lab04.intent.action.PracticalTest01Activity";
//                    final String THE_CATEGORY="android.intent.category.DEFAULT";
                    Intent intent = new Intent();
                    intent.setAction(MY_ACTION);
//                    intent.addCategory(THE_CATEGORY);
                    intent.putExtra(MY_ACTION+".name", name);
                    intent.putExtra(MY_ACTION+".name", group);
                    try {
                        startActivityForResult(intent,ID);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        Log.d("TAG", "Secondary Activity not found");
                    }
                    break;
            }
        }
    }



//    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.name_check:
                if (nameText.isEnabled())
                    nameText.setEnabled(false);
                else
                    nameText.setEnabled(true);
                break;
            case R.id.group_check:
                if (groupText.isEnabled())
                    groupText.setEnabled(false);
                else
                    groupText.setEnabled(true);
                break;
        }

        if ((nameCheck.isChecked() == false) && (groupCheck.isChecked() == false)){

            Intent serviceIntent = new Intent();
            serviceIntent.setComponent(new ComponentName("ro.pub.cs.systems.eim.practicaltest01var07", "ro.pub.cs.systems.eim.practicaltest01var07.PracticalTest01Var07Service"));
            serviceIntent.putExtra("name", "name");
            serviceIntent.putExtra("group", "group");
            startService(serviceIntent);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);
        navButton = (Button) findViewById(R.id.nav_button);
        nameText = (EditText) findViewById(R.id.name_text);
        groupText = (EditText) findViewById(R.id.group_text);
        nameCheck = (CheckBox) findViewById(R.id.name_check);
        groupCheck = (CheckBox) findViewById(R.id.group_check);
        navButton.setOnClickListener(new HandleClick());
//        nameCheck.setOnClickListener(new onCheckedChanged(nameCheck,nameCheck.isChecked()));
//        nameCheck.setOnCheckedChangeListener(this,nameCheck.isChecked());


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("name", nameText.getText().toString());
        savedInstanceState.putString("second", groupText.getText().toString());
//        Log.d(TAG,"onSaved1 first=" + firstText.getText().toString() + "; second=" + secondText.getText().toString());
//        Log.d(Constants.TAG,"onSaved2 first=" + savedInstanceState.getString("first") + "; second=" + savedInstanceState.getString("second"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getString("name") != null) {
            nameText.setText(savedInstanceState.getString("name"));
        }
        if (savedInstanceState.getString("group") != null) {
            groupText.setText(savedInstanceState.getString("group"));
        }
//        Log.TAG,"onRestore first=" + savedInstanceState.getString("first") + "; second=" + savedInstanceState.getString("second"));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 99:
                if (resultCode == Activity.RESULT_OK) {
                    //Bundle data = intent.getExtras();
                    Toast.makeText(getApplicationContext(), "RESULT_OK", Toast.LENGTH_LONG).show();
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(getApplicationContext(), "RESULT_CANCELED", Toast.LENGTH_LONG).show();

                }
                break;

            // process other request codes
        }

    }

}
