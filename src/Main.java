import javax.swing.*;
import java.awt.EventQueue;

public class Main {

    private JFrame frame;
    private final Dictionary myFrenchDictionary = new Dictionary();

    public static void main(String[] args){

        EventQueue.invokeLater(() -> {
            try{
                Main window = new Main();
                window.frame.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }

    public Main(){
        initialize();
    }

    private void initialize(){

        // set up window
        frame = new JFrame();
        frame.setBounds(100,100,450,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // creates welcome label
        JLabel welcomeLabel = new JLabel("Welcome to The French Dictionary");
        welcomeLabel.setBounds(125,87,300,50);
        frame.getContentPane().add(welcomeLabel);

        // sets up buttons enter and quit buttons
        JButton open_dictionary = new JButton("Open Dictionary");
        JButton quit = new JButton("Quit");

        // quit button makes program exit
        quit.addActionListener(e -> System.exit(0));

        open_dictionary.setBounds(100,150,141,35);
        quit.setBounds(250,150,141,35);
        frame.getContentPane().add(open_dictionary);
        frame.getContentPane().add(quit);

        // Page 2
        // buttons
        JButton add_word = new JButton("Add Word");
        add_word.setBounds(10,10,125,30);

        JButton find_word = new JButton("Find Word");
        find_word.setBounds(10,40,125,30);

        JButton display_dictionary = new JButton("Display Dictionary");
        display_dictionary.setBounds(10,70,125,30);

        JButton remove_word = new JButton("Remove Word");
        remove_word.setBounds(10,100,125,30);

        JButton remove = new JButton("Remove");
        remove.setBounds(145,10,125,30);

        JButton search = new JButton("Search");
        search.setBounds(145,10,125,30);

        JButton add_words = new JButton("Add Words");
        add_words.setBounds(50,70,125,30);

        JButton back1 = new JButton("Back");
        back1.setBounds(50,100,125,30);

        JButton back2 = new JButton("Back");
        back2.setBounds(50,100,125,30);

        //labels -> TextField
        JLabel englishWordLabel = new JLabel("English Word:");
        englishWordLabel.setBounds(10,10,125,30);

        JLabel frenchWord = new JLabel("French Word:");
        frenchWord.setBounds(10,40,125,30);

        JLabel label4 = new JLabel();
        label4.setBounds(250,25,200,25);

        //Text fields
        JTextField field = new JTextField();
        field.setBounds(10,10,125,30);

        JTextField addWordTextField = new JTextField();
        addWordTextField.setBounds(100,10,125,30);

        JTextField addFrWord = new JTextField();
        addFrWord.setBounds(100,40,125,30);


        // pressing open dictionary button
        // removes all information and repaints it with new information
        open_dictionary.addActionListener(e -> {
            quit.setBounds(10,130,125,30);
            frame.remove(welcomeLabel);
            frame.remove(quit);
            frame.remove(open_dictionary);
            frame.repaint();

            frame.getContentPane().add(add_word);
            frame.getContentPane().add(find_word);
            frame.getContentPane().add(display_dictionary);
            frame.getContentPane().add(remove_word);
            frame.getContentPane().add(quit);
        });

        // pressing add word
        add_word.addActionListener(e -> {
            // removes items
            frame.remove(add_word);
            frame.remove(find_word);
            frame.remove(display_dictionary);
            frame.remove(remove_word);
            frame.remove(add_words);
            frame.remove(quit);
            frame.repaint();

            frame.getContentPane().add(addWordTextField);
            frame.getContentPane().add(add_words);
            frame.getContentPane().add(addFrWord);
            frame.getContentPane().add(englishWordLabel);
            frame.getContentPane().add(frenchWord);
            frame.getContentPane().add(label4);
            frame.getContentPane().add(back1);

        });

        //pressing add word inside add word page
        add_words.addActionListener(e -> {
            myFrenchDictionary.addWord(addWordTextField.getText(),addFrWord.getText());
            label4.setText("The Words Has Been Added");
            addWordTextField.setText("");
            addFrWord.setText("");
        });

        //pressing back button inside add word page
        back1.addActionListener(e -> {
            // removes layer
            label4.setText("");
            frame.remove(addWordTextField);
            frame.remove(addFrWord);
            frame.remove(add_words);
            frame.remove(back1);
            frame.remove(frenchWord);
            frame.remove(label4);
            frame.remove(englishWordLabel);
            frame.repaint();

            //adds layer
            frame.getContentPane().add(add_word);
            frame.getContentPane().add(find_word);
            frame.getContentPane().add(display_dictionary);
            frame.getContentPane().add(remove_word);
            frame.getContentPane().add(quit);
            frame.repaint();

        });

        //pressing find word button
        find_word.addActionListener(e -> {
            frame.remove(add_word);
            frame.remove(find_word);
            frame.remove(display_dictionary);
            frame.remove(remove_word);
            frame.remove(quit);
            frame.repaint();


            frame.getContentPane().add(field);
            frame.getContentPane().add(search);
            frame.getContentPane().add(back2);
            frame.getContentPane().add(label4);
            frame.repaint();
        });

        back2.addActionListener(e -> {
            frame.remove(field);
            frame.remove(search);
            frame.remove(back2);
            label4.setText("");
            frame.remove(label4);
            frame.repaint();

            frame.getContentPane().add(add_word);
            frame.getContentPane().add(find_word);
            frame.getContentPane().add(display_dictionary);
            frame.getContentPane().add(remove_word);
            frame.getContentPane().add(quit);
        });

        //pressing search button
        search.addActionListener(e -> label4.setText(myFrenchDictionary.search(field.getText())));

        remove_word.addActionListener(e ->{
            frame.remove(add_word);
            frame.remove(find_word);
            frame.remove(display_dictionary);
            frame.remove(remove_word);
            frame.remove(add_words);
            frame.remove(quit);
            frame.repaint();

            frame.getContentPane().add(field);
            frame.getContentPane().add(remove);

        });

        //pressing remove
        remove.addActionListener(e -> myFrenchDictionary.remove(field.getText()));

        // Pressing Quit Button
        quit.addActionListener(e -> System.exit(0));

    }
}
