package com.sample.tools;

public class DriverFactory {
	

    public DriverSelection getDriver(String DriverType){
        if(DriverType ==null){
            return  null;
        }
        if(DriverType.equalsIgnoreCase("firefox")){
            return new Firefox();
        }
        if(DriverType.equalsIgnoreCase("chrome")){
            return new Chrome();
        }
        if(DriverType.equalsIgnoreCase("IE")){
            
        }if(DriverType.equalsIgnoreCase("remote")) {
        	return new Remote();
        }
        return null;
    }
}
