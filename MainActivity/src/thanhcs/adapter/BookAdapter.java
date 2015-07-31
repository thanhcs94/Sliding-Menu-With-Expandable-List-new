package thanhcs.adapter;

import java.util.ArrayList;

import thanhcs.db.DacNhanTamDB;
import thanhcs.db.SMS1;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.thanhcs.smsmau.*;
public class BookAdapter extends ArrayAdapter<SMS1> {

	TextView tvsms;
	ArrayList<SMS1> arrSMS;
	Context context;
	DacNhanTamDB mDB;
	ImageView share;
	public LayoutInflater inflater;
	public BookAdapter(Context context, int resource, ArrayList<SMS1>arrSMS) {
		super(context, resource , arrSMS);
		this.arrSMS = arrSMS;
		this.context = context;
		
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		LayoutInflater inf=(LayoutInflater)
				getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view=inf.inflate(R.layout.item_sms,parent, false);
		tvsms = (TextView)view.findViewById(R.id.tvsms);
		mDB = new DacNhanTamDB(getContext().getApplicationContext());
		mDB.createDatabase();
		mDB.open();
		
		tvsms.setText(arrSMS.get(position).get_text());
		
		return view;
	}

}
