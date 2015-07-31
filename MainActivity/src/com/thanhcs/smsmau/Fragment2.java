
package com.thanhcs.smsmau;

import java.util.ArrayList;

import thanhcs.adapter.BookAdapter;
import thanhcs.db.DacNhanTamDB;
import thanhcs.db.SMS1;

import com.thanhcs.smsmau.*;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment2 extends Fragment {

	private LinearLayout llMain;
	private TextView tvFragmentName;
	DacNhanTamDB mDB;
	ArrayList<SMS1> arrSMS;
	BookAdapter adapter;
	ListView lvSMS;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_sms, null);
		mDB  = new DacNhanTamDB(getActivity().getApplicationContext());
		mDB.createDatabase();
		mDB.open();
		
		lvSMS = (ListView)view.findViewById(R.id.lvsms);
		arrSMS = new ArrayList<SMS1>();
		for(int i = 1 ; i <=85;i++)
		{
			SMS1 a = new SMS1();
			a =  mDB.getNewYear(i);
			arrSMS.add(a);
		}
		
		adapter  = new BookAdapter(getActivity().getApplicationContext(), R.layout.item_sms, arrSMS);
		lvSMS.setAdapter(adapter);
	
		lvSMS.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		lvSMS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				 Intent share = new Intent(Intent.ACTION_SEND);
		            share.setType("text/plain");
		            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
		            // Add data to the intent, the receiving app will decide
		            // what to do with it.
		            share.putExtra(Intent.EXTRA_SUBJECT,"Best wishes to you");
		            share.putExtra(Intent.EXTRA_TEXT,arrSMS.get(position).get_text());
		           getActivity().startActivity(Intent.createChooser(share, "Share SMS!"));
				return false;
			}
			
			
		});
		
		
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}












