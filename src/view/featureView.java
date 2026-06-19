package view;

import com.shinhands.dto.AccountSummaryDTO;
import com.shinhands.model.AccountHistoryVO;
import java.util.List;
import java.util.Scanner;

public class AccountView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n======= 신한 DS 은행 계좌 관리 System =======");
        System.out.println("1. 수입 입력");
        System.out.println("2. 지출 입력");
        System.out.println("3. 전체 내역 및 잔액 조회");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택: ");
        return scanner.nextInt();
    }

    public int inputAmount(String text) {
        System.out.print(text + " 금액을 입력하세요: ");
        return scanner.nextInt();
    }

    public String inputDescription() {
        System.out.print("내역 설명을 입력하세요: ");
        scanner.nextLine(); // 버퍼 비우기
        return scanner.nextLine();
    }

    public void printHistories(List<AccountHistoryVO> histories, AccountSummaryDTO summary) {
        System.out.println("\n--- [ 거래 내역 목록 ] ---");
        for (AccountHistoryVO h : histories) {
            System.out.printf("[%s] %s : %,d원\n", h.getType(), h.getDescription(), h.getAmount());
        }
        System.out.println("------------------------");
        System.out.printf("현재 잔액: %,d원 (총 %d건)\n", summary.getBalance(), summary.getHistoryCount());
    }

    public void printMessage(String message) {
        System.out.println("[알림] " + message);
    }
}
