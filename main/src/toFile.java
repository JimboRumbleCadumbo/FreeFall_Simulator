import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class toFile {
    public void writeToCSV(ArrayList<calculation> usrStats) throws FileNotFoundException {
        File usrCSV = new File("Result.csv");
        PrintWriter output = new PrintWriter(usrCSV);
        output.printf("%s    , %s  , %s\n", "Time", "Height", "Velocity"); // write stats to file
        for (calculation stat : usrStats) {
            output.printf("%-8.2f, %-8.2f, %-8.2f\n", stat.getTime(), stat.getCurHeight(), stat.getVelocity()); // write stats to file
            System.out.printf("Time: %-8.2f(s), Height: %-8.2f(m), Velocity: %-8.2f(m/s)\n", stat.getTime(), stat.getCurHeight(), stat.getVelocity()); // console output for debug
        }

        output.close();
    }
}
