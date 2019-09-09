package org.cshah.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;

        List<StringBuffer> list = new ArrayList<StringBuffer>(numRows);
          for (int i=0; i <numRows;i++) {
              list.add(i, new StringBuffer());

          }

        int start =0;
        int end = s.length();
        int totalSpace = numRows-1;
        int endPosition = 0;

        while (start < end) {
            int oneCycleTotalRecord = numRows*2-2;

            for (int i = 0; i < numRows ; i++) {
                    if (start >= end)
                        break;

                    list.get(i).append(s.charAt(start));

                    if (i == 0 || i == numRows-1) {
                        for (int space = 1; space <= totalSpace ; space++) {
                            list.get(i).append(" ");
                        }
                    } else {
                        for (int space = 1; space <= totalSpace - i; space++) {
                            list.get(i).append(" ");
                        }
                        int nextPosition = start + oneCycleTotalRecord  ;

                        if (nextPosition < end) {
                            list.get(i).append(s.charAt(nextPosition));
                            if (nextPosition > endPosition) {
                                endPosition = nextPosition;
                            }

                            for (int nextSpace=totalSpace-i+1; nextSpace < totalSpace;nextSpace++) {
                                list.get(i).append(" ");
                            }
                        }

                    }

                    start++;
                    oneCycleTotalRecord-=2;
                }


            if (endPosition >= start) {
                start = endPosition+1;
            }

        }

        StringBuffer sb = new StringBuffer();
        for (StringBuffer sbList : list) {
            sb.append(sbList.toString()).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(zigZag.convert(s,3));

        System.out.println(zigZag.convert(s,4));

        System.out.println(zigZag.convert(s,5));

        System.out.println(zigZag.convert(s,6));

        System.out.println(zigZag.convert(s,7));

        s = "yjsolwkzhdmruqozbamspjuoescxoftmqlaejlfroriljykmawhrgdhmvmljrhvjsynclvvbmfmyfwkfttybwfpsradkhbwczlgkgbltgytlwfsrzqsvxjppmtbvuxxvjffpgskosdbpjtgilbflkvawodskbrfmxkbfemuxrvmarsketqpelrcbxulyoqklcnqgbkdtirvbkghfyzllsompkznyrzlvncboohhyyfbkljqlkdwcrkselfechqxwuakkjujizmumxmzhqxkjhenuluyskxogxbqhx";
        System.out.println(zigZag.convert(s,16));
    }
}
