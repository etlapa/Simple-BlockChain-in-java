package cobwebs;

import java.util.ArrayList;
import java.util.Date;

public class Block {
	private int index=0;
	private String hash;
	private String previousHash;
	 Date date = new Date();
	//This method returns the time in millis
    private long timeMilli = date.getTime();
    //collecting date in String
    private String timestamp = String.valueOf(timeMilli);
    //used for proof of work
    private int nonce = 0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private String TransactionsToString="";
    //getters and setters
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	//this method used for mining
	public void incrementingNonce() {
		nonce++;
	}
	//setting transactions for mining
	public void setTransactionsToString() {
		for(int i=0;i<transactions.size();i++) {
			if(transactions.get(i)!=null) {
			TransactionsToString+=transactions.get(i).TransactionToString()+" ";
		}
		}
	}
	
	public void printBlock() {
		System.out.println("Index: "+index+", Nonce: "+nonce+", Timestamp: "+timestamp+", Block hash: "+hash+", Previous Block hash: "+previousHash+
				", Transactions: "+TransactionsToString);
	}
	//all informations for mining block
	public String valueForHashing() {
		return this.index+" "+" "+nonce+" "+this.timestamp+" "+this.previousHash+" "+this.TransactionsToString;
	}
	//used on Sequence for transfering transactions to this block transactions
	public void transferTransactions(ArrayList<Transaction>t) {
		for(int i=0;i<t.size();i++) {
			transactions.add(t.get(i));
		}
	}
    
    

}
