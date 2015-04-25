package com.velan.testandroid4.model;

import android.app.Application;



public class PricingApplication extends Application {
	
	private CostSync costSync;
	private ChargeableSync chargeableSync;
	private FinancialIndicatorSync financialIndicatorSync;
	
	public CostSync getCostSync() {
		if(costSync == null)
			costSync = new CostSync();
		return costSync;
	}
	public void setCostSync(CostSync costSync) {
		this.costSync = costSync;
	}
	public ChargeableSync getChargeableSync() {
		if(chargeableSync == null)
			chargeableSync = new ChargeableSync();
		return chargeableSync;
	}
	public void setChargeableSync(ChargeableSync chargeableSync) {
		this.chargeableSync = chargeableSync;
	}
	
	public FinancialIndicatorSync getFinancialIndicatorSync() {
		if(financialIndicatorSync == null)
			financialIndicatorSync = new FinancialIndicatorSync();
		return financialIndicatorSync;
	}
	
	public void setFinancialIndicatorSync(
			FinancialIndicatorSync financialIndicatorSync) {
		this.financialIndicatorSync = financialIndicatorSync;
	}
	

	
	/*
	//Cost items
	private List<CostItem> costitems = null;
	private List<CostTotal> costTotals = null;
	private Boolean costitemssyncdone = false;
	private Boolean costTotalssyncdone = false;
	private CostTotal costTotalCurrent;
	private CollectionResponseCostItem resultCostItem;
	private CollectionResponseCostTotal resultResponseCostTotal;
	private Double costTotal=0.0;
	
	//Chargeable items
	private Boolean chargeableItemsssyncdone = false;
	private Boolean chargeableItemstotalssyncdone = false;
	
	public Boolean getChargeableItemsssyncdone() {
		return chargeableItemsssyncdone;
	}
	public void setChargeableItemsssyncdone(Boolean chargeableItemsssyncdone) {
		this.chargeableItemsssyncdone = chargeableItemsssyncdone;
	}
	public Boolean getChargeableItemstotalssyncdone() {
		return chargeableItemstotalssyncdone;
	}
	public void setChargeableItemstotalssyncdone(
			Boolean chargeableItemstotalssyncdone) {
		this.chargeableItemstotalssyncdone = chargeableItemstotalssyncdone;
	}

	private List<ChargeableItemsTotal> chargeableItemsTotal = null;
	private Double chargeableTotal=0.0;
	private ChargeableItemsTotal chargeableItemsTotalcurrent;
	private List<ChargeableItems> chargeableitems = null;
	private CollectionResponseChargeableItems resultChargeableItems;
	private CollectionResponseChargeableItemsTotal resultChargeableItemsTotal;
	
	
	
	
	//Chargeable items Getter/Setter
	
	public List<ChargeableItemsTotal> getChargeableItemsTotal() {
		return chargeableItemsTotal;
	}
	public void setChargeableItemsTotal(
			List<ChargeableItemsTotal> chargeableItemsTotal) {
		this.chargeableItemsTotal = chargeableItemsTotal;
	}
	
	public Double getChargeableTotal() {
		return chargeableTotal;
	}
	
	public void setChargeableTotal(Double total) {
		this.chargeableTotal = total;
		CalculateGrossMargin();
	}
	
	
	public ChargeableItemsTotal getChargeableItemsTotalcurrent() {
		return chargeableItemsTotalcurrent;
	}
	public void setChargeableItemsTotalcurrent(
			ChargeableItemsTotal chargeableItemsTotalcurrent) {
		this.chargeableItemsTotalcurrent = chargeableItemsTotalcurrent;
	}
	public List<ChargeableItems> getChargeableitems() {
		return chargeableitems;
	}
	public void setChargeableitems(List<ChargeableItems> chargeableitems) {
		this.chargeableitems = chargeableitems;
	}
	public CollectionResponseChargeableItems getResultChargeableItems() {
		return resultChargeableItems;
	}
	public void setResultChargeableItems(
			CollectionResponseChargeableItems resultChargeableItems) {
		this.resultChargeableItems = resultChargeableItems;
	}
	public CollectionResponseChargeableItemsTotal getResultChargeableItemsTotal() {
		return resultChargeableItemsTotal;
	}
	public void setResultChargeableItemsTotal(
			CollectionResponseChargeableItemsTotal resultChargeableItemsTotal) {
		this.resultChargeableItemsTotal = resultChargeableItemsTotal;
	}
	
	public void ChargeableItemsAsync() {
		Log.i("PricingApplication", "ChargeableItemsAsync");
		new ListOfChargeableItemsAsyncRetriever().execute();
	}

	public void ChargeableItemsTotalAsync() {
		Log.i("PricingApplication", "ChargeableItemsTotalAsync");
		new ListOfChargeableItemsTotalAsyncRetriever().execute();
	}	
	
	//Cost
	
	public CollectionResponseCostTotal getResultResponseCostTotal() {
		return resultResponseCostTotal;
	}
	public void setResultResponseCostTotal(CollectionResponseCostTotal resultResponseCostTotal) {
		this.resultResponseCostTotal = resultResponseCostTotal;
	}
	public CollectionResponseCostItem getResult() {
		return resultCostItem;
	}
	public void setResult(CollectionResponseCostItem result) {
		this.resultCostItem = result;
	}
	
	public CostTotal getCostTotalcurrent() {
		return costTotalCurrent;
	}
	public void setCostTotalcurrent(CostTotal CostTotalcurrent) {
		this.costTotalCurrent = CostTotalcurrent;
	}
	public Double getCostTotal() {
		return costTotal;
	}
	public void setCostTotal(Double costTotal) {
		this.costTotal = costTotal;
		CalculateGrossMargin();
	}

	
	public void CostTotalAsync() {
		Log.i("PricingApplication", "CostTotalAsync");
		new ListOfCostTotalAsyncRetriever().execute();
	}
	
	
	public void CostItemAsync() {
		Log.i("PricingApplication", "CostItemAsync");
		new ListOfCostItemAsyncRetriever().execute();
	}	
	
	public List<CostItem> getCostItems() {
		Log.i("PricingApplication", "getCostItems");
		return costitems;
	}
	
	public void setCostItems(List<CostItem> costitems) {
		this.costitems = costitems;
	}
	
	public List<CostTotal> getCostTotals() {
		
		return costTotals;
	}
	public void setCostTotals(List<CostTotal> CostTotals) {
		this.costTotals = CostTotals;
	}

	public Boolean getCostItemssyncdone() {
		return costitemssyncdone;
	}
	public void setCostItemssyncdone(Boolean costitemssyncdone) {
		this.costitemssyncdone = costitemssyncdone;
	}



	public Boolean getCostTotalssyncdone() {
		return costTotalssyncdone;
	}
	
	public void setCostTotalssyncdone(Boolean CostTotalssyncdone) {
		this.costTotalssyncdone = CostTotalssyncdone;
	}

	private class ListOfCostItemAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseCostItem> {

		@Override
		protected CollectionResponseCostItem doInBackground(Void... params) {

			Log.i("PricingApplication", "ListOfCostItemAsyncRetriever asyntask");

			Costitemendpoint.Builder endpointBuilder = new Costitemendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Costitemendpoint endpoint = endpointBuilder.build();

			

			// Display CostItem list
			// new ListOfCostItemAsyncRetriever().execute();

			try {
				resultCostItem = endpoint.listCostItem().execute();
				Log.i("PricingApplication", "result init");
			} catch (IOException e) {
				Log.i("PricingApplication", "endpoint exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultCostItem = null;
			}
			return resultCostItem;
		}

		@Override
		protected void onPostExecute(CollectionResponseCostItem result) {
			Log.i("PricingApplication", "onPostExecute");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("PricingApplication", "result is null");
				//costitemList.setAdapter(null);
				costitemssyncdone = true;
				return;
			}

			//ListAdapter costitemsListAdapter = createCostItemListAdapter(result.getItems());
			//costitemList.setAdapter(costitemsListAdapter);
			costitems = result.getItems();
			costitemssyncdone = true;
		}
	}
	
	private class ListOfCostTotalAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseCostTotal> {

		@Override
		protected CollectionResponseCostTotal doInBackground(Void... params) {

			Log.i("PricingApplication", "ListOfCostTotalAsyncRetriever asyntask");

			Costtotalendpoint.Builder endpointBuilder = new Costtotalendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Costtotalendpoint endpoint = endpointBuilder.build();

			CollectionResponseCostTotal result;


			try {
				result = endpoint.listCostTotal().execute();
				Log.i("PricingApplication", "result init CostTotal");
			} catch (IOException e) {
				Log.i("PricingApplication", "endpoint exception CostTotal");
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = null;
			}
			return result;
		}
		
		@Override
		protected void onPostExecute(CollectionResponseCostTotal result) {
			Log.i("PricingApplication", "onPostExecute CostTotal");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("PricingApplication", "result is null CostTotal");
				costTotalssyncdone = true;
				return;
			}

			costTotals = result.getItems();
			costTotalCurrent = costTotals.get(0);
			CostDetailsInputFragment.currentcostTotal = costTotalCurrent;
			costTotal = costTotals.get(0).getTotal();
			//cost_total.setText(taskCT.toString()+ " €");
			costTotalssyncdone = true;
		}
	}
	
	//Chargeable items
	
	private class ListOfChargeableItemsAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseChargeableItems> {

		@Override
		protected CollectionResponseChargeableItems doInBackground(Void... params) {

			Log.i("ChargeableItemsFragment", "ListOfChargeableItemsAsyncRetriever asyntask");

			Chargeableitemsendpoint.Builder endpointBuilder = new Chargeableitemsendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Chargeableitemsendpoint endpoint = endpointBuilder.build();

			//CollectionResponseChargeableItems result;

			// Display CostItem list
			// new ListOfCostItemAsyncRetriever().execute();

			try {
				resultChargeableItems = endpoint.listChargeableItems().execute();
				Log.i("ChargeableItemsFragment", "result init");
			} catch (IOException e) {
				Log.i("ChargeableItemsFragment", "endpoint exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultChargeableItems = null;
			}
			return resultChargeableItems;
		}

		@Override
		protected void onPostExecute(CollectionResponseChargeableItems result) {
			Log.i("ChargeableItemsFragment", "onPostExecute");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("ChargeableItemsFragment", "result is null");
				//chargeableItemsList.setAdapter(null);
				chargeableItemsssyncdone = true;
				return;
			}

			//ListAdapter chargeableItemsListAdapter = createChargeableItemsListAdapter(result.getItems());
			//chargeableItemsList.setAdapter(chargeableItemsListAdapter);
			chargeableitems = result.getItems();
			chargeableItemsssyncdone = true;
		}

	}
	
	private class ListOfChargeableItemsTotalAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseChargeableItemsTotal> {

		@Override
		protected CollectionResponseChargeableItemsTotal doInBackground(Void... params) {

			Log.i("HomeFragment", "ListOfChargeableItemsTotalAsyncRetriever asyntask");

			Chargeableitemstotalendpoint.Builder endpointBuilder = new Chargeableitemstotalendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					null).setApplicationName("testandroid4");

			endpointBuilder = CloudEndpointUtils.updateBuilder(endpointBuilder);
			Chargeableitemstotalendpoint endpoint = endpointBuilder.build();

			//CollectionResponseChargeableItemsTotal result;


			try {
				resultChargeableItemsTotal = endpoint.listChargeableItemsTotal().execute();
				Log.i("HomeFragment", "result init CostTotal");
			} catch (IOException e) {
				Log.i("HomeFragment", "endpoint exception CostTotal");
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultChargeableItemsTotal = null;
			}
			return resultChargeableItemsTotal;
		}
		
		@Override
		protected void onPostExecute(CollectionResponseChargeableItemsTotal result) {
			Log.i("HomeFragment", "onPostExecute CostTotal");
			if (result == null || result.getItems() == null
					|| result.getItems().size() < 1) {
				Log.i("HomeFragment", "result is null CostTotal");
				chargeableItemstotalssyncdone = true;
				return;
			}

			chargeableItemsTotal = result.getItems();
			chargeableItemsTotalcurrent = chargeableItemsTotal.get(0);
			ChargeableItemDetailsInputFragment.currentChargeableItemTotal = chargeableItemsTotalcurrent;
			chargeableTotal = chargeableItemsTotal.get(0).getTotal();
			//chargeableItems_total.setText(total.toString()+ " €");
			chargeableItemstotalssyncdone = true;
		}
	}
*/
}
