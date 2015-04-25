package com.velan.testandroid4.ui;


import java.io.IOException;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.velan.testandroid4.R;
import com.velan.testandroid4.costitemendpoint.Costitemendpoint;
import com.velan.testandroid4.costitemendpoint.model.CostItem;
import com.velan.testandroid4.costtotalendpoint.Costtotalendpoint;
import com.velan.testandroid4.costtotalendpoint.model.CostTotal;
import com.velan.testandroid4.model.CloudEndpointUtils;
import com.velan.testandroid4.model.PricingApplication;

import android.app.Fragment;
import android.content.Context;
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
	private CostItem currentcostItem;
	//private CostTotal currentcostTotal;
	private EditText costItem_desc;
	private EditText costItem_numberOfItem;
	private EditText costItem_UnitCost;
	private TextView costItem_TotalCost;
	private Button save_costItem;
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
		  
		  
	    //View CostItemDetailsInputFragmentView = getActivity().findViewById(R.id.costItem_details_input_fragment);
		  View view = inflater.inflate(R.layout.costitem_detail_input_fragment,
			        container, false);
		  //setContentView(R.layout.activity_single_costItem);
	    costItem_desc = (EditText) view.findViewById(R.id.costItem_desc);
	    costItem_numberOfItem = (EditText) view.findViewById(R.id.costItem_numberOfItem);
	    costItem_UnitCost = (EditText) view.findViewById(R.id.costItem_UnitCost);
	    costItem_TotalCost = (TextView) view.findViewById(R.id.costItem_TotalCost);
	    save_costItem = (Button) view.findViewById(R.id.save_costItem);
	    
	    final PricingApplication PricingApp = (PricingApplication) getActivity().getApplicationContext();
	    currentcostItem = PricingApp.getCostSync().getCurrentcostItem();
	    
	    
	    if(currentcostItem != null)
	    {
	    costItem_desc.setText(currentcostItem.getDescription());
	    costItem_numberOfItem.setText(currentcostItem.getNumberOfItem().toString());
	    costItem_UnitCost.setText(currentcostItem.getUnitCost().toString());
	    costItem_TotalCost.setText(currentcostItem.getTotal().toString());
	    }
	    else
	    {
	    	currentcostItem = new CostItem();
	    }
	    
	    save_costItem.setOnClickListener(new OnClickListener(){
	    		  @Override
	    		  public void onClick(View v) {
	    			  Log.i("CostItemDetailsInputFragment", "update costItem click");
	    			  
	    			  
	    			  currentcostItem.setDescription(costItem_desc.getText().toString());
	    			  currentcostItem.setNumberOfItem(Integer.parseInt(costItem_numberOfItem.getText().toString()));
	    			  currentcostItem.setUnitCost(Double.parseDouble(costItem_UnitCost.getText().toString()));
	    			  PricingApp.getCostSync().addCostItem(currentcostItem);
	    			  currentcostItem = PricingApp.getCostSync().getCurrentcostItem();
	    			  //CalculateC();
	    			  //CalculateCT();
	    			  costItem_TotalCost.setText(currentcostItem.getTotal().toString());
	    			  
	    			  //PricingApp.getCostSync()
	    			  //new CostItemAsyncUpdate().execute();
	    			  //new CostTotalAsyncUpdate().execute();
	    			  }
	    		  });
	    return view;
	    
	  }
	  

		
		/*
	  	//CostItem update
		private class CostItemAsyncUpdate extends AsyncTask<Void, Void, CostItem> {

		@Override
		protected CostItem doInBackground(Void... arg0) {
			Log.i("CostItemDetailsInputFragment", "CostItemAsyncUpdate");
			Costitemendpoint.Builder endpointBuilder = new Costitemendpoint.Builder(
		    AndroidHttp.newCompatibleTransport(), new JacksonFactory(), null)
		    .setApplicationName("testandroid4");
	   
		    endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
		    Costitemendpoint endpoint = endpointBuilder.build();

		    CostItem result;

			      try {
			    	  
					    if(currentcostItem.getId() == null)
					    {
					    	currentcostItem.setId(System.currentTimeMillis());
					    	Log.i("CostItemDetailsInputFragment", "Insert CostItem");
					    	result = endpoint.insertCostItem(currentcostItem).execute();
					    }
					    else {
					    	Log.i("CostItemDetailsInputFragment", "Update CostItem");
					    	result = endpoint.updateCostItem(currentcostItem).execute();
					    }
					    
				        
				      } catch (IOException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
				        result = null;
				      }
				      return result;		    	

		}
		
	    @Override
	    protected void onPostExecute(CostItem result) {
	    	String displayString = "CostItem saved!";
	    	Toast msg = Toast.makeText(getActivity().getBaseContext(), displayString,Toast.LENGTH_LONG);
	    	msg.show();
			}
		}
		
		//CostTotal update
		private class CostTotalAsyncUpdate extends AsyncTask<Void, Void, CostTotal> {

				@Override
				protected CostTotal doInBackground(Void... arg0) {
					Log.i("CostItemDetailsInputFragment", "CostTotalAsyncUpdate");
					Costtotalendpoint.Builder endpointBuilder = new Costtotalendpoint.Builder(
				    AndroidHttp.newCompatibleTransport(), new JacksonFactory(), null)
				    .setApplicationName("testandroid4");
			   
				    endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
				    Costtotalendpoint endpoint = endpointBuilder.build();

				    CostTotal result;

					      try {
					    	  
							    if(currentcostTotal.getId() == null)
							    {
							    	currentcostTotal.setId(System.currentTimeMillis());
							    	Log.i("CostItemDetailsInputFragment", "Insert CostTotal");
							    	result = endpoint.insertCostTotal(currentcostTotal).execute();
							    }
							    else {
							    	Log.i("CostItemDetailsInputFragment", "Update CostTotal");
							    	result = endpoint.updateCostTotal(currentcostTotal).execute();
							    }
							    
						        
						      } catch (IOException e) {
						        // TODO Auto-generated catch block
						        e.printStackTrace();
						        result = null;
						      }
						      return result;		    	

				}
				
			    @Override
			    protected void onPostExecute(CostTotal result) {
			    	String displayString = "CostTotal saved!";
			    	Toast msg = Toast.makeText(getActivity().getBaseContext(), displayString,Toast.LENGTH_LONG);
			    	msg.show();
					}
				}
				*/
}
