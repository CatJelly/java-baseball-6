package baseball;

public class GameResult {
    private int strike;
    private int ball;
    private int maxSize;

    public GameResult(int strike, int ball, int maxSize) {
        this.strike = strike;
        this.ball = ball;
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크 ");
        }

        return sb.toString();
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isStrikeOut() {
        return strike == maxSize;
    }
}

