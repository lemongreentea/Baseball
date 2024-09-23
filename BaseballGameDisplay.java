public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        if(strike==0 && ball==0){
            System.out.println("아웃");
        }else{
            System.out.println("현재 스트라이크:"+strike+", 현재 볼:"+ball);
        }
    }
}
