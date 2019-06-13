import java.io.*;
import java.util.Random;

public class OutputSeri {
    public static void main(String[] args) {
        CharacterClass characterClass = new CharacterClass(1, 2, 3);
        characterClass.Viewstats();
        characterClass.Serialization(characterClass);
        characterClass.Deserialization();
    }
}

class CharacterClass implements Serializable {

    private int strength, intelligence, agility, hp;
    private transient int vitality;
    private Random generator = new Random();
    static int counter = 0;

    static {
        counter++;
    }

    CharacterClass(int strength, int intelligence, int agility) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.hp = generator.nextInt(100) + 10;
        this.vitality = 10;
    }

    public void Viewstats() {

        System.out.println("Siła: " + strength);
        System.out.println("Inteligencja: " + intelligence);
        System.out.println("Zręczność: " + agility);
        System.out.println("Hp: " + hp);
        System.out.println("Witalność: " + vitality);
        System.out.println("Liczba obiektów: " + counter + "\n\n\n");
    }

    public void Serialization(CharacterClass characterClass) {
        ObjectOutputStream objectOutputStream;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("CharacterStats.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(characterClass);
            objectOutputStream.close();
            System.out.println("Operacja zakończona pomyślnie");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Deserialization() {
        try {
            FileInputStream fileInputStream = new FileInputStream("CharacterStats.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CharacterClass characterClass = (CharacterClass) objectInputStream.readObject();
            characterClass.Viewstats();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}