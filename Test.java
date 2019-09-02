package cobwebs;

public class Test {

	public static void main(String[] args) {
		Sequence chain = new Sequence();
		chain.creatingControlBlock();
		chain.GenesisBlock();
		chain.printGenesis();
		chain.makeTransaction("HoLLe197","Some Cool Guy",1997);
		chain.mining("0x00000");

	}

}
