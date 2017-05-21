package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		//for each RateDomain model in the arraylist 
		for (RateDomainModel Rate :rates ){
			//Filter the ArrayList...  look for the correct rate for the given credit score
			
			//comparing (lambda) credit score to givencredit score
			
			if (Rate.getiMinCreditScore()<= GivenCreditScore){
				
				dInterestRate = Rate.getdInterestRate();
			}
			if(dInterestRate==0){
				RateDomainModel rate1= new RateDomainModel();
				rate1.setiMinCreditScore(GivenCreditScore);
				throw new RateException(rate1);
			}
		}

	
		
		return dInterestRate;
		
		
	}
	
	
	
	
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
