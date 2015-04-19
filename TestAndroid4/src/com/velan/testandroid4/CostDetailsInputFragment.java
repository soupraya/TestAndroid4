package com.velan.testandroid4;


import java.io.IOException;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.velan.testandroid4.taskendpoint.Taskendpoint;
import com.velan.testandroid4.taskendpoint.model.Task;
import com.velan.testandroid4.todoendpoint.Todoendpoint;
import com.velan.testandroid4.todoendpoint.model.Todo;

import android.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CostDetailsInputFragment extends Fragment {
	protected static Todo currenttodo;
	protected static Task currenttask;
	private EditText todo_desc;
	private EditText todo_long_desc;
	private EditText todo_a;
	private EditText todo_b;
	private TextView todo_c;
	private Button save_todo;
	Context thiscontext;
	
	/**
	   * Initializes the activity content, binds relevant widgets and starts asynchronously retrieving
	   * offers and recommendations.
	   */
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
	        //super.onActivityCreated(savedInstanceState);
	        if (container == null) {
	            // We have different layouts, and in one of them this
	            // fragment's containing frame doesn't exist.  The fragment
	            // may still be created from its saved state, but there is
	            // no reason to try to create its view hierarchy because it
	            // won't be displayed.  Note this is not needed -- we could
	            // just run the code below, where we would create and return
	            // the view hierarchy; it would just never be used.
	            return null;
	        }
		  thiscontext = container.getContext();
		  
		  
	    //View TodoDetailsInputFragmentView = getActivity().findViewById(R.id.todo_details_input_fragment);
		  View view = inflater.inflate(R.layout.todo_detail_input_fragment,
			        container, false);
		  //setContentView(R.layout.activity_single_todo);
	    todo_desc = (EditText) view.findViewById(R.id.todo_desc);
	    todo_long_desc = (EditText) view.findViewById(R.id.todo_long_desc);
	    todo_a = (EditText) view.findViewById(R.id.todo_a);
	    todo_b = (EditText) view.findViewById(R.id.todo_b);
	    //task_at = (EditText) view.findViewById(R.id.task_at);
	    //task_bt = (EditText) view.findViewById(R.id.task_bt);
	    todo_c = (TextView) view.findViewById(R.id.todo_c);
	    save_todo = (Button) view.findViewById(R.id.save_todo);
	    
	    if(currenttodo != null)
	    {
	    todo_desc.setText(currenttodo.getShortDescription());
	    todo_long_desc.setText(currenttodo.getLongDescription());
	    todo_a.setText(currenttodo.getA().toString());
	    todo_b.setText(currenttodo.getA().toString());
	    todo_c.setText(currenttodo.getC().toString());
	    }
	    else
	    {
	    	currenttodo = new Todo();
	    }
	    
	    save_todo.setOnClickListener(new OnClickListener(){
	    		  @Override
	    		  public void onClick(View v) {
	    			  Log.i("TodoDetailsInputFragment", "update todo click");
	    			  currenttodo.setShortDescription(todo_desc.getText().toString());
	    			  currenttodo.setLongDescription(todo_long_desc.getText().toString());
	    			  currenttodo.setA(Double.parseDouble(todo_a.getText().toString()));
	    			  currenttodo.setB(Double.parseDouble(todo_b.getText().toString()));
	    			  CalculateC();
	    			  CalculateCT();
	    			  todo_c.setText(currenttodo.getC().toString());
	    			  new TodoAsyncUpdate().execute();
	    			  new TaskAsyncUpdate().execute();
	    			  }
	    		  });
	    return view;
	    
	  }
	  
		public void CalculateC() {
			Double C;
			C = currenttodo.getA()*currenttodo.getB();
			currenttodo.setC(C);
		}
		
		public void CalculateCT() {
			Double CT=currenttodo.getC();
			if(currenttask != null)
				CT += currenttask.getCt();
			currenttask.setCt(CT);
		}
		
	  	//Todo list update
		private class TodoAsyncUpdate extends AsyncTask<Void, Void, Todo> {

		@Override
		protected Todo doInBackground(Void... arg0) {
			Log.i("TodoDetailsInputFragment", "TodoAsyncUpdate");
		    Todoendpoint.Builder endpointBuilder = new Todoendpoint.Builder(
		    AndroidHttp.newCompatibleTransport(), new JacksonFactory(), null)
		    .setApplicationName("testandroid4");
	   
		    endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
		    Todoendpoint endpoint = endpointBuilder.build();

		    Todo result;

			      try {
			    	  
					    if(currenttodo.getId() == null)
					    {
					    	currenttodo.setId(System.currentTimeMillis());
					    	Log.i("TodoDetailsInputFragment", "Insert Todo");
					    	result = endpoint.insertTodo(currenttodo).execute();
					    }
					    else {
					    	Log.i("TodoDetailsInputFragment", "Update Todo");
					    	result = endpoint.updateTodo(currenttodo).execute();
					    }
					    
				        
				      } catch (IOException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
				        result = null;
				      }
				      return result;		    	

		}
		
	    @Override
	    protected void onPostExecute(Todo result) {
	    	String displayString = "Todo saved!";
	    	Toast msg = Toast.makeText(getActivity().getBaseContext(), displayString,Toast.LENGTH_LONG);
	    	msg.show();
			}
		}
		
		//Todo list update
		private class TaskAsyncUpdate extends AsyncTask<Void, Void, Task> {

				@Override
				protected Task doInBackground(Void... arg0) {
					Log.i("TodoDetailsInputFragment", "TaskAsyncUpdate");
				    Taskendpoint.Builder endpointBuilder = new Taskendpoint.Builder(
				    AndroidHttp.newCompatibleTransport(), new JacksonFactory(), null)
				    .setApplicationName("testandroid4");
			   
				    endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
				    Taskendpoint endpoint = endpointBuilder.build();

				    Task result;

					      try {
					    	  
							    if(currenttask.getId() == null)
							    {
							    	currenttask.setId(System.currentTimeMillis());
							    	Log.i("TodoDetailsInputFragment", "Insert Task");
							    	result = endpoint.insertTask(currenttask).execute();
							    }
							    else {
							    	Log.i("TodoDetailsInputFragment", "Update Task");
							    	result = endpoint.updateTask(currenttask).execute();
							    }
							    
						        
						      } catch (IOException e) {
						        // TODO Auto-generated catch block
						        e.printStackTrace();
						        result = null;
						      }
						      return result;		    	

				}
				
			    @Override
			    protected void onPostExecute(Task result) {
			    	String displayString = "Task saved!";
			    	Toast msg = Toast.makeText(getActivity().getBaseContext(), displayString,Toast.LENGTH_LONG);
			    	msg.show();
					}
				}
}
