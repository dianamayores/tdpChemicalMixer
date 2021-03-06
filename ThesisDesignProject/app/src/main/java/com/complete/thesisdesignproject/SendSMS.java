package com.complete.thesisdesignproject;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SendSMS extends Activity {

    private Spinner speeds;
    private Spinner timeHours;
    private Spinner timeMinutes;
    private Spinner timeSeconds;
    private Spinner temperatures;
    private Button editButton;
    private Button submitBtn;
    private Button pauseButton;
    private Button closeButton;
    private String phoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        phoneNumber = "09352909064";
        speeds = (Spinner) findViewById(R.id.speeds);
        timeHours = (Spinner) findViewById(R.id.timeHours);
        timeMinutes = (Spinner) findViewById(R.id.timeMinutes);
        timeSeconds = (Spinner) findViewById(R.id.timeSeconds);
        temperatures = (Spinner) findViewById(R.id.temperatures);
        submitBtn = (Button) findViewById(R.id.button);
        pauseButton = (Button) findViewById(R.id.pauseBtn);
        closeButton = (Button) findViewById(R.id.exitBtn);
        editButton = (Button) findViewById(R.id.editBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSmsByManager();}
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendPause();}
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendClose();}
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEdit();}
        });
    }

    public void sendSmsByManager() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.toString(),
                    null,
                            "START PROCESS"+ System.getProperty("line.separator")+
                            String.valueOf(speeds.getSelectedItem()) + " RPM"+ System.getProperty ("line.separator")+
                            String.valueOf(timeHours.getSelectedItem())+ " hour/s"+ System.getProperty ("line.separator")+
                            String.valueOf(timeMinutes.getSelectedItem())+ " minute/s"+ System.getProperty ("line.separator")+
                            String.valueOf(timeSeconds.getSelectedItem())+ " second/s"+ System.getProperty ("line.separator")+
                            String.valueOf(temperatures.getSelectedItem())+" degree celsius",
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "Your settings are successfully sent to the device!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your transaction has failed. Sorry",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    public void sendPause() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.toString(),
                    null,
                    "PAUSE PROCESS",
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "Your transaction is now on pause",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your transaction has failed. Sorry",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    public void sendClose() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.toString(),
                    null,
                    "STOP PROCESS",
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "Your settings are successfully sent to the device!",
                    Toast.LENGTH_LONG).show();
            //sendSmsByManager.close();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your transaction has failed. Sorry",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
    public void sendEdit() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.toString(),
                    null,
                    "EDIT PROCESS",
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "You may now edit your current transaction.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your transaction has failed. Sorry",
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
