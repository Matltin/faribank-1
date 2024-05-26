package ir.ac.kntu;

import ir.ac.kntu.db.AdminDB;
import ir.ac.kntu.db.AnswerDB;
import ir.ac.kntu.message.Message;
import ir.ac.kntu.message.MessageOption;
import ir.ac.kntu.person.admin.Admin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    void checkAdminDB() throws ParseException {
        AdminDB adminDB = new AdminDB(new HashSet<>());
        Admin admin1 = new Admin("Matin", "Ahmadi", "1", "m");
        Admin admin2 = new Admin("Erfan", "Dostmohammadi", "2", "e");

        assertEquals(admin1 ,adminDB.findAdmin(admin1.getUserName()));
        assertNull(adminDB.findAdmin(admin2.getUserName()));
    }

    @Test
    void checkPrintMessage() throws FileNotFoundException {

        FileOutputStream f = new FileOutputStream("outputfile/PrintMessage.txt");
        System.setOut(new PrintStream(f));

        AnswerDB answerDB = new AnswerDB(new ArrayList<>());
        Message message1 = new Message("09102607040", "contact", MessageOption.CONTACT);
        Message message2 = new Message("09059293062", "report", MessageOption.REPORT);
        Message message3 = new Message("09126410299", "setting", MessageOption.SETTING);
        Message message4 = new Message("09136942050", "transfer", MessageOption.TRANSFER);
        answerDB.add(message1);
        answerDB.add(message2);
        answerDB.add(message3);
        answerDB.add(message4);

        answerDB.printMessage();
    }
}
