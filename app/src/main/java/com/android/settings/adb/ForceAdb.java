package com.android.settings.adb;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class ForceAdb extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    finishAndRemoveTask();
    String msg = "";
    try {
        Settings.Global.putInt(getContentResolver(), "adb_enabled", 1);
        msg = "ADB is enabled.";
    } catch (SecurityException ignored) {
        msg = "SecurityException occurred.";
    } catch (Exception e) {
        msg = e.getMessage();
    } finally {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
  }

}
