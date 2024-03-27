import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;

public class calculation {
    public double usrHeight;
    public double curHeight;
    public double finalTime;
    public double velocity;
    public double time;

    public calculation(){

    }

    public calculation(double curHeight,double time, double velocity){
        this.curHeight = curHeight;
        this.velocity = velocity;
        this.time = time;
    }

    public void startCalculating() throws FileNotFoundException {
        ArrayList<calculation> stats = new ArrayList<>();
        System.out.println("usrHeight: " + usrHeight); // console output for debug

        //height calculation
        calcLandingTime();
        calculation temp = new calculation(usrHeight, time, 0); // starting height
        stats.add(temp);
        for(time = 1; time < Math.floor(finalTime); time+=1){
            calcCurrentHeight();
            calcCurrentVelocity();
            temp = new calculation(curHeight, time, velocity);
            stats.add(temp);
        }
        temp = new calculation(0,finalTime,0);
        stats.add(temp);

        toFile writer = new toFile();
        writer.writeToCSV(stats);
    }

    private void calcLandingTime(){
        finalTime = Math.sqrt(2*usrHeight/9.8);
    }

    private void calcCurrentHeight(){
        curHeight = (usrHeight - ((0.5) * 9.8 * time * time));
    }

    private void calcCurrentVelocity(){
        velocity = 9.8 * time;
    }

    public void setUsrHeight(double usrInput){
        usrHeight = usrInput;
    }

    public double getCurHeight(){
        return curHeight;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getTime(){
        return time;
    }
}

