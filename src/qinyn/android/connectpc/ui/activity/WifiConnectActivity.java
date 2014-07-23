package qinyn.android.connectpc.ui.activity;

import java.io.DataOutputStream;
import java.io.IOException;

import qinyn.android.connectpc.R;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import custom.utils.NetUtil;
import custom.utils.SharedPreferenceUtils;

/**
 * @author evan.qin
 * 
 */
public class WifiConnectActivity extends BaseFragmentActivity {

	private String pName;
	private String key;
	private boolean defaultValue = false;
	private EditText edt_port;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_wifi;
	}

	@Override
	protected void onContentView() {
		TextView tv = (TextView) findViewById(R.id.tv_ip);
		String s = NetUtil.getLocalHostIp();
		tv.setText("当前手机ip为： " + s);

		edt_port = (EditText) findViewById(R.id.edt_port);
		ToggleButton tgb_connect = (ToggleButton) findViewById(R.id.tgb_connect);
		tgb_connect.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				init(isChecked);
			}
		});

		boolean isOn = SharedPreferenceUtils.getPreference(pName, key,
				defaultValue);
		tgb_connect.setChecked(isOn);
		init(tgb_connect.isChecked());

	}

	private void init(boolean isOn) {
		if (isOn) {
			String s = edt_port.getText().toString();
			if (TextUtils.isEmpty(s)) {
				s = "5554";
			}
			start(s);
		} else {
			stop();
		}
	}

	private void start(String port) {
		Process localProcess;
		try {
			localProcess = Runtime.getRuntime().exec("su");
			DataOutputStream localDataOutputStream = new DataOutputStream(
					localProcess.getOutputStream());
			localDataOutputStream.writeBytes("setprop service.adb.tcp.port "
					+ port + "\n");
			localDataOutputStream.writeBytes("stop adbd" + "\n");
			localDataOutputStream.writeBytes("start adbd" + "\n");
			localDataOutputStream.flush();
			localDataOutputStream.close();
			localProcess.waitFor();
			localProcess.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void stop() {
		Process localProcess;
		try {
			localProcess = Runtime.getRuntime().exec("su");
			DataOutputStream localDataOutputStream = new DataOutputStream(
					localProcess.getOutputStream());
			localDataOutputStream.writeBytes("stop adbd" + "\n");
			localDataOutputStream.flush();
			localDataOutputStream.close();
			localProcess.waitFor();
			localProcess.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
