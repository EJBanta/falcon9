package projects;
import java.util.*;

public class RandomLatin {
    public static void main(String[] args) {
        RandomLatin gerald = new RandomLatin();
        ArrayList<String> a = gerald.parseQuizlet("canis, dog; est, he/she/it is; filius, son; hortus, garden; in, in/on; laborat, he/she/it works; mater, mother; pater, father; sedet, he/she/it sits; servus, slave; via, street; coquus, cook; atrium, atrium/reception hall; cubiculum, small room/bedroom; culina, kitchen; tablinum, a study; triclinium, dining room; legit, he/she/it reads; circumspectat, he/she/it looks around; mēnsā, table; salit, he/she it jumps; stat, he/she/it stands; stertit, he/she/it snores; lātrat, he/she/it barks; surgit, he/she/it gets up; īrātus, angry; pestis, pest/rascal; furcifer, scoundrel/crook; clāmat, he/she/it shouts; exit, he/she/it goes out;");
        ArrayList<String> b = gerald.parseQuizlet("amicus, friend; ancilla, slave girl; cena, dinner; cibus, food; dominus, master; dormit, sleeps; gustat, tastes; intrat, enters; laetus, happy; laudat, praises; mercator, merchant; quoque, also; salutat, greets; mensa, table; toga, toga; tunica, tunic; vīsitat, visits; vīlla, house; pecunia, money; numerat, counts; argentārius, banker; respondet, replies; lectus, couch; recumbit, reclines; cantat, sings; coquit, cooks; pāvō, peacock; audit, hears; nōn, not; cēna, dinner; exspectat, waits for; vituperat, curses; portat, carries; vīnum, wine; optimus, best; suāviter, sweetly; dēlectat, pleases; mox, soon; videt, sees; cōnsūmit, eats; bibit, drinks; magnificus, magnificent; cēnat, dines; spectat, watches; laetissimus, very happy;");
        ArrayList<String> c = gerald.parseQuizlet("ad, to/toward; bibit, drinks/is drinking; circumspectat, looks around/is looking around; clamat, shouts/is shouting; ecce!, look! see! behold!; et, and; exit, leaves/goes out; expectat, is waiting for/waits for; forum, forum/business center; ianua, door; iratus, angry; leo, lion; magnus, large/great/big; navis, ship; non, not; portat, carries/is carrying; respondet, replies/is replying; ridet, smiles/laughs; salve!, hello! greetings!; surgit, gets up/rises; taberna, shop/inn/store; videt, sees/is seeing; villa, house/farmhouse; vinum, wine; negotium agit, does business; artifex, artist; ambulat, walks; tōnsor, barber; vēnālīcius, slave dealer; venit, comes; pulsat, hits/punches/whacks; aperit, opens; vocat, calls; ducīt, leads; pictūra, picture; pingit, paints; ferōciter, fiercely; petit, attacks/seeks/heads for; fūstis, club/stick; tenet, holds; verberat, strikes/beats; fortis, brave/strong; revenit, comes back/returns; inquit, says; occupātus, busy; senex, old man; sella, chair; novāculum, razor; barbam, beard; tondet, shaves/trims; intentē, intently; poēta, poet; versus, verse; recitat, recites; scurrīlis, rude/obscene; rīdet, laughs/smiles; sed, but; secat, cuts; multus, much/many; sanguis, blood; fluit, flows; ē/ex, out of/from; portus, harbor; prope, near; quaerit, searches for/looks for; contentus, satisfied; emit, buy; pulchra, beautiful/handsome/fair; discit, learns; lingua, language; doctus, skillful/educated; satis, enough;");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public RandomLatin() {
        
    }

    public ArrayList<String> parseQuizlet(String str) {
        String word = "";
        String str2 = "";
        int semiColons = 0;
        int j = 0;
        String[] other = {"in", "iratus", "laetus", "quoque", "non", "optimus", "suaviter", "mox", "magnificus", "laetissimus", "ad", "magnus", "ferociter", "fortis", "occupatus", "intente", "scurrilis", "sed", "multus", "e/ex", "prope", "contentus", "pulchra", "doctus", "satis"};
        ArrayList<String> words = new ArrayList<String>();

        // Replacing macron chars with normal english versions
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\u0101') {
                str2 += "a";
            } else if (str.charAt(i) == '\u0113') {
                str2 += "e";
            } else if (str.charAt(i) == '\u012B') {
                str2 += "i";
            } else if (str.charAt(i) == '\u014D') {
                str2 += "o";
            } else if (str.charAt(i) == '\u016B') {
                str2 += "u";
            } else {
                str2 += str.charAt(i);
            }
        }
        str = str2;

        // Getting semicolon number
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ';') {
                semiColons += 1;
            }
        }

        // Removing english words and turning String into ArrayList
        for (int i = 0; i < semiColons; i++) {
            word = "";
            while (!(str.charAt(j) == ',')) {
                word += str.charAt(j);
                j++;
            }
            words.add(word);
            while (!(str.charAt(j) == ';')) {
                j++;
            }
            j += 2;
        }

        // Removing verbs and interjections
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
            if (words.get(i).charAt(words.get(i).length() - 1) == 't' || words.get(i).charAt(words.get(i).length() - 1) == '!') {
                System.out.println(words.get(i) + " removed.");
                words.remove(i);
                i--;
            }
        }

        // Removing adjectives, adverbs, prepositions, etc.
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
            for (int a = 0; a < other.length; a++) {
                if (words.get(i).equals(other[a])) {
                    System.out.println(words.get(i) + " removed.");
                    words.remove(i);
                    i--;
                    break;
                }
            }
        }
        
        return words;
    }
}
