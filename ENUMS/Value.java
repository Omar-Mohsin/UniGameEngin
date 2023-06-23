package ENUMS;

public enum Value {
            zero, one, two, three, four, five, six, seven, eight, nine;

            private static Value[] values = Value.values();

            public static Value getValues(int i) {
                return values[i];
            }
        }