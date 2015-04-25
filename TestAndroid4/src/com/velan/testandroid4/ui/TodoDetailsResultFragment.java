package com.velan.testandroid4.ui;

import com.velan.testandroid4.R;
import com.velan.testandroid4.R.id;
import com.velan.testandroid4.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class TodoDetailsResultFragment extends Fragment {
	private TextView todo_c;
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		
		
		  View view = inflater.inflate(R.layout.todo_detail_result_fragment,
			        container, false);
		  todo_c = (TextView) view.findViewById(R.id.todo_c);
		  todo_c.setText("77");
		  return view;
	}
}
