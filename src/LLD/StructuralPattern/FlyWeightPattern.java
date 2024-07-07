package LLD.StructuralPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Flyweight Interface
interface Character {
    void display(int fontSize);
}

// Concrete Flyweight
class ConcreteCharacter implements Character {
    private char symbol;
    private String fontFamily;

    public ConcreteCharacter(char symbol, String fontFamily) {
        this.symbol = symbol;
        this.fontFamily = fontFamily;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Character: " + symbol + ", Font family: " + fontFamily + ", Font size: " + fontSize);
    }
}

// Flyweight Factory
class CharacterFactory {
    private Map<CharacterKey, Character> characters = new HashMap<>();

    public Character getCharacter(char symbol, String fontFamily) {
        CharacterKey key = new CharacterKey(symbol, fontFamily);
        Character character = characters.get(key);
        if (character == null) {
            character = new ConcreteCharacter(symbol, fontFamily);
            characters.put(key, character);
        }
        return character;
    }

    private static class CharacterKey {
        private char symbol;
        private String fontFamily;

        public CharacterKey(char symbol, String fontFamily) {
            this.symbol = symbol;
            this.fontFamily = fontFamily;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterKey that = (CharacterKey) o;
            return symbol == that.symbol && fontFamily.equals(that.fontFamily);
        }

        @Override
        public int hashCode() {
            return Objects.hash(symbol, fontFamily);
        }
    }
}

// Client
public class FlyWeightPattern {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        Character a1 = factory.getCharacter('a', "Arial");
        Character a2 = factory.getCharacter('a', "Arial");
        Character b = factory.getCharacter('b', "Arial");

        a1.display(12);
        a2.display(14);
        b.display(12);

        System.out.println(a1 == a2); // true
    }
}
