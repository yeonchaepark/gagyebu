package dao;


import java.util.ArrayList;
import java.util.List;

import vo.AccountHistoryVO;

public class AccountDAO {
    // 가상의 데이터베이스 역할 (메모리 저장)
    private static final List<AccountHistoryVO> database = new ArrayList<>();
    private static int balance = 0;

    public void insertHistory(AccountHistoryVO history) {
        database.add(history);
        if (history.getType().equals("INCOME")) {
            balance += history.getAmount();
        } else if (history.getType().equals("EXPENSE")) {
            balance -= history.getAmount();
        }
    }

    public List<AccountHistoryVO> selectAllHistories() {
        return new ArrayList<>(database);
    }

    public int selectBalance() {
        return balance;
    }
}