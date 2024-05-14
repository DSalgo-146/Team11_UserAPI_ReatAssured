package Utilities;

import java.util.HashMap;

import java.util.Map;

import javax.naming.Context;

public class ScenarioContext {

	private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(String string){
        return scenarioContext.get(string.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }

	public Object setContext(String string, String token) {
		return scenarioContext.put(string, token);
	}

	public Object getContext(String string, String token) {
		// TODO Auto-generated method stub
		//return null;
		return scenarioContext.put(string, token);
	}
    
}
