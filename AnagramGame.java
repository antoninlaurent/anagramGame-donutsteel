
public class AnagramGame {
	public static Account acc;
    public static void main(String args[]) {
		Account.loadAll(); //load all the account
		StartupMenu.start(); //open the first menu frame
		//subsequent menu frames are opened in FrameChangeClickListener
	}
}