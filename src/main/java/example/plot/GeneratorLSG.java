package example.plot;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorLSG implements Generator{
    private final int a, c, m;
    private int next;
    List<Integer> list = new ArrayList<>();

    public GeneratorLSG() {
        a = 9301;
        c = 49297;
        m = 233280;
    }

    @Override
    public int setRandom(int min, int max) {
        next = Math.abs((next * a + c) % m);
        return Math.abs(min + next % (max - min));
    }


    @Override
    public List<Integer> generate(int symbols) throws UnsupportedEncodingException {
        next = (int) System.currentTimeMillis();

        for (int i = 0; i < symbols; i++) {
            final int number = setRandom(0, 32);
            list.add(number);
        }
        System.out.println(list);
        return list;
    }

}