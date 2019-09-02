package cobwebs;

import java.util.ArrayList;


public class Sequence {
	public ArrayList<Block> chain = new ArrayList<Block>(); 
	private ArrayList<Transaction> pendingTransactions = new ArrayList<Transaction>();
	private Block[] controlBlock = new Block[1];
	private Algorithm sha256 = new Algorithm();
	
	
	
	
	public void mining(String miner) {
		
		String tempHashValue=sha256.getHash(controlBlock[0].valueForHashing().getBytes());
		while(tempHashValue.substring(0,5)!="00000") {
			controlBlock[0].incrementingNonce();
			tempHashValue=sha256.getHash(controlBlock[0].valueForHashing().getBytes());
			if(tempHashValue.substring(0,5).equals("00000")) {
				controlBlock[0].setHash(tempHashValue);
				controlBlock[0].setIndex(chain.size());
				controlBlock[0].setPreviousHash(chain.get(chain.size()-1).getHash());
				chain.add(controlBlock[0]);

				//make new controlBlock
				controlBlock[0]=new Block();
				makeTransaction("New Generated Coing",miner,10);
				controlBlock[0].transferTransactions(pendingTransactions);
				controlBlock[0].setTransactionsToString();
				pendingTransactions=new ArrayList<Transaction>();
				chain.get(chain.size()-1).printBlock();
				
			}
		

		}
		mining(miner);
		
}
	
	//creating Genesis Block the first block in BlockChain
	public void GenesisBlock() {
		Block genesis = new Block();
		genesis.setNonce(0);
		genesis.setHash("GenesisBlock");
		genesis.setPreviousHash("0000000000000000000000000000000000000000000000000000000000000000");
		chain.add(genesis);
	}
	//for miner rewards and regular transactions
	public void makeTransaction(String s,String r,int a) {
		Transaction t = new Transaction();
		t.setSender(s);
		t.setRecipient(r);
		t.setAmount(a);
		pendingTransactions.add(t);
	}
	
	public void creatingControlBlock() {
		for(int i=0;i<controlBlock.length;i++) {
			controlBlock[i]=new Block();
		}
	}
	//only for testing
	//printing the first block in BlockChain
	//delete later
	public void printGenesis() {
		chain.get(0).printBlock();
	}
	

}
