package com.tim.hundreds

class ControllerPaginationUtil {

    public static paginateList(ArrayList list, params) {
        def max = params?.max?.toInteger() ?: 10
        def offset = params?.offset?.toInteger() ?: 0

        int total = list.size()
        int upperLimit = total>0 ? findUpperIndex(offset, max, total) : 0
        List filteredlist = total>0 ? list.getAt(offset..upperLimit) : []

        filteredlist
    }

    private static int findUpperIndex(int offset, int max, int total) {
        max = offset + max - 1
        if (max >= total) {
          max -= max - total + 1
        }
        max
    }

}