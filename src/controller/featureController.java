package controller;

import com.shinhands.service.AccountService;
import com.shinhands.view.AccountView;

public class featureController {
    private final AccountService service = new AccountService();
    private final featureView view = new featureView();

    public void run() {
        while (true) {
            int menu = view.showMenu();
            
            // 💡 실습 팁: 이 switch-case문 내부를 팀원들이 각자의 브랜치에서 분담하여 구현하세요.
            // 겹치는 라인을 수정하게 되므로 'git merge' 혹은 'git pull' 시 충돌이 터집니다.
            switch (menu) {
                case 1: // 팀원 A 작업 영역 (수입)
                    int depAmount = view.inputAmount("수입");
                    String depDesc = view.inputDescription();
                    service.deposit(depAmount, depDesc);
                    view.printMessage("수입이 성공적으로 등록되었습니다.");
                    break;
                    
                case 2: // 팀원 B 작업 영역 (지출)
                    int witAmount = view.inputAmount("지출");
                    String witDesc = view.inputDescription();
                    if (service.withdraw(witAmount, witDesc)) {
                        view.printMessage("지출이 성공적으로 등록되었습니다.");
                    } else {
                        view.printMessage("잔액이 부족하여 지출을 등록할 수 없습니다.");
                    }
                    break;
                    
                case 3: // 팀원 C 작업 영역 (조회)
                    view.printHistories(service.getHistories(), service.getAccountSummary());
                    break;
                    
                case 4:
                    view.printMessage("시스템을 종료합니다. 이용해 주셔서 감사합니다.");
                    return;
                    
                default:
                    view.printMessage("잘못된 메뉴 선택입니다. 다시 선택해 주세요.");
            }
        }
    }
}
