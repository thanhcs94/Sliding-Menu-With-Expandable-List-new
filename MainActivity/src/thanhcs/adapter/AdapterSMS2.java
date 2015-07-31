package thanhcs.adapter;

import java.util.ArrayList;

import thanhcs.db.DacNhanTamDB;
import thanhcs.db.SMS1;
import thanhcs.db.SMS2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanhcs.smsmau.R;

public class AdapterSMS2 extends ArrayAdapter<SMS2> {

	TextView tvsms;
	ArrayList<SMS2> arrSMS;
	Context context;
	DacNhanTamDB mDB;
	ImageView share;
	public LayoutInflater inflater;
	public AdapterSMS2(Context context, int resource, ArrayList<SMS2>arrSMS) {
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

		tvsms.setText(arrSMS.get(position).getNoidung());

		return view;
	}

}

