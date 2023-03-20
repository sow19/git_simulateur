package util;

import java.util.ArrayList;

public abstract class AbstractListenableModel implements ListenableModel {
	private ArrayList<ListeningModel > ecouteurs;
	
	@Override
	public void addListening(ListeningModel  e) {
		this.ecouteurs.add(e);
		
	}	
	@Override
	public void removeListening(ListeningModel  e) {
		this.ecouteurs.remove(e);
		
	}
	protected void fireChangement() {
		for(ListeningModel  e : ecouteurs) {
			e.modeleMIsAJour(this);
		}
	}

}
