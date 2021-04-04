package util;

import mainFunction.MainFunction;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class CsvGenerator {

    private String fileName;
    private MainFunction mainFunction;

    public CsvGenerator(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setMainFunction(MainFunction mainFunction) {
        this.mainFunction = mainFunction;
    }


    public void generate(double from, double to, double step) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            StringBuilder sb = new StringBuilder();
            double curr = from;
            sb.append("x, y, sin(x), cos(x), tan(x), sec(x), cosec(x), ln(x), log2(x), log3(x), log5(x), log10(x)");
            sb.append("\n");
            do {
                sb.append(curr)
                        .append(", ")
                        .append(mainFunction.apply(curr))
                        .append(", ")
                        .append(mainFunction.getSin().apply(curr))
                        .append(", ")
                        .append(mainFunction.getCos().apply(curr))
                        .append(", ")
                        .append(mainFunction.getTan().apply(curr))
                        .append(", ")
                        .append(mainFunction.getCoSec().apply(curr))
                        .append(", ")
                        .append(mainFunction.getSec().apply(curr))
                        .append(", ")
                        .append(mainFunction.getLn().apply(curr))
                        .append(", ")
                        .append(mainFunction.getLog().apply(curr, 2))
                        .append(", ")
                        .append(mainFunction.getLog().apply(curr, 3))
                        .append(", ")
                        .append(mainFunction.getLog().apply(curr, 5))
                        .append(", ")
                        .append(mainFunction.getLog().apply(curr, 10))
                        .append("\n");
                curr += step;
            } while (Double.compare(curr, to) < 0);

            printWriter.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
