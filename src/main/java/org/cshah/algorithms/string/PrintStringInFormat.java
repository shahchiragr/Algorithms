package org.cshah.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class PrintStringInFormat {

    public static void printInFormat(String document, int size) {
     List<String> dataList = new ArrayList<String>();
     int start =0;

      while (start < document.length()) {
         int nextPosition = addIntoListAndReturnNextPosition(document,start, size, dataList);
         start = nextPosition;
      }
      for (String s : dataList) {
          System.out.println(s);
      }
    }

    public static int addIntoListAndReturnNextPosition(String document, int startingPoint, int totalSize, List<String> data) {
        int endPosition =(document.length()-startingPoint);
        String tokenizedString = document.substring(startingPoint, document.length()-startingPoint >=totalSize ? totalSize+startingPoint : document.length());
        int endIndex = tokenizedString.length()+startingPoint;

        if (endPosition > totalSize && document.charAt(startingPoint+totalSize) != ' ') {
            int backPointer = startingPoint+totalSize;
            while (document.charAt(backPointer) != ' ') {
                tokenizedString = tokenizedString.substring(0, tokenizedString.length()-1);
                backPointer--;
            }
            endIndex = backPointer+1;

        }

        data.add(tokenizedString);

        return endIndex;

    }

    public static void main(String args[]) {
        String data = "this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.this is test data.";
        PrintStringInFormat.printInFormat(data,80);
        data = "Crater is a small constellation in the southern celestial hemisphere, one of 48 listed by the second-century astronomer Ptolemy. It depicts a krater, a type of cup used by the Greeks to water down wine, perched on the back of Hydra, the water snake, to its south and west. It has been associated with the mythological god Apollo. It is also bordered by Leo and Virgo to the north, Corvus to the east, and Sextans to the northwest. There is no star brighter than third magnitude in the constellation. Its two brightest stars, Delta Crateris of magnitude 3.56 and Alpha Crateris of magnitude 4.07, are ageing orange giant stars that are cooler and larger than the Sun. Beta Crateris is a binary star system composed of a white giant star and a white dwarf. Seven star systems have been found to host planets. A few galaxies, including Crater 2 and NGC 3981, and a quasar lie within the borders of the constellation.";
        PrintStringInFormat.printInFormat(data,80);
    }
}
