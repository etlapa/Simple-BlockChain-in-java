package cobwebs;

public class Transaction {
	private String sender;
	private String recipient;
	private int amount;
	//getters and setters
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//converting Transaction values to String
	public String TransactionToString() {
		return sender+" "+recipient+" "+amount;
	}
	
	//delete after testing this method
	public void PrintTransaction() {
		System.out.println(sender+" "+recipient+" "+amount);
	}

}
