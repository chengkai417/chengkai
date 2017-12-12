package com.example.szuwifi;

import java.util.List;
import java.util.TreeMap;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
    private TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
	private WifiManager wifiManager=null;
	private List<ScanResult> wifiList;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView)findViewById(R.id.tv);
		
		wifiManager=(WifiManager)this.getSystemService(WIFI_SERVICE);
		wifiManager.setWifiEnabled(true);
		
		
	}
 
	
	
	public void onClick1(View view) {
		wifiManager.startScan();
		wifiList = wifiManager.getScanResults();
		if(wifiList != null){
			tv.setText("");
			for(int i = 0;i < wifiList.size();i++){
				String ssid = wifiList.get(i).SSID;
				if (ssid.equalsIgnoreCase("SZU_WLAN")) {
					//treeMap.put(wifiList.get(i).BSSID, wifiList.get(i).level);
					//tv.setText(ssid+"\t"+wifiList.get(i).BSSID+"\t"+"\t"+wifiList.get(i).level+"\t"+"\r");
					
				    tv.append(ssid+"\t"+wifiList.get(i).BSSID+"\t"+"\t"+wifiList.get(i).level+"\n");				
				}
				/*tv.setText(treeMap.toString());
				treeMap.clear();*/
			}
		}
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id==R.id.action_exit) {
			finish();
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
}
