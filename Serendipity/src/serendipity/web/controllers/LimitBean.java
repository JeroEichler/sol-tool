package serendipity.web.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LimitBean {
	
	private List<Integer> limitValues = initLimitValues();
	
	public List<Integer> getLimitValues(){		
		return limitValues;
	}
	
	private List<Integer> initLimitValues(){
		List<Integer> limitValues = new ArrayList<Integer>();
		limitValues.add(5);
		limitValues.add(10);
		limitValues.add(20);
		limitValues.add(50);
		limitValues.add(100);

		return limitValues;
		
	}

}
