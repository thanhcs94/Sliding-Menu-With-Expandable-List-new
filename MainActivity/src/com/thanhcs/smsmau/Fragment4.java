package com.thanhcs.smsmau;

import thanhcs.db.SMS2;
import thanhcs.db.SMSDB;

import com.thanhcs.smsmau.*;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment4 extends Fragment {
	private LinearLayout llMain;
	private TextView tvFragmentName;
	SMS2 sms2;
	SMSDB smsDB;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main, null);
		smsDB =  new SMSDB(getActivity().getApplicationContext());
		llMain = (LinearLayout) view.findViewById(R.id.llMain);
		smsDB.createDatabase();
		smsDB.open();
		tvFragmentName = (TextView) view.findViewById(R.id.tvFragmentName);
		sms2 =  smsDB.getSMSKute("chaobuoisang", 1);
		llMain.setBackgroundColor(Color.DKGRAY);
		tvFragmentName.setText(sms2.getNoidung());

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}
