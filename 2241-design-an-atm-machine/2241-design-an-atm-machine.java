class ATM {

    private int[] banknotesCount;
    private final int[] banknotesValue;

    public ATM() {
        banknotesCount = new int[5];
        banknotesValue = new int[] {20, 50, 100, 200, 500};
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            this.banknotesCount[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] updatedBanknotesCount = this.banknotesCount.clone();
        int[] result = new int[5];

        int remainingAmount = amount;
        int banknotes = 0;

        for (int i = result.length - 1; i >= 0; i--) {
            if (this.banknotesCount[i] == 0) {
                continue;
            }

            banknotes = Math.min(remainingAmount / this.banknotesValue[i], this.banknotesCount[i]);
            result[i] = banknotes;

            if (banknotes != 0) {
                remainingAmount -= banknotes * this.banknotesValue[i];
                updatedBanknotesCount[i] -= banknotes;
            }
        }

        if (remainingAmount == 0) {
            this.banknotesCount = updatedBanknotesCount;
            return result;
        }

        return new int[] {-1};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */