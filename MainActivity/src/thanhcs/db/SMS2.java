package thanhcs.db;

import java.io.Serializable;

public class SMS2 implements Serializable {

	int _id;
	String  noidung;
	String gravity;
	public SMS2(int _id, String noidung, String gravity) {
		super();
		this._id = _id;
		this.noidung = noidung;
		this.gravity = gravity;
	}
	public SMS2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	@Override
	public String toString() {
		return "SMS2 [_id=" + _id + ", noidung=" + noidung + ", gravity="
				+ gravity + "]";
	}
	
	
	
}
