package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	// RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	private RateDomainModel rate1= new RateDomainModel();
	
	//	* Create a constructor, passing in RateDomainModel
	
	public RateException(RateDomainModel rate1){
			this.rate1= rate1;
			}
//	* Create a getter (no setter, set value only in Constructor)
	public RateDomainModel getRate1() {
		return rate1;
	}


	
	
}
