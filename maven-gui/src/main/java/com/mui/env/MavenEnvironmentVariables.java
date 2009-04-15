
package com.mui.env;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author sabuj.das
 */
public class MavenEnvironmentVariables  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1093977900812332575L;
	private Map<String, String> requiredVars;
    private Map<String, String> optionalVars;

    public MavenEnvironmentVariables() {
        requiredVars = new HashMap<String, String>();
        optionalVars = new HashMap<String, String>();
    }

    public void addEnvironmentVariable(String var, String val, boolean isRequired){
        if(var != null && !var.equals("")){
            if(isRequired){
                requiredVars.put(var, val);
            }else{
                optionalVars.put(var, val);
            }
        }
    }

    public void addEnvironmentVariables(Map<String, String> envVars, boolean isRequired){
        if(envVars == null){
            return;
        }
        Iterator<String> envVarItr = envVars.keySet().iterator();
        while(envVarItr.hasNext()){
            String key = envVarItr.next();
            String val = envVars.get(key);
            addEnvironmentVariable(key, val, isRequired);
        }
    }

    public boolean checkRequiredVarsPresent(){
        return true;
    }
    
    public String getValue(String varName){
    	if(requiredVars.containsKey(varName)){
    		return requiredVars.get(varName);
    	}
    	if(optionalVars.containsKey(varName)){
    		return optionalVars.get(varName);
    	}
    	return null;
    }
}
