package TP5;

public class TP5 {
	 
    public static Integer calc(Integer nb) throws Exception {
        if (nb > 12) {
            throw new Exception();
        }
        if (nb == 0) {
            return 1;
        } else {
            return nb * calc(Math.abs(nb - 1));
        }
    }
}
