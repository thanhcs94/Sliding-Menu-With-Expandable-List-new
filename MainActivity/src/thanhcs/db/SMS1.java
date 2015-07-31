package thanhcs.db;

import java.io.Serializable;

public class SMS1 implements Serializable {
	
	int _id;
	String _text;
	public SMS1(int _id, String _text) {
		super();
		this._id = _id;
		this._text = _text;
	}
	public SMS1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_text() {
		return _text;
	}
	public void set_text(String _text) {
		this._text = _text;
	}
	@Override
	public String toString() {
		return "SMS1 [_id=" + _id + ", _text=" + _text + "]";
	}
	
	
	
	

	
}
