package org.cshah.algorithms.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PickUpDropOffCombination {
    public  void checkValidRec(List<String> routes, Set<String> visitedMap, List<String> results, Set<List<String>> finalSet, int nPickup, int nDelivery ) {

        if (nPickup ==0 && nDelivery ==0) {
            if (! finalSet.contains(results)) {
                finalSet.add(results);
                for (String s : results) {
                    System.out.print(s + ",");
                }
                System.out.println();
            }
        }

        if (nPickup > nDelivery)
            return;

        //add base condition
        for (String routeId : routes) {

            if (visitedMap.contains(routeId) ||  (isPickUpDoneBeforeDropOff(routeId, results)) ) {
                continue;
            }

            visitedMap.add(routeId);
            results.add(routeId);

            if (nPickup > 0)
                checkValidRec(routes, visitedMap, results, finalSet,nPickup-1, nDelivery);

            if (nDelivery >0)
                checkValidRec(routes, visitedMap, results, finalSet,nPickup, nDelivery-1);

            results.remove(routeId);
            visitedMap.remove(routeId);
        }
    }

    public boolean isPickUpDoneBeforeDropOff(String routeId, List<String> results) {
        return isDropOff(routeId) && !results.contains("p" + routeId.substring(1));
    }

    public boolean isValidRoute(List<String> route) {
        if (route == null || route.isEmpty())
            return  true;

        Map<String, Boolean> routeMap = new HashMap<String, Boolean>();
        for (String routeId : route) {
            if (isPickup(routeId)) {
                if (routeMap.containsKey(getRouteUUID(routeId)))
                    return  false;
                routeMap.put(getRouteUUID(routeId), false);
            }

            if (!isPickup(routeId) ) {
                if (routeMap.containsKey(getRouteUUID(routeId)) && routeMap.get(getRouteUUID(routeId)) == false) {
                    routeMap.put(getRouteUUID(routeId), true);
                } else {
                    return false;
                }
            }
        }

        Iterator<Map.Entry<String, Boolean>> iterator  = routeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() == false)
                return  false;
        }

        return  true;
    }

    private boolean isDropOff(String routeId) {
        return  !isPickup(routeId);
    }

    private boolean isPickup(String routeId) {
        return  routeId.charAt(0) == 'p';
    }

    private String getRouteUUID(String routeId) {
        return routeId.substring(1);
    }

    @Test
    public void testRoute() {
        List<String> routeList = new ArrayList<String>();
        routeList.add("p1");
        routeList.add("d1");
        boolean result = isValidRoute(routeList);
        Assert.assertEquals(true,result);
    }


    @Test
    public void testRouteWithMultipleDelivery() {
        List<String> routeList = new ArrayList<String>();
        routeList.add("p1");
        routeList.add("p2");
        routeList.add("d2");
        routeList.add("d1");
        boolean result = isValidRoute(routeList);
        Assert.assertEquals(true,result);
    }


    @Test
    public void testRouteWithMultipleDeliveryFalse() {
        List<String> routeList = new ArrayList<String>();
        routeList.add("p1");
        routeList.add("d2");
        routeList.add("p2");
        routeList.add("d1");
        boolean result = isValidRoute(routeList);
        Assert.assertEquals(false,result);
    }

    @Test
    public void testRouteWithMultipleDuplicatePickupFalse() {
        List<String> routeList = new ArrayList<String>();
        routeList.add("p1");
        routeList.add("p1");
        routeList.add("d1");
        boolean result = isValidRoute(routeList);
        Assert.assertEquals(false,result);
    }


    @Test
    public void testRouteWithMultiplePickupFalse() {
        List<String> routeList = new ArrayList<String>();
        routeList.add("p1");
        routeList.add("p2");
        routeList.add("d1");
        boolean result = isValidRoute(routeList);
        Assert.assertEquals(false,result);
    }
    public static void main(String[] args) {
        PickUpDropOffCombination solution = new PickUpDropOffCombination();
        List<String> routes = new ArrayList<String>();
        int count = 4;

        for (int i=1; i<= count; i++) {
            routes.add("p" + i);
        }

        for (int i=1; i<= count; i++) {
            routes.add("d" + i);
        }

        Set<List<String>> finalSet = new HashSet<List<String>>();
        solution.checkValidRec(routes,new HashSet<String>(), new ArrayList<String>(),finalSet,count,count);
    }
}
