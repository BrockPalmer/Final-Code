package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message){
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			
		try {
			lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			
			
		} catch (RateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("error message, stop processing");
		}
		
//		Determine if payment, call RateBLL.getPayment	
//	you should update lq, and then send lq back to the caller(s)
		
		
		// must fill in r, n, p, f, t.... confused on how to calculate them even after
		//looking at the website
		lq.setdPayment(RateBLL.getPayment(lq.getdRate(), ClientID, ClientID, ClientID, false));
		
		sendToAll(lq);
		}
	}
}
