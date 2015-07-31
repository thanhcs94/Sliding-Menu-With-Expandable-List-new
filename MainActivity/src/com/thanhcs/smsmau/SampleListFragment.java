package com.thanhcs.smsmau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.actionbarsherlock.view.MenuItem;
import com.thanhcs.smsmau.*;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

 
public class SampleListFragment extends Fragment  {
	public String[] menus = { "Giáng sinh", "Năm mới", "Chào ngày mới",
			"Chúc ngủ ngon" , "Tình yêu", "Sinh nhật", "Thi tốt","Nhà giáo", "8 tháng 3", "Năm mới 2", "Giáng sinh 2" , "Valentine",
			"Halloween", "Kí tự đẹp", "Vui vui", "Hay hay"};

	static String TYPE_SMS;
	static int SIZE ;
	ListView lv ;
	public ExpandableListView xl;
	public ActionBarDrawerToggle adt;
	public List<String> alkitab;
	public HashMap<String, List<String>> data_alkitab;
	public CharSequence title;
	private int lastExpandPosition = -1;
	private MenuItem menuItem;
	private ExpandableDrawerAdapter adapt;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		  loadData();
		    
		    xl = (ExpandableListView)getView().findViewById(R.id.left_drawer);
		    adapt = new ExpandableDrawerAdapter(getActivity(), alkitab, data_alkitab);
		    xl.setAdapter(adapt);
		    xl.setTextFilterEnabled(true);
		    xl.setOnGroupClickListener(new OnGroupClickListener() {
		        @Override
		        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
		            return false;
		        }
		    });

		    xl.setOnGroupExpandListener(new OnGroupExpandListener() {
		        @Override
		        public void onGroupExpand(int groupPosition) {
		            if (lastExpandPosition != -1 && groupPosition != lastExpandPosition) {
		                xl.collapseGroup(lastExpandPosition);
		            }
		            lastExpandPosition = groupPosition;
		        }
		    });

		    xl.setOnGroupCollapseListener(new OnGroupCollapseListener() {   
		        @Override
                            public void onGroupCollapse(int groupPosition) {}
                        });

                        xl.setOnChildClickListener(new OnChildClickListener() {
                            @Override
                            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                                int grup_pos = (int)adapt.getGroupId(groupPosition);
                                int child_pos = (int)adapt.getChildId(groupPosition, childPosition);
                                Fragment newContent = null;
                                if(grup_pos == 1){
                                    switch (child_pos) {
                                        case 0:
                                            Toast.makeText(getActivity(), "Child 1 Group 1", Toast.LENGTH_SHORT).show();
                                            newContent = new Fragment3();
		                    TYPE_SMS =  "sinhnhat";
		                    break;
		                case 1:
		                    Toast.makeText(getActivity(), "Child 2 Group 1", Toast.LENGTH_SHORT).show();
		                    newContent = new Fragment1();
		                    break;
                                case 2:
                                Toast.makeText(getActivity(), "Child 3 Group 1", Toast.LENGTH_SHORT).show();
                                newContent = new Fragment2();
                                break;
                                case 3:

                                Toast.makeText(getActivity(), "Child 4 Group 1", Toast.LENGTH_SHORT).show();
                                newContent = new Fragment4();
                                break;


                            }
                        }
		            if (newContent != null)
		    			switchFragment(newContent);
		            return false;
		        }
		    });
		    
	}

	 

	public void loadData(){

	    alkitab = new ArrayList<String>();
	    data_alkitab = new HashMap<String, List<String>>();

	    alkitab.add("Group 1");
	    alkitab.add("Group 2");
	    alkitab.add("Group 3");
	    alkitab.add("Group 4");

	    List<String> kitab_perjanjian_lama = new ArrayList<String>();
	    kitab_perjanjian_lama.add("Child 1 Of Group 1");
	    kitab_perjanjian_lama.add("Child 2 Of Group 1");
	    kitab_perjanjian_lama.add("Child 3 Of Group 1");
	    kitab_perjanjian_lama.add("Child 4 Of Group 1");

	    List<String> kitab_perjanjian_baru = new ArrayList<String>();
	    kitab_perjanjian_baru.add("Child 1 Of Group 2");
	    kitab_perjanjian_baru.add("Child 2 Of Group 2");
	    kitab_perjanjian_baru.add("Child 3 Of Group 2");
	    kitab_perjanjian_baru.add("Child 4 Of Group 2");

	    List<String> kidung_jemaat = new ArrayList<String>();
	    kidung_jemaat.add("Child 1 Of Group 3");
	    kidung_jemaat.add("Child 2 Of Group 3");
	    kidung_jemaat.add("Child 3 Of Group 3");
	    kidung_jemaat.add("Child 4 Of Group 3");

	    List<String> gita_bakti = new ArrayList<String>();
	    gita_bakti.add("Child 1 Of Group 4");
	    gita_bakti.add("Child 2 Of Group 4");
	    gita_bakti.add("Child 3 Of Group 4");
	    gita_bakti.add("Child 4 Of Group 4");

	    data_alkitab.put(alkitab.get(0), kitab_perjanjian_lama);
	    data_alkitab.put(alkitab.get(1), kitab_perjanjian_baru);
	    data_alkitab.put(alkitab.get(2), kidung_jemaat);
	    data_alkitab.put(alkitab.get(3), gita_bakti);
	}



	@SuppressWarnings("unused")
	private void displayViewExpandableListview(int position){
	    Fragment frag = null;
	    switch (position) {
	    case 0:
	        Toast.makeText(getActivity(), "test 1", Toast.LENGTH_SHORT).show();
	        break;
	    case 1:
	        Toast.makeText(getActivity(), "test 2", Toast.LENGTH_SHORT).show();
	        break;
	    case 2:
	        Toast.makeText(getActivity(), "Test 3", Toast.LENGTH_SHORT).show();
	        break;
	    default:
	        break;
	    }

	    if(frag != null){
	        FragmentManager frag_mgr = getFragmentManager();
	        frag_mgr.beginTransaction().replace(R.id.content_frame, frag).commit();
	        xl.setItemChecked(position, true);
	      //  dl.closeDrawer(xl);
	    } else {
	       // Log.d("Error 1", "Error creating fragment");
	    }
	    
	
	}

	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		}

	}

	
	
	
	
	public class ExpandableDrawerAdapter extends BaseExpandableListAdapter{

	    public final Context _context;
	    public List<String> _alkitab, tempchild;
	    public HashMap<String, List<String>> _data_alkitab;

	    public ExpandableDrawerAdapter(Context context, List<String> alkitab, HashMap<String, List<String>> data_alkitab){
	        this._context = context;
	        this._alkitab = alkitab;
	        this._data_alkitab = data_alkitab;
	    }

	    @Override
	    public Object getChild(int groupPosition, int childPosition) {
	        return this._data_alkitab.get(this._alkitab.get(groupPosition)).get(childPosition);
	    }

	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }

	    @Override
	    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
	        final String childText = (String)getChild(groupPosition, childPosition);
	        if(convertView == null){
	            LayoutInflater inflater = (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = inflater.inflate(R.layout.list_row_data_alkitab, null);
	        }
	        TextView a = (TextView)convertView.findViewById(R.id.lblListItem);
	        a.setText(childText);
	        return convertView;
	    }

	    @Override
	    public int getChildrenCount(int groupPosition) {
	        return this._data_alkitab.get(this._alkitab.get(groupPosition)).size();
	    }

	    @Override
	    public Object getGroup(int groupPosition) {
	        return this._alkitab.get(groupPosition);
	    }

	    @Override
	    public int getGroupCount() {
	        return this._alkitab.size();
	    }

	    @Override
	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }

	    @Override
	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	        String headerTitle = (String)getGroup(groupPosition);
	        if(convertView == null){            
	            LayoutInflater inflater = (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = inflater.inflate(R.layout.list_row_group, null);
	        }
	        if(groupPosition==0){
	            ((ImageView)convertView.findViewById(R.id.image2)).setImageResource(R.drawable.ic_launcher);
	            ((TextView)convertView.findViewById(R.id.text2)).setText("Description below group 1");
	        }else if(groupPosition==1){
	            ((ImageView)convertView.findViewById(R.id.image2)).setImageResource(R.drawable.ic_launcher);
	            ((TextView)convertView.findViewById(R.id.text2)).setText("Description below group 2");
	        }else if(groupPosition==2){
	            ((ImageView)convertView.findViewById(R.id.image2)).setImageResource(R.drawable.ic_launcher);
	            ((TextView)convertView.findViewById(R.id.text2)).setText("Description below group 3");
	        }else if(groupPosition==3){
	            ((ImageView)convertView.findViewById(R.id.image2)).setImageResource(R.drawable.ic_launcher);
	            ((TextView)convertView.findViewById(R.id.text2)).setText("Description below group 4");
	        }
	        TextView b = (TextView)convertView.findViewById(R.id.text1);
	        b.setTypeface(null, Typeface.BOLD);
	        b.setText(headerTitle);

	        return convertView;
	    }

	    @Override
	    public boolean hasStableIds() {
	        return true;
	    }

	    @Override
	    public boolean isChildSelectable(int groupPosition, int childPosition) {
	        return true;
	    }
	}
	
	
}
