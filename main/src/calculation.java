import java.lang.Math;

public class calculation {
    public double usrHeight;
    public double curHeight;
    public double finalTime;
    public int time;

    public void startCalculating(){
        CalcLandingTime();
        for(time = 0; time < Math.floor(finalTime); time++){
            getCurrentHeight();
            System.out.println("usrHeight: " + usrHeight);
            System.out.println("curHeight: " + curHeight);
            System.out.println("time: " + time);

        }
        System.out.println("final time: " + finalTime);
    }

    private void CalcLandingTime(){
        finalTime = Math.sqrt(2*usrHeight/9.8);
    }

    private void getCurrentHeight(){
        curHeight = (usrHeight - ((0.5) * 9.8 * time * time));
    }

    public void setUsrHeight(double usrInput){
        usrHeight = usrInput;
    }

}
