class Bank {

    private final long[] balanceAccounts;

    public Bank(long[] balance) {
        balanceAccounts = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account2) && withdraw(account1, money)) {
            deposit(account2, money);
            return true;
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            balanceAccounts[account - 1] += money;
            return true;
        }

        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if (isValidAccount(account) && hasEnoughMoney(account, money)) {
            balanceAccounts[account - 1] -= money;
            return true;
        }

        return false;
    }

    private boolean isValidAccount(int account) {
        return account <= balanceAccounts.length;
    }

    private boolean hasEnoughMoney(int account, long money) {
        return balanceAccounts[account - 1] >= money;
    }

}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */