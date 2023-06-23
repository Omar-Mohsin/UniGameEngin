enum Color {
            red, blue , green, yellow;

            private static Color[] colors = Color.values();

            public static Color getColors(int i) {
                return colors[i];
            }

        }