package dev.eduardo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
@Path("/labseq")
public class GreetingResource {

    @GET
    @Path("{n}")
    @Produces(MediaType.TEXT_PLAIN)
    public String labseq(long n) {
    if(n>=0)
    {
    	BigInteger[] cache = new BigInteger[(int)n+1];
    	String seq="";
    	BigInteger res ;
    	
    		
    			for (int i=0;i<=n;i++)
    			{
    				if(i==0 || i ==2)
    				{
    					cache[i]= BigInteger.valueOf(0);
    				}
    				if(i==1 || i ==3)
    				{
    					cache[i]= BigInteger.valueOf(1);
    				}
    				if(i>3)
    				{
    				res= cache[i-4].add(cache[i-3]) ; 
    				cache[i]= res;
    				}
    			
    			}
    			
    	
    	for(int j = 0; j<cache.length; j++)
    	{
    		seq = seq + "\n n(" + j + ")="+cache[j].toString(); 
    	}

        return  seq;
    }
    return "Error";
    }
}