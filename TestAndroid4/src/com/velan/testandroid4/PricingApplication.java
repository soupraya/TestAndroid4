package com.velan.testandroid4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.velan.testandroid4.taskendpoint.Taskendpoint;
import com.velan.testandroid4.taskendpoint.model.CollectionResponseTask;
import com.velan.testandroid4.taskendpoint.model.Task;
import com.velan.testandroid4.todoendpoint.Todoendpoint;
import com.velan.testandroid4.todoendpoint.model.CollectionResponseTodo;
import com.velan.testandroid4.todoendpoint.model.Todo;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class PricingApplication extends Application {
	private List<Todo> todos = null;
	private List<Task> tasks = null;
	private Boolean todosgetfinished = false;
	private Task taskcurrent;
	
	public Task getTaskcurrent() {
		return taskcurrent;
	}
	public void setTaskcurrent(Task taskcurrent) {
		this.taskcurrent = taskcurrent;
	}
	public Double getTaskCT() {
		return taskCT;
	}
	public void setTaskCT(Double taskCT) {
		this.taskCT = taskCT;
	}

	private Double taskCT;
	
	public List<Todo> getTodos() {
		new ListOfTodoAsyncRetriever();
		return todos;
	}
	
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	public List<Task> getTasks() {
		
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public Boolean getTodosgetfinished() {
		return todosgetfinished;
	}
	
	public void setTodosgetfinished(Boolean todosgetfinished) {
		this.todosgetfinished = todosgetfinished;
	}

	private class ListOfTodoAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseTodo> {

		@Override
		protected CollectionResponseTodo doInBackground(Void... params) {

			Log.i("HomeFragment", "ListOfTodoAsyncRetriever asyntask");

			Todoendpoint.Builder endpointBuilder = new Todoendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Todoendpoint endpoint = endpointBuilder.build();

			CollectionResponseTodo result;

			// Display Todo list
			// new ListOfTodoAsyncRetriever().execute();

			try {
				result = endpoint.listTodo().execute();
				Log.i("HomeFragment", "result init");
			} catch (IOException e) {
				Log.i("HomeFragment", "endpoint exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = null;
			}
			return result;
		}

		@Override
		protected void onPostExecute(CollectionResponseTodo result) {
			Log.i("HomeFragment", "onPostExecute");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("HomeFragment", "result is null");
				//todoList.setAdapter(null);
				return;
			}

			//ListAdapter todosListAdapter = createTodoListAdapter(result.getItems());
			//todoList.setAdapter(todosListAdapter);
			todos = result.getItems();
			setTodosgetfinished(true);
		}
	}
	
	private class ListOfTaskAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseTask> {

		@Override
		protected CollectionResponseTask doInBackground(Void... params) {

			Log.i("HomeFragment", "ListOfTaskAsyncRetriever asyntask");

			Taskendpoint.Builder endpointBuilder = new Taskendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Taskendpoint endpoint = endpointBuilder.build();

			CollectionResponseTask result;


			try {
				result = endpoint.listTask().execute();
				Log.i("HomeFragment", "result init Task");
			} catch (IOException e) {
				Log.i("HomeFragment", "endpoint exception Task");
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = null;
			}
			return result;
		}
		
		@Override
		protected void onPostExecute(CollectionResponseTask result) {
			Log.i("HomeFragment", "onPostExecute Task");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("HomeFragment", "result is null Task");
				return;
			}

			tasks = result.getItems();
			taskcurrent = tasks.get(0);
			CostDetailsInputFragment.currenttask = taskcurrent;
			taskCT = tasks.get(0).getCt();
			//cost_total.setText(taskCT.toString()+ " €");
			
		}
	}

}
