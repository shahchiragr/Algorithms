package com.example.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chirag on 9/10/16.
 *
 * Find maximum no of hours the conference room is booked
 */
public class CalendarSlot {
    class Slot {
        int startTime;
        int endTime;
        boolean visited = false;

        public Slot(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

        public void calculateSum(List<Slot> slotList) {
            for (int i=0; i < slotList.size(); i++) {
                Slot slot = slotList.get(i);
                if (slot.visited)
                    continue;

                int startTime = slot.startTime;
                int endTime = slot.endTime;

                for (int j=i+1; j < slotList.size(); j++) {
                    Slot nextSlot = slotList.get(j);

                    if (slot.endTime < nextSlot.startTime) {
                        break;
                    } else  {
                        nextSlot.visited = true;
                        if (slot.endTime <= nextSlot.endTime) {
                            endTime = nextSlot.endTime;
                        }
                    }
                }//for
            System.out.println("Current Slot " + startTime + ":" + endTime + ", hours : " + (endTime -startTime));

            }//for

        }

        public  void  runwitTestData1() {
            List<Slot> slotList = new ArrayList<Slot>();
            slotList.add(new Slot(1,2));
            slotList.add(new Slot(3,5));
            slotList.add(new Slot(4,6));
            slotList.add(new Slot(5,7));
            calculateSum(slotList);
        }

        public  void  runwitTestData2() {
            List<Slot> slotList = new ArrayList<Slot>();
            slotList.add(new Slot(1,2));
            slotList.add(new Slot(2,3));
            slotList.add(new Slot(3,6));
            slotList.add(new Slot(6,7));
            calculateSum(slotList);
        }

        public static void main(String args[]) {
            CalendarSlot calendarSlot = new CalendarSlot();
            calendarSlot.runwitTestData1();
            calendarSlot.runwitTestData2();
        }
}
