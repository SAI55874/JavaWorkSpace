import java.util.ArrayList;
import java.util.List;

import com.htc.bankapplication.pojo.BankAccount;

public class BankAccountDaoImpli {
	
	List<BankAccount> account;
	public BankAccountDaoImpli()

	{
		account=new ArrayList<BankAccount>();
		BankAccount b1=new BankAccount("nibin");
		BankAccount b2=new BankAccount("Sreerag");
		account.add(b1);
		account.add(b2);
	}
	public List<BankAccount> getAllBankAccounts()
	{
		return account;
		
	}
	

}
