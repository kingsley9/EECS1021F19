
public class Account {
	String N;
	char t;
	double bal;

	Account (String N, char t, double ibal){
		this.N=N;
		this.t=t;
		this.bal=ibal;
		
	}
	Account (String N, char t){
		this.N=N;
		this.t=t;
		this.bal=0.0;
		
	}
	String getDescription() {
		String Des="";
		if (t=='d') {
			Des="Domestic account with current owner "+N+" has current balance "+bal;
		}
		else {
			Des="International account with current owner "+N+" has current balance "+bal;
		}
		return Des;
	}
	double getBalance() {
		double balance =0.0;
		balance = this.bal;
		return balance;
		
	}
	
	void setBalance(double s) {
		this.bal=s;
	}
	
	void deposit(double dep){
		if (t=='d') {
		this.bal=this.bal+dep;
		}
		else {
			this.bal =this.bal+(0.9*dep);
		}
	}
	void withdraw(double dep) {
		
		if (t=='d') {
			this.bal=this.bal-dep;
			}
			else {
				this.bal =this.bal-(dep+(0.1*dep));
			}
	}
	
	void transferTo(Account Trf, double am) {
		
		if ((Trf.t=='d')&&(t=='d')) {
			Trf.bal=Trf.bal+am;
			this.bal=this.bal-am;
			}
			else if ((Trf.t=='i')&&(t=='i')) {
				Trf.bal=Trf.bal+(0.9*am);
				this.bal =this.bal-(am+(0.1*am));
			}
			else if ((Trf.t=='i')&&(t=='d')) {
				Trf.bal=Trf.bal+(0.9*am);
				this.bal=this.bal-am;
			}
			else {
				Trf.bal=Trf.bal+am;
				this.bal =this.bal-(am+(0.1*am));
			}
		
		
	}
	

}
