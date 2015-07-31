package thanhcs.db;

import java.io.IOException; 
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.util.Log; 
//Class chÃƒÂ­nh thao tac1 vÃ¡Â»â€ºi dÃ¡Â»Â¯ liÃ¡Â»â€¡u
public class SMSDB<DataBaseHelper>  
{ 
	protected static final String TAG = "DataAdapter"; 

	private final Context mContext; 
	private SQLiteDatabase mDb; 
	private MYDB2 mDbHelper; 
	int dem = 0;
	public SMSDB (Context context)  
	{ 
		this.mContext = context; 
		mDbHelper = new MYDB2(mContext); 
	} 
	//khÃ¡Â»Å¸i tÃ¡ÂºÂ¡o 1 TestAdapter
	public SMSDB createDatabase() throws SQLException  
	{ 
		try  
		{ 
			mDbHelper.createDataBase(); 
		}  
		catch (IOException mIOException)  
		{ 
			Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
			throw new Error("UnableToCreateDatabase"); 
		} 
		return this; 
	} 
	//MÃ¡Â»Å¸ sau khi Ã„â€˜ÃƒÂ£ Ã„â€˜Ã†Â°Ã†Â¡c khÃ¡Â»Å¸i tÃ¡ÂºÂ¡o
	public SMSDB open() throws SQLException  
	{ 
		try  
		{ 
			mDbHelper.openDataBase(); 
			mDbHelper.close(); 
			mDb = mDbHelper.getWritableDatabase(); 
		}  
		catch (SQLException mSQLException)  
		{ 
			Log.e(TAG, "open >>"+ mSQLException.toString()); 
			throw mSQLException; 
		} 
		return this; 
	} 
	///close database
	public void close()  
	{ 
		mDbHelper.close(); 
	} 

	
	
//	public SMS1 getGiangSinh(int id) 
//	{ 
//		SMS1 resut=new SMS1();
//		String sql ="sselect *from details where _id = "+id;//"SELECT id, CauNoiHay FROm data";  
//		Cursor mCur = mDb.rawQuery(sql,null);
//
//		if (mCur!=null) 
//		{ 
//			mCur.moveToNext(); 
//		} 
//		resut.set_id(mCur.getInt(mCur.getColumnIndex("_id")));
//		resut.set_text(((mCur.getString(mCur.getColumnIndex("_text")))));
//	
//		Log.d("sms", resut.toString());
//		return resut;
//	}
//	
//	public SMS1 getNewYear(int id) 
//	{ 
//		SMS1 resut=new SMS1();
//		String sql ="select *from newyear where _id = "+id;//"SELECT id, CauNoiHay FROm data";  
//		Cursor mCur = mDb.rawQuery(sql,null);
//
//		if (mCur!=null) 
//		{ 
//			mCur.moveToNext(); 
//		} 
//		resut.set_id(mCur.getInt(mCur.getColumnIndex("_id")));
//		resut.set_text(((mCur.getString(mCur.getColumnIndex("_text")))));
//	
//		Log.d("sms", resut.toString());
//		return resut;
//	}
	
	
	
	
	public SMS2 getSMSKute(String tenbang , int id) 
	{ 
		SMS2 resut=new SMS2();
		String sql ="select *from "+tenbang+" where _id = "+id;//"SELECT id, CauNoiHay FROm data";  
		Cursor mCur = mDb.rawQuery(sql,null);

		if (mCur!=null) 
		{ 
			mCur.moveToNext(); 
		} 
		resut.set_id(mCur.getInt(mCur.getColumnIndex("_id")));
		resut.setNoidung(((mCur.getString(mCur.getColumnIndex("noidung")))));
		resut.setGravity(((mCur.getString(mCur.getColumnIndex("gravity")))));
		
	
		Log.d("SMS2", resut.toString());
		return resut;
	}	
	
	public int getSizeSMSKute(String tenbang) 
	{ 
		ArrayList<SMS2> list=new ArrayList<SMS2>();
		String sql ="select *from "+tenbang;
		Cursor mCur = mDb.rawQuery(sql, null); 
		if (mCur!=null) 
		{ 
			mCur.moveToNext(); 
		} 
		while(mCur.isAfterLast()==false){
			dem++;
			SMS2 resut=new SMS2();
			resut.set_id(mCur.getInt(mCur.getColumnIndex("_id")));
			resut.setNoidung(((mCur.getString(mCur.getColumnIndex("noidung")))));
			resut.setGravity(((mCur.getString(mCur.getColumnIndex("gravity")))));

			mCur.moveToNext();

			list.add(resut);
		}
		return dem;
	}
} 


