package com.hit.client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.hit.view.CacheUnitView;

public class CacheUnitClientObserver implements PropertyChangeListener {
	private CacheUnitClient cuClient;
	public CacheUnitClientObserver() {
		cuClient = new CacheUnitClient();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if(evt.getPropertyName().equals("Load a Request") || evt.getPropertyName().equals("Show Stats")) {
			CacheUnitView observable = (CacheUnitView)evt.getSource();
			String response = "Failed";
			response = cuClient.send((String)evt.getNewValue());
			observable.updateUIData(response);
		}

	}
	
}
