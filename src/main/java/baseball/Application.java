package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        final int LIMIT_DIGIT = 3; // 자리 수 제한

        // 1. 랜덤으로 0~9까지의 3자리 숫자 생성
        String randomNumber = Randoms.pickNumberInRange(100, 999) + "";

        // 2. 3자리 숫자 유저로부터 입력 받기
        System.out.println("숫자를 입력해 주세요 : ");
        String userInput = Console.readLine();

        // 3. 숫자가 랜덤 숫자와 정확히 맞았는지 체크
        if (randomNumber.equals(userInput)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println("틀렸습니다. 다시 시도하세요.");
        }
        // 4. 스트라이크와 볼 계산
        int strikeCount = 0;
        int ballCount = 0;
        
        for (int i = 0; i < LIMIT_DIGIT; i++) {
            if (userInput.charAt(i) == randomNumber.charAt(i)) {
                strikeCount++;
            } else if (randomNumber.indexOf(userInput.charAt(i)) != -1) {
                ballCount++;
            }
        }
        // 결과 출력 (임시)
        System.out.println(strikeCount + " 스트라이크, " + ballCount + " 볼");

        // 5. 스트라이크, 볼, 낫싱 등의 결과 출력
        // 6. 게임이 끝난 후 새 게임 여부 확인
        // 7. IllegalArgumentException 예외처리
    }
}
