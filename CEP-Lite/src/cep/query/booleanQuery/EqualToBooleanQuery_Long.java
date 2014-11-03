package cep.query.booleanQuery;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualToBooleanQuery_Long extends BooleanQuery{
	int parameter;
	public EqualToBooleanQuery_Long(String in_query,int queryParameters)
	{
		super(in_query);
		this.parameter=queryParameters;
		
	}
	public boolean process(HashMap<String,String> currentDataMap)
	{
		query=query.trim();
		//System.out.println(currentDataMap.toString());  
		String[] parametersNames=query.split("==");
		parametersNames[0]=parametersNames[0].replaceAll("\\s+","");
		parametersNames[1]=parametersNames[1].replaceAll("\\s+","");
		ArrayList<Long> parametersStrings=new ArrayList<Long>();
		if(parameter==0)
		{		
			parametersStrings.add(Long.parseLong(currentDataMap.get(parametersNames[0])));
			parametersStrings.add(Long.parseLong(currentDataMap.get(parametersNames[1])));
		}
		else
		{	
			String a=parametersNames[0];
			parametersStrings.add(Long.parseLong(currentDataMap.get(a)));
			String userGivenValue=parametersNames[1].replace("(","");
			userGivenValue=userGivenValue.replace(")","");
			parametersStrings.add(Long.parseLong(userGivenValue));
		}
		
		//checking for equality
		return (parametersStrings.get(0).equals(parametersStrings.get(1)));
	}

}
