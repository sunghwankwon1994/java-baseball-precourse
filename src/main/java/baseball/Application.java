package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int newGameOption = 1; // 새 게임 옵션
        final int LIMIT_DIGIT = 3; // 자리 수 제한

        while (newGameOption == 1) {
            // 1. 랜덤으로 0~9까지의 3자리 숫자 생성
            Set<Integer> uniqueNumbers = new HashSet<>();
            StringBuilder randomNumber = new StringBuilder();
            while (uniqueNumbers.size() < LIMIT_DIGIT) {
                int randomDigit = Randoms.pickNumberInRange(1, 9);
                if (uniqueNumbers.add(randomDigit)) {
                    randomNumber.append(randomDigit);
                }
            }
            //System.out.println(randomNumber);
            while (true) {
                // 2. 3자리 숫자 유저로부터 입력 받기
                System.out.print("숫자를 입력해 주세요 : ");
                String userInput = Console.readLine();

                // 7. IllegalArgumentException 예외처리 (3자리 숫자가 아닌 경우)
                if (userInput.length() != LIMIT_DIGIT || !userInput.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력해야 합니다.");
                }
                // 3. 숫자가 랜덤 숫자와 정확히 맞았는지 체크
                if (randomNumber.toString().equals(userInput)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                // 4. 스트라이크와 볼 계산
                int strikeCount = 0;
                int ballCount = 0;

                for (int i = 0; i < LIMIT_DIGIT; i++) {
                    if (userInput.charAt(i) == randomNumber.charAt(i)) {
                        strikeCount++;
                    } else if (randomNumber.toString().contains(String.valueOf(userInput.charAt(i)))) {
                        ballCount++;
                    }
                }

                // 5. 스트라이크, 볼, 낫싱 등의 결과 출력
                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ballCount > 0) {
                        System.out.print(ballCount + " 볼 ");
                    }
                    if (strikeCount > 0) {
                        System.out.print(strikeCount + " 스트라이크");
                    }
                    System.out.println();
                }
            }

            // 6. 게임이 끝난 후 새 게임 여부 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            newGameOption = Integer.parseInt(Console.readLine());
            // 7. IllegalArgumentException 예외 처리: 1 또는 2가 아닌 값을 입력할 때
            if (newGameOption != 1 && newGameOption != 2) {
                throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력해야 합니다.");
            }

        }

    }
}
