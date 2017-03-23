package com.craigstockton.teksystems.state;

import com.craigstockton.teksystems.state.search.StateSearch;

public class StateSearchApp {
    public static void main(String... aArgs) {
        while (true) {
            System.out.print("\n\nEnter State name or abbreviation ['q' to quit]:");
            String input = System.console().readLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }
            System.out.print(StateSearch.getInstance(input).query().getMessage());
        }
    }
}
