package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 1. 랜덤으로 0~9까지의 3자리 숫자 생성
        String randomNumber = Randoms.pickNumberInRange(100, 999) + "";

        // 2. 3자리 숫자 유저로부터 입력 받기
        // 3. 숫자가 랜덤 숫자와 정확히 맞았는지 체크
        // 4. 스트라이크와 볼 계산
        // 5. 스트라이크, 볼, 낫싱 등의 결과 출력
        // 6. 게임이 끝난 후 새 게임 여부 확인
        // 7. IllegalArgumentException 예외처리
    }
}
