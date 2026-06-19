package dto;

//AccountSummaryDTO.java (현재 잔액과 총 내역 수를 화면에 전달할 때 사용)
public class AccountSummaryDTO {
 private final int balance;
 private final int historyCount;

 public AccountSummaryDTO(int balance, int historyCount) {
     this.balance = balance;
     this.historyCount = historyCount;
 }

 public int getBalance() { return balance; }
 public int getHistoryCount() { return historyCount; }
}