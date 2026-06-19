package service;

import java.util.List;

public class AccountService {
    private final AccountDAO accountDAO = new AccountDAO();

    // 수입 등록 비즈니스 로직
    public void deposit(int amount, String description) {
        AccountHistoryVO history = new AccountHistoryVO("수입", amount, description);
        accountDAO.insertHistory(history);
    }

    // 지출 등록 비즈니스 로직 (잔액 검증 로직 포함)
    public boolean withdraw(int amount, String description) {
        if (accountDAO.selectBalance() < amount) {
            return false; // 잔액 부족
        }
        AccountHistoryVO history = new AccountHistoryVO("지출", amount, description);
        accountDAO.insertHistory(history);
        return true;
    }

    // 전체 내역 조회
    public List<AccountHistoryVO> getHistories() {
        return accountDAO.selectAllHistories();
    }

    // 계좌 요약 정보 DTO 생성 및 반환
    public AccountSummaryDTO getAccountSummary() {
        return new AccountSummaryDTO(accountDAO.selectBalance(), accountDAO.selectAllHistories().size());
    }
}