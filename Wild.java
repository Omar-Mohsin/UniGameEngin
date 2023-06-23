 enum Wild{
            wild, wild_draw_four;
            private static Wild[] wilds = Wild.values();

            public static Wild getWild(int i) {
                return wilds[i];
            }
        }