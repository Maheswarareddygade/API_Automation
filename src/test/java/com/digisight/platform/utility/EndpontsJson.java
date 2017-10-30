package com.digisight.platform.utility;
public class EndpontsJson
{
	public Endpoints Enpoints;
    public Endpoints getEndpoints() {
    	return Enpoints;
	    }
    public void setEnpoints(Endpoints enpoints) {
		Enpoints = enpoints;
	}


	@Override
    public String toString()
    {
        return "ClassPojo [Enpoints = "+Enpoints+"]";
    }
	
}	