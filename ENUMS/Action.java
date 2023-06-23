package ENUMS;

public enum Action{
            skip , reverse , draw_two;
            private static Action[] actions = Action.values();
            public static Action getActions(int i) {
                return actions[i];
            }
}