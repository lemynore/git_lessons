public class Main {
    public static void main(String[] args) {
        // 1
        ThreeWords tw = new ThreeWords();
        tw.printThreeWords();

        // 2
        SumSignChecker ssc = new SumSignChecker();
        ssc.checkSumSign();

        // 3
        ColorPrinter cp = new ColorPrinter();
        cp.printColor();

        // 4
        NumberComparer nc = new NumberComparer();
        nc.compareNumbers();

        // 5
        SumRangeChecker src = new SumRangeChecker();
        src.checkSumInRange();

        // 6
        NumberSignChecker nsc = new NumberSignChecker();
        nsc.checkPositiveOrNegative();

        // 7
        NegativeChecker negc = new NegativeChecker();
        negc.checkNegative();

        // 8
        StringPrinter sp = new StringPrinter();
        sp.printStringMultipleTimes();

        // 9
        LeapYearChecker lyc = new LeapYearChecker();
        lyc.checkLeapYear();

        // 10
        ArrayInverter ai = new ArrayInverter();
        ai.invertArray();

        // 11
        ArrayFiller af = new ArrayFiller();
        af.fillArray();

        // 12
        ArrayMultiplier am = new ArrayMultiplier();
        am.doubleIfLessThanSix();

        // 13
        MatrixFiller mf = new MatrixFiller();
        mf.fillDiagonal();

        // 14
        CustomArrayCreator cac = new CustomArrayCreator();
        cac.createArray();
    }
}